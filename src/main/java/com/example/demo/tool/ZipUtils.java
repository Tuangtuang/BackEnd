package com.example.demo.tool;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @program: demo
 * @description: 文件压缩工具
 * @author: tyq
 * @create: 2019-06-24 19:54
 **/
@Slf4j
public class ZipUtils {


    /**
     * @Description: 压缩当前目录path下的所有文件 , 生成文件名称为 zipname , 放在路径zippath下 ;
     * @Param: [phone, identity]
     * @return: boolean
     * @Author: tyq
     * @Date:
     */
//  TODO 放到服务器后修改路径
    private static String servicePath = "/var/lib/jiyiedu/";
//    private static String servicePath = "/Users/tangyuqi/Downloads/jiyiedu/";

    public static String folder2zip(String address, String followpath, String zipname) {

        String path=servicePath+address;
        File src = new File(path);
        ZipOutputStream zos = null;

        String zippath = servicePath + followpath + "";

        if (src == null || !src.exists() || !src.isDirectory()) {
            // 源目录不存在 或不是目录 , 则异常
            log.error("压缩源目录不存在或非目录!" + path);
            throw new RuntimeException("压缩源目录不存在或非目录!" + path);
        }

        File destdir = new File(zippath);

        if (!destdir.exists()) {
            // 创建目录
            log.info("压缩目标路径不存在, 创建之." + zippath);
            destdir.mkdirs();
        }

        File zipfile = new File(zippath + zipname);


        File[] srclist = src.listFiles();

        if (srclist == null || srclist.length == 0) {
            // 源目录内容为空,无需压缩
            log.error("源目录内容为空,无需压缩下载!" + path);
//            throw new RuntimeException("源目录内容为空,无需压缩下载!" + path);
        }

        try {
            zos = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipfile)));

            // 递归压缩目录下所有的文件  ;
            compress(zos, src, src.getName());

            zos.close();

        } catch (FileNotFoundException e) {
            log.error("压缩文件不存在", e);
            throw new RuntimeException("压缩目标文件不存在!" + e.getMessage());
        } catch (IOException e) {
            log.error("压缩文件IO异常", e);
            throw new RuntimeException("压缩文件IO异常!" + e.getMessage());
        } finally {
            if (zos != null) {
                try {
                    zos.close();
                } catch (Exception e2) {
                    log.error("文件流关闭失败");
                }
            }
        }
        return zippath+zipname;

    }

    /**
     * @Description: 递归压缩文件
     * @Param: [phone, identity]
     * @return: boolean
     * @Author: tyq
     * @Date:
     */

    private static void compress(ZipOutputStream zos, File src, String name) throws IOException {
        if (src == null || !src.exists()) {
            return;
        }
        if (src.isFile()) {
            byte[] bufs = new byte[10240];

            ZipEntry zentry = new ZipEntry(name);
            zos.putNextEntry(zentry);

            log.debug("压缩:" + src.getAbsolutePath());
            FileInputStream in = new FileInputStream(src);

            BufferedInputStream bin = new BufferedInputStream(in, 10240);

            int readcount = 0;

            while ((readcount = bin.read(bufs, 0, 10240)) != -1) {
                zos.write(bufs, 0, readcount);
            }

            zos.closeEntry();
            bin.close();
        } else {
            // 文件夹
            File[] fs = src.listFiles();

            if (fs == null || fs.length == 0) {
                zos.putNextEntry(new ZipEntry(name + File.separator));
                zos.closeEntry();
                return;
            }

            for (File f : fs) {
                compress(zos, f, name + File.separator + f.getName());
            }
        }
    }

}
