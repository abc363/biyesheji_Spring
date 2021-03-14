package cn.WindTech.store.service.impl;

import cn.WindTech.store.entity.Activity;
import cn.WindTech.store.entity.delActivity;
import cn.WindTech.store.mapper.ActivityMapper;
import cn.WindTech.store.service.IActivityService;
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
public class ActivityServiceImpl implements IActivityService {
    @Autowired
    private ActivityMapper activityMapper;
//添加新闻
    @Override
    public void addToActivity(Activity activity, String username) throws InsertException, UpdateException {
        // 4项日志：时间是直接创建对象得到，用户名使用参数username
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        activity.setCreatedUser(username);
        activity.setCreatedTime(formatter.format(date));
        activity.setModifiedUser(username);
        activity.setModifiedTime(formatter.format(date));
        // 插入数据：insert(news)
        insert(activity);
    }
//    获取新闻数据
    @Override
    public List<Activity> getActivity(Integer startPage,Integer pageSize) {
        return showActivity(startPage,pageSize);
    }
//    获取所有新闻数据
    @Override
    public Integer count(){
        return countNum();
    }
//    删除新闻数据
    @Override
    @Transactional
    public void delete(Integer aid) throws DeleteException{
        // 执行删除
        deleteByAid(aid);
    }
    /**
     * 修改新闻数据
     */
    @Override
    public void changeInfo(Activity activity,String username) throws UserNotFoundException, UpdateException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        activity.setModifiedUser(username);
        activity.setModifiedTime(formatter.format(date));
        // 执行新闻修改
        updateInfo(activity);
    }
//    搜索新闻
    @Override
    public List<Activity> searchActivity(String activity_name,String activity_state,Integer startPage,Integer pageSize) {
        return searchNewsActivity(activity_name,activity_state,startPage,pageSize);
    }
//    搜索新闻数目
    @Override
    public Integer toSearchCountActivity(String activity_name,String activity_state) {
        return searchCountActivity(activity_name,activity_state);
    }
//  根据id获取新闻数据
    @Override
    public Activity getByAid(Integer aid) {
        return findByAid(aid);
    }
    private void insert(Activity activity) {
        Integer rows = activityMapper.insert(activity);
        if (rows != 1) {
            throw new InsertException(
                    "添加活动数据出现未知错误！");
        }
    }
    //    删除文件数据
    @Override
    @Transactional
    public void delFile(delActivity del, Integer aid, String username, String activity_rules) throws DeleteException{
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        del.setAid(aid);
        del.setActivity_rules(activity_rules);
        del.setModifiedUser(username);
        del.setModifiedTime(formatter.format(date));
        // 执行删除
        deleteFileNid(del);
    }



    private void deleteByAid(Integer aid) {
        Integer rows = activityMapper.deleteByAid(aid);
        if (rows != 1) {
            throw new DeleteException("删除活动时出现未知错误！");
        }
    }
    private List<Activity> showActivity(Integer startPage, Integer pageSize) {
        return activityMapper.showActivity(startPage,pageSize);
    }
    private Integer countNum(){
        return activityMapper.countByAid();
    }

    private void updateInfo(Activity activity) {
        Integer rows = activityMapper.updateInfo(activity);
        if (rows != 1) {
            throw new UpdateException(
                    "修改活动数据时出现未知错误！");
        }
    }
    private List<Activity> searchNewsActivity(String activity_name,String activity_state,Integer startPage,Integer pageSize) {
        return activityMapper.searchActivity(activity_name,activity_state,startPage,pageSize);
    }
    private Integer searchCountActivity(String activity_name,String activity_state){
        return activityMapper.countSearchActivity(activity_name,activity_state);
    }
    private Activity findByAid(Integer aid) {
        return activityMapper.findByAid(aid);
    }


    private void deleteFileNid(delActivity del) {
        Integer rows = activityMapper.deleteFile(del);
        if (rows != 1) {
            throw new DeleteException("删除文件时出现未知错误！");
        }
    }
}
