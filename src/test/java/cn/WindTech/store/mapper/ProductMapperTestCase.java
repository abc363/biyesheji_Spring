package cn.WindTech.store.mapper;

import cn.WindTech.store.entity.Product;
import cn.WindTech.store.vo.ProductVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductMapperTestCase {
    @Autowired
    public ProductMapper mapper;
//插入产品数据
    @Test
    public void insert() {
        Product pro = new Product();
        pro.setPro_Name("C2S02模块");
        pro.setPro_Type("CS系列");
        pro.setPro_Num(242);
        pro.setPro_State(1);
        Integer rows = mapper.insert(pro);
        System.err.println("rows="+rows );
    }
//显示产品数据
    @Test
    public void showProduct() {
        List<ProductVO> list = mapper.showProduct();
        System.err.println("BEGIN:");
        for (ProductVO data : list) {
            System.err.println(data);
        }
        System.err.println("END.");
    }
//根据相应id显示产品数据
    @Test
    public void findByAid() {
        Integer pid = 3;
        Product data = mapper.findByPId(pid);
        System.err.println(data);
    }
//    根据产品pid删除数据
    @Test
    public void deleteByPid() {
        Integer pid = 3;
        Integer rows = mapper.deleteByPid(pid);
        System.err.println("rows=" + rows);
    }
//    统计产品个数
    @Test
    public void countByUid() {
        Integer count = mapper.countProduct();
        System.err.println("count=" + count);
    }
//修改相应id的产品数据
	@Test
	public void updateInfo() {
		Product pro= new Product();
		pro.setPid(1);
		pro.setPro_info("这里是C2S01模块");
		pro.setPro_State(1);
		pro.setPro_Num(455);
        pro.setPro_Name("C2S01模块");
        pro.setPro_Type("C2系列");
		Integer rows = mapper.updateInfo(pro);
		System.err.println("rows=" + rows);
	}

    @Test
    public void updateAvatar() {
        Integer pid = 1;
        String pro_img = "这里应该是头像的路径";
        Integer rows = mapper.updateAvatar(pid, pro_img);
        System.err.println("rows=" + rows);
    }
}
