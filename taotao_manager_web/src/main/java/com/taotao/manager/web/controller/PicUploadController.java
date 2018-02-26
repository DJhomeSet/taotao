package com.taotao.manager.web.controller;

import com.taotao.common.utils.PicUploadResult;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author DJ
 * @version 1.0
 * @description com.taotao.manager.web.controller
 * @date 2018/2/25
 */
@Controller
@RequestMapping("pic")
public class PicUploadController {
    private String[] type = {"jpg","jpeg","gif","png","bmp"};
    @Value("${TAOTAO_FASTDFS_SERVER}")
    private String TAOTAO_FASTDFS_SERVER;
    @RequestMapping("upload")
    @ResponseBody
    public PicUploadResult uploadPic(MultipartFile uploadFile){
        PicUploadResult result = new PicUploadResult();
        //后缀名校验
        boolean flag = false;
        String oldName = uploadFile.getOriginalFilename();
        String extName = oldName.substring(oldName.lastIndexOf(".")+1);
        for (String s : type) {
            if(s.equals(extName)){
                flag = true;
                break;
            }
        }
        if(flag){
            //文件内容校验
            try {
                BufferedImage image = ImageIO.read(uploadFile.getInputStream());
                if(image != null){
                    result.setHeight(image.getHeight()+"");
                    result.setWidth(image.getWidth()+"");
                }
            } catch (Exception e) {
                result.setError(1);
                e.printStackTrace();
            }
        }
        //上传文件
        try {
            String conf_filename = System.getProperty("user.dir")+"\\src\\main\\resources\\tracker.conf";
            ClientGlobal.init(conf_filename);
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer = null;
            StorageClient storageClient = new StorageClient(trackerServer,storageServer);
            String[] urls = storageClient.upload_file(uploadFile.getBytes(), extName, null);
            String url = TAOTAO_FASTDFS_SERVER+urls[0]+"/"+urls[1];
            result.setUrl(url);
            result.setError(0);
        } catch (Exception e) {
            result.setError(1);
            e.printStackTrace();
        }
        if(result.getError()==0){
            return result;
        }
        return null;
    }
}
