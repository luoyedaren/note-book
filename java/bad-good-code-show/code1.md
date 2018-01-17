#### 语义话代码
1. 无语义 
2. 容易引起NPE
```java
if (state.equals(5)) {
			// code ....
		}
		
```
优化后,语义清晰，容易各处调用，一处修改,便于维护,状态判断-业务归类
```java

public class OrderStateUtil {
    public static isOrderPaid() {
        return Integer.valueOf(State.ISPAID).equals(state);
    }
}
```

#### 分离独立逻辑
```java
if(!OrderUtils.isNewOrderNo(param.getOrderNo())){
            deliveryParam.setItemIds(param.getItemIds().stream().map(itemId->itemId.intValue()).collect(Collectors.toList()));
        }else {
            deliveryParam.setItemIds(param
                    .getItemIds()
                    .stream()
                    .map(
                            x -> {
                                if (orderItems.stream().anyMatch(orderItem -> x.equals(orderItem.getTcOrderItemId()))) {
                                    return orderItems
                                            .stream()
                                            .filter(orderItem -> x.equals(orderItem.getTcOrderItemId()))
                                            .map(orderItem -> orderItem.getId())
                                            .collect(Collectors.toList()).get(0);
                                } else {
                                    return x.intValue();
                                }
                            }
                    ).collect(Collectors.toList())
            );
        }

```
1. 抽离
```java

private List<Integer> getItemIds(DeliveryParamV2 param, List<OrderItem> orderItems) {
        if(!OrderUtils.isNewOrderNo(param.getOrderNo())){
            return StreamUtil.map(param.getItemIds(), Long::intValue);
        }
 
        Map<Long, Integer> itemIdMap = orderItems.stream().collect(
                                                 Collectors.toMap(OrderItem::getTcOrderItemId, OrderItem::getId));
        return StreamUtil.map(param.getItemIds(),
                              itemId -> itemIdMap.getOrDefault(itemId, itemId.intValue()));
    }
 
public class StreamUtil {
 
  public static <T,R> List<R> map(List<T> dataList, Function<T,R> getData) {
    if (dataList == null || dataList.isEmpty()) { return new ArrayList(); }
    return dataList.stream().map(getData).collect(Collectors.toList());
  }
 
}
```

#### 分离外部服务调用
>现在我们进入正题。 一环扣一环的外部服务调用，正是使单测编写变得困难的主要因素。 在 “使用Java函数接口及lambda表达式隔离和模拟外部依赖更容易滴单测” 一文已经初步探讨了如何使用函数接口及lambda表达式来隔离和模拟外部依赖，增强代码可测性。不过不彻底。 如果一个方法里含有多个外部服务调用怎么办？ 如果方法A调用B，B调用C，C调用D，D依赖了外部服务，怎么让 A,B,C,D更加容易测试？ 如何可配置化地调用外部服务，而让类的大部分方法保持函数纯粹性而容易单测，少部分方法则承担外部服务调用的职责？指导思想是： 通过函数接口隔离外部服务依赖，分离出真正可单测的部分 。真正可单测的部分往往是条件性、循环性的不含服务调用依赖的业务性逻辑，而顺序的含服务调用依赖的流程性逻辑，应当通过接口测试用例来验证。



