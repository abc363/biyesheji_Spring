package cn.WindTech.store.service;

import cn.WindTech.store.entity.Product;
import cn.WindTech.store.service.ex.*;
import cn.WindTech.store.vo.ProductVO;

import java.nio.file.AccessDeniedException;
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
    List<ProductVO> getProduct();
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
    /**
     * 更新产品图片
     * @param pro_img 图片路径
     * @throws UserNotFoundException 图片数据不存在
     * @throws UpdateException 更新数据异常
     */
    void changeImage(Integer pid, String pro_img,String username)
            throws UserNotFoundException,
            UpdateException;

}
