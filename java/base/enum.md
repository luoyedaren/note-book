enum 枚举 根据value 取key : https://www.cnblogs.com/jian-xiao/p/6036925.html
或者根据key取value
```java
 MAN("M", "男"),
  WOMAN("F", "女");

```

demo
```java
package com.fdc.home.workstation.enums;

/**
 * project: home-workstation
 * Created by chenghai on 2017/11/17. - 星期五
 */
public enum HouseOrderEnum {

	UNPUBLISH("未发布", 10), PUBLISHED_WAIT_FOR_CONFIRM("发布待确认", 12), PUBLISHED_WITH_AGENT("已发布转自营", 15), PUBLISHED("已发布", 20), DOWNSTOCK("下架", 30);

	private String desc;
	private Integer orderNum;

	HouseOrderEnum(String desc, Integer orderNum) {
		this.desc = desc;
		this.orderNum = orderNum;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	public static HouseOrderEnum getHouseOrderEnumByCode(Integer code) {
		for (HouseOrderEnum houseOrderEnum : HouseOrderEnum.values()) {
			if (code == houseOrderEnum.getOrderNum()) {
				return houseOrderEnum;
			}
		}
		return null;
	}

}


```