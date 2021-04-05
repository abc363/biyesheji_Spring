package cn.WindTech.store.controller;


import cn.WindTech.store.entity.ActivityNews;
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
        String username = "windiot";
        usersActivityService.addToUsersActivity(usersActivity,username);
        // 返回成功
        return new ResponseResult<>(SUCCESS);
    }
    //    显示相应id的产品数据
    @GetMapping("/{uaid}/showUsersActivity")
    public ResponseResult<UsersActivity> getByUAid(@PathVariable("uaid") Integer uaid) {
        // 调用业务层对象执行
        UsersActivity data=usersActivityService.getByUAid(uaid);
        // 返回
        return new ResponseResult<>(SUCCESS,data);
    }
}
