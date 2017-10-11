#### lamada 集合操作

list转map, getId不可重复，否则抛异常  
```java
homeImgs.stream().collect(Collectors.toMap(HomeImg::getId, homeImg1 -> homeImg1));

list.stream().filter(u -> u.getName().equals("mike")).collect(Collectors.toList());

```
