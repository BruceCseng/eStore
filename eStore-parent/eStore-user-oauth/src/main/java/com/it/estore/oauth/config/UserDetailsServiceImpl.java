package com.it.estore.oauth.config;

import com.it.estore.oauth.utils.UserJwt;
import com.it.estore.user.feign.UserFeign;
import com.it.estore.user.vo.UserVO;
import com.it.estore.utils.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private UserFeign userFeign;

    @Autowired
    private DataSource dataSource;

    private static final List<String> APPS = new ArrayList<>(3);

    private static final List<String> GRANT_TYPES = new ArrayList<>(4);

    private static final Set<String> REDIRECT_URLS = new HashSet<>(1);

    static {
        APPS.add("app");
        APPS.add("miniApp");
        APPS.add("browse");
        GRANT_TYPES.add("authorization_code");
        GRANT_TYPES.add("password");
        GRANT_TYPES.add("refresh_token");
        GRANT_TYPES.add("client_credentials");
        REDIRECT_URLS.add("http://localhost");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // ------------------------客户端信息认证 start
        //取出身份，如果身份为空说明没有认证
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //没有认证统一采用httpbasic认证，httpbasic中存储了client_id和client_secret，开始认证client_id和client_secret
        if (authentication == null) {
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(username);
            if (clientDetails != null) {
                //秘钥
                String clientSecret = clientDetails.getClientSecret();
                //静态方式
                /**return new User(username // 客户端id
                 ,new BCryptPasswordEncoder().encode(clientSecret) // 客户端秘钥加密操作
                 , AuthorityUtils.commaSeparatedStringToAuthorityList("")); // 权限*/
                //数据库查找方式
                return new User(username, clientSecret, AuthorityUtils.commaSeparatedStringToAuthorityList(""));
            }
        }
        // ---------------- 客户端认证end

        // ---------------- 用户信息认证 start
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        //根据用户名查询用户信息
        Result<UserVO> userVO = userFeign.findByUsername(username);
        if (userVO == null || userVO.getData() == null) {
            return null;
        }

        String pwd = userVO.getData().getPassword();
        //创建User对象  授予权限.GOODS_LIST  SECKILL_LIST
        String permissions = "goods_list,seckill_list";
        UserJwt userDetails = new UserJwt(username, pwd, AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));
        userDetails.setPhone(userVO.getData().getPhone());
        userDetails.setNickName(userVO.getData().getNickName());
        userDetails.setHeadPic(userVO.getData().getHeadPic());
        userDetails.setSex(userVO.getData().getSex());
        userDetails.setUserLevel(userVO.getData().getUserLevel());
        userDetails.setPoints(userVO.getData().getPoints());
        userDetails.setName(userVO.getData().getName());
        return userDetails;
    }

    public void addOAuthInfo(UserVO userVO) {
        JdbcClientDetailsService jdbcClientDetailsService = new JdbcClientDetailsService(dataSource);
        BaseClientDetails baseClientDetails = new BaseClientDetails();
        baseClientDetails.setClientId(userVO.getUsername());
        baseClientDetails.setClientSecret(userVO.getPassword());
        baseClientDetails.setScope(APPS);
        baseClientDetails.setAuthorizedGrantTypes(GRANT_TYPES);
        baseClientDetails.setRegisteredRedirectUri(REDIRECT_URLS);
        baseClientDetails.setAccessTokenValiditySeconds(600);
        baseClientDetails.setRefreshTokenValiditySeconds(60);
        jdbcClientDetailsService.addClientDetails(baseClientDetails);
    }

}
