

- [Java 读取 .properties 配置文件的几种方式 ](https://www.cnblogs.com/sebastian-tyd/p/7895182.html)  


## Spring Boot application.properties 
### 获取配置参数
1. 通过ApplicationContext上下文获取  
```java
@SpringBootApplication
public class DemoApplication {
 
	public static void main(String[] args) {
		ConfigurableApplicationContext app = SpringApplication.run(DemoApplication.class, args);
		// application.properties文件中的name=chenyanwu
		System.out.println(app.getEnvironment().getProperty("name"));
	}
}
```

2. 通过@Value注解来获取   
```java
@RestController
public class HelloWorldController {
	
	@Value("${name}")
	private String name;
	@Value("${age}")
	private int age;
	
	@RequestMapping("/getUser")
	public String getUser() {
		return "name: " + name + ";age:" + age;
	}
}
```

3. 通过@ConfigurationPorperties注解来获取  
```java 
//先创建一个Person类，为这个对象赋值显示(使用了@Value和@ConfigurationPorperties注解)
@Component
@ConfigurationProperties(prefix="user")
public class Person {
	@Value("${name}")
	private String name;
	
	@Value("${age}")
	private Integer age;
	private String addr;
	
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public Integer getAge() {
		return age;
	}
 
	public void setAge(Integer age) {
		this.age = age;
	}
 
	public String getAddr() {
		return addr;
	}
 
	public void setAddr(String addr) {
		this.addr = addr;
	}
 
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}
```
## SpringBoot 项目启动加载自定义配置
### [springboot项目启动之后初始化自定义配置类](https://www.cnblogs.com/chenmc/p/9253230.html)  
1. 创建自定义类实现 CommandLineRunner接口，重写run（）方法。springboot启动之后会默认去扫描所有实现了CommandLineRunner的类，并运行其run（）方法。  
```java
@Component
@Order(2)   //通过order值的大小来决定启动的顺序
public class AskForLeave implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        askForLeave();
    }

    public void askForLeave(){
        System.out.println("项目启动了，执行了方法");
    }
}
```
2. 创建自定义类实现ApplicationRunner 接口，重写run（）方法。   
```java
@Component
@Order(3)
public class Hello implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {

        hello();
    }

    public void hello(){
        System.out.println("项目又启动了，这次使用的是：继承 ApplicationRunner");
    }
}
``` 

## @PropertySource  
经常使用@PropertySource 来指定配置文件，然后@value获取配置参数：

1 @Component  
2 @PropertySource(value= {"classpath:rules.yml"})  
3 @ConfigurationProperties(prefix = "busi-udid-mapper")  
 
默认，配置文件都是指定classpath下的文件路径，如果使用绝对路径（操作系统下某个配置文件路径），请使用如下方式：  

1 @Component  
2 @PropertySource(value= {"file:${rule.fullpath}"})  
3 @ConfigurationProperties(prefix = "busi-udid-mapper")  
这里的rule.funnpath是在系统配置文件中变量化的参数  



