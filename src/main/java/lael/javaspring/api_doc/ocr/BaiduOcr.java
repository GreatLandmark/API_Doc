package lael.javaspring.api_doc.ocr;

// import java.util.HashMap;
// import java.util.Properties;
import com.baidu.aip.ocr.AipOcr;
// import org.json.JSONObject;
// import lael.javaspring.api_doc.utils.LoadProperties;

/* Singleton
*/
public class BaiduOcr extends AipOcr {
    private static BaiduOcr INSTANCE = null;
    // // 设置APPID/AK/SK
    // public static final String APP_ID = "111";// "你的 App ID";
    // public static final String API_KEY = "DDwe";// "你的 Api Key";
    // public static final String SECRET_KEY = "TfesFf";// "你的 Secret Key";
    // private BaiduOcr() {
    // super(APP_ID, API_KEY, SECRET_KEY);
    // }

    private BaiduOcr(String appId, String apiKey, String secretKey) {
        super(appId, apiKey, secretKey);
        // TODO Auto-generated constructor stub
    }

    public static synchronized BaiduOcr getInstance(String appId, String apiKey, String secretKey) {
        if (INSTANCE == null) {
            INSTANCE = new BaiduOcr(appId, apiKey, secretKey);
        }
        return INSTANCE;
    }

    // public static void main(String[] args) {
    // LoadProperties.loadProperties(filePath)
    // 初始化一个AipOcr
    // AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

    // 可选：设置网络连接参数
    // client.setConnectionTimeoutInMillis(2000);
    // client.setSocketTimeoutInMillis(60000);

    // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
    // client.setHttpProxy("proxy_host", proxy_port); // 设置http代理
    // client.setSocketProxy("proxy_host", proxy_port); // 设置socket代理

    // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
    // 也可以直接通过jvm启动参数设置此环境变量
    // System.setProperty("aip.log4j.conf","log4j.properties"
    // );//"src/main/resources/log4j.properties"

    // 调用接口
    // String path = "resources/pictures/quota_invoice1.jpg";
    // JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
    // System.out.println(res.toString(2));
    
    //fang shi 2
    // Properties pro =
    // LoadProperties.loadProperties("G:/Lofit/LofitSecretProperties.properties");
    // BaiduOcr ocr = getInstance(pro.getProperty("baidu-service.appId"),
    // pro.getProperty("baidu-service.apiKey"),
    // pro.getProperty("baidu-service.secretKey"));
    // // BaiduOcr ocr = getInstance(APP_ID, API_KEY, SECRET_KEY);
    // String path = "resources/pictures/quota_invoice1.jpg";
    // JSONObject res = ocr.basicGeneral(path, new HashMap<String, String>());
    // System.out.println(res.toString(2));

    // }

}
