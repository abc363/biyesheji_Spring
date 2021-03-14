package cn.WindTech.store.service.impl;

import cn.WindTech.store.entity.News;
import cn.WindTech.store.entity.Product;
import cn.WindTech.store.entity.delNews;
import cn.WindTech.store.entity.delProduct;
import cn.WindTech.store.mapper.NewsMapper;
import cn.WindTech.store.mapper.ProductMapper;
import cn.WindTech.store.service.INewsService;
import cn.WindTech.store.service.IProductService;
import cn.WindTech.store.service.ex.DeleteException;
import cn.WindTech.store.service.ex.InsertException;
import cn.WindTech.store.service.ex.UpdateException;
import cn.WindTech.store.service.ex.UserNotFoundException;
import cn.WindTech.store.vo.NewsVO;
import cn.WindTech.store.vo.ProductVO;
import cn.WindTech.store.vo.TypeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 处理新闻数据的业务层实现类
 */
@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    private NewsMapper newsMapper;
//添加新闻
    @Override
    public void addToNews(News news,String username) throws InsertException, UpdateException {
        // 4项日志：时间是直接创建对象得到，用户名使用参数username
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        news.setCreatedUser(username);
        news.setCreatedTime(formatter.format(date));
        news.setModifiedUser(username);
        news.setModifiedTime(formatter.format(date));
        // 插入数据：insert(news)
        insert(news);
    }
//    获取新闻数据
    @Override
    public List<News> getNews(Integer startPage,Integer pageSize) {
        return showNews(startPage,pageSize);
    }
//    获取所有新闻数据
    @Override
    public Integer count(){
        return countNum();
    }
//    删除新闻数据
    @Override
    @Transactional
    public void delete(Integer nid) throws DeleteException{
        // 执行删除
        deleteByNid(nid);
    }
    /**
     * 修改新闻数据
     */
    @Override
    public void changeInfo(News news,String username) throws UserNotFoundException, UpdateException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        news.setModifiedUser(username);
        news.setModifiedTime(formatter.format(date));
        // 执行新闻修改
        updateInfo(news);
    }
//    搜索新闻
    @Override
    public List<News> searchNews(String news_title,String news_tag,Integer startPage,Integer pageSize) {
        return searchNew(news_title,news_tag,startPage,pageSize);
    }
//    搜索新闻数目
    @Override
    public Integer toSearchCountNews(String news_title,String news_tag) {
        return searchCountNews(news_title,news_tag);
    }
//  根据id获取新闻数据
    @Override
    public News getByNid(Integer nid) {
        return findByNid(nid);
    }
    private void insert(News news) {
        Integer rows = newsMapper.insert(news);
        if (rows != 1) {
            throw new InsertException(
                    "添加新闻数据出现未知错误！");
        }
    }
    //    删除文件数据
    @Override
    @Transactional
    public void delFile(delNews del, Integer nid, String username, String fileName) throws DeleteException{
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        del.setNid(nid);
        del.setFileName(fileName);
        del.setModifiedUser(username);
        del.setModifiedTime(formatter.format(date));
        // 执行删除
        deleteFileNid(del);
    }
//    修改时间
    @Override
    public void updateTime(String username) throws UserNotFoundException, UpdateException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        updateServiceTime(username, formatter.format(date));
    }


    private void deleteByNid(Integer nid) {
        Integer rows = newsMapper.deleteByNid(nid);
        if (rows != 1) {
            throw new DeleteException("删除新闻时出现未知错误！");
        }
    }
    private List<News> showNews(Integer startPage, Integer pageSize) {
        return newsMapper.showNews(startPage,pageSize);
    }
    private Integer countNum(){
        return newsMapper.countByNid();
    }

    private void updateInfo(News news) {
        Integer rows = newsMapper.updateInfo(news);
        if (rows != 1) {
            throw new UpdateException(
                    "修改新闻数据时出现未知错误！");
        }
    }
    private List<News> searchNew(String news_title,String news_tag,Integer startPage,Integer pageSize) {
        return newsMapper.searchNews(news_title,news_tag,startPage,pageSize);
    }
    private Integer searchCountNews(String news_title,String news_tag){
        return newsMapper.countSearchNews(news_title,news_tag);
    }
    private News findByNid(Integer nid) {
        return newsMapper.findByNid(nid);
    }

    private void updateServiceTime(String username,String time) {
        Integer rows = newsMapper.updateTime(username,time);
        if (rows != 1) {
            throw new UpdateException(
                    "修改数据时出现未知错误！");
        }
    }
    private void deleteFileNid(delNews del) {
        Integer rows = newsMapper.deleteFile(del);
        if (rows != 1) {
            throw new DeleteException("删除文件时出现未知错误！");
        }
    }
}
