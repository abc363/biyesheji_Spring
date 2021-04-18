package cn.WindTech.store.mapper;

import cn.WindTech.store.entity.Activity;
import cn.WindTech.store.entity.UsersActivity;
import cn.WindTech.store.entity.delActivity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersActivityMapper {
    Integer insert(UsersActivity usersActivity);
//    根据id拿取数据
List<UsersActivity> findByUAid(Integer uaid);
    UsersActivity findByUAidNid(Integer uaid,Integer news_id);
    Integer updateActivity(Integer uaid,Integer news_id,String add_tag);
}
