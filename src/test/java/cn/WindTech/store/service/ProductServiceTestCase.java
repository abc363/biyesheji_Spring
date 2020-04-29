package cn.WindTech.store.service;

import cn.WindTech.store.entity.Product;
import cn.WindTech.store.service.ex.ServiceException;
import cn.WindTech.store.vo.ProductVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTestCase {

    @Autowired
    public IProductService service;
//添加产品
    @Test
    public void addToPro() {
        try {
            Product pro = new Product();
            pro.setPro_Name("C2S03模块");
            pro.setPro_Type("CS系列");
            pro.setPro_Num(675);
            pro.setPro_State(0);
            service.addToPro(pro,"xxx");
            System.err.println("OK.");
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }
//    展示产品数据
    @Test
    public void getProduct() {
        List<ProductVO> list = service.getProduct();
//        System.err.println("BEGIN:");
//        for (ProductVO data : list) {
//            System.err.println(data);
//        }
//        System.err.println("END.");
    }
    @Test
    public void getByd() {
        Integer pid = 3;
        Product data = service.getByPId(pid);
        System.err.println(data);
    }
//    删除指定产品
    @Test
    public void delete() {
        try {
            Integer pid = 2;
            service.delete(pid);
            System.err.println("OK.");
        } catch (ServiceException e) {
            System.err.println(e.getClass().getName());
            System.err.println(e.getMessage());
        }
    }
//    修改指定id的产品数据
    @Test
	public void changeInfo() {
		try {
			Product pro = new Product();
            pro.setPid(1);
            pro.setPro_info("这里是C2S03模块");
            pro.setPro_State(1);
            pro.setPro_Num(8888);
            pro.setPro_Name("C2S03模块");
            pro.setPro_Type("CS系列");
			service.changeInfo(pro,"xxxx");
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}
	@Test
	public void changeImage() {
		try {
			Integer pid = 1;
			String pro_img = "新图片的路径";
			service.changeImage(pid, pro_img,"XXX");
			System.err.println("OK.");
		} catch (ServiceException e) {
			System.err.println(e.getClass().getName());
			System.err.println(e.getMessage());
		}
	}


}
