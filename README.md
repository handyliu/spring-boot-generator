![Licence](https://img.shields.io/badge/licence-Apache%202-green.svg)
[![GitHub Release](https://img.shields.io/github/release/xuxinlong001/spring-boot-generator.svg)](https://github.com/xuxinlong001/spring-boot-generator/releases)
## 简介
Spring Boot Generator 是一个基于Spring Boot & MyBatis Generator的项目，用于快速构建中小型API、RESTful风格API项目，该项目已经有过多个真实项目的实践，稳定、简单、快速，使我们摆脱那些重复劳动，专注于业务代码的编写。

## 特征&提供
- 最佳实践的项目结构、配置文件、精简的pom.xml
- 统一响应结果封装及生成工具
- 统一异常处理，接口返回异常json数据，错误页面统一跳转404、500页面
- 简单的接口签名认证
- 常用基础方法抽象封装
- 使用Druid Spring Boot Starter 集成Druid数据库连接池与监控
- 使用FastJsonHttpMessageConverter，提高JSON序列化速度
- 集成MyBatis、通用Mapper插件、PageHelper分页插件，实现单表业务零SQL
- 提供代码生成器根据表名生成对应的Model、Mapper、MapperXML、Service、ServiceImpl、Controller等基础代码，其中Controller模板默认提供RESTful 风格的API，根据需求在```CodeGenerator.genController(tableName)```
代码模板可根据实际项目的需求来扩展，由于每个项目业务都不太一样，所以只提供了一些比较基础、通用的模板，主要是提供一个思路来减少重复代码的编写，我在实际项目的使用中，其实根据项目业务的抽象编写了大量的模板。另外，使用模板也有助于保持团队代码风格的统一

 
## 快速开始
1. 克隆项目
2. 对```test```包内的代码生成器```CodeGenerator```进行配置，主要是JDBC，因为要根据表名来生成代码
3. 如果只是想根据上面的演示来亲自试试的话可以使用```test resources```目录下的```user.sql```，否则忽略该步
3. 输入表名，运行```CodeGenerator.main()```方法，生成基础代码（可能需要刷新项目目录才会出来）
4. 根据业务在基础代码上进行扩展
5. 对开发环境配置文件```application-dev.yml```进行配置，启动项目
 
## 开发建议
- 表名，建议使用小写，多个单词使用下划线拼接
- Model内成员变量建议与表字段数量对应，如需扩展成员变量（比如连表查询）建议创建DTO，否则需在扩展的成员变量上加```@Transient```注解，详情见[通用Mapper插件文档说明](https://mapperhelper.github.io/docs/2.use/)
- 建议业务失败直接使用```ServiceException("message")```抛出，由统一异常处理器来封装业务失败的响应结果，比如```throw new ServiceException("该手机号已被注册")```，会直接被封装为```{"code":400,"message":"该手机号已被注册"}```返回，无需自己处理，尽情抛出
- 需要工具类的话建议先从```apache-commons-*```和```guava```中找，尽量精简项目
- 开发规范建议遵循阿里巴巴Java开发手册（[最新版下载](https://files.cnblogs.com/files/han-1034683568/%E9%98%BF%E9%87%8C%E5%B7%B4%E5%B7%B4Java%E5%BC%80%E5%8F%91%E6%89%8B%E5%86%8C%E7%BB%88%E6%9E%81%E7%89%88v1.3.0.pdf))
- 建议在项目开发时使用[SpringFox-Swagger2](https://github.com/springfox/springfox)、[RAP](https://github.com/thx/RAP)等开源项目来编写、管理API文档
 
## 技术选型&文档
- Spring Boot（[查看Spring Boot学习&使用指南](http://blog.csdn.net/column/details/spring-boot.html)）
- MyBatis（[查看官方中文文档](http://www.mybatis.org/mybatis-3/zh/index.html)）
- MyBatis 通用Mapper插件（[查看官方中文文档](https://mapperhelper.github.io/docs/)）
- MyBatis PageHelper分页插件（[查看官方中文文档](https://pagehelper.github.io/)）
- Druid Spring Boot Starter（[查看官方中文文档](https://github.com/alibaba/druid/tree/master/druid-spring-boot-starter/)）
- Fastjson（[查看官方中文文档](https://github.com/Alibaba/fastjson/wiki/%E9%A6%96%E9%A1%B5)）
- FreeMarker（[查看官方中文文档](http://freemarker.foofun.cn/)）
- 其他可以根据项目自身的业务需求自行扩展