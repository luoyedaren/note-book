- 查询统计 `aggregate` 使用
```js
db.getCollection('customerReport').aggregate([
    {
        $match:{
            'createTime':{'$gte':'20170915','$lte':'20170929'}
            }
    },
    {
        $group:{
         _id:null, //无法必须有
        '亿房推送客户数':{$sum:'$pushCount'}, //要统计的字段，前面只是展示的名字
        '用户手工录入客户数':{$sum:'$manualCount'},
        '有需求':{$sum:'$hasDemandCount'},
        '无需求':{$sum:'$noDemandCount'},
        '不匹配':{$sum:'$notMatchedCount'},
        '已成交':{$sum:'$dealedCount'},
        '未联系':{$sum:'$unconnectedCount'},
        '未接通':{$sum:'$unThroughCount'}
        
        }
        
    }
    
])
```

- 去重
```js
总数，去重
db.customer.distinct('phone' //去重字段
,{'createTime':{'$gte':'20170915','$lte':'20170929'} //查询

}).length
```

删除文档
- 全删 `db.inventory.deleteMany({})`
- 条件删 `db.customer.deleteMany({ createTime : "20171120" })  `
- 单删  `db.inventory.deleteOne( { status: "D" } )`

查
```js
db.customer.find({createTime:'20171120'}).length()
db.getCollection('customerReport').find({createTime:"20171120"})
```

插入
```js
db.customer.insert({
    "_id" : ObjectId("5a13d4edc05c33598820c2c0"),
    "_class" : "com.fdc.data.market.domain.po.Customer",
    "customerId" : "5a13d4ecc05c33598820c2be",
    "customerName" : "",
    "phone" : "111",
    "sex" : "1",
    "age" : "",
    "assignedFlag" : "0",
    "closedFlag" : "0",
    "origin" : "2",
    "createTime" : "20171121",
    "matchAdmin" : "5a02a607eb0623466ccd74d0",
    "matchAdminName" : "mainuser",
    "contactFlag" : "0"
})

```

查询null 或者 not null
[参考链接](http://blog.csdn.net/xiaojin21cen/article/details/40504753)
```js
db.foo.find({name:{$in:[null],$exists:true}})

db.foo.find({name:{$ne:null}})
```

mongodb 知识

`iosdate` 
>UTC 通用标准时，以z来标识
mongo中的时间与China系统时间相差了8个小时，
这是因为mongo中的date类型以UTC（Coordinated Universal Time）存储，就等于GMT（格林尼治标准时）时间。而系统时间使用的是GMT+0800时间，两者正好相差8个小时。 



---

#### 查询高级用法
参考:https://www.cnblogs.com/t2xingzhe/p/3555268.html

- 字段中是集合的查询
```js
db.systemInfo211.find({ "validStartTime" : { "$gt" : ISODate("2014-11-01T10:33:09.661Z") },   
"versionLimitList" : { "$elemMatch" : { "clientId" : 109, "platFormCode" : 2 } } }).limit(50);  
```