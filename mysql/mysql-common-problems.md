#### mysql 开发绕不过去的问题

- 乱码
   1. server问题 建库建表时 记住设置 `utf-8`. 查看你的数据库：` show variables like"%char%"`
   2. jdbc 连接加上 `?useUnicode=true&characterEncoding=utf-8`
   3. mysql 配置 **utf-8** `/etc/my.cnf　,在[mysql]段加入default_character_set=utf8`
   4. 确保字段上的编码没有手误建成非utf-8格式, 修正方法 `ALTER TABLE `table_name` CHANGE `column` `column` VARCHAR( 长度 ) CHARACTER SET utf8 DEFAULT NULL `
   5. `order by varchar` 类型字段 ，mysql无效过，绕过方式：`order by varchar+1 desc`
   