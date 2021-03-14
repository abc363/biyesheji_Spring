package cn.WindTech.store.service;

import cn.WindTech.store.entity.Activity;
import cn.WindTech.store.entity.delActivity;
import cn.WindTech.store.service.ex.DeleteException;
import cn.WindTech.store.service.ex.InsertException;
import cn.WindTech.store.service.ex.UpdateException;
import cn.WindTech.store.service.ex.UserNotFoundException;

import java.util.List;

/**
 * 处理产品数据的业务层接口
 */
public interface IActivityService {
//  增加新闻
    void addToActivity(Activity activity, String username) throws InsertException, UpdateException;
//  获取所有活动数据
    List<Activity> getActivity(Integer startPage, Integer pageSize);
    //  获取所有活动数据数目
    Integer count();
//  删除活动
    void delete(Integer aid) throws DeleteException;
//  修改新闻数据
    void changeInfo(Activity activity, String username)
            throws UserNotFoundException,
            UpdateException;
//  搜索新闻数据
    List<Activity> searchActivity(String activity_name, String activity_state, Integer startPage, Integer pageSize);
//    搜索新闻数据数目
    Integer toSearchCountActivity(String activity_name, String activity_state);
//    根据id获取新闻数据
    Activity getByAid(Integer aid);
    //    删除文件
    void delFile(delActivity del, Integer aid, String username, String activity_rules) throws DeleteException;
}
