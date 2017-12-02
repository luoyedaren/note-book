#### lamada 集合操作

list转map, getId不可重复，否则抛异常  
```java
homeImgs.stream().collect(Collectors.toMap(HomeImg::getId, homeImg1 -> homeImg1));

list.stream().filter(u -> u.getName().equals("mike")).collect(Collectors.toList());

/**
 * List -> Map
 * 需要注意的是：
 * toMap 如果集合对象有重复的key，会报错Duplicate key ....
 *  apple1,apple12的id都为1。
 *  可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
 */
Map<Integer, Apple> appleMap = appleList.stream().collect(Collectors.toMap(Apple::getId, a -> a,(k1,k2)->k1));

```

list 过滤数据
```java
List<HouseSourceImg> coverImg = imgs.stream().filter(img1 -> img1.getIsCover().equals("1")).collect(Collectors.toList());


//List 以ID分组 Map<Integer,List<Apple>>
Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));

求和
//计算 总金额
BigDecimal totalMoney = appleList.stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);


```
