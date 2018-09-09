# TinkerStudyDemo
Tinker接入、学习的Demo

## 最简单的集成参考

* http://www.tinkerpatch.com/Docs/SDK

* https://github.com/TinkerPatch/tinkerpatch-easy-sample

## 遇到注意的坑

1、记得给项目配上签名文件，未签名的apk不允许安装的

2、APP的版本号建议都写到gradle.properties中，这样不需要再在每次发版的时候改动app目录下的build.gradle及tinkerpatch.gradle文件

3、记得每次发版都把基包（即app/build/bakApk整个目录）保存（建议是放到git提交记录或者cdn上）

4、tinker platform平台上的版本号是跟tinkerpatch.gradle中的版本号对应上的，即也就是gradle.properties中的版本号，发布补丁的时候需要选择正确的app版本

5、改完bug打补丁包的时候需要
  ① clean
  
  ② sync一下重新生成build文件
  
  ③ 把基包（即上个版本的bakApk目录）拷贝到app/build文件夹下
  
  ④ 修改tinkerpatch.gradle文件中的def baseInfo = "app-0.0.1-0909-01-39-21"，改成基包的文件名
  
  ⑤ 执行tinkerpatch-release命令
  
  ⑥ 补丁在app/build/outputs.apk/tinkerPatch/release/patch_signed_7zip.apk     
  
  ⑦ 把补丁传到tinker platform（http://www.tinkerpatch.com/Apps/index） 找到对应的APP及对应的APP版本号，用开发模式下发
  
  ⑧ 下载tinkerpatch开发者工具http://www.tinkerpatch.com/Index/sdk  安装完成，打开开关，查看修复是否成功
  
  ⑨ 验证通过后再灰度下发或全量下发

6、tinker可以在老的基包上打多个补丁；不建议用tinker来发布新功能，合成成功率是一个问题
