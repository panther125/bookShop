# 网页书城

> 前后端项目 By [panther](www.panther9985.icu)
>
> 网页端商店

## 实现的功能

1. 页面显示数据库的信息，商品信息，购物订单信息
2. 登录注册的校验，组件生成的随机验证码
3. 商品通过数据库的限制显示实现分页
4. 页面编辑购买的商品数量

## 技术栈

### 前端

主要技术：

* Vue
* jQuery
* bootstrap

依赖库：

* axios异步请求

## 后端

主要技术：

* Mysql
* Servlet
* Thymeleaf

依赖库

* druid数据库连接池
* Axios
* Gson
* Kaptcha 生成验证码

## 目录结构

* Gin 后端代码

  * book 主要Servlet 处理以及数据库获取信息
  * myssm 分析application.xml和网页请求然后，解析成特定格式交给对应servlet

* web前端代码

  * static 静态文件
  * WEB-INF 项目的主要页面

* application.xml  servlet解析页面响应分析

* jdbc.properties  数据库信息

  