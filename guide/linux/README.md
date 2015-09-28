Linux 下安卓开发环境的配置
===================

----------

Linux下的Android环境配置，不出什么意外的话是非常简单的。但总会出各种各样的意外。常见的一些坑我们也会在文中列举出来。总体的流程是这样的：

- <a href="#1">JDK的安装</a>
- <a href="#2">Android Studio的安装</a>
- <a href="#3">Android SDK的安装</a>
- <a href="#4">Git的配置</a>

----------

<a name="1" id="1">JDK</a>
-------------

java运行环境, 可以到[Oracle](http://www.oracle.com/technetwork/java/javase/downloads/index.html)下载，这个不需要翻墙。或者也可以直接在国内的下载站下载，注意不要下到假的。大概100多MB。注意选择对应自己操作系统位数的JDK。32位的选X86，64位的选X64。
我下载的是jdk\_1.8.0\_40，Linux64位的。
接下来添加环境变量，目的是为了Android Studio使用java的东西的时候能到这些目录里面去找。在terminal中输入以下内容：

移动到某个目录下，解压，比如我把它放到`/opt/`下

> sudo cp jdk-8u40-linux-x64.tar.gz /opt/  
> tar zxvf jdk-8u40-linux-x64.tar.gz 

打开/etc/profile，添加环境变量。

> sudo gedit /etc/profile

在编辑器中输入以下内容，保存退出：

> export JAVA_HOME=/opt/jdk1.8.0_40  
> export CLASSPATH=.:$JAVA_HOME/lib:$JRE_HOME/lib:$JAVA_HOME/lib/tools.jar:$JAVA_HOME/lib/dt.jar  
> export PATH=$JAVA_HOME:$JAVA_HOME/bin:$JRE_HOME/bin:$JAVA_HOME/lib:$PATH

在terminal中，使用source来应用修改后的环境变量：

> source /etc/profile

输入`java -version`，看看是不是显示了刚刚安装的jdk的版本信息？也可以用`echo $JAVA_HOME`等命令看看环境变量是否设置好了。


<a name="2" id="2">Android Studio</a>
-------------------

在[http://www.android-studio.org/](http://www.android-studio.org/)下载最新版本Android Studio, 还有SDK tools可以一并下载, 然后安装, 安装过程中会跳到SDK安装, 跳过就可以了

下载下来后，移动到某个目录下，解压就可以用了。`cd`到安装目录下的`/bin/`目录下，输入

> sudo ./studio.sh

就能看到Android Studio的启动画面了。

<a name="3" id="3">Android SDK</a>
-------------------

到现在还不能开始写程序。你需要安装至少一个版本的Android SDK。首先`cd`到你刚下载的SDK tools的`/tools/`目录下，输入

> sudo ./android

打开SDK Manager，按理说会出现一个SDK的列表，但是由于Google被墙了你看不到。一个简单的方法是改host。让访问Google的时候强制访问你指定的那个IP，就可以绕过墙了（是这样的吧？）。Linux下改host：

> sudo gedit /etc/hosts

输入IP地址。这个地址不一定一直有效，你可以在网上搜索`Google最新IP地址`之类的关键词，找到dl-ssl.google.com的那一项加进来：

> 216.58.209.227 dl-ssl.google.com

然后回到SDK Manager，选择`Tools-->Option...`，勾选`Force https://… sources to be fetched using http://…`，然后`Package-->Reload`，应该就可以得到SDK列表了。如果还是不行，你看看Logcat里面他去获取目录的那个URL，你拿出来到浏览器打开，如果404 no found什么的，说明那个IP用不了了，再换一个就行。

SDK装好之后工程就可以运行了。


<a name="4" id="4">Git</a>
-------------

在Linux下Git推荐用命令行。当然用客户端也可以的，在这里就不详细说了。要获得克隆东岳项目的权限，需要添加公钥。首先进入`~/.ssh`目录：

> cd ~/.ssh

生成SSH公钥，输入你在[git.tongqu.me](git.tongqu.me)的用户的邮箱。

> $ ssh-keygen -t rsa -C "your_email@youremail.com"
 
接下来可以一路回车。

打开[git.tongqu.me](git.tongqu.me)，到你的账户信息底下添加一个SSH，把`idrsa.pub`内容复制到key里面。

试试用 `git clone` 克隆一个项目到本地：

> git clone ssh://git@git.tongqu.me:3022/tongqu/tongqu-app.git

> **Note:** 
> - git教程网上有很多，大家可以随便看看
>   - [git教程](http://www.liaoxuefeng.com/wiki/0013739516305929606dd18361248578c67b8067c8c017b000/)

<a name="5" id="5">常见坑</a>
-------------

### 启动Android Studio提示no jdk found ###

我jdk明明已经装好了，java -version也正常输出了，但是打开Android Studio就是报这个错，怎么办？
我目前的方法是，用编辑器打开studio.sh，找到检测$JAVA_HOME环境变量的那段代码，把jdk的地址写死，不让他自己去找就行了。

> sudo gedit ./studio.sh

找到下面这段代码：

> if [ -n "$STUDIO_JDK" -a -x "$STUDIO_JDK/bin/java" ]; then  
>   JDK="$STUDIO_JDK"  
> elif [ -n "$JDK_HOME" -a -x "$JDK_HOME/bin/java" ]; then  
>   JDK="$JDK_HOME"  
> elif [ -n "$JAVA_HOME" -a -x "$JAVA_HOME/bin/java" ]; then  
>   JDK="$JAVA_HOME" 

把它改成：

> if [ -n "/opt/jdk1.8.0_40" -a -x "/opt/jdk1.8.0_40/bin/java" ]; then  
>   JDK="/opt/jdk1.8.0_40" 
> elif [ -n "$JDK_HOME" -a -x "$JDK_HOME/bin/java" ]; then  
>   JDK="$JDK_HOME"  
> elif [ -n "$JAVA_HOME" -a -x "$JAVA_HOME/bin/java" ]; then  
>   JDK="$JAVA_HOME" 

注意安装目录换成你自己的。保存退出再启动，应该好了。

### 真机调试无法识别 ###

开发android当然还是真机调试更方便一点，但经常不是一插上就能用了的。网上有很多加rules的解决方法，但我用了都没用。看了[这一篇](http://blog.csdn.net/liuqz2009/article/details/7942569) 之后，用他的b方案成功解决了。手机的VID可通过lsusb命令查看。