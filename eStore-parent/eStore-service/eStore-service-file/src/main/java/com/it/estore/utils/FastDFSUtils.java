package com.it.estore.utils;

import com.it.estore.file.FastDFSFile;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 上传
 * 删除
 * 下载
 * 信息获取
 * tracker信息获取
 * storage信息获取
 */
public class FastDFSUtils {

    static {
        try {
            // 查找classpath下配置文件的路径
            String path = new ClassPathResource("fdfs_client.conf").getPath();
            ClientGlobal.init(path);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件上传公共方法
     *
     * @param fastDFSFile
     */
    public static String[] upload(FastDFSFile fastDFSFile) throws Exception {
        // 手动创建附加参数
        NameValuePair[] metaList = new NameValuePair[1];
        metaList[0] = new NameValuePair("author", fastDFSFile.getAuthor());
        TrackerServer trackerServer = getTrackerServer();
        // 创建storage连接对象，并将tracker信息加载进去
        StorageClient storageClient = getStorageClient(trackerServer);
        /**
         * 第三个参数是附加参数
         * 获取上传后的文件存储信息
         */
        String[] uploads = storageClient.upload_file(fastDFSFile.getContent(), fastDFSFile.getExt(), metaList);
        return uploads;

    }

    public static FileInfo getFile(String groupName, String remoteFileName) throws Exception {
        TrackerServer trackerServer = getTrackerServer();
        StorageClient storageClient = getStorageClient(trackerServer);
        return storageClient.get_file_info(groupName, remoteFileName);

    }

    public static InputStream download(String groupName, String remoteFileName) throws Exception {
        TrackerServer trackerServer = getTrackerServer();
        StorageClient storageClient = getStorageClient(trackerServer);
        byte[] bytes = storageClient.download_file(groupName, remoteFileName);
        return new ByteArrayInputStream(bytes);
    }

    public static int delete(String groupName, String remoteFileName) throws Exception {
        TrackerServer trackerServer = getTrackerServer();
        StorageClient storageClient = getStorageClient(trackerServer);
        return storageClient.delete_file(groupName, remoteFileName);
    }

    public static String getTrackInfo() throws Exception {
        TrackerServer trackerServer = getTrackerServer();
        String host = trackerServer.getInetSocketAddress().getHostString();
        int port = ClientGlobal.getG_tracker_http_port();
        return "http://"+host+":"+port;
    }

    public static TrackerServer getTrackerServer() throws Exception{
        // 获取tracker客户端连接对象
        TrackerClient trackerClient = new TrackerClient();
        // 获取连接信息
        TrackerServer trackerServer = trackerClient.getConnection();
        return trackerServer;
    }

    public static StorageClient getStorageClient(TrackerServer trackerServer){
        StorageClient storageClient = new StorageClient(trackerServer, null);
        return storageClient;
    }
}
