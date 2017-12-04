- [批量杀死java进程](https://www.cnblogs.com/CoreXin/p/5566607.html)
```bash
tasklist /fi "imagename eq java.exe"
taskkill /fi "imagename eq java.exe" /f 

```