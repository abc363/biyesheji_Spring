package cn.WindTech.store.mapper;

import cn.WindTech.store.entity.Product;
import cn.WindTech.store.entity.User;
import cn.WindTech.store.entity.delProduct;
import cn.WindTech.store.vo.ProductVO;
import cn.WindTech.store.vo.TypeVO;
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
     *展示不同类型产品数据
     */
    List<ProductVO> showProduct(@Param("startPage")Integer startPage,@Param("pageSize") Integer pageSize);
    /**
     *展示所有产品数据
     */
    List<ProductVO> showAllProduct(Product product);
    /**
     *搜索产品数据
     */
    List<ProductVO> searchProduct(@Param("pro_Name")String pro_Name, @Param("pro_State") String pro_State,
                                  @Param("pro_Type") String pro_Type,@Param("startPage")Integer startPage,
                                  @Param("pageSize")Integer pageSize);
    /**
     *返回搜索数据条目
     */
    Integer countSearch(@Param("pro_Name")String pro_Name,
                                  @Param("pro_State") String pro_State,@Param("pro_Type") String pro_Type);
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
//    修改时间
    Integer updateTime(@Param("username")String username,
                       @Param("modifiedTime")String modifiedTime);

    /**
     * 根据id删除文件路径和文件名
     * @return 受影响的行数
     */
    Integer deleteFile(delProduct del);
//   所有产品的数目
    Integer countByPid();
//    展示产品的所有类型
    List<TypeVO> showType();
}
