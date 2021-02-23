# wishlist-vue-springboot
![erd](https://github.com/Kaiwenkevinz/wishlist-vue-springboot/blob/main/doc/img/erd.PNG)

vue init webpack bm-front

npm install --save axios
npm i element-ui
npm install --save vuex

POST http://localhost:8989/bm/api/login
{
  "username": "admin",
  "password": "123"
}

springboot访问项目外的静态资源
MyWebConfigurer
http://localhost:8989/bm/api/file/download.jpg