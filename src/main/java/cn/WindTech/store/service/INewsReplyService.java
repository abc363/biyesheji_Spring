package cn.WindTech.store.service;

import cn.WindTech.store.entity.NewsComment;
import cn.WindTech.store.entity.NewsReply;
import cn.WindTech.store.service.ex.DeleteException;
import cn.WindTech.store.service.ex.InsertException;
import cn.WindTech.store.service.ex.UpdateException;

import java.util.List;

/**
 * 处理产品数据的业务层接口
 */
public interface INewsReplyService {
//  增加新闻
    void addToNewsReply(NewsReply newsReply, String username) throws InsertException, UpdateException;
//  获取所有活动数据
    List<NewsReply> getNewsReply(Integer startPage, Integer pageSize);
    //  获取所有活动数据数目
    Integer count();
//  删除活动
    void delete(Integer rid) throws DeleteException;
}
