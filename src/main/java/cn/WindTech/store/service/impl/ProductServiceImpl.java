package cn.WindTech.store.service.impl;

import cn.WindTech.store.entity.Product;
import cn.WindTech.store.mapper.ProductMapper;
import cn.WindTech.store.service.IProductService;
import cn.WindTech.store.service.ex.*;
import cn.WindTech.store.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.AccessDeniedException;
import java.util.Date;
import java.util.List;

/**
 * 处理产品数据的业务层实现类
 */
@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public void addToPro(Product product) throws InsertException, UpdateException {
        // 插入数据：insert(product)
        insert(product);
        Date now = new Date();
        product.setModifiedUser("WindTech");
        product.setModifiedTime(now);
    }
    //    查询产品数据
    @Override
    public List<ProductVO> getProduct() {
        return showProduct();
    }

    @Override
    public Product getByPId(Integer pid) {
        return findByPId(pid);
    }
//    删除产品数据
    @Override
    @Transactional
    public void delete(Integer pid) throws DeleteException{
        // 执行删除
        deleteByPid(pid);
        // 获取产品数量
        Integer count = countProduct();
        // 判断数量是否为0
        if (count.equals(0)) {
            return;
        }
    }
    @Override
    public void changeInfo(Product product) throws UserNotFoundException, UpdateException {
        // 执行产品修改
        updateInfo(product);
        Date now = new Date();
        product.setModifiedUser("WindTech");
        product.setModifiedTime(now);
    }


    /**
     * 查询产品数据
     */
    private List<ProductVO> showProduct() {
        return productMapper.showProduct();
    }
    /**
     * 根据产品id查询匹配的数据
     * @param pid 产品id
     * @return 匹配的数据，如果没有匹配的数据，则返回null
     */
    private Product findByPId(Integer pid) {
        return productMapper.findByPId(pid);
    }
    /**
     * 插入产品数据
     * @param product 产品数据
     */
    private void insert(Product product) {
        Integer rows = productMapper.insert(product);
        if (rows != 1) {
            throw new InsertException(
                    "添加购产品数据出现未知错误！");
        }
    }
    /**
     * 根据id删除产品数据
     * @param pid 将删除产品数据的id
     * @return 受影响的行数
     */
    private void deleteByPid(Integer pid) {
        Integer rows = productMapper.deleteByPid(pid);
        if (rows != 1) {
            throw new DeleteException("删除产品时出现未知错误！");
        }
    }
    /**
     * 统计产品数据的数量
     * @return 产品数据的数量
     */
    private Integer countProduct() {
        return productMapper.countProduct();
    }
    /**
     * 更新产品数据
     * @param product 产品数据
     */
    private void updateInfo(Product product) {
        Integer rows = productMapper.updateInfo(product);
        if (rows != 1) {
            throw new UpdateException(
                    "修改产品数据时出现未知错误！");
        }
    }
}
