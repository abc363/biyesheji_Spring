package cn.WindTech.store.service.impl;

import cn.WindTech.store.entity.Product;
import cn.WindTech.store.entity.delProduct;
import cn.WindTech.store.mapper.ProductMapper;
import cn.WindTech.store.service.IProductService;
import cn.WindTech.store.service.ex.*;
import cn.WindTech.store.vo.ProductVO;
import cn.WindTech.store.vo.TypeVO;
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
//  添加产品数据
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
    public List<ProductVO> getProduct(Integer startPage,Integer pageSize) {
        return showProduct(startPage,pageSize);
    }
    //    查询所有产品数据
    @Override
    public List<ProductVO> getAllProduct(Product product) {
        return showAllProduct(product);
    }
    //    搜索产品数据
    @Override
    public List<ProductVO> searchProduct(String pro_Name,String pro_State,String pro_Type,Integer startPage,Integer pageSize) {
        return searchPro(pro_Name,pro_State,pro_Type,startPage,pageSize);
    }
    //    搜索产品数据数目
    @Override
    public Integer toSearchCount(String pro_Name,String pro_State,String pro_Type) {
        return searchCount(pro_Name,pro_State,pro_Type);
    }
//    根据id获取产品数据
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
//    所有产品数据数目
    @Override
    public Integer count(){
        return countNum();
    }

    //    删除文件数据
    @Override
    @Transactional
    public void delFile(delProduct del, Integer pid, String username, String fileName) throws DeleteException{
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        del.setPid(pid);
        del.setFileName(fileName);
        del.setModifiedUser(username);
        del.setModifiedTime(formatter.format(date));
        // 执行删除
        deleteFilePid(del);
    }

    /**
     * 修改产品数据
     */
    @Override
    public void changeInfo(Product product,String username) throws UserNotFoundException, UpdateException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        product.setModifiedUser(username);
        product.setModifiedTime(formatter.format(date));
        // 执行产品修改
        updateInfo(product);
    }
//    修改时间
    @Override
    public void updateTime(String username) throws UserNotFoundException, UpdateException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 执行产品修改
        updateServiceTime(username, formatter.format(date));
    }
//    获取产品类型
    @Override
    public List<TypeVO> getType() throws UserNotFoundException, UpdateException {
        return showType();
    }




    /**
     * 查询产品数据
     */
    private List<ProductVO> showProduct(Integer startPage,Integer pageSize) {
        return productMapper.showProduct(startPage,pageSize);
    }
    /**
     * 查询产品类型
     */
    private List<TypeVO> showType() {
        return productMapper.showType();
    }
    /**
     * 查询所有产品数据
     */
    private List<ProductVO> showAllProduct(Product product) {
        return productMapper.showAllProduct(product);
    }
    /**
     * 搜索产品数据
     */
    private List<ProductVO> searchPro(String pro_Name,String pro_State,String pro_Type,Integer startPage,Integer pageSize) {
        return productMapper.searchProduct(pro_Name,pro_State,pro_Type,startPage,pageSize);
    }
//    返回所有产品数目
    private Integer countNum(){
         return productMapper.countByPid();
    }
//    返回搜索产品数目
    private Integer searchCount(String pro_Name,String pro_State,String pro_Type){
        return productMapper.countSearch(pro_Name,pro_State,pro_Type);
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
//    删除文件数据库字段置空
    private void deleteFilePid(delProduct del) {
        Integer rows = productMapper.deleteFile(del);
        if (rows != 1) {
            throw new DeleteException("删除文件时出现未知错误！");
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

    private void updateServiceTime(String username,String time) {
        Integer rows = productMapper.updateTime(username,time);
        if (rows != 1) {
            throw new UpdateException(
                    "修改数据时出现未知错误！");
        }
    }

}
