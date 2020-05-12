# Introduction
HC-SSO 是一个分布式单点登录框架。只需要登录一次就可以访问所有相互信任的应用系统。
拥有"轻量级、分布式、跨域、Cookie+Token均支持、Web+APP均支持"等特性。现已开放源代码，开箱即用。
ps: 项目代码起始借鉴自XXL开源社区（XXL-SSO）：https://www.xuxueli.com/，大家可以关注下！
并且我会在此基础上持续更新。

## Features
1. 简洁：API直观简洁，可快速上手
2. 轻量级：环境依赖小，部署与接入成本较低
3. 单点登录：只需要登录一次就可以访问所有相互信任的应用系统
4. 分布式：接入SSO认证中心的应用，支持分布式部署
5. HA：Server端与Client端，均支持集群部署，提高系统可用性
6. 跨域：支持跨域应用接入SSO认证中心
7. Cookie+Token均支持：支持基于Cookie和基于Token两种接入方式，并均提供Sample项目
8. Web+APP均支持：支持Web和APP接入
9. 实时性：系统登陆、注销状态，全部Server与Client端实时共享
10. CS结构：基于CS结构，包括Server"认证中心"与Client"受保护应用"
11. 记住密码：未记住密码时，关闭浏览器则登录态失效；记住密码时，支持登录态自动延期，在自定义延期时间的基础上，原则上可以无限延期
12. 路径排除：支持自定义多个排除路径，支持Ant表达式。用于排除SSO客户端不需要过滤的路径

## TODO LIST
1. 认证中心与接入端交互数据加密，增强安全性；redirect_url必须和临时AccessToken配合才会生效，AccessToken有效期60s，阅后即焚模式；
2. SSO SessionId 与IP绑定，增强用户增强安全性；
3. 支持认证分组，分组内共享登陆状态，分组之间登录态隔离，【待考虑】；
4. 客户端新增属性 “xxl.sso.server”，用于构建跳转连接，防止跳转第三方导致登陆漏洞；
5. token验证方式增加jwt方式支持；
6. Client端移除Redis依赖，改为 LocalCache/30s + RPC + Server-Redis/Broadcast 校验方式；
7. 安全性增强，登陆用户数据中，新增客户端信息如ip、ua等，方式session被窃取；

## Donate
无论金额多少都足够表达您这份心意，非常感谢 ：） [前往捐赠](https://www.xuxueli.com/page/donate.html )
（本人为表心意，金额虽小但已赞助此社区，希望能涌现出更多更好的作品！）
最后注意!!!捐赠链接不是我这，是XXL开源社区
