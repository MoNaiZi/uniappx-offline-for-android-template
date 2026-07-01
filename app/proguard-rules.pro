# ============================================
# uni-app X 离线打包 ProGuard 混淆规则
# uni-app X SDK 大量使用反射，必须保留以下类不被混淆
# ============================================

# === 保留行号和源文件信息（线上崩溃日志可读） ===
-keepattributes SourceFile,LineNumberTable
-renamesourcefileattribute SourceFile

# === 保留注解 ===
-keepattributes *Annotation*

# === 保留 Application 类（AndroidManifest 中注册的） ===
-keep class com.guodong.uniappx.offline.App { *; }

# === 保留 uni-app X 核心 SDK（io.dcloud.*） ===
-keep class io.dcloud.** { *; }
-keepclassmembers class io.dcloud.** { *; }

# === 保留 UTS 运行时及所有 UTS 模块 ===
-keep class uts.sdk.** { *; }
-keepclassmembers class uts.sdk.** { *; }
-keep class io.dcloud.uts.** { *; }
-keepclassmembers class io.dcloud.uts.** { *; }

# === 保留 uts.sdk.modules 下所有通过反射注册的组件和 Hook ===
-keep class uts.sdk.modules.DCloudUniVideo.* { *; }
-keep class uts.sdk.modules.zlText.* { *; }

# === 保留 Kotlin 相关 ===
-keep class kotlin.** { *; }
-keepclassmembers class kotlin.Metadata { *; }
-dontwarn kotlin.**

# === 保留 Serializable / Parcelable ===
-keepclassmembers class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}
-keep class * implements java.io.Serializable { *; }

# === 保留枚举 ===
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# === 保留 WebView JS 接口 ===
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}

# === 保留 Native 方法 ===
-keepclasseswithmembernames class * {
    native <methods>;
}

# === 保留 R 文件内部类 ===
-keepclassmembers class **.R$* {
    public static <fields>;
}

# === 第三方 SDK ===

# 穿山甲（字节跳动广告 SDK）
-keep class com.bytedance.sdk.** { *; }
-dontwarn com.bytedance.sdk.**

# 个推 / 个验
-keep class com.getui.** { *; }
-dontwarn com.getui.**
-keep class com.gyf.** { *; }
-dontwarn com.gyf.**

# 支付宝
-keep class com.alipay.** { *; }
-dontwarn com.alipay.**

# 微信支付
-keep class com.tencent.mm.** { *; }
-dontwarn com.tencent.mm.**

# 腾讯地图
-keep class com.tencent.map.** { *; }
-keep class com.tencent.tencentmap.** { *; }
-dontwarn com.tencent.map.**

# 阿里云人脸识别
-keep class com.aliyun.** { *; }
-dontwarn com.aliyun.**

# Gromore 聚合广告
-keep class com.bytedance.msdk.** { *; }
-dontwarn com.bytedance.msdk.**

# 百度百青藤广告
-keep class com.baidu.mobads.** { *; }
-dontwarn com.baidu.mobads.**

# Funlink / uni-ad
-keep class com.funlink.** { *; }
-dontwarn com.funlink.**

# 扫描 SDK
-keep class com.ztec.bsp.zbcr.** { *; }

# === 通用：保留所有反射可能用到的构造方法 ===
-keepclassmembers class * {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
}