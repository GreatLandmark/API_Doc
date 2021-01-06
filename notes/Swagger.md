## 
- https://blog.csdn.net/qq_36826506/article/details/82182817  
__对于@ApiImplicitParam的paramType：query、form域中的值需要使用@RequestParam获取， header域中的值需要使用@RequestHeader来获取，path域中的值需要使用@PathVariable来获取，body域中的值使用@RequestBody来获取，否则可能出错；而且如果paramType是body，name就不能是body，否则有问题，与官方文档中的“If paramType is "body", the name should be "body"不符。__
- @ApiImplicitParams：用在方法上包含一组参数说明
- @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
  - paramType：参数放在哪个地方  
      header-->请求参数的获取：@RequestHeader  
      query-->请求参数的获取：@RequestParam  
      path（用于restful接口）-->请求参数的获取：PathVariable  
      body（不常用）
      form（不常用）
  - name：参数名
  - dataType：参数类型
  - required：参数是否必须传
  - value：参数的意思
  - defaultValue：参数的默认值
- @ApiResponses：用于表示一组响应
- @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息  
code：数字，例如400
message：信息，例如"请求参数没填好"
response：抛出异常的类

## Swagger 常用注解说明
Swagger 通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。

常用注解
@Api：修饰整个类，描述 Controller 的作用
@ApiOperation：描述一个类的一个方法，或者说一个接口
@ApiParam：单个参数描述
@ApiModel：用对象来接收参数
@ApiProperty：用对象接收参数时，描述对象的一个字段
@ApiResponse：HTTP 响应其中 1 个描述
@ApiResponses：HTTP 响应整体描述
@ApiIgnore：使用该注解忽略这个API
@ApiError：发生错误返回的信息
@ApiImplicitParam：一个请求参数
@ApiImplicitParams：多个请求参数

作者：撸帝
链接：https://www.jianshu.com/p/3c9986f81ff0
来源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。