package lael.javaspring.api_doc.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class LoadProperties {
    // private Properties properties;

    /**
     * 获取key对应的value值, <br/>
     * 使用：properties.getProperty(String key); 
     * @param filePath
     * @return Properties properties
     */
    public static Properties loadProperties(String filePath) {
        Properties properties = new Properties();
        try (// 使用InPutStream流读取properties文件
                BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            properties.load(bufferedReader);
            // 获取key对应的value值
            // System.out.println("Lofit.LoadPro:"+
            // properties.getProperty("BaiduService.Token");
            return properties;
        } catch (Exception e) {
            System.err.println("Lofit.LoadProperties: " + filePath + "\nError: " + e);
            return null;
        }
    }
}
