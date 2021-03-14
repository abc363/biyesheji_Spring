package cn.WindTech.store.mapper;

import cn.WindTech.store.entity.News;
import cn.WindTech.store.entity.NewsComment;
import cn.WindTech.store.entity.delNews;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsCommentMapper {
    Integer insert(NewsComment newsComment);
    /**
     *展示新闻数据
     */
    List<NewsComment> showNewsComment(@Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize);
//    所有新闻数目
    Integer countByCid();
//     根据id删除新闻数据
    Integer deleteByCid(Integer cid);

}
