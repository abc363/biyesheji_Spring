package cn.WindTech.store.util;

import com.qiniu.util.Auth;
import com.qiniu.util.Base64;
import com.qiniu.util.StringMap;
import com.qiniu.util.UrlSafeBase64;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;


/**
 * 七牛云上传文件工具类
 */
public class QiniuCloudUtil {
    // 设置需要操作的账号的AK和SK
    private static final String ACCESS_KEY = "zBwS2zlxzHGc3vA2qJ5x6sAAwJKXOqEmublsXESC";
    private static final String SECRET_KEY = "Mn4xRZt6nX4vZJwqW3LhmR9Hhm9ey_kRg6odW-n7";
    // 要上传的空间
    private static final String bucketname = "webgdufeimages";
    // 密钥
    private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    private static final String DOMAIN = "q98i9va0h.bkt.clouddn.com";
    private static final String style = "imageView2/2/w/400/h/400/q/100";

    public static String getUpToken() {
        return auth.uploadToken(bucketname, null, 3600, new StringMap().put("insertOnly", 1));
    }

    //base64方式上传
    public static String put64image(byte[] base64, String key) throws Exception {
        String file64 = Base64.encodeToString(base64, 0);
        Integer len = base64.length;

        String url = "http://upload.qiniu.com/putb64/" + len + "/key/"+ UrlSafeBase64.encodeToString(key);

        RequestBody rb = RequestBody.create(null, file64);
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/octet-stream")
                .addHeader("Authorization", "UpToken " + getUpToken())
                .post(rb).build();
        OkHttpClient client = new OkHttpClient();
        okhttp3.Response response = client.newCall(request).execute();
        System.out.println(response);
        return DOMAIN + key + "?" + style;
    }

}
