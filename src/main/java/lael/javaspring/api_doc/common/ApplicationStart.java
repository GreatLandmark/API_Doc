package lael.javaspring.api_doc.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lael.javaspring.api_doc.service.OcrService;
import lael.javaspring.api_doc.utils.LoadProperties;

@Component
@Order(1) // 启动顺序为1
public class ApplicationStart implements ApplicationRunner {
    // @Value("${LofitProperties.path}")
    // private String filePath;
    // @Autowired
    // private OcrService ocr;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // LoadProperties.loadProperties(filePath);
        System.out.println("Lofit ---> ApplicationStart -- 成功");
        // System.out.println("ocr: "+ocr.toString());
    }
}
