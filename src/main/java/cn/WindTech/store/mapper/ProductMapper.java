package cn.WindTech.store.mapper;

import cn.WindTech.store.entity.Product;
import cn.WindTech.store.vo.ProductVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
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
     * 统计产品的数量
     * @return 产品数据的数量
     */
    Integer countProduct();

    /**
     * 修改指定的产品数据
     * @param product 产品数据
     * @return 受影响的行数
     */
    Integer updateInfo(Product product);

}
