package com.it.estore.controller;

import com.github.pagehelper.PageInfo;
import com.it.estore.goods.vo.AlbumVO;
import com.it.estore.service.AlbumService;
import com.it.estore.utils.Result;
import com.it.estore.utils.StatueCode;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {

    @Resource
    private AlbumService albumService;

    @GetMapping("/findAllAlbum")
    public Result<List<AlbumVO>> findAllAlbum(){
        List<AlbumVO> allAlbumVO = albumService.findAll();
        return new Result<>(true, StatueCode.SUCCESS_CODE,"success",allAlbumVO);
    }

    @GetMapping("/findAlbumById/{id}")
    public Result<AlbumVO> findAlbumById(@PathVariable("id")Long id){
        AlbumVO albumVO = albumService.findById(id);
        return new Result<>(true, StatueCode.SUCCESS_CODE,"success",albumVO);
    }

    @PostMapping("/addAlbum")
    public Result addAlbum(@RequestBody AlbumVO albumVO){
        albumService.add(albumVO);
        return new Result(true, StatueCode.SUCCESS_CODE,"success");
    }

    @PutMapping("/updateAlbum/{id}")
    public Result updateAlbum(@PathVariable("id") Long id,@RequestBody AlbumVO albumVO){
        albumVO.setId(id);
        albumService.update(albumVO);
        return new Result(true, StatueCode.SUCCESS_CODE,"修改成功");
    }

    @DeleteMapping("/deleteAlbum/{id}")
    public Result deleteAlbum(@PathVariable("id") Long id){
        albumService.delete(id);
        return new Result(true, StatueCode.SUCCESS_CODE,"删除成功");
    }

    @PostMapping("/search")
    public Result<List<AlbumVO>> search(@RequestBody AlbumVO albumVO){
        List<AlbumVO> list = albumService.findList(albumVO);
        return new Result<>(true, StatueCode.SUCCESS_CODE,"条件搜索查询成功",list);
    }

    @GetMapping("/search/{page}/{size}")
    public Result<PageInfo<AlbumVO>> findPageInfo(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageInfo<AlbumVO> list = albumService.findPage(page, size);
        return new Result<>(true, StatueCode.SUCCESS_CODE,"分页查询成功",list);
    }

    @PostMapping("/search/{page}/{size}")
    public Result<PageInfo<AlbumVO>> findPageInfo(@RequestBody AlbumVO albumVO, @PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageInfo<AlbumVO> list = albumService.findPage(albumVO,page, size);
        return new Result<>(true, StatueCode.SUCCESS_CODE,"分页查询成功",list);
    }

}
