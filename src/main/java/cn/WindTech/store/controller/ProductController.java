package cn.WindTech.store.controller;

import cn.WindTech.store.entity.Product;
import cn.WindTech.store.service.IProductService;
import cn.WindTech.store.util.ResponseResult;
import cn.WindTech.store.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController extends BaseController{
    @Autowired
    private IProductService proService;
    //添加产品数据
    @PostMapping("/add")
    public ResponseResult<Void> product(Product pro) {
        ResponseResult<Void> rr = new ResponseResult<Void>();
        proService.addToPro(pro);
        // 返回成功
        rr.setState(200);
        return rr;
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
}
