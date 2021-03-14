package cn.WindTech.store.service.impl;

import cn.WindTech.store.entity.NewsComment;
import cn.WindTech.store.entity.NewsReply;
import cn.WindTech.store.mapper.NewsCommentMapper;
import cn.WindTech.store.mapper.NewsReplyMapper;
import cn.WindTech.store.service.INewsCommentService;
import cn.WindTech.store.service.INewsReplyService;
import cn.WindTech.store.service.ex.DeleteException;
import cn.WindTech.store.service.ex.InsertException;
import cn.WindTech.store.service.ex.UpdateException;
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
public class NewsReplyServiceImpl implements INewsReplyService {
    @Autowired
    private NewsReplyMapper newsReplyMapper;
//添加新闻
    @Override
    public void addToNewsReply(NewsReply newsReply, String username) throws InsertException, UpdateException {
        // 4项日志：时间是直接创建对象得到，用户名使用参数username
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        newsReply.setCreatedUser(username);
        newsReply.setCreatedTime(formatter.format(date));
        newsReply.setModifiedUser(username);
        newsReply.setModifiedTime(formatter.format(date));
        // 插入数据：insert(news)
        insert(newsReply);
    }
//    获取新闻数据
    @Override
    public List<NewsReply> getNewsReply(Integer startPage,Integer pageSize) {
        return showNewsReply(startPage,pageSize);
    }
//    获取所有新闻数据
    @Override
    public Integer count(){
        return countNum();
    }
    //    删除新闻数据
    @Override
    @Transactional
    public void delete(Integer rid) throws DeleteException {
        // 执行删除
        deleteByRid(rid);
    }


    private void insert(NewsReply newsReply) {
        Integer rows = newsReplyMapper.insert(newsReply);
        if (rows != 1) {
            throw new InsertException(
                    "添加活动数据出现未知错误！");
        }
    }
    private List<NewsReply> showNewsReply(Integer startPage, Integer pageSize) {
        return newsReplyMapper.showNewsReply(startPage,pageSize);
    }
    private Integer countNum(){
        return newsReplyMapper.countByRid();
    }
    private void deleteByRid(Integer rid) {
        Integer rows = newsReplyMapper.deleteByRid(rid);
        if (rows != 1) {
            throw new DeleteException("删除活动时出现未知错误！");
        }
    }

}
