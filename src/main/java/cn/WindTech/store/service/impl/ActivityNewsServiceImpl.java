package cn.WindTech.store.service.impl;

import cn.WindTech.store.entity.Activity;
import cn.WindTech.store.entity.ActivityNews;
import cn.WindTech.store.entity.delActivity;
import cn.WindTech.store.mapper.ActivityMapper;
import cn.WindTech.store.mapper.ActivityNewsMapper;
import cn.WindTech.store.service.IActivityNewsService;
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
public class ActivityNewsServiceImpl implements IActivityNewsService {
    @Autowired
    private ActivityNewsMapper activityNewsMapper;
//添加新闻
    @Override
    public void addToActivityNews(ActivityNews activityNews, String username) throws InsertException, UpdateException {
        // 4项日志：时间是直接创建对象得到，用户名使用参数username
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        activityNews.setCreatedUser(username);
        activityNews.setCreatedTime(formatter.format(date));
        activityNews.setModifiedUser(username);
        activityNews.setModifiedTime(formatter.format(date));
        // 插入数据：insert(news)
        insert(activityNews);
    }
//    获取新闻数据
    @Override
    public List<ActivityNews> getActivityNews(Integer startPage,Integer pageSize) {
        return showActivityNews(startPage,pageSize);
    }
//    获取所有新闻数据
    @Override
    public Integer count(){
        return countNum();
    }

    /**
     * 修改新闻数据
     */
    @Override
    public void changeInfo(ActivityNews activityNews,String username) throws UserNotFoundException, UpdateException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        activityNews.setModifiedUser(username);
        activityNews.setModifiedTime(formatter.format(date));
        // 执行新闻修改
        updateInfo(activityNews);
    }

//  根据id获取新闻数据
    @Override
    public ActivityNews getByAnid(Integer anid) {
        return findByAnid(anid);
    }
    private void insert(ActivityNews activityNews) {
        Integer rows = activityNewsMapper.insert(activityNews);
        if (rows != 1) {
            throw new InsertException(
                    "添加活动数据出现未知错误！");
        }
    }



    private List<ActivityNews> showActivityNews(Integer startPage, Integer pageSize) {
        return activityNewsMapper.showActivityNews(startPage,pageSize);
    }
    private Integer countNum(){
        return activityNewsMapper.countByAnid();
    }

    private void updateInfo(ActivityNews activityNews) {
        Integer rows = activityNewsMapper.updateInfo(activityNews);
        if (rows != 1) {
            throw new UpdateException(
                    "修改活动数据时出现未知错误！");
        }
    }

    private ActivityNews findByAnid(Integer anid) {
        return activityNewsMapper.findByAnid(anid);
    }

}
