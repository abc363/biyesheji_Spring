package cn.WindTech.store.controller;


import cn.WindTech.store.entity.NewsComment;
import cn.WindTech.store.entity.NewsReply;
import cn.WindTech.store.service.INewsCommentService;
import cn.WindTech.store.service.INewsReplyService;
import cn.WindTech.store.util.ResponseResult;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/NewsReply")
@CrossOrigin
public class NewsReplyController extends BaseController{
    @Autowired
    private INewsReplyService newsReplyService;

    //添加新闻数据
    @PostMapping(value="/add")
    public ResponseResult<List<NewsReply>> product(@RequestBody NewsReply newsReply, HttpSession session) {
//        String username = session.getAttribute("username").toString();
        String username = "windiot";
        newsReplyService.addToNewsReply(newsReply,username);
        // 返回成功
        return new ResponseResult<>(SUCCESS);
    }
    // 展示分页新闻数据
    @GetMapping("/show")
    public ResponseResult<JSONObject> getNewsReply(@RequestParam("startPage")Integer startPage,
                                                       @RequestParam("pageSize")Integer pageSize) {
        // 调用业务层对象执行
        List<NewsReply> data = newsReplyService.getNewsReply(startPage,pageSize);
        Integer totalNum = newsReplyService.count();
        JSONObject result= new JSONObject();
        result.put("tableData",data);
        result.put("totalNum",totalNum);
        // 返回
        return new ResponseResult<>(SUCCESS, result);
    }
    //删除特定id的数据
    @RequestMapping("/{rid}/delete")
    public ResponseResult<Void> delete(@PathVariable("rid") Integer rid,HttpSession session) {
        // 执行
        newsReplyService.delete(rid);
        // 返回
        return new ResponseResult<>(SUCCESS);
    }

}
