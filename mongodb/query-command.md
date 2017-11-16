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