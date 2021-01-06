package lael.javaspring.api_doc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import lael.javaspring.api_doc.service.OcrService;

@RestController
@RequestMapping("/ocr")
@Api(description =  "关于COR服务的接口文档")
public class OcrController {
    @Autowired
    private OcrService ocrService;

    @GetMapping("/test1")
    public String test1() {
        return ocrService.test1();
    }
}
