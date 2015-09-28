DongYue Android Developing Preparation
===================


----------

Java
-------------

java运行环境, 去[www.java.com](http://www.java.com)检查一下更新, 然后配置环境变量, 参考[百度经验](http://jingyan.baidu.com/article/f96699bb8b38e0894e3c1bef.html)

> **Note:**

> - 照着教程做就ok, 别忘了测试
> - 环境变量里面值是以**英文分号**分隔的

----------


Android Studio
-------------------

Eclipse可以放弃了, 在[http://www.android-studio.org/](http://www.android-studio.org/)下载最新版本Android Studio, 还有SDK tools可以一并下载, 然后安装, 安装过程中会跳到SDK安装, 跳过就可以了

AS整个页面布局和Eclipse是差不多的, 安装好之后应该是不能运行的, 开SDK manager安装SDK

安装SDK一般来说会比较慢, 可以翻个墙=_=...SDK manager菜单, Tools->Options, 勾上Force...然后设置一下就可以下载了, 速度还可以

SDK装好之后工程就可以运行了, 就是那个绿色的箭头, 然后会build很长时间, 检查一下能在手机上运行就ok了

> **Note:**

> - AS最好找个教程看看, 特别是快捷键, 非!常!好!用!, 强烈推荐**Ctrl+Alt+L**
> - 下载SDK之前看一下左边列表, 下载的内容差不多这三类, SDK, build-tool, 还有system image, system image不建议安装, 虚拟机用的, 关键是很大, 随便一个都几G
> - AS主题这样改, File->Setting->Appearance, 然后下面的Editor里面可以调整字体:-)
> - 往上面看有Version Control, 这个等一下再配置
> - 还有, 记得升级, 升到最新的吧, 方法参照SDK manager

----

Git
-------------

使用客户端[SourceTree](http://www.sourcetreeapp.com/), 装好之后:

- 菜单, 文件->创建向导, 邮箱最好和github一样, 使用OpenSSH
- github要先注册账号的, 还有gitlab账号, gitlab在[这里](http://git.tongqu.me/)登陆, gitlab账号找谁申请呢, 我也不造...
- 打开SourceTree右上角的终端, 在本地创建ssh key:
	- $ ssh-keygen -t rsa -C "your_email", 之后要求确认路径和密码, 默认一路回车, 成功的话会在~/下生成.ssh文件夹, 进去打开id_rsa.pub, 复制里面的key
	- 开github, 右上角setting->ssh key->add, title随便, 贴key
	- 回终端验证: $ssh -T git@github.com 第一次会提示continue, yes, 看到...success...就好了
- 设置username和email, 因为git每次commit都要记录
	 - $ git config --global user.name "your_name"
	 - $ git config --global user.email "your_email" 

> **Note:** 
> - [git教程](http://rogerdudler.github.io/git-guide/index.zh.html)
> - SourceTree也找个教程吧, 大概看看=_=...