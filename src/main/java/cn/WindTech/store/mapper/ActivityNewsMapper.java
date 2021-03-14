package cn.WindTech.store.mapper;

import cn.WindTech.store.entity.Activity;
import cn.WindTech.store.entity.ActivityNews;
import cn.WindTech.store.entity.delActivity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityNewsMapper {
    Integer insert(ActivityNews activityNews);
    /**
     *展示活动数据
     */
    List<ActivityNews> showActivityNews(@Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize);
//    所有活动数目
    Integer countByAnid();
//    更新活动数据
    Integer updateInfo(ActivityNews activityNews);
//    根据id拿取数据
    ActivityNews findByAnid(Integer anid);
}
