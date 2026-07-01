package com.guodong.uniappx.offline

import android.content.ComponentName
import android.content.pm.PackageManager
import android.util.Log
import io.dcloud.uniapp.UniApplication
import io.dcloud.uniapp.UniSDKEngine
import io.dcloud.uniapp.ui.component.IComponent
import io.dcloud.uts.UTSAndroidHookProxy

class App : UniApplication() {

    private val TAG = "App"

    override fun onCreate() {
        // 💡 核心魔法代码：在冷启动的第一时间，让系统包管理器直接禁用这个死掉的 Provider 组件
        // 这能完美阻止它因为 ClassNotFoundException 而导致 App 刚启动就“屡次停止运行”
        try {
            val provider = ComponentName(this.packageName, "com.bytedance.sdk.openadsdk.TTFileProvider")
            this.packageManager.setComponentEnabledSetting(
                provider,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP
            )
        } catch (e: Exception) {
            Log.d(TAG, "穿山甲 Provider 移除失败或已被彻底清理: ${e.message}")
        }

        super.onCreate()
        register()
    }

    private fun register() {
        try {
            registerComponents("video", "uts.sdk.modules.DCloudUniVideo.VideoComponent")
        } catch (e: Exception) {
            Log.e(TAG, "register: 无法注册 video 组件", e)
        }

        try {
            registerHooksClass("uts.sdk.modules.zlText.ZlTextHook")
        } catch (e: Exception) {
            Log.e(TAG, "register: 无法注册 ZlTextHook 生命周期监听函数", e)
        }
    }

    /**
     * "name": 对应 buildConfigField UTSRegisterComponents 配置中的 name
     * "className": 对应 buildConfigField UTSRegisterComponents 配置中的 class
     */
    @Throws(ClassNotFoundException::class)
    private fun registerComponents(name: String, className: String) {
        UniSDKEngine.registerUniComponent(name, Class.forName(className) as Class<out IComponent>)
    }

    /**
     * "className": 对应 buildConfigField UTSHooksClassArray 配置中的值
     */
    @Throws(ClassNotFoundException::class)
    private fun registerHooksClass(className: String) {
        // 注册应用程序生命周期监听函数
        val instance = Class.forName(className).newInstance()
        if (instance is UTSAndroidHookProxy) {
            instance.onCreate(this)
        }
    }
}
