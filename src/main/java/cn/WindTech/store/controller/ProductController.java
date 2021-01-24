package cn.WindTech.store.controller;


import cn.WindTech.store.entity.Product;
import cn.WindTech.store.entity.Search;
import cn.WindTech.store.entity.delProduct;
import cn.WindTech.store.service.IProductService;
import cn.WindTech.store.util.FileUtil;
import cn.WindTech.store.util.ResponseResult;
import cn.WindTech.store.vo.FileVO;
import cn.WindTech.store.vo.ProductVO;
import cn.WindTech.store.vo.TypeVO;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;
import net.sf.json.JSONObject;

@RestController
@RequestMapping(value = "/products")
@CrossOrigin
public class ProductController extends BaseController{
    @Autowired
    private IProductService proService;

    //下载附件
    @RequestMapping(value = "/downFile")
    @ResponseBody
    public void downFile(HttpServletRequest request, HttpServletResponse response) {
        BufferedInputStream input = null;
        OutputStream outputStream = null;
        try {
            String endpoint = FileUtil.ENDPOINT;
            String accessKeyId = FileUtil.KEYID;
            String accessKeySecret = FileUtil.KEYSECRET;
            String yourBucketName = FileUtil.BUCKETNAME;
            String filePath = request.getParameter("path");
            filePath = filePath.replaceAll("\\\\", "/");
            response.reset();
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/x-msdownload");
            response.addHeader("Content-Disposition", "attachment;filename="
                    + new String(filePath.getBytes("gb2312"),"ISO8859-1"));
            System.out.println("endpoint:"+endpoint+"accessKeyId:"+accessKeyId+"accessKeySecret:"
                    +accessKeySecret+"yourBucketName:"+yourBucketName);
            OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
            OSSObject object = ossClient.getObject(yourBucketName, filePath);
            input = new BufferedInputStream(object.getObjectContent());
            byte[] buffBytes = new byte[1024];
            outputStream = response.getOutputStream();
            int read = 0;
            while ((read = input.read(buffBytes)) != -1) {
                outputStream.write(buffBytes, 0, read);
            }
            outputStream.flush();
            ossClient.shutdown();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (input != null) {
                    input.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
//    删除文件
    @RequestMapping(value="/deleteFile")
    public ResponseResult<Void> deletePath(@RequestBody delProduct del,HttpSession session) throws IOException {
        String filePath = del.getFilePath();
        Integer pid = del.getPid();
        String fileName = del.getFileName();
        String endpoint = FileUtil.ENDPOINT;
        String accessKeyId = FileUtil.KEYID;
        String accessKeySecret = FileUtil.KEYSECRET;
        String yourBucketName = FileUtil.BUCKETNAME;
        filePath = filePath.replaceAll("\\\\", "/");
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.deleteObject(yourBucketName,filePath);
        ossClient.shutdown();
        if(pid!=0){
//            String username = session.getAttribute("username").toString();
            String username = "windiot";
            proService.delFile(del,pid,username,fileName);
            System.out.println(username);
        }
        return new ResponseResult<>(SUCCESS);
    }
//上传文件
    @PostMapping(value="/uploadFile")
    public ResponseResult<FileVO> getFilePath(@RequestParam("file")MultipartFile file) throws IOException {
        String endpoint = FileUtil.ENDPOINT;
        String accessKeyId = FileUtil.KEYID;
        String accessKeySecret = FileUtil.KEYSECRET;
        String yourBucketName = FileUtil.BUCKETNAME;
        String fileName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        fileName = uuid + fileName;
        String filePath = new DateTime().toString("yyyy/MM/dd");
        fileName = filePath + "/" + fileName;
        InputStream in = file.getInputStream();
        OSS ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(yourBucketName, fileName, in);
        ossClient.shutdown();
        String path = "http://" +yourBucketName+"."+endpoint+"/"+ fileName;
        FileVO fileInfo = new FileVO();
        fileInfo.setName(file.getOriginalFilename());
        fileInfo.setPath(path);
        return new ResponseResult<>(SUCCESS,fileInfo);
    }
    //添加产品数据
    @PostMapping(value="/add")
    public ResponseResult<List<ProductVO>> product(@RequestBody Product pro, HttpSession session) {
//        String username = session.getAttribute("username").toString();
        String username = "windiot";
        proService.addToPro(pro,username);
        // 返回成功
        return new ResponseResult<>(SUCCESS);
    }
    // 展示分页产品数据
    @GetMapping("/show")
    public ResponseResult<JSONObject> getProduct(@RequestParam("startPage")Integer startPage,
                                                       @RequestParam("pageSize")Integer pageSize) {
        // 调用业务层对象执行
        List<ProductVO> data = proService.getProduct(startPage,pageSize);
        Integer totalNum = proService.count();
        JSONObject result= new JSONObject();
        result.put("tableData",data);
        result.put("totalNum",totalNum);
        // 返回
        return new ResponseResult<>(SUCCESS, result);
    }
    // 展示所有产品数据
    @GetMapping("/showAll")
    public ResponseResult<List<ProductVO>> getAllProduct(Product product) {
        // 调用业务层对象执行
        List<ProductVO> data = proService.getAllProduct(product);
        // 返回
        return new ResponseResult<>(SUCCESS, data);
    }
    // 模糊搜索产品数据
    @RequestMapping("/search")
    public ResponseResult<JSONObject> searchProduct(@RequestBody Search search) {
        String pro_State = search.getPro_State();
        String pro_Type = search.getPro_Type();
        String pro_Name = search.getPro_Name();
        Integer startPage = search.getStartPage();
        Integer pageSize = search.getPageSize();
        // 调用业务层对象执行
        List<ProductVO> data = proService.searchProduct(pro_Name,pro_State,pro_Type,startPage,pageSize);
        Integer totalNum = proService.toSearchCount(pro_Name,pro_State,pro_Type);
        JSONObject result = new JSONObject();
        result.put("tableData",data);
        result.put("totalNum",totalNum);
        // 返回
        return new ResponseResult<>(SUCCESS, result);
    }
//    显示相应id的产品数据
    @GetMapping("/{pid}/showPro")
    public ResponseResult<Product> getByPId(@PathVariable("pid") Integer pid) {
        // 调用业务层对象执行
        Product data=proService.getByPId(pid);
        // 返回
        return new ResponseResult<>(SUCCESS,data);
    }
    //删除特定id的数据
    @RequestMapping("/{pid}/delete")
    public ResponseResult<Void> delete(@PathVariable("pid") Integer pid,HttpSession session) {
        // 执行
//        String username = session.getAttribute("username").toString();
        String username = "windiot";
        proService.delete(pid);
        proService.updateTime(username);
        // 返回
        return new ResponseResult<>(SUCCESS);
    }
//    修改特定的产品数据
    @RequestMapping("/{pid}/change_info")
    public ResponseResult<Void> changeInfo(@RequestBody Product product, @PathVariable("pid") Integer pid, HttpSession session) throws IOException {
        // 执行更新：
        product.setPid(pid);
//        System.out.println(session.getAttribute("username").toString());
//        String username = session.getAttribute("username").toString();
        String username = "windiot";
        proService.changeInfo(product,username);

        // 返回成功
        return new ResponseResult<>(SUCCESS);
    }
    //    返回系列
    @RequestMapping("/showType")
    public ResponseResult<List<TypeVO>> showType() throws IOException {
        List<TypeVO> type= proService.getType();
        // 返回成功
        return new ResponseResult<>(SUCCESS,type);
    }

}
