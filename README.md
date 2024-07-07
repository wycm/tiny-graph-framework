## 简易图化调度框架

### 解决什么问题？
#### 在微服务架构的复杂业务场景下，一个场景数据输出时会依赖大量的二方服务，且二方服务之间存在一些依赖关系，可以通过借助该框架，构建出性能最大化的DAG有向无环图；日常业务开发只需要关注单个节点业务逻辑和节点依赖关系编排，不需要关注复杂的异步处理、回调等相关逻辑；
#### 如果只是简单的业务场景，使用该框架是没有优势的，因为简单业务场景，手动管理其节点依赖关系即可；通过手动submit后，需要使用的时候再Future.get()即可；但是当业务场景足够复杂，比如一个接口涉及的外部rpc依赖，超过30+、50+节点，甚至100+节点时，借助图化框架的优势就能体现了；

### 实现思路
#### 通过注解定义节点依赖关系，类似依赖注入思路，注入依赖实例后；并借助CountDownLatch实现节点触发通知

### 举个具体的例子
#### 比如在电商业务场，以我们看到的商品详情页为例，下发商品详情页的接口一次需要依赖N多个二方服务；页面展示有商品基础信息、营销信息(优惠券)、仓储配送信息(预估多久到达)、售后信息(N天无理由退还、假一赔N等)、评价信息、店铺信息等；通过手动编排依赖关系，最终生成DAG有向无环图，如下图；
![image](https://raw.githubusercontent.com/wycm/tiny-graph-framework/main/img_1.png)

### 待优化的点
#### 当前节点触发需要依赖节点数据提前准备好,可以升级为节点提前触发，获取依赖数据时再等待；


