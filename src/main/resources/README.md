# EVO
[![version][version-badge]][CHANGELOG] 


**日常写着玩**

**Owner**昂太 (昂太@maihaoche.com)
  

## 项目背景
evo资产交易服务提供了资金运营审核，推送资方，生成请款单，主要面向订单审核人员使用。
 
## 功能介绍： 
当前功能： 
1. 推送资方
2. 供应商签约
3. 经销商签约
4. 资产打包
5. 生成借据

## 架构设计
提供commonservice相关架构设计文档与资料。

## 总体设计
https://cf.dawanju.net/pages/viewpage.action?pageId=15879926#id-2.1%E8%B5%84%E4%BA%A7%E6%89%93%E5%8C%85-%E6%95%B4%E4%BD%93%E6%96%B9%E6%A1%88

## 详细设计
https://cf.dawanju.net/pages/viewpage.action?pageId=15879926#id-2.1%E8%B5%84%E4%BA%A7%E6%89%93%E5%8C%85-3.1%E8%AF%A6%E7%BB%86%E8%AE%BE%E8%AE%A1

## 数据库设计
https://cf.dawanju.net/pages/viewpage.action?pageId=22022486#id-%E3%80%90%E5%A4%A9%E6%B2%B3%E3%80%91EVO-%E8%B5%84%E4%BA%A7%E6%89%93%E5%8C%85-9%E3%80%81%E5%BB%BA%E8%A1%A8%E8%AF%AD%E5%8F%A5

## 外部服务接口
待完善（RPC接口/HTTP接口）

## 系统依赖关系图
待完善（参考Pinpoint依赖关系图）


## 常见问题
* 推送资方失败
* 没有生成请款单
* 放款没有生成请款单

    **解决方法：**
公司法人信息不全，补齐法人信息    
消息没有回调，补消息
查询林肯系统车辆是否已经在贷，以及结清状态

## 迭代历史
V1.2.0
版本迭代内容介绍，参考：

【add】新增XX功能；

【modify】完善XX；

【fix】修复XX bug;


## Roadmap
待完善

在这里输入你的任务, 使用 "@"分配用户，使用 "//" 选择到期日期


## Contribute

Please do contribute! Issues and pull requests are welcome.

Thank you for your help improving our performance at a time!

0827 
引入 mybatis-plus

[CHANGELOG]: ./CHANGELOG.md
[version-badge]: https://img.shields.io/badge/version-1.1.6-blue.svg





