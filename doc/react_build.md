---
layout: post
title: "从源代码编译React Native"
date: 2018-3-25 10:36
comments: true
tags: 
  - 技术
---


#### 从源代码编译React Native
* 环境准备
1. Android SDK version 23 (非必须)
1. SDK build tools version 23.0.1 (非必须)
1. Android Support Repository >= 17
1. Android NDK(必须android-ndk-r10e)

---

* ndk安装

[android-ndk-r10e下载链接](http://dl.google.com/android/ndk/android-ndk-r10e-darwin-x86_64.bin)
1.chmod a+x android-ndk-r10e-darwin-x86_64.bin （申请权限）
2."./android-ndk-r10e-darwin-x86_64.bin" (切勿用工具解压)
3.指定ndk路径，打开.bash_profile  输入
    ```
     export NDK_ROOT=/Users/wangyang/sdk/android-ndk-r10e
     export PATH=$PATH:$NDK_ROOT
    ```
4.source .bash_profile 应用
5.检查ndk是否配置成功
   ```
   进入： /Users/wangyang/sdk/android-ndk-r10e/samples/hello-jni 
   执行 ndk-build  正常编译则表示配置成功
   在project structure中指定ndk的路径
   /Users/wangyang/sdk/android-ndk-r10e
         
   ```

---

* 项目文件修改

1.project中 build.gradle添加如下

    ```
    classpath 'de.undercouch:gradle-download-task:3.1.2'  //此步骤马上执行sync,不然接下来可能会报错
    ```

2.修改settings.gradle

    ```
    include ':ReactAndroid'
    project(':ReactAndroid').projectDir = new File(settingsDir, '.  ./rn/node_modules/react-native/ReactAndroid')
    ```
    
3.app build.gradle 修改
 
    ```
    dependencies{
           api project(':ReactAndroid')
         此处需要注释掉所有测试相关的依赖
        }
    configurations.all {
               exclude group: 'com.facebook.react', module: 'react-native'
         }
    ```
    
4.ReactAndroid 项目修改

    ```
    1.移动与ReactAndroid 同级的 ReactCommon到ReactAndroid（此步可有可无）
    修改 build.gradle "REACT_COMMON_DIR=$projectDir/../ReactCommon" 为"REACT_COMMON_DIR=$projectDir/ReactCommon",（有两处需修改）
    ```

5.app第三方本地依赖修改
- 注销掉原来的react-native 依赖

    ```
     opensourcelibrary moudle中
     //api 'com.facebook.react:react-native:+'
    ```

- 第三方本地引入依赖修改 

    ```
    com.horcrux.svg 此包整个从组件库中移入主项目中，不然会报找不到react相关的包
    ```
    
#### androidStudio 3.0的兼容处理

* 修改前(ReactAndroid/release.gradle)

    ```
  def getRepositoryUrl() {
            return hasProperty('repositoryUrl') ? property('repositoryUrl') : 'https://oss.sonatype .org/service/local/staging/deploy/maven2/'
        }
        
  def getRepositoryUsername() {
            return hasProperty('repositoryUsername') ? property('repositoryUsername') : ''
        }
  def getRepositoryPassword() {
            return hasProperty('repositoryPassword') ? property('repositoryPassword') : ''
        }
    ```
* 修改后
    ```
      def getRepositoryUrl() {
                return findProperty('repositoryUrl') != null ? property('repositoryUrl') : 'https://oss.sonatype.org/service/local/staging/deploy/maven2/'
            }
            
      def getRepositoryUsername() {
                return findProperty('repositoryUsername') !=null ? property('repositoryUsername') : ''
            }
            
      def getRepositoryPassword() {
                return findProperty('repositoryPassword') != null ? property('repositoryPassword') : ''
            }
    ```

#### 网络耗时任务的处理

  下载的文件放入 ReactAndroid/build/downloads下[boost下载](https://github.com/react-native-community/boost-for-react-native/releases/download/v1.63.0-0/boost_1_63_0.tar.gz)

 正常情况下只需要下载boost，其它的在编译时自动下载，如果下载不成功就采取手动下载，链接的资源如下
```
     https://github.com/react-native-community/boost-for-react-native/releases/download/v1.63.0-0/boost_1_63_0.tar.gz
     https://github.com/google/double-conversion/archive/v1.1.1.tar.gz
     https://github.com/facebook/folly/archive/v2016.09.26.00.tar.gz
     https://github.com/google/glog/archive/v0.3.3.tar.gz
     https://raw.githubusercontent.com/WebKit/webkit/38b15a3ba3c1b0798f2036f7cea36ffdc096202e/Source/JavaScriptCore/API/
                头文件只下载此数组中的['JavaScript.h', 'JSBase.h', 'JSContextRef.h', 'JSObjectRef.h', 'JSRetainPtr.h', 'JSStringRef.h', 'JSValueRef.h', 'WebKitAvailability.h']
                 下载的头文件放入 downloads/jsc目录下  
                 
```


#### 其它踩坑指南
  ReactNative 暂时还不支持新版的 api依赖等方式，所以需要保持 compile
  下面这个任务会不通过，因为此任务会去compile中复制一些文件过来
   
    ```
      task prepareJSC(dependsOn: dependenciesPath ? [] : [downloadJSCHeaders]) << {
                copy {
                  from zipTree(configurations.compile.fileCollection { dep -> dep.name == 'android-jsc'  }.singleFile)
                  from dependenciesPath ? "$dependenciesPath/jsc-headers" : {downloadJSCHeaders.dest}
                  from 'src/main/jni/third-party/jsc/Android.mk'
                     include 'jni/**/*.so', '*.h', 'Android.mk'
                     filesMatching('*.h', { fname -> fname.path = "JavaScriptCore/${fname.path}"})
                    into "$thirdPartyNdkDir/jsc";
               }
             }
    ```
*  React 不支持 D8的merge dex工具
  
    ```
    需要关闭此属性，在project/gradle.properties中
    android.enableD8=false  默认就是关闭
    ```

  