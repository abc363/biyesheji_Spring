package cn.WindTech.store.controller;

import cn.WindTech.store.entity.ProductImg;
import cn.WindTech.store.util.QiniuCloudUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
public class ImgUploadController {
    @ResponseBody
    @RequestMapping(value="/uploadImg", method=RequestMethod.POST)
    public ProductImg uploadImg(@RequestParam MultipartFile image, HttpServletRequest request) {
        ProductImg result = new ProductImg();
        if (image.isEmpty()) {
            result.setCode(400);
            result.setMsg("文件为空，请重新上传");
            return result;
        }
        try {
            byte[] bytes = image.getBytes();
            String imageName = UUID.randomUUID().toString();
            try {
                //使用base64方式上传到七牛云
                String url = QiniuCloudUtil.put64image(bytes, imageName);
                result.setCode(200);
                result.setMsg("文件上传成功");
                result.setInfo(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            result.setCode(500);
            result.setMsg("文件上传发生异常！");
        } finally {
            return result;
        }
    }

}

