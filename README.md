# AndroidOpenSSL
Compile and study openSSL on Android!

### Introduction
OpenSSL is a robust, commercial-grade, and full-featured toolkit for the Transport Layer Security
(TLS) and Secure Sockets Layer (SSL) protocols. It is also a general-purpose cryptography library.

#### Compile OpenSSL Static Library：
 * Compile is easy on Linux OS.
 1. Download All files that we need: NDK, OpenSSL Source Code, Set Env Script:
 ``` shell
 # NDK
 wget https://dl.google.com/android/repository/android-ndk-r14b-linux-x86_64.zip
 # OpenSSL
 wget https://www.openssl.org/source/openssl-1.1.1b.tar.gz
 ```

 2. upzip the archives:
 ``` shell
 # NDK
 unzip android-ndk-r14b-linux-x86_64.zip
 # OpenSSL
 tar -zxvf openssl-1.1.1b.tar.gz
 ```

 3. read 'NOTES.ANDROID' and compile.</br>
 ARCH: android-arm, android-arm64, android-x86, android-x86_64

 ``` shell
 # set NDK Home
export ANDROID_NDK_HOME=/root/android-ndk-r14b

PATH=$ANDROID_NDK_HOME/toolchains/arm-linux-androideabi-4.9/prebuilt/linux-x86_64/bin:$PATH
PATH=$ANDROID_NDK_HOME/toolchains/aarch64-linux-android-4.9/prebuilt/linux-x86_64/bin:$PATH
PATH=$ANDROID_NDK_HOME/toolchains/x86-4.9/prebuilt/linux-x86_64/bin:$PATH
PATH=$ANDROID_NDK_HOME/toolchains/x86_64-4.9/prebuilt/linux-x86_64/bin:$PATH

./Configure android-arm -D__ANDROID_API__=16
# ./Configure android-arm64 -D__ANDROID_API__=21
# ./Configure android-x86 -D__ANDROID_API__=21
# ./Configure android-x86_64 -D__ANDROID_API__=21

make
 ```

#### More Info
* Official Document: https://www.openssl.org/docs/


### About Me
 * GitHub: [https://huzongyao.github.io/](https://huzongyao.github.io/)
 * ITEye博客：[http://hzy3774.iteye.com/](http://hzy3774.iteye.com/)
 * 新浪微博: [http://weibo.com/hzy3774](http://weibo.com/hzy3774)

### Contact To Me
 * QQ: [377406997](http://wpa.qq.com/msgrd?v=3&uin=377406997&site=qq&menu=yes)
 * Gmail: [hzy3774@gmail.com](mailto:hzy3774@gmail.com)
 * Foxmail: [hzy3774@qq.com](mailto:hzy3774@qq.com)
 * WeChat: hzy3774

  ![image](https://raw.githubusercontent.com/hzy3774/AndroidP7zip/master/misc/wechat.png)
