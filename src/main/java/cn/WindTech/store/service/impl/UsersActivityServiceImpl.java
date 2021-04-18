package cn.WindTech.store.service.impl;

import cn.WindTech.store.entity.ActivityNews;
import cn.WindTech.store.entity.UsersActivity;
import cn.WindTech.store.mapper.ActivityNewsMapper;
import cn.WindTech.store.mapper.UsersActivityMapper;
import cn.WindTech.store.service.IActivityNewsService;
import cn.WindTech.store.service.IUsersActivityService;
import cn.WindTech.store.service.ex.InsertException;
import cn.WindTech.store.service.ex.UpdateException;
import cn.WindTech.store.service.ex.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 处理新闻数据的业务层实现类
 */
@Service
public class UsersActivityServiceImpl implements IUsersActivityService {
    @Autowired
    private UsersActivityMapper usersActivityMapper;
//添加新闻
    @Override
    public void addToUsersActivity(UsersActivity usersActivity, String username) throws InsertException, UpdateException {
        // 4项日志：时间是直接创建对象得到，用户名使用参数username
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        usersActivity.setCreatedUser(username);
        usersActivity.setCreatedTime(formatter.format(date));
        usersActivity.setModifiedUser(username);
        usersActivity.setModifiedTime(formatter.format(date));
        // 插入数据：insert(news)
        insert(usersActivity);
    }
    @Override
    public void updateAct(Integer uaid,Integer news_id,String add_tag) {
        // 执行新闻修改
        updateInfo(uaid,news_id,add_tag);
    }
//  根据id获取新闻数据
    @Override
    public List<UsersActivity> getByUAid(Integer uaid) {
        return findByUAid(uaid);
    }
    @Override
    public UsersActivity getByUAidNid(Integer uaid,Integer news_id) {
        return findByUAidNid(uaid,news_id);
    }
    private void insert(UsersActivity usersActivity) {
        Integer rows = usersActivityMapper.insert(usersActivity);
        if (rows != 1) {
            throw new InsertException(
                    "添加活动数据出现未知错误！");
        }
    }

    private List<UsersActivity> findByUAid(Integer uaid) {
        return usersActivityMapper.findByUAid(uaid);
    }
    private UsersActivity findByUAidNid(Integer uaid,Integer news_id) {
        return usersActivityMapper.findByUAidNid(uaid, news_id);
    }
    private void updateInfo(Integer uaid,Integer news_id,String add_tag) {
        Integer rows = usersActivityMapper.updateActivity(uaid,news_id,add_tag);
        if (rows != 1) {
            throw new UpdateException(
                    "修改数据时出现未知错误！");
        }
    }
}
