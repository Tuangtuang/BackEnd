package com.example.demo.tool;

import com.example.demo.model.overview.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @program: demo
 * @description: 文件上传下载接口
 * @author: tyq
 * @create:
 **/
@Slf4j

public class FileTool {

    public static Result uploadFile(String filePath, MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResultTool.error("文件为空");
            }
            java.io.File dest = new java.io.File(filePath);
            // 检测是否存在目录
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();// 新建文件夹
            }
            file.transferTo(dest);// 文件写入
            return ResultTool.success();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResultTool.error("上传失败");
    }

    public static void downloadFile(HttpServletResponse response, String fileName, String filePath) {
        File downloadFile = new File(filePath);
        if(downloadFile.exists()) {
            response.setContentType("application/octet-stream");
            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=" + new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
            response.setHeader(headerKey, headerValue);
            response.setContentLength((int) downloadFile.length());
            try {
                InputStream myStream = new FileInputStream(filePath);
                OutputStream toClient = response.getOutputStream();
                IOUtils.copy(myStream, toClient);
                response.flushBuffer();
                myStream.close();
                toClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            new Exception("不存在文件").printStackTrace();
        }
    }



    /**
    * @Description: 删除单个文件
    * @Param: [sPath]
    * @return: boolean
    * @Author: tyq
    * @Date:
    */
    public static boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }


    /** 
    * @Description: 删除文件夹 
    * @Param: [dirPath] 
    * @return: void 
    * @Author: tyq 
    * @Date:
    */ 
    public static void deleteDir(String dirPath)
    {
        File file = new File(dirPath);
        if(file.isFile())
        {
            file.delete();
        }else
        {
            File[] files = file.listFiles();
            if(files == null)
            {
                file.delete();
            }else
            {
                for (int i = 0; i < files.length; i++)
                {
                    deleteDir(files[i].getAbsolutePath());
                }
                file.delete();
            }
        }
    }


    /**
    * @Description: 在指定路径创建文件夹
    * @Param: [filePath]
    * @return: void
    * @Author: tyq
    * @Date: 2019-06-30
    */
    public static void createFolder(String filePath,String folderName){
        String newPath=filePath+folderName;
        File file =new File(newPath);
        if(file.exists()){
            log.info("文件夹已存在");
        }else {
            file.mkdir();
        }

    }




}
