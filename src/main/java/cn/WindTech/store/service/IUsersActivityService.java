package cn.WindTech.store.service;

import cn.WindTech.store.entity.ActivityNews;
import cn.WindTech.store.entity.UsersActivity;
import cn.WindTech.store.service.ex.InsertException;
import cn.WindTech.store.service.ex.UpdateException;
import cn.WindTech.store.service.ex.UserNotFoundException;

import java.util.List;

/**
 * 处理产品数据的业务层接口
 */
public interface IUsersActivityService {
    //  增加新闻
    void addToUsersActivity(UsersActivity usersActivity, String username) throws InsertException, UpdateException;
//    根据id获取新闻数据
List<UsersActivity> getByUAid(Integer uaid);
    List<UsersActivity> getAll();
    UsersActivity getByUAidNid(Integer uaid,Integer news_id);
    void  updateAct(Integer uaid,Integer news_id,String add_tag);
}
