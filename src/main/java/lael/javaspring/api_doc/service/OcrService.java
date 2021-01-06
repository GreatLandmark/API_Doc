package lael.javaspring.api_doc.service;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import lael.javaspring.api_doc.ocr.BaiduOcr;

@Service
@PropertySource(value = { "file:${LofitProperties.path}" })
// @ConfigurationProperties(prefix = "baidu-service",ignoreInvalidFields = true)
// 使用上面的注解不能给类中的字段注入值，似乎需要给字段添加setter方法；这里使用@Value为每个字段注入。
public class OcrService {
    @Value("${baidu-service.appId}")
    private String appId;
    @Value("${baidu-service.apiKey}")
    private String apiKey;
    @Value("${baidu-service.secretKey}")
    private String secretKey;

    private BaiduOcr ocr =null; 

    @Override
    public String toString() {
        return "OcrService [apiKey=" + apiKey + ", appId=" + appId + ", secretKey=" + secretKey + ", ocr=" + ocr + "]";
    }

    public String test1() {
        ocr=BaiduOcr.getInstance(appId, apiKey, secretKey);
        // 调用接口
        String path = "resources/pictures/quota_invoice1.jpg";
        JSONObject res = ocr.basicGeneral(path, new HashMap<String, String>());
        // System.out.println(res.toString(2));
        return res.toString(2);
    }
}
