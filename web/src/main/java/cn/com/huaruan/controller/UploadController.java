package cn.com.huaruan.controller;

import cn.com.huaruan.model.ResultVo;
import cn.com.huaruan.utils.fastdfs.FastDFSClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/upload")
@RestController
public class UploadController {
    @PostMapping
    public ResultVo upload(MultipartFile file){
        try {
            //获取文件拓展名
            String file_ext_name = file.getOriginalFilename().
                    substring(file.getOriginalFilename().lastIndexOf(".")+1);
            FastDFSClient fastDFSClient = new
                    FastDFSClient("classpath:fastdfs/tracker.conf");
            String url = fastDFSClient.uploadFile(file.getBytes(),
                    file_ext_name);
            return new ResultVo(true, url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResultVo(false,"上传图片失败");
    }
}