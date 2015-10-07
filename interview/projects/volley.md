##volley
难度：★★★☆☆

volley是极好的网络框架。代码好写，速度快，不闪退。现在要实现一个同去活动列表，要求网络部分使用volley。相关的API在[这里](android-stuff/interview/old/api.md)，官方文档在[这里](https://developer.android.com/training/volley/index.html)。
volley好像还不能直接加dependency，可以clone下来自己编译。

```
git clone https://android.googlesource.com/platform/frameworks/volley
```

###用到的知识点

* Volley的配置和使用
* 单例模式
* JSON解析

###Hint

* Volley的配置，网上的教程都比较老。其实在android studio里面直接import existing project就可以了，然后记得在app module的build.gradle里面添加```compile project(':volley')```
