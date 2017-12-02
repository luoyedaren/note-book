### linux 命令

sshpass 服务器建copy文件
```bash
scp /home/daisy/full.tar.gz root@172.19.2.75:/home/root

#或者

/usr/bin/sshpass -p 'fdcserver' scp /usr/local/openresty.tar.gz root@192.168.1.5:/usr/local/
```

tar 解压 压缩
```bash
tar

-c: 建立压缩档案
-x：解压
-t：查看内容
-r：向压缩归档文件末尾追加文件
-u：更新原压缩包中的文件

这五个是独立的命令，压缩解压都要用到其中一个，可以和别的命令连用但只能用其中一个。下面的参数是根据需要在压缩或解压档案时可选的。

-z：有gzip属性的
-j：有bz2属性的
-Z：有compress属性的
-v：显示所有过程
-O：将文件解开到标准输出

下面的参数-f是必须的

-f: 使用档案名字，切记，这个参数是最后一个参数，后面只能接档案名。
```
demo
```bash
tar -czf uc_tomcat.tar.gz /usr/local/tomcat
```

查看端口占用
```bash
netstat –apn | grep 8080
```