package cn.WindTech.store.service;

import cn.WindTech.store.entity.Activity;
import cn.WindTech.store.entity.NewsComment;
import cn.WindTech.store.entity.delActivity;
import cn.WindTech.store.service.ex.DeleteException;
import cn.WindTech.store.service.ex.InsertException;
import cn.WindTech.store.service.ex.UpdateException;
import cn.WindTech.store.service.ex.UserNotFoundException;

import java.util.List;

/**
 * 处理产品数据的业务层接口
 */
public interface INewsCommentService {
//  增加新闻
    void addToNewsComment(NewsComment newsComment, String username) throws InsertException, UpdateException;
//  获取所有活动数据
    List<NewsComment> getNewsComment(Integer startPage, Integer pageSize);
    //  获取所有活动数据数目
    Integer count();
//  删除活动
    void delete(Integer cid) throws DeleteException;
}
