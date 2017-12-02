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
#### 数据导出： mongoexport 
进入到mongoDB的安装根目录 /usr/local/mongodb 运行下面的命令

 ./bin/mongoexport -d 数据库名-c 表名 -o 导出的文件名.dat -q '{查询条件}'  

 ./bin/mongoexport -d snstest -c snsPosts -o snsPosts_newhouse.dat -q '{"fid":666666, "createdBy":"新房sqlserver导入"}'  


####　数据导入：mongoimport

使用mongoimport  
在命令行执行如下：  
mongoimport -d test -c students students.dat 
-d test 指的是导入test 数据库(database)
-c students 指的是导入students表 collections(tables)  
 ./bin/mongoexport -d data_market -o pro_data_market.dat  
 mongorestore -d data_market /home/zhangy/mongodb/tank/ 