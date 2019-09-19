## Gradle 依赖

**方式引用**

```gradle

maven { url 'https://jitpack.io' }

dependencies {
    implementation 'com.github.oneway2030:Toast:V1.0.0'
}
```

## 简单使用

```java
   //初始化 Toast
        ToastConfig.builder(this)
                .setTextSize(12)   //设置字体大小
                .setDefaultTextColor(Color.WHITE)//设置默认字体颜色 默认白色 #FFFFFF
                .setSuccessColor(Color.GREEN) //成功背景   默认黑色透明百分之75  #C0000000
                .setErrorColor(Color.RED) //错误背景色     默认黑色透明百分之75  #C0000000
                .setWarningColor(Color.BLUE)//警告背景色   默认黑色透明百分之75  #C0000000
                .setNormalColor(Color.GRAY) //普通背景色   默认黑色透明百分之75  #C0000000
                .setTintIcon(true)//图标与文字是否同色     默认黑色透明百分之75  #C0000000
                .build()
```
## 详细说明
- [配置文件](ToastConfig.java)
- [使用参考Demo](MainActivity.kt)



