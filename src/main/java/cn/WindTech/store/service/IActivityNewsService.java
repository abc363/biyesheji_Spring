package cn.WindTech.store.service;

import cn.WindTech.store.entity.Activity;
import cn.WindTech.store.entity.ActivityNews;
import cn.WindTech.store.entity.delActivity;
import cn.WindTech.store.service.ex.DeleteException;
import cn.WindTech.store.service.ex.InsertException;
import cn.WindTech.store.service.ex.UpdateException;
import cn.WindTech.store.service.ex.UserNotFoundException;

import java.util.List;

/**
 * 处理产品数据的业务层接口
 */
public interface IActivityNewsService {
    //  增加新闻
    void addToActivityNews(ActivityNews activityNews, String username) throws InsertException, UpdateException;
//  获取所有活动数据
    List<ActivityNews> getActivityNews(Integer startPage, Integer pageSize);
    //  获取所有活动数据数目
    Integer count();
//  修改新闻数据
    void changeInfo(ActivityNews activityNews, String username)
            throws UserNotFoundException,
            UpdateException;
//    根据id获取新闻数据
    ActivityNews getByAnid(Integer anid);
}
