package cn.WindTech.store.service.impl;

import cn.WindTech.store.entity.Product;
import cn.WindTech.store.mapper.ProductMapper;
import cn.WindTech.store.service.IProductService;
import cn.WindTech.store.service.ex.*;
import cn.WindTech.store.vo.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
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
    public void addToPro(Product product,String username) throws InsertException, UpdateException {
        // 4项日志：时间是直接创建对象得到，用户名使用参数username
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        product.setCreatedUser(username);
        product.setCreatedTime(formatter.format(date));
        product.setModifiedUser(username);
        product.setModifiedTime(formatter.format(date));
        // 插入数据：insert(product)
        insert(product);
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
    }
    @Override
    public void changeInfo(Product product,String username) throws UserNotFoundException, UpdateException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        product.setModifiedUser(username);
        product.setModifiedTime(formatter.format(date));
        // 执行产品修改
        updateInfo(product);
    }

    @Override
    public void changeImage(Integer pid, String pro_img,String username) throws UserNotFoundException, UpdateException {

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                // 执行图片更新
        updateAvatar(pid, pro_img,username,formatter.format(date));
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

    /**
     * 更新产品图片
     * @param pid 产品的id
     * @param pro_img 图片的路径
     */
    private void updateAvatar(Integer pid, String pro_img ,String modifiedUser,String modifiedTime){
        Integer rows = productMapper.updateImage(pid, pro_img,modifiedUser,modifiedTime);
        if (rows != 1) {
            throw new UpdateException("修改图片数据时出现未知错误！");
        }
    }

}
