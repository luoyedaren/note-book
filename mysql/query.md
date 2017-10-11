#### union & union all & order by 
- union 和 order by 
```mysql
select id,title from subjects where id>#some_id# order by id limit 1
union
select id,title from subjects where id<#some_id# order by id limit 1
提示错误 `Incorrect usage of UNION and ORDER BY`

解决方案
select * from (
select id,title from subjects where id>#some_id# order by id limit 1
) as one union
select id,title from subjects where id<#some_id# order by id limit 1
```

- union & union all. all 代表不去重，全部合并结果集

