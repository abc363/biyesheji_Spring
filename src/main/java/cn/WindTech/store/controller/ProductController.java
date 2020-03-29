package cn.WindTech.store.controller;

import cn.WindTech.store.controller.ex.*;
import cn.WindTech.store.entity.Product;
import cn.WindTech.store.service.IProductService;
import cn.WindTech.store.util.ResponseResult;
import cn.WindTech.store.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController extends BaseController{
    @Autowired
    private IProductService proService;
    /**
     * 确定上传文件的名称
     */
    private static final String UPLOAD_DIR = "upload";
    /**
     * 确定上传文件的最大大小
     */
    private static final long UPLOAD_MAX_SIZE = 1 * 1024 * 1024;
    /**
     * 确定允许上传的类型的列表
     */
    private static final List<String> UPLOAD_CONTENT_TYPES = new ArrayList<>();
    static {
        UPLOAD_CONTENT_TYPES.add("image/jpeg");
        UPLOAD_CONTENT_TYPES.add("image/png");
        UPLOAD_CONTENT_TYPES.add("image/gif");
        UPLOAD_CONTENT_TYPES.add("image/PNG");
    }


    //添加产品数据
    @PostMapping("/add")
    public ResponseResult<Void> product(Product pro) {
        proService.addToPro(pro);
        // 返回成功
        return new ResponseResult<>(SUCCESS);
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
    public ResponseResult<Void> changeInfo(Product product, @PathVariable("pid") Integer pid) {
        product.setPid(pid);
        // 执行修改产品数据
        proService.changeInfo(product);
        // 返回
        return new ResponseResult<>(SUCCESS);
    }


    @PostMapping("/{pid}/change_avatar")
    public ResponseResult<String> changeAvatar(HttpServletRequest request,
                   @PathVariable("pid") Integer pid, @RequestParam("file") MultipartFile file) {
        // 检查文件是否为空  为空：抛出异常：FileEmptyException
        if (file.isEmpty()) {
            throw new FileEmptyException("上传头像错误！上传的头像文件为空！");
        }
        // 检查文件大小
        if (file.getSize() > UPLOAD_MAX_SIZE) {
            // 超出范围(> UPLOAD_MAX_SIZE)：抛出异常：FileSizeException
            throw new FileSizeException("上传头像错误！不允许上传超过" + (UPLOAD_MAX_SIZE / 1024) + "KB的文件！");
        }
        // 检查文件类型
        String contentType = file.getContentType();
        if (!UPLOAD_CONTENT_TYPES.contains(contentType)) {
            // 类型不符(contains()为false)：抛出异常：FileContentTypeException
            throw new FileContentTypeException("上传头像错误！不支持选择的文件类型！");
        }
        // 确定文件夹路径：request.getServletContext().getRealPath(UPLOAD_DIR);
        String parentPath = request.getServletContext().getRealPath(UPLOAD_DIR);
        // 创建上传文件夹的File对象parent
        File parent = new File(parentPath);
        // 检查文件夹是否存在，如果不存在，则创建
        if (!parent.exists()) {
            parent.mkdirs();
        }
        // 获取原文件名：file.getOriginalFilename()
        String originalFilename = file.getOriginalFilename();
        // 从原文件名中得到扩展名
        String suffix = "";
        int beginIndex = originalFilename.lastIndexOf(".");
        if (beginIndex > 0) {
            suffix = originalFilename.substring(beginIndex);
        }
        // 确定文件名：uuid/nanoTime/...
        String filename = System.nanoTime() + suffix;
        // 创建dest对象：new File(parent, filename);
        File dest = new File(parent, filename);
        try {
            // 执行上传：file.transferTo(dest);
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            throw new FileIllegalStateException("上传头像错误！存储头像文件时状态异常！");
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileIOException("上传头像错误！读写文件时出现错误！");
        }
        // 生成avatar：/UPLOAD_DIR/文件名.扩展名
        String pro_img = "/" + UPLOAD_DIR + "/" + filename;
        // 执行更新：userService.changeAvatar(uid, avatar);
        proService.changeAvatar(pid, pro_img);
        // 返回成功
        return new ResponseResult<>(SUCCESS, pro_img);
    }

}
