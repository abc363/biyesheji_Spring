package cn.WindTech.store.service.impl;

import cn.WindTech.store.entity.NewsComment;
import cn.WindTech.store.mapper.ActivityNewsMapper;
import cn.WindTech.store.mapper.NewsCommentMapper;
import cn.WindTech.store.service.IActivityNewsService;
import cn.WindTech.store.service.INewsCommentService;
import cn.WindTech.store.service.ex.DeleteException;
import cn.WindTech.store.service.ex.InsertException;
import cn.WindTech.store.service.ex.UpdateException;
import cn.WindTech.store.service.ex.UserNotFoundException;
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
public class NewsCommentServiceImpl implements INewsCommentService {
    @Autowired
    private NewsCommentMapper newsCommentMapper;
//添加新闻
    @Override
    public void addToNewsComment(NewsComment newsComment, String username) throws InsertException, UpdateException {
        // 4项日志：时间是直接创建对象得到，用户名使用参数username
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        newsComment.setCreatedUser(username);
        newsComment.setCreatedTime(formatter.format(date));
        newsComment.setModifiedUser(username);
        newsComment.setModifiedTime(formatter.format(date));
        // 插入数据：insert(news)
        insert(newsComment);
    }
//    获取新闻数据
    @Override
    public List<NewsComment> getNewsComment(Integer startPage,Integer pageSize) {
        return showNewsComment(startPage,pageSize);
    }
//    获取所有新闻数据
    @Override
    public Integer count(){
        return countNum();
    }
    //    删除新闻数据
    @Override
    @Transactional
    public void delete(Integer cid) throws DeleteException {
        // 执行删除
        deleteByCid(cid);
    }


    private void insert(NewsComment newsComment) {
        Integer rows = newsCommentMapper.insert(newsComment);
        if (rows != 1) {
            throw new InsertException(
                    "添加活动数据出现未知错误！");
        }
    }
    private List<NewsComment> showNewsComment(Integer startPage, Integer pageSize) {
        return newsCommentMapper.showNewsComment(startPage,pageSize);
    }
    private Integer countNum(){
        return newsCommentMapper.countByCid();
    }
    private void deleteByCid(Integer cid) {
        Integer rows = newsCommentMapper.deleteByCid(cid);
        if (rows != 1) {
            throw new DeleteException("删除活动时出现未知错误！");
        }
    }

}
