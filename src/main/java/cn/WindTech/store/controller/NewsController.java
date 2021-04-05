package cn.WindTech.store.controller;


import cn.WindTech.store.entity.*;
import cn.WindTech.store.service.INewsService;
import cn.WindTech.store.util.FileUtil;
import cn.WindTech.store.util.ResponseResult;
import cn.WindTech.store.vo.NewsVO;
import com.aliyun.oss.OSSClient;
import net.sf.json.JSONObject;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/news")
@CrossOrigin
public class NewsController extends BaseController{
    @Autowired
    private INewsService newsService;

    //添加新闻数据
    @PostMapping(value="/add")
    public ResponseResult<List<News>> product(@RequestBody News news, HttpSession session) {
//        String username = session.getAttribute("username").toString();
        String username = "windiot";
        newsService.addToNews(news,username);
        // 返回成功
        return new ResponseResult<>(SUCCESS);
    }
    // 展示分页新闻数据
    @GetMapping("/show")
    public ResponseResult<JSONObject> getNews(@RequestParam("startPage")Integer startPage,
                                                       @RequestParam("pageSize")Integer pageSize) {
        // 调用业务层对象执行
        List<News> data = newsService.getNews(startPage,pageSize);
        Integer totalNum = newsService.count();
        JSONObject result= new JSONObject();
        result.put("tableData",data);
        result.put("totalNum",totalNum);
        // 返回
        return new ResponseResult<>(SUCCESS, result);
    }

    //删除特定id的数据
    @RequestMapping("/{nid}/delete")
    public ResponseResult<Void> delete(@PathVariable("nid") Integer nid,HttpSession session) {
        // 执行
//        String username = session.getAttribute("username").toString();
        String username = "windiot";
        newsService.delete(nid);
        newsService.updateTime(username);
        // 返回
        return new ResponseResult<>(SUCCESS);
    }
    //    修改特定的新闻数据
    @RequestMapping("/{nid}/change_info")
    public ResponseResult<Void> changeInfo(@RequestBody News news, @PathVariable("nid") Integer nid, HttpSession session) throws IOException {
        // 执行更新：
        news.setNid(nid);
//        System.out.println(session.getAttribute("username").toString());
//        String username = session.getAttribute("username").toString();
        String username = "windiot";
        newsService.changeInfo(news,username);

        // 返回成功
        return new ResponseResult<>(SUCCESS);
    }
    // 模糊搜索新闻数据
    @RequestMapping("/search")
    public ResponseResult<JSONObject> searchNews(@RequestBody SearchNews search) {
        String news_title = search.getNews_title();
        String news_tag = search.getNews_tag();
        Integer startPage = search.getStartPage();
        Integer pageSize = search.getPageSize();
        // 调用业务层对象执行
        List<News> data = newsService.searchNews(news_title,news_tag,startPage,pageSize);
        Integer totalNum = newsService.toSearchCountNews(news_title,news_tag);
        JSONObject result = new JSONObject();
        result.put("tableData",data);
        result.put("totalNum",totalNum);
        // 返回
        return new ResponseResult<>(SUCCESS, result);
    }
    //    显示相应id的产品数据
    @GetMapping("/{nid}/showNews")
    public ResponseResult<News> getByNid(@PathVariable("nid") Integer nid) {
        // 调用业务层对象执行
        News data=newsService.getByNid(nid);
        // 返回
        return new ResponseResult<>(SUCCESS,data);
    }
    //    显示相应id的产品数据
    @GetMapping("/{anid}/showNewsActivity")
    public ResponseResult<List<News>> getByANid(@PathVariable("anid") Integer anid) {
        // 调用业务层对象执行
        List<News> data=newsService.getByANid(anid);
        // 返回
        return new ResponseResult<>(SUCCESS,data);
    }
    //    显示相应id的产品数据
    @GetMapping("/{uaid}/showNewsByUser")
    public ResponseResult<List<News>> getByUAid(@PathVariable("uaid") Integer uaid) {
        // 调用业务层对象执行
        List<News> data=newsService.getByUAid(uaid);
        // 返回
        return new ResponseResult<>(SUCCESS,data);
    }
    //    删除文件
    @RequestMapping(value="/deleteFile")
    public ResponseResult<Void> deletePath(@RequestBody delNews del,HttpSession session) throws IOException {
        String filePath = del.getFilePath();
        Integer nid = del.getNid();
        String fileName = del.getFileName();
        String endpoint = FileUtil.ENDPOINT;
        String accessKeyId = FileUtil.KEYID;
        String accessKeySecret = FileUtil.KEYSECRET;
        String yourBucketName = FileUtil.BUCKETNAME;
        filePath = filePath.replaceAll("\\\\", "/");
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.deleteObject(yourBucketName,filePath);
        ossClient.shutdown();
        if(nid!=0){
//            String username = session.getAttribute("username").toString();
            String username = "windiot";
            newsService.delFile(del,nid,username,fileName);
        }
        return new ResponseResult<>(SUCCESS);
    }
}
