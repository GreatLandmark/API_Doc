package lael.javaspring.api_doc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/")
public class index {
    private final String hello="hello java";
    @GetMapping("/hello")
    @ApiOperation(value = "这是value", notes = "这是notes")
    public ResponseEntity<String> hello(){
        return ResponseEntity.status(HttpStatus.OK).body(hello);
    }
    @GetMapping("/")
    @ApiOperation(value = "这是value", notes = "这是notes")
    public String index(){
        return "index";
    }
    // @GetMapping("/hello")
    // @ApiOperation(value = "这是value", notes = "这是notes")
    // public String hello(){
    //     return hello;
    // }
}
