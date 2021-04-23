package cn.WindTech.store.service;

import cn.WindTech.store.entity.News;
import cn.WindTech.store.entity.Product;
import cn.WindTech.store.entity.delNews;
import cn.WindTech.store.entity.delProduct;
import cn.WindTech.store.service.ex.DeleteException;
import cn.WindTech.store.service.ex.InsertException;
import cn.WindTech.store.service.ex.UpdateException;
import cn.WindTech.store.service.ex.UserNotFoundException;
import java.util.List;

/**
 * 处理产品数据的业务层接口
 */
public interface INewsService {
//  增加新闻
    void addToNews(News news, String username) throws InsertException, UpdateException;
//  获取所有新闻数据
    List<News> getNews(Integer startPage, Integer pageSize);
    List<News> getNewsByCold(Integer startPage, Integer pageSize);
    //  获取所有新闻数据数目
    Integer count();
    Integer countByCold();
//  删除新闻
    void delete(Integer nid) throws DeleteException;
//  修改新闻数据
    void changeInfo(News news,String username)
            throws UserNotFoundException,
            UpdateException;
    void changeView(Integer nid,Integer news_view);
//  搜索新闻数据
    List<News> searchNews(String news_title,String news_tag,Integer startPage,Integer pageSize);
//    搜索新闻数据数目
    Integer toSearchCountNews(String news_title,String news_tag);
//    根据id获取新闻数据
    News getByNid(Integer nid);
    //    根据id获取新闻数据
    List<News> getByANid(Integer anid);
    //    根据id获取新闻数据
    List<News> getByUAid(Integer uaid);
    List<News> getAllNews();
    List<News> getByTag(String news_tag);
//    更新时间
    void  updateTime(String username);
//    删除文件
    void delFile(delNews del, Integer nid, String username, String fileName) throws DeleteException;
}
