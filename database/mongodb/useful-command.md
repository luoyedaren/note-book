`mongoexport`

```bash
-h  arg     主机
--port arg  端口
-u  arg     用户名
-p  arg     密码
-d  arg     数据库
-c  arg     集合
-f  arg     字段名 逗号隔开
-q  arg     查询条件 json格式
--csv       导出csv格式
-o  arg     导出的文件名	
/usr/local/mongodb/bin/mongoexport  -d data_market -c customer -q "{'accountId':'5a02adada093c0207de708c2'}" -f phone,contactFlag,demandId --type=csv -o /data.csv
```
