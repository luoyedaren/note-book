#### lamada 集合操作

list转map, getId不可重复，否则抛异常  
```java
homeImgs.stream().collect(Collectors.toMap(HomeImg::getId, homeImg1 -> homeImg1));

list.stream().filter(u -> u.getName().equals("mike")).collect(Collectors.toList());

```

list 过滤数据
```java
List<HouseSourceImg> coverImg = imgs.stream().filter(img1 -> img1.getIsCover().equals("1")).collect(Collectors.toList());

```