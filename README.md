### 本地运行
vue init webpack bm-front  
npm install --save axios  
npm i element-ui  
npm install --save vuex  

### API
POST http://localhost:8989/bm/api/login  

### 踩的一些坑
springboot访问项目外的静态资源  
MyWebConfigurer  
http://localhost:8989/bm/api/file/download.jpg

## Tomcat
报错：
```
java.util.concurrent.ExecutionException: org.apache.catalina.LifecycleException: Failed to start component [StandardEngine[Tomcat].StandardHost[localhost].TomcatEmbeddedContext[]]
```
解决：
改一下pom.xml的tomcat版本即可
```
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
            // 原先是 <version>8.xx.xx</version>
            <version>9.0.41</version>
        </dependency>
```

## Vue打包
问题：打包后static文件夹和index.html放入Springboot项目resources/static路径下，图片不显示  
https://blog.csdn.net/rainbow8300/article/details/83010507