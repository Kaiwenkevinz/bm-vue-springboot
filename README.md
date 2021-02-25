### 本地运行
vue init webpack bm-front  
npm install --save axios  
npm i element-ui  
npm install --save vuex  

### 部署到云服务器(linux)
ssh到远程服务器，安装相关环境  
MySQL
```
apt-get update
sudo apt-get install mysql-server
systemctl status mysql.service
mysql -u root -p
mysql> select version();
```

JDK 1.8
```
sudo apt-get install openjdk-8-jdk
java -version
javac -version
echo "JAVA_HOME=$(which java)" | sudo tee -a /etc/environment
source /etc/environment
echo $JAVA_HOME
```

Redis
```
apt install redis-server
systemctl restart redis.service
sudo systemctl status redis
```

MySQL建表  
```
create database bm character set utf8;
source bm.sql
```

terminal中运行，关闭terminal结束
```
java -jar wishlist-0.0.1-SNAPSHOT.jar
```

后台运行
```
nohup java -jar xxx.jar > xxx.txt &
jobs  // 查看后台程序
netstat -nlp | grep :8989 // 查看端口占用情况
```

### TODO
引入swagger进行更好的api管理  
引入RBAC，进行用户注册、权限管理  
查询sql加索引优化  
基于where的分页查询
