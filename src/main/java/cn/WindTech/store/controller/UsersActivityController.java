package cn.WindTech.store.controller;


import cn.WindTech.store.entity.ActivityNews;
import cn.WindTech.store.entity.News;
import cn.WindTech.store.entity.User;
import cn.WindTech.store.entity.UsersActivity;
import cn.WindTech.store.service.IActivityNewsService;
import cn.WindTech.store.service.IUsersActivityService;
import cn.WindTech.store.util.ResponseResult;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/UsersActivity")
@CrossOrigin
public class UsersActivityController extends BaseController{
    @Autowired
    private IUsersActivityService usersActivityService;

    //添加新闻数据
    @PostMapping(value="/add")
    public ResponseResult<List<UsersActivity>> product(@RequestBody UsersActivity usersActivity, HttpSession session) {
//        String username = session.getAttribute("username").toString();

        Integer uaid = usersActivity.getUaid();
        Integer news_id = usersActivity.getNews_id();
        String add_tag = usersActivity.getAdd_tag();//        查询是否有该用户行为
//        没有就插入，有就修改
        String username = "windiot";
        UsersActivity data = usersActivityService.getByUAidNid(uaid,news_id);
        if(data == null){
            usersActivityService.addToUsersActivity(usersActivity,username);
        }else{
            usersActivityService.updateAct(uaid,news_id,add_tag);
        }
        // 返回成功
        return new ResponseResult<>(SUCCESS);
    }
    //    显示相应id的产品数据
    @GetMapping("/{uaid}/showUsersActivity")
    public ResponseResult<List<UsersActivity>> getByUAid(@PathVariable("uaid") Integer uaid) {
        // 调用业务层对象执行
        List<UsersActivity> data=usersActivityService.getByUAid(uaid);
        // 返回
        return new ResponseResult<>(SUCCESS,data);
    }
}
