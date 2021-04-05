package cn.WindTech.store.controller;


import cn.WindTech.store.entity.ActivityNews;
import cn.WindTech.store.entity.NewsComment;
import cn.WindTech.store.service.IActivityNewsService;
import cn.WindTech.store.service.INewsCommentService;
import cn.WindTech.store.util.ResponseResult;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/NewsComment")
@CrossOrigin
public class NewsCommentController extends BaseController{
    @Autowired
    private INewsCommentService newsCommentService;

    //添加新闻数据
    @PostMapping(value="/add")
    public ResponseResult<List<NewsComment>> product(@RequestBody NewsComment newsComment, HttpSession session) {
//        String username = session.getAttribute("username").toString();
        String username = "windiot";
        newsCommentService.addToNewsComment(newsComment,username);
        // 返回成功
        return new ResponseResult<>(SUCCESS);
    }
    // 展示分页新闻数据
    @GetMapping("/show")
    public ResponseResult<JSONObject> getNewsComment(@RequestParam("news_id") Integer news_id,@RequestParam("startPage")Integer startPage,
                                                       @RequestParam("pageSize")Integer pageSize) {
        // 调用业务层对象执行
        List<NewsComment> data = newsCommentService.getNewsComment(news_id,startPage,pageSize);
        Integer totalNum = newsCommentService.count(news_id);
        JSONObject result= new JSONObject();
        result.put("tableData",data);
        result.put("totalNum",totalNum);
        // 返回
        return new ResponseResult<>(SUCCESS, result);
    }
    //删除特定id的数据
    @RequestMapping("/{cid}/delete")
    public ResponseResult<Void> delete(@PathVariable("cid") Integer cid,HttpSession session) {
        // 执行
        newsCommentService.delete(cid);
        // 返回
        return new ResponseResult<>(SUCCESS);
    }

}
