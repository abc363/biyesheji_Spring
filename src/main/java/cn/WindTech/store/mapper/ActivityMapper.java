package cn.WindTech.store.mapper;

import cn.WindTech.store.entity.Activity;
import cn.WindTech.store.entity.News;
import cn.WindTech.store.entity.delActivity;
import cn.WindTech.store.entity.delNews;
import cn.WindTech.store.vo.NewsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityMapper {
    Integer insert(Activity activity);
    /**
     *展示活动数据
     */
    List<Activity> showActivity(@Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize);
//    所有活动数目
    Integer countByAid();
//     根据id删除活动数据
    Integer deleteByAid(Integer aid);
//    更新活动数据
    Integer updateInfo(Activity activity);
//      搜索活动数据
    List<Activity> searchActivity(@Param("activity_name") String activity_name, @Param("activity_state") String activity_state,
                            @Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize);
//  搜索活动数据的数目
    Integer countSearchActivity(@Param("activity_name") String activity_name,
                            @Param("activity_state") String activity_state);
//    根据id拿取数据
    Activity findByAid(Integer aid);
//    删除文件
    Integer deleteFile(delActivity del);
}
