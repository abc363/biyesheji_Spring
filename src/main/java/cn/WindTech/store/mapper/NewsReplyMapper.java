package cn.WindTech.store.mapper;

import cn.WindTech.store.entity.NewsComment;
import cn.WindTech.store.entity.NewsReply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsReplyMapper {
    Integer insert(NewsReply newsReply);
    /**
     *展示新闻数据
     */
    List<NewsReply> showNewsReply(@Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize);
//    所有新闻数目
    Integer countByRid();
//     根据id删除新闻数据
    Integer deleteByRid(Integer rid);

}
