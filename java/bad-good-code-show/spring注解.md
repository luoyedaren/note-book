### spring 注解事物 自调用问题 
>参考资料：https://www.ibm.com/developerworks/cn/java/j-master-spring-transactional-use/index.html

```java
@Service
public class OrderService {
    private void insert() {
insertOrder();
}
@Transactional
    public void insertOrder() {
        //insert log info
        //insertOrder
        //updateAccount
       }
}
```
使用spring aop代理对象，内部自己调用insert方法，事物被忽略，出现异常不会发生回滚现象
**方案：**
1. 避免内部调用 抽出事物方法
2. 使用AspectJ 取代 spring aop

