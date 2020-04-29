package cn.WindTech.store.mapper;

import cn.WindTech.store.entity.Product;
import cn.WindTech.store.vo.ProductVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ProductMapper {
    //以下是后台系统代码
    /**
     * 插入产品数据
     * @param product 产品数据
     * @return 受影响的行数
     */
    Integer insert(Product product);
    /**
     *展示产品数据
     */
    List<ProductVO> showProduct();
    /**
     *根据id展示产品数据
     */
    Product findByPId(Integer pid);
    /**
     * 根据id删除产品数据
     * @param pid 将删除的产品数据的id
     * @return 受影响的行数
     */
    Integer deleteByPid(Integer pid);

    /**
     * 修改指定的产品数据
     * @param product 产品数据
     * @return 受影响的行数
     */
    Integer updateInfo(Product product);
    /**
     * 更新产品图片
     * @param pid 产品的id
     * @param pro_img 产品图片
     * @return 受影响的行数
     */
    Integer updateImage(
            @Param("pid") Integer pid,
            @Param("pro_img") String pro_img,
            @Param("modifiedUser") String modifiedUser,
            @Param("modifiedTime") String modifiedTime);
}
