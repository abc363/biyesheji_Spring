package cn.WindTech.store.controller;


import cn.WindTech.store.entity.Activity;
import cn.WindTech.store.entity.ActivityNews;
import cn.WindTech.store.service.IActivityNewsService;
import cn.WindTech.store.util.ResponseResult;
import com.aliyun.oss.OSSClient;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/activityNews")
@CrossOrigin
public class ActivityNewsController extends BaseController{
    @Autowired
    private IActivityNewsService activityNewsService;

    //添加新闻数据
    @PostMapping(value="/add")
    public ResponseResult<List<ActivityNews>> product(@RequestBody ActivityNews activityNews, HttpSession session) {
        String username = "windiot";
        activityNewsService.addToActivityNews(activityNews,username);
        // 返回成功
        return new ResponseResult<>(SUCCESS);
    }
    // 展示分页新闻数据
    @GetMapping("/show")
    public ResponseResult<JSONObject> getActivityNews(@RequestParam("startPage")Integer startPage,
                                                       @RequestParam("pageSize")Integer pageSize) {
        // 调用业务层对象执行
        List<ActivityNews> data = activityNewsService.getActivityNews(startPage,pageSize);
        Integer totalNum = activityNewsService.count();
        JSONObject result= new JSONObject();
        result.put("tableData",data);
        result.put("totalNum",totalNum);
        // 返回
        return new ResponseResult<>(SUCCESS, result);
    }

    //    修改特定的新闻数据
    @RequestMapping("/{anid}/change_info")
    public ResponseResult<Void> changeInfo(@RequestBody ActivityNews activityNews, @PathVariable("anid") Integer aid, HttpSession session) throws IOException {
        // 执行更新：
        activityNews.setAnid(aid);
//        System.out.println(session.getAttribute("username").toString());
//        String username = session.getAttribute("username").toString();
        String username = "windiot";
        activityNewsService.changeInfo(activityNews,username);

        // 返回成功
        return new ResponseResult<>(SUCCESS);
    }
    //    显示相应id的产品数据
    @GetMapping("/{aid}/showActivityNews")
    public ResponseResult<ActivityNews> getByAnid(@PathVariable("anid") Integer anid) {
        // 调用业务层对象执行
        ActivityNews data=activityNewsService.getByAnid(anid);
        // 返回
        return new ResponseResult<>(SUCCESS,data);
    }
}
