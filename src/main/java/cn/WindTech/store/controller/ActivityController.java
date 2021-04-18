package cn.WindTech.store.controller;


import cn.WindTech.store.entity.*;
import cn.WindTech.store.service.IActivityService;
import cn.WindTech.store.service.INewsService;
import cn.WindTech.store.util.FileUtil;
import cn.WindTech.store.util.ResponseResult;
import cn.WindTech.store.vo.NewsVO;
import com.aliyun.oss.OSSClient;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/activity")
@CrossOrigin
public class ActivityController extends BaseController{
    @Autowired
    private IActivityService activityService;

    //添加新闻数据
    @PostMapping(value="/add")
    public ResponseResult<List<Activity>> product(@RequestBody Activity activity, HttpSession session) {
//        String username = session.getAttribute("username").toString();
        String username = "windiot";
        activityService.addToActivity(activity,username);
        // 返回成功
        return new ResponseResult<>(SUCCESS);
    }
    // 展示分页新闻数据
    @GetMapping("/show")
    public ResponseResult<JSONObject> getActivity(@RequestParam("startPage")Integer startPage,
                                                       @RequestParam("pageSize")Integer pageSize) {
        // 调用业务层对象执行
        List<Activity> data = activityService.getActivity(startPage,pageSize);
        Integer totalNum = activityService.count();
        JSONObject result= new JSONObject();
        result.put("tableData",data);
        result.put("totalNum",totalNum);
        // 返回
        return new ResponseResult<>(SUCCESS, result);
    }

    //删除特定id的数据
    @RequestMapping("/{aid}/delete")
    public ResponseResult<Void> delete(@PathVariable("aid") Integer aid,HttpSession session) {
        // 执行
        activityService.delete(aid);
        // 返回
        return new ResponseResult<>(SUCCESS);
    }
    //    修改特定的新闻数据
    @RequestMapping("/{aid}/change_info")
    public ResponseResult<Void> changeInfo(@RequestBody Activity activity, @PathVariable("aid") Integer aid, HttpSession session) throws IOException {
        // 执行更新：
        activity.setAid(aid);
//        System.out.println(session.getAttribute("username").toString());
//        String username = session.getAttribute("username").toString();
        String username = "windiot";
        activityService.changeInfo(activity,username);

        // 返回成功
        return new ResponseResult<>(SUCCESS);
    }
    // 模糊搜索新闻数据
    @RequestMapping("/search")
    public ResponseResult<JSONObject> searchActivity(@RequestBody SearchActivity search) {
        String activity_name = search.getActivity_name();
        String activity_state = search.getActivity_state();
        Integer startPage = search.getStartPage();
        Integer pageSize = search.getPageSize();
        // 调用业务层对象执行
        List<Activity> data = activityService.searchActivity(activity_name,activity_state,startPage,pageSize);
        Integer totalNum = activityService.toSearchCountActivity(activity_name,activity_state);
        JSONObject result = new JSONObject();
        result.put("tableData",data);
        result.put("totalNum",totalNum);
        // 返回
        return new ResponseResult<>(SUCCESS, result);
    }
    //    显示相应id的产品数据
    @GetMapping("/{aid}/showActivity")
    public ResponseResult<Activity> getByAid(@PathVariable("aid") Integer aid) {
        // 调用业务层对象执行
        Activity data=activityService.getByAid(aid);
        // 返回
        return new ResponseResult<>(SUCCESS,data);
    }
    //    删除文件
    @RequestMapping(value="/deleteFile")
    public ResponseResult<Void> deletePath(@RequestBody delActivity del,HttpSession session) throws IOException {
        Integer aid = del.getAid();
        String activity_rules = del.getActivity_rules();
        String endpoint = FileUtil.ENDPOINT;
        String accessKeyId = FileUtil.KEYID;
        String accessKeySecret = FileUtil.KEYSECRET;
        String yourBucketName = FileUtil.BUCKETNAME;
        activity_rules = activity_rules.replaceAll("\\\\", "/");
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.deleteObject(yourBucketName,activity_rules);
        ossClient.shutdown();
        if(aid!=0){
//            String username = session.getAttribute("username").toString();
            String username = "windiot";
            activityService.delFile(del,aid,username,activity_rules);
        }
        return new ResponseResult<>(SUCCESS);
    }
}
