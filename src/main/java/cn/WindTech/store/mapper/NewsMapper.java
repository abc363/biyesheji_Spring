package cn.WindTech.store.mapper;

import cn.WindTech.store.entity.News;
import cn.WindTech.store.entity.delNews;
import cn.WindTech.store.vo.NewsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsMapper {
    Integer insert(News news);
    /**
     *展示新闻数据
     */
    List<News> showNews(@Param("startPage") Integer startPage, @Param("pageSize") Integer pageSize);
//    所有新闻数目
    Integer countByNid();
//     根据id删除新闻数据
    Integer deleteByNid(Integer nid);
//    更新新闻数据
    Integer updateInfo(News news);
//      搜索新闻数据
    List<News> searchNews(@Param("news_title")String new_title, @Param("news_tag") String new_type,
                                @Param("startPage")Integer startPage, @Param("pageSize")Integer pageSize);
//  搜索新闻数据的数目
    Integer countSearchNews(@Param("news_title")String new_title,
                        @Param("news_tag") String new_type);
//    根据id拿取数据
    News findByNid(Integer nid);

    //    根据id拿取数据
    List<News> findByANid(Integer anid);

    //    根据id拿取数据
    List<News> findByUAid(Integer uaid);
//  更新时间
    Integer updateTime(@Param("username")String username,
                       @Param("modifiedTime")String modifiedTime);
//    删除文件
    Integer deleteFile(delNews del);
}
