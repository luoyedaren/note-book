### war部署shell



1. git拉代码并且maven打包
```bash

#!/bin/sh
DATE=$(date +%Y%m%d:%H:%M:%S) 
projectRoot=/root/gitlab/data-market
warPath=$projectRoot/data-market-web/target/datamarket.war


echo -e "\033[41;37m ----------------------开始拉取代码 ${DATE}  ---------------------------- \033[0m"
cd $projectRoot
git pull origin master
echo ""
#echo -e "\033[41;37m ----------------------开始install---------------------------- \033[0m"
#echo ""
#cd $projectRoot
#mvn clean
#mvn install -Dmaven.test.skip=true

echo -e "\033[41;37m ----------------------开始打包---------------------------- \033[0m"
cd $projectRoot
mvn clean
echo "----------------------------------"  
echo "----------------------------------"  
mvn package -Ptest -Dmaven.test.skip=true
   if [ -f $warPath ]
	then 
	  echo -e "\033[41;37m ---------------------打包结束---------------------------- \033[0m"
	  rm -f /root/datamarketwar/*
	  find $projectRoot -name "*.war" | xargs -n1 -i cp {} /root/datamarketwar
	  echo -e "\033[41;37m --------打包位置为：/root/datamarketwar--------- \033[0m"
	else 
	   echo -e "\033[41;37m ----------打包错误，请检查代码---------------- \033[0m"
	  exit
   fi
 echo -e "\033[41;37m ---------------------开始发布---------------------------- \033[0m"

/usr/bin/sshpass -p 'whfdc@027' ssh root@192.168.1.177 'rm -f /root/war/datamarket.war'
/usr/bin/sshpass -p 'whfdc@027' scp /root/datamarketwar/*.war root@192.168.1.177:/root/war
/usr/bin/sshpass -p 'whfdc@027' ssh root@192.168.1.177 'sh /publish-yjb.sh'
echo -e "\033[41;37m --------------------测试环境发布完成---------------------------- \033[0m"


```

**ssh错误  ssh  -o StrictHostKeyChecking=no  192.168.1.177 ssh认证添加命令** 

2. 执行重启tomcat脚本
```bash
export JAVA_HOME=/usr/local/jdk
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$JAVA_HOME/jre/lib:$JAVA_HOME/lib:$JAVA_HOME/lib/tools.jar
####8083
tomcatID=$(ps -ef |grep 'tomcat_market'|grep -v 'grep'|awk '{print $2}')
kill -9 $tomcatID
#
project=/usr/local/tomcat_market
rm -rf $project/webapps/datamarket*
cp /root/war/datamarket.war $project/webapps/

sh $project/bin/startup.sh

tailf $project/logs/catalina.out


```