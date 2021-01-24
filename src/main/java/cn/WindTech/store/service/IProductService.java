package cn.WindTech.store.service;

import cn.WindTech.store.entity.Product;
import cn.WindTech.store.entity.delProduct;
import cn.WindTech.store.service.ex.*;
import cn.WindTech.store.vo.ProductVO;
import cn.WindTech.store.vo.TypeVO;

import java.util.List;

/**
 * 处理产品数据的业务层接口
 */
public interface IProductService {
//    以下是后台系统代码
    /**
     * 将产品数据添加到数据中
     * @param product 产品数据
     * @throws InsertException 插入数据异常
     * @throws UpdateException 更新数据异常
     */
    void addToPro(Product product,String username) throws InsertException, UpdateException;
    /**
     *展示产品数据
     */
    List<ProductVO> getProduct(Integer startPage,Integer pageSize);
    /**
     *展示所有产品数据
     */
    List<ProductVO> getAllProduct(Product product);
    /**
     *展示搜索产品数据
     */
    List<ProductVO> searchProduct(String pro_Name,String pro_State,String pro_Type,Integer startPage,Integer pageSize);
    /**
     *展示搜索产品数据数目
     */
    Integer toSearchCount(String pro_Name,String pro_State,String pro_Type);
    /**
     * 根据产品id查询数据
     * @param pid 产品id
     * @return 匹配的产品数据，如果没有匹配的数据，则返回null
     */
    Product getByPId(Integer pid);
    /**
     * 根据id删除产品数据
     * @param pid 将删除的产品数据的id
     * @throws DeleteException 删除数据异常
     */
    void delete(Integer pid) throws DeleteException;
    /**
     * 更新产品数据
     * @param product 产品数据
     * @throws UserNotFoundException 产品数据不存在
     * @throws UpdateException 更新数据异常
     */
    void changeInfo(Product product,String username)
            throws UserNotFoundException,
            UpdateException;
//  删除文件
    void delFile(delProduct del, Integer pid, String username, String fileName) throws DeleteException;
//    更新时间
    void  updateTime(String username);
//  返回所有产品数据的数目
    Integer count();
    /**
     *展示产品类型
     */
    List<TypeVO> getType();

}
