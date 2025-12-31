# demo-sa-token
使用示例-Sa-Token权限认证框架
> OpenJDK 21
> 
> Spring Boot 3.5.X

## sa-springboot
使用示例-SpringBoot集成Sa-Token，使用sa-token AOP注解鉴权插件

## sa-route-interceptor
使用示例-路由拦截器鉴权

## sa-redis
使用示例-集成Redis，将会话数据存储在缓存中间件上，分布式环境中共享数据

## sa-sso-server
使用示例-单点登录（统一认证中心SSO-Server）

## sa-sso-model1
使用示例-SSO模式一（共享Cookie同步会话）
> 前端同域+后端同Redis
### 1. sso-model1-server
统一认证中心模块
### 2. sso-model1-client
客户端模块

## sa-sso-model2
使用示例-SSO模式二（URL重定向传播会话）
> 前端不同域+后端同Redis
### 1. sso-model2-server
统一认证中心模块
### 2. sso-model2-client
客户端模块

## sa-sso-model3
使用示例-SSO模式三（Http请求获取会话）
> 前端不同域+后端不同Redis
### 1. sso-model3-server
统一认证中心模块
### 2. sso-model3-client
客户端模块

## sa-sso-model3-backend
使用示例-SSO模式三（Http请求获取会话）【前后端分离架构下的整合方案（后端）】
> 前端不同域+后端不同Redis
### 1. sso-model3-backend-server
统一认证中心模块
### 2. sso-model3-backend-client
客户端模块

## sa-sso-model3-frontend-h5
使用示例-SSO模式三（Http请求获取会话）【前后端分离架构下的整合方案（前端h5）】
