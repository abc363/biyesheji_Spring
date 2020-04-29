package cn.WindTech.store.controller;

import cn.WindTech.store.controller.ex.*;
import cn.WindTech.store.entity.Product;
import cn.WindTech.store.service.IProductService;
import cn.WindTech.store.util.ResponseResult;
import cn.WindTech.store.vo.ProductVO;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.MultipartConfigElement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping(value = "/products")
public class ProductController extends BaseController{
    @Autowired
    private IProductService proService;
    // 七牛云账号的相关信息
    private static final String accessKey = "zBwS2zlxzHGc3vA2qJ5x6sAAwJKXOqEmublsXESC";    //访问秘钥
    private static final String secretKey = "Mn4xRZt6nX4vZJwqW3LhmR9Hhm9ey_kRg6odW-n7";    //授权秘钥
    private static final String bucket = "webgdufeimages";       //存储空间名称
    private static final String domain = "q98i9va0h.bkt.clouddn.com";       //外链域名
    private static String randomFileName="";


    //添加产品数据
    @PostMapping(value="/add")
    public Map<String, Object> product(Product pro,@RequestParam String suffix, HttpSession session) {
        // 从session中获取id
        Integer id = getUidFromSession(session);
        // 将id封装到pro中
        pro.setPid(id);
        // 从session中获取username
        String username = session.getAttribute("username").toString();
        Map<String, Object> result =QiniuUpToken(suffix);
        String pro_image="http://"+domain+"/"+randomFileName;
        pro.setPro_img(pro_image);
        proService.addToPro(pro,username);
        // 返回成功
        return result;
    }
    // 展示产品数据
    @GetMapping("/show")
    public ResponseResult<List<ProductVO>> getProduct() {
        // 调用业务层对象执行
        List<ProductVO> data = proService.getProduct();
        System.err.println(data);
        // 返回
        return new ResponseResult<>(SUCCESS, data);
    }
//    显示相应id的产品数据
    @GetMapping("/{pid}/showPro")
    public ResponseResult<Product> getByPId(@PathVariable("pid") Integer pid) {
        // 调用业务层对象执行
        Product data=proService.getByPId(pid);
        // 返回
        return new ResponseResult<>(SUCCESS,data);
    }
    //删除特定id的数据
    @RequestMapping("/{pid}/delete")
    public ResponseResult<Void> delete(@PathVariable("pid") Integer pid) {
        // 执行
        proService.delete(pid);
        // 返回
        return new ResponseResult<>(SUCCESS);
    }
//    修改特定的产品数据
    @RequestMapping("/{pid}/change_info")
    public ResponseResult<Void> changeInfo(Product product, @PathVariable("pid") Integer pid, HttpSession session) {
        // 执行更新：
        product.setPid(pid);
        String username = session.getAttribute("username").toString();
        proService.changeInfo(product,username);
        // 返回成功
        return new ResponseResult<>(SUCCESS);
    }
    //    修改特定的产品图片
    @PostMapping(value="/{pid}/changeImage")
    public Map<String, Object> changeImage(@RequestParam String suffix,@PathVariable("pid") Integer pid,HttpSession session) {
        Map<String, Object> result =QiniuUpToken(suffix);
        String pro_image="http://"+domain+"/"+randomFileName;
        String username = session.getAttribute("username").toString();
        proService.changeImage(pid, pro_image,username);
        // 返回成功
        return result;
    }



    public Map<String, Object> QiniuUpToken(String suffix) {
        Map<String, Object> result = new HashMap<String, Object>();
        try {
            //验证七牛云身份是否通过
            Auth auth = Auth.create(accessKey, secretKey);
            //生成凭证
            String upToken = auth.uploadToken(bucket);
            result.put("token", upToken);
            //存入外链默认域名，用于拼接完整的资源外链路径
            result.put("domain", domain);
            // 是否可以上传的图片格式
            boolean flag = false;
            String[] imgTypes = new String[]{"jpg","jpeg","bmp","gif","png"};
            for(String fileSuffix : imgTypes) {
                if(suffix.substring(suffix.lastIndexOf(".") + 1).equalsIgnoreCase(fileSuffix)) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                throw new Exception("图片：" + suffix + " 上传格式不对！");
            }
            //生成实际路径名
            randomFileName = UUID.randomUUID().toString() + suffix;
            result.put("imgUrl", randomFileName);
            result.put("success", 1);
        } catch (Exception e) {
            result.put("message", "获取凭证失败，"+e.getMessage());
            result.put("success", 0);
        } finally {
            return result;
        }
    }


}
