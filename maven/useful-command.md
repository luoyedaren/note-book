**打包 编译**
 
- mvn clean -Dmaven.test.skip=true
- mvn compile -Dmaven.test.skip=true
- mvn install -Dmaven.test.skip=true
- mvn  clean  package -Ptest - Dmaven.test.skip=true


**maven部署到私服**
- mvn deploy -Dmaven.test.skip=true



**模块版本修改（不常用）**
- mvn versions:set-DnewVersion=1.0.1-SNAPSHOT
- mvn -N versions:update-child-modules
- mvn versions:commit `提交修改`
- mvn versions:revert `对所做的修改回滚` 
- mvn versions:set -DnewVersion=1.0.1-SNAPSHOT 和 mvn -N versions:update-child-modules `对子模块进行修改`


---

项目结构：
```
system-parent
    　　　　|----pom.xml
    　　　　|----system-domain
        　　　　　　　　|----pom.xml
    　　　　|----system-dao
        　　　　　　　　|----pom.xml
    　　　　|----system-service
        　　　　　　　　|----pom.xml
    　　　　|----system-web
        　　　　　　　　|----pom.xml

```

### 建父项目命令：
mvn3建议采用
_generate_ 命令替代  _create_ 命令

- 父模块 `pom文件修改`
  - mvn archetype:generate -DgroupId=me.gacl -DartifactId=system-parent -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
- 创建system-domain 模块
   - mvn archetype:generate -DgroupId=me.gacl -DartifactId=system-domain -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false


- 创建dao模块
  - mvn archetype:generate -DgroupId=me.gacl -DartifactId=system-dao -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
- 创建service模块
   - mvn archetype:generate -DgroupId=me.gacl -DartifactId=system-service -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
- 创建web模块
   - mvn archetype:generate -DgroupId=me.gacl -DartifactId=system-web -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false


---
generate命令替代 create命令  
mvn archetype:generate -DgroupId=com.fdc.dmp -DartifactId=dmp -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

创建service模块  
mvn archetype:generate -DgroupId=com.fdc.dmp -DartifactId=dmp-service -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

创建web模块  
mvn archetype:generate -DgroupId=com.fdc.dmp -DartifactId=dmp-web -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

mvn archetype:generate -DgroupId=com.fdc.dmp -DartifactId=dmp-api -DarchetypeArtifactId=maven-archetype-webapp -DinteractiveMode=false

mvn archetype:generate -DgroupId=com.fdc.dmp.service -DartifactId=dmp-service-inter -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

mvn archetype:generate -DgroupId=com.fdc.dmp.service -DartifactId=dmp-service-impl -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

mvn archetype:generate -DgroupId=com.fdc.dmp -DartifactId=dmp-job -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false