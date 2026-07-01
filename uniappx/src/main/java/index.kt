@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "SENSELESS_COMPARISON", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNI02D379B
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import kotlin.properties.Delegates
import io.dcloud.uniapp.extapi.exit as uni_exit
import uts.sdk.modules.ysapi.getSystemHelper
import io.dcloud.uniapp.extapi.showToast as uni_showToast
val runBlock1 = run {
    __uniConfig.getAppStyles = fun(): Map<String, Map<String, Map<String, Any>>> {
        return GenApp.styles
    }
}
var firstBackTime: Number = 0
open class GenApp : BaseApp {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onLaunch(fun(_: OnLaunchOptions) {
            val app = getApp().getAndroidApplication()
            getSystemHelper().init(app)
            console.log("设备信息", app)
            console.log("App Launch")
        }
        , __ins)
        onAppShow(fun(_: OnShowOptions) {
            console.log("App Show")
        }
        , __ins)
        onAppHide(fun() {
            console.log("App Hide")
        }
        , __ins)
        onLastPageBackPress(fun() {
            console.log("App LastPageBackPress")
            if (firstBackTime == 0) {
                uni_showToast(ShowToastOptions(title = "再按一次退出应用", position = "bottom"))
                firstBackTime = Date.now()
                setTimeout(fun(){
                    firstBackTime = 0
                }, 2000)
            } else if (Date.now() - firstBackTime < 2000) {
                firstBackTime = Date.now()
                uni_exit(null)
            }
        }
        , __ins)
        onExit(fun() {
            console.log("App Exit")
        }
        , __ins)
    }
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("uni-row" to _pS(_uM("flexDirection" to "row")), "uni-column" to _pS(_uM("flexDirection" to "column")), "page-container" to _pS(_uM("width" to 1280, "height" to 800, "backgroundColor" to "#EEF2F5", "borderTopWidth" to 2, "borderRightWidth" to 2, "borderBottomWidth" to 2, "borderLeftWidth" to 2, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "#000000", "borderRightColor" to "#000000", "borderBottomColor" to "#000000", "borderLeftColor" to "#000000")))
            }
    }
}
val GenAppClass = CreateVueAppComponent(GenApp::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "app", name = "", inheritAttrs = true, inject = Map(), props = Map(), propsNeedCastKeys = _uA(), emits = Map(), components = Map(), styles = GenApp.styles)
}
, fun(instance): GenApp {
    return GenApp(instance)
}
)
val `default` = "/static/heade/bg.png"
val default__1 = "/static/heade/hospital-logo.png"
val default__2 = "/static/heade/positioning.png"
val default__3 = "/static/heade/time-bg.png"
open class Menu (
    @JsonNotNull
    open var icon: String,
    @JsonNotNull
    open var isAuth: Boolean = false,
    @JsonNotNull
    open var pageUrl: String,
    @JsonNotNull
    open var key: String,
    @JsonNotNull
    open var title: String,
    @JsonNotNull
    open var bgColor: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return MenuReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class MenuReactiveObject : Menu, IUTSReactive<Menu> {
    override var __v_raw: Menu
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: Menu, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(icon = __v_raw.icon, isAuth = __v_raw.isAuth, pageUrl = __v_raw.pageUrl, key = __v_raw.key, title = __v_raw.title, bgColor = __v_raw.bgColor) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): MenuReactiveObject {
        return MenuReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var icon: String
        get() {
            return _tRG(__v_raw, "icon", __v_raw.icon, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("icon")) {
                return
            }
            val oldValue = __v_raw.icon
            __v_raw.icon = value
            _tRS(__v_raw, "icon", oldValue, value)
        }
    override var isAuth: Boolean
        get() {
            return _tRG(__v_raw, "isAuth", __v_raw.isAuth, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("isAuth")) {
                return
            }
            val oldValue = __v_raw.isAuth
            __v_raw.isAuth = value
            _tRS(__v_raw, "isAuth", oldValue, value)
        }
    override var pageUrl: String
        get() {
            return _tRG(__v_raw, "pageUrl", __v_raw.pageUrl, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("pageUrl")) {
                return
            }
            val oldValue = __v_raw.pageUrl
            __v_raw.pageUrl = value
            _tRS(__v_raw, "pageUrl", oldValue, value)
        }
    override var key: String
        get() {
            return _tRG(__v_raw, "key", __v_raw.key, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("key")) {
                return
            }
            val oldValue = __v_raw.key
            __v_raw.key = value
            _tRS(__v_raw, "key", oldValue, value)
        }
    override var title: String
        get() {
            return _tRG(__v_raw, "title", __v_raw.title, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("title")) {
                return
            }
            val oldValue = __v_raw.title
            __v_raw.title = value
            _tRS(__v_raw, "title", oldValue, value)
        }
    override var bgColor: String
        get() {
            return _tRG(__v_raw, "bgColor", __v_raw.bgColor, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("bgColor")) {
                return
            }
            val oldValue = __v_raw.bgColor
            __v_raw.bgColor = value
            _tRS(__v_raw, "bgColor", oldValue, value)
        }
}
open class RegisterDate (
    @JsonNotNull
    open var date: String,
    @JsonNotNull
    open var year: Number,
    @JsonNotNull
    open var month: String,
    @JsonNotNull
    open var day: String,
    @JsonNotNull
    open var dayOfWeek: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return RegisterDateReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class RegisterDateReactiveObject : RegisterDate, IUTSReactive<RegisterDate> {
    override var __v_raw: RegisterDate
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: RegisterDate, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(date = __v_raw.date, year = __v_raw.year, month = __v_raw.month, day = __v_raw.day, dayOfWeek = __v_raw.dayOfWeek) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): RegisterDateReactiveObject {
        return RegisterDateReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var date: String
        get() {
            return _tRG(__v_raw, "date", __v_raw.date, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("date")) {
                return
            }
            val oldValue = __v_raw.date
            __v_raw.date = value
            _tRS(__v_raw, "date", oldValue, value)
        }
    override var year: Number
        get() {
            return _tRG(__v_raw, "year", __v_raw.year, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("year")) {
                return
            }
            val oldValue = __v_raw.year
            __v_raw.year = value
            _tRS(__v_raw, "year", oldValue, value)
        }
    override var month: String
        get() {
            return _tRG(__v_raw, "month", __v_raw.month, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("month")) {
                return
            }
            val oldValue = __v_raw.month
            __v_raw.month = value
            _tRS(__v_raw, "month", oldValue, value)
        }
    override var day: String
        get() {
            return _tRG(__v_raw, "day", __v_raw.day, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("day")) {
                return
            }
            val oldValue = __v_raw.day
            __v_raw.day = value
            _tRS(__v_raw, "day", oldValue, value)
        }
    override var dayOfWeek: String
        get() {
            return _tRG(__v_raw, "dayOfWeek", __v_raw.dayOfWeek, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("dayOfWeek")) {
                return
            }
            val oldValue = __v_raw.dayOfWeek
            __v_raw.dayOfWeek = value
            _tRS(__v_raw, "dayOfWeek", oldValue, value)
        }
}
open class State (
    open var `fun`: Menu? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return StateReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class StateReactiveObject : State, IUTSReactive<State> {
    override var __v_raw: State
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: State, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(`fun` = __v_raw.`fun`) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): StateReactiveObject {
        return StateReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var `fun`: Menu?
        get() {
            return _tRG(__v_raw, "fun", __v_raw.`fun`, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("fun")) {
                return
            }
            val oldValue = __v_raw.`fun`
            __v_raw.`fun` = value
            _tRS(__v_raw, "fun", oldValue, value)
        }
}
val commonState = reactive(State(`fun` = null))
val initCommonState = fun() {
    commonState.`fun` = null
}
val GenComponentsNavigationBarClass = CreateVueComponent(GenComponentsNavigationBar::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsNavigationBar.inheritAttrs, inject = GenComponentsNavigationBar.inject, props = GenComponentsNavigationBar.props, propsNeedCastKeys = GenComponentsNavigationBar.propsNeedCastKeys, emits = GenComponentsNavigationBar.emits, components = GenComponentsNavigationBar.components, styles = GenComponentsNavigationBar.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsNavigationBar.setup(props as GenComponentsNavigationBar)
    }
    )
}
, fun(instance, renderer): GenComponentsNavigationBar {
    return GenComponentsNavigationBar(instance)
}
)
val default__4 = "/static/auth/bg.png"
val GenComponentsCommonBgImgClass = CreateVueComponent(GenComponentsCommonBgImg::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsCommonBgImg.name, inheritAttrs = GenComponentsCommonBgImg.inheritAttrs, inject = GenComponentsCommonBgImg.inject, props = GenComponentsCommonBgImg.props, propsNeedCastKeys = GenComponentsCommonBgImg.propsNeedCastKeys, emits = GenComponentsCommonBgImg.emits, components = GenComponentsCommonBgImg.components, styles = GenComponentsCommonBgImg.styles)
}
, fun(instance, renderer): GenComponentsCommonBgImg {
    return GenComponentsCommonBgImg(instance)
}
)
val default__5 = "/static/back-btn.png"
val GenComponentsBackPageBtnClass = CreateVueComponent(GenComponentsBackPageBtn::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsBackPageBtn.name, inheritAttrs = GenComponentsBackPageBtn.inheritAttrs, inject = GenComponentsBackPageBtn.inject, props = GenComponentsBackPageBtn.props, propsNeedCastKeys = GenComponentsBackPageBtn.propsNeedCastKeys, emits = GenComponentsBackPageBtn.emits, components = GenComponentsBackPageBtn.components, styles = GenComponentsBackPageBtn.styles)
}
, fun(instance, renderer): GenComponentsBackPageBtn {
    return GenComponentsBackPageBtn(instance)
}
)
val default__6 = "/static/square-back-btn.png"
val default__7 = "/static/square-confirm-btn.png"
val GenComponentsLeftAndRightLayoutClass = CreateVueComponent(GenComponentsLeftAndRightLayout::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsLeftAndRightLayout.inheritAttrs, inject = GenComponentsLeftAndRightLayout.inject, props = GenComponentsLeftAndRightLayout.props, propsNeedCastKeys = GenComponentsLeftAndRightLayout.propsNeedCastKeys, emits = GenComponentsLeftAndRightLayout.emits, components = GenComponentsLeftAndRightLayout.components, styles = GenComponentsLeftAndRightLayout.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsLeftAndRightLayout.setup(props as GenComponentsLeftAndRightLayout)
    }
    )
}
, fun(instance, renderer): GenComponentsLeftAndRightLayout {
    return GenComponentsLeftAndRightLayout(instance)
}
)
val default__8 = "/static/home/bg.png"
val default__9 = "/static/home/ccb.png"
val default__10 = "/static/home/company.png"
val GenPagesIndexIndexClass = CreateVueComponent(GenPagesIndexIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesIndexIndex.inheritAttrs, inject = GenPagesIndexIndex.inject, props = GenPagesIndexIndex.props, propsNeedCastKeys = GenPagesIndexIndex.propsNeedCastKeys, emits = GenPagesIndexIndex.emits, components = GenPagesIndexIndex.components, styles = GenPagesIndexIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesIndexIndex.setup(props as GenPagesIndexIndex)
    }
    )
}
, fun(instance, renderer): GenPagesIndexIndex {
    return GenPagesIndexIndex(instance, renderer)
}
)
val default__11 = "/static/auth/bell.png"
val default__12 = "/static/auth/empty.png"
val GenComponentsAnimationClass = CreateVueComponent(GenComponentsAnimation::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsAnimation.name, inheritAttrs = GenComponentsAnimation.inheritAttrs, inject = GenComponentsAnimation.inject, props = GenComponentsAnimation.props, propsNeedCastKeys = GenComponentsAnimation.propsNeedCastKeys, emits = GenComponentsAnimation.emits, components = GenComponentsAnimation.components, styles = GenComponentsAnimation.styles)
}
, fun(instance, renderer): GenComponentsAnimation {
    return GenComponentsAnimation(instance)
}
)
interface Props {
    var show: Boolean
}
val GenComponentsPopupClass = CreateVueComponent(GenComponentsPopup::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsPopup.inheritAttrs, inject = GenComponentsPopup.inject, props = GenComponentsPopup.props, propsNeedCastKeys = GenComponentsPopup.propsNeedCastKeys, emits = GenComponentsPopup.emits, components = GenComponentsPopup.components, styles = GenComponentsPopup.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsPopup.setup(props as GenComponentsPopup)
    }
    )
}
, fun(instance, renderer): GenComponentsPopup {
    return GenComponentsPopup(instance)
}
)
open class Auth (
    @JsonNotNull
    open var img: String,
    @JsonNotNull
    open var key: String,
) : UTSObject()
val GenPagesAuthSelectAuthClass = CreateVueComponent(GenPagesAuthSelectAuth::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesAuthSelectAuth.inheritAttrs, inject = GenPagesAuthSelectAuth.inject, props = GenPagesAuthSelectAuth.props, propsNeedCastKeys = GenPagesAuthSelectAuth.propsNeedCastKeys, emits = GenPagesAuthSelectAuth.emits, components = GenPagesAuthSelectAuth.components, styles = GenPagesAuthSelectAuth.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesAuthSelectAuth.setup(props as GenPagesAuthSelectAuth)
    }
    )
}
, fun(instance, renderer): GenPagesAuthSelectAuth {
    return GenPagesAuthSelectAuth(instance, renderer)
}
)
interface KeyboardProps {
    var mode: String
    var extraKeys: UTSArray<String>
}
val GenComponentsKeyboardClass = CreateVueComponent(GenComponentsKeyboard::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsKeyboard.inheritAttrs, inject = GenComponentsKeyboard.inject, props = GenComponentsKeyboard.props, propsNeedCastKeys = GenComponentsKeyboard.propsNeedCastKeys, emits = GenComponentsKeyboard.emits, components = GenComponentsKeyboard.components, styles = GenComponentsKeyboard.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsKeyboard.setup(props as GenComponentsKeyboard)
    }
    )
}
, fun(instance, renderer): GenComponentsKeyboard {
    return GenComponentsKeyboard(instance)
}
)
val default__13 = "/static/empty.png"
interface InputProps {
    var index: Number
    var value: String
    var placeholder: String
    var placeholderSize: String
    var isActive: Boolean
    var size: String
}
val GenComponentsCustomInputClass = CreateVueComponent(GenComponentsCustomInput::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenComponentsCustomInput.inheritAttrs, inject = GenComponentsCustomInput.inject, props = GenComponentsCustomInput.props, propsNeedCastKeys = GenComponentsCustomInput.propsNeedCastKeys, emits = GenComponentsCustomInput.emits, components = GenComponentsCustomInput.components, styles = GenComponentsCustomInput.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenComponentsCustomInput.setup(props as GenComponentsCustomInput)
    }
    )
}
, fun(instance, renderer): GenComponentsCustomInput {
    return GenComponentsCustomInput(instance)
}
)
val GenPagesAuthInputAuthClass = CreateVueComponent(GenPagesAuthInputAuth::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesAuthInputAuth.inheritAttrs, inject = GenPagesAuthInputAuth.inject, props = GenPagesAuthInputAuth.props, propsNeedCastKeys = GenPagesAuthInputAuth.propsNeedCastKeys, emits = GenPagesAuthInputAuth.emits, components = GenPagesAuthInputAuth.components, styles = GenPagesAuthInputAuth.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesAuthInputAuth.setup(props as GenPagesAuthInputAuth)
    }
    )
}
, fun(instance, renderer): GenPagesAuthInputAuth {
    return GenPagesAuthInputAuth(instance, renderer)
}
)
val default__14 = "/static/register/check.png"
val default__15 = "/static/register/doctor-avatar.png"
val default__16 = "/static/register/caret-right.png"
val GenPagesEmergentRegisterSelectDoctorClass = CreateVueComponent(GenPagesEmergentRegisterSelectDoctor::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesEmergentRegisterSelectDoctor.inheritAttrs, inject = GenPagesEmergentRegisterSelectDoctor.inject, props = GenPagesEmergentRegisterSelectDoctor.props, propsNeedCastKeys = GenPagesEmergentRegisterSelectDoctor.propsNeedCastKeys, emits = GenPagesEmergentRegisterSelectDoctor.emits, components = GenPagesEmergentRegisterSelectDoctor.components, styles = GenPagesEmergentRegisterSelectDoctor.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesEmergentRegisterSelectDoctor.setup(props as GenPagesEmergentRegisterSelectDoctor)
    }
    )
}
, fun(instance, renderer): GenPagesEmergentRegisterSelectDoctor {
    return GenPagesEmergentRegisterSelectDoctor(instance, renderer)
}
)
val default__17 = "/static/print.gif"
val GenPagesEmergentRegisterResultClass = CreateVueComponent(GenPagesEmergentRegisterResult::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesEmergentRegisterResult.inheritAttrs, inject = GenPagesEmergentRegisterResult.inject, props = GenPagesEmergentRegisterResult.props, propsNeedCastKeys = GenPagesEmergentRegisterResult.propsNeedCastKeys, emits = GenPagesEmergentRegisterResult.emits, components = GenPagesEmergentRegisterResult.components, styles = GenPagesEmergentRegisterResult.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesEmergentRegisterResult.setup(props as GenPagesEmergentRegisterResult)
    }
    )
}
, fun(instance, renderer): GenPagesEmergentRegisterResult {
    return GenPagesEmergentRegisterResult(instance, renderer)
}
)
val default__18 = "/static/register/date-item-bg.png"
open class State__1 (
    open var registerDate: RegisterDate? = null,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return State__1ReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
class State__1ReactiveObject : State__1, IUTSReactive<State__1> {
    override var __v_raw: State__1
    override var __v_isReadonly: Boolean
    override var __v_isShallow: Boolean
    override var __v_skip: Boolean
    constructor(__v_raw: State__1, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(registerDate = __v_raw.registerDate) {
        this.__v_raw = __v_raw
        this.__v_isReadonly = __v_isReadonly
        this.__v_isShallow = __v_isShallow
        this.__v_skip = __v_skip
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): State__1ReactiveObject {
        return State__1ReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip)
    }
    override var registerDate: RegisterDate?
        get() {
            return _tRG(__v_raw, "registerDate", __v_raw.registerDate, __v_isReadonly, __v_isShallow)
        }
        set(value) {
            if (!__v_canSet("registerDate")) {
                return
            }
            val oldValue = __v_raw.registerDate
            __v_raw.registerDate = value
            _tRS(__v_raw, "registerDate", oldValue, value)
        }
}
val registerState = reactive(State__1(registerDate = null))
val setRegisterDate = fun(obj: RegisterDate): Unit {
    registerState.registerDate = obj
}
val GenPagesRegisteSelectDateClass = CreateVueComponent(GenPagesRegisteSelectDate::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesRegisteSelectDate.inheritAttrs, inject = GenPagesRegisteSelectDate.inject, props = GenPagesRegisteSelectDate.props, propsNeedCastKeys = GenPagesRegisteSelectDate.propsNeedCastKeys, emits = GenPagesRegisteSelectDate.emits, components = GenPagesRegisteSelectDate.components, styles = GenPagesRegisteSelectDate.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesRegisteSelectDate.setup(props as GenPagesRegisteSelectDate)
    }
    )
}
, fun(instance, renderer): GenPagesRegisteSelectDate {
    return GenPagesRegisteSelectDate(instance, renderer)
}
)
val GenPagesRegisteSelectDepartmentClass = CreateVueComponent(GenPagesRegisteSelectDepartment::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesRegisteSelectDepartment.inheritAttrs, inject = GenPagesRegisteSelectDepartment.inject, props = GenPagesRegisteSelectDepartment.props, propsNeedCastKeys = GenPagesRegisteSelectDepartment.propsNeedCastKeys, emits = GenPagesRegisteSelectDepartment.emits, components = GenPagesRegisteSelectDepartment.components, styles = GenPagesRegisteSelectDepartment.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesRegisteSelectDepartment.setup(props as GenPagesRegisteSelectDepartment)
    }
    )
}
, fun(instance, renderer): GenPagesRegisteSelectDepartment {
    return GenPagesRegisteSelectDepartment(instance, renderer)
}
)
val GenPagesRegisteSelectDoctorClass = CreateVueComponent(GenPagesRegisteSelectDoctor::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesRegisteSelectDoctor.inheritAttrs, inject = GenPagesRegisteSelectDoctor.inject, props = GenPagesRegisteSelectDoctor.props, propsNeedCastKeys = GenPagesRegisteSelectDoctor.propsNeedCastKeys, emits = GenPagesRegisteSelectDoctor.emits, components = GenPagesRegisteSelectDoctor.components, styles = GenPagesRegisteSelectDoctor.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesRegisteSelectDoctor.setup(props as GenPagesRegisteSelectDoctor)
    }
    )
}
, fun(instance, renderer): GenPagesRegisteSelectDoctor {
    return GenPagesRegisteSelectDoctor(instance, renderer)
}
)
val GenPagesRegisteSelectDayTimeClass = CreateVueComponent(GenPagesRegisteSelectDayTime::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesRegisteSelectDayTime.inheritAttrs, inject = GenPagesRegisteSelectDayTime.inject, props = GenPagesRegisteSelectDayTime.props, propsNeedCastKeys = GenPagesRegisteSelectDayTime.propsNeedCastKeys, emits = GenPagesRegisteSelectDayTime.emits, components = GenPagesRegisteSelectDayTime.components, styles = GenPagesRegisteSelectDayTime.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesRegisteSelectDayTime.setup(props as GenPagesRegisteSelectDayTime)
    }
    )
}
, fun(instance, renderer): GenPagesRegisteSelectDayTime {
    return GenPagesRegisteSelectDayTime(instance, renderer)
}
)
val GenPagesRegisteSelectDoctorTimeClass = CreateVueComponent(GenPagesRegisteSelectDoctorTime::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesRegisteSelectDoctorTime.inheritAttrs, inject = GenPagesRegisteSelectDoctorTime.inject, props = GenPagesRegisteSelectDoctorTime.props, propsNeedCastKeys = GenPagesRegisteSelectDoctorTime.propsNeedCastKeys, emits = GenPagesRegisteSelectDoctorTime.emits, components = GenPagesRegisteSelectDoctorTime.components, styles = GenPagesRegisteSelectDoctorTime.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesRegisteSelectDoctorTime.setup(props as GenPagesRegisteSelectDoctorTime)
    }
    )
}
, fun(instance, renderer): GenPagesRegisteSelectDoctorTime {
    return GenPagesRegisteSelectDoctorTime(instance, renderer)
}
)
val default__19 = "/static/register/0.png"
val default__20 = "/static/register/1.png"
val default__21 = "/static/register/2.png"
val GenPagesRegisteSelectSettlementTypeClass = CreateVueComponent(GenPagesRegisteSelectSettlementType::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesRegisteSelectSettlementType.inheritAttrs, inject = GenPagesRegisteSelectSettlementType.inject, props = GenPagesRegisteSelectSettlementType.props, propsNeedCastKeys = GenPagesRegisteSelectSettlementType.propsNeedCastKeys, emits = GenPagesRegisteSelectSettlementType.emits, components = GenPagesRegisteSelectSettlementType.components, styles = GenPagesRegisteSelectSettlementType.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesRegisteSelectSettlementType.setup(props as GenPagesRegisteSelectSettlementType)
    }
    )
}
, fun(instance, renderer): GenPagesRegisteSelectSettlementType {
    return GenPagesRegisteSelectSettlementType(instance, renderer)
}
)
val default__22 = "/static/register/confirm-register-bg.png"
val default__23 = "/static/register/bell-icon.png"
val default__24 = "/static/register/medicine-chest-icon.png"
val GenPagesRegisteConfirmRegisteClass = CreateVueComponent(GenPagesRegisteConfirmRegiste::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesRegisteConfirmRegiste.inheritAttrs, inject = GenPagesRegisteConfirmRegiste.inject, props = GenPagesRegisteConfirmRegiste.props, propsNeedCastKeys = GenPagesRegisteConfirmRegiste.propsNeedCastKeys, emits = GenPagesRegisteConfirmRegiste.emits, components = GenPagesRegisteConfirmRegiste.components, styles = GenPagesRegisteConfirmRegiste.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesRegisteConfirmRegiste.setup(props as GenPagesRegisteConfirmRegiste)
    }
    )
}
, fun(instance, renderer): GenPagesRegisteConfirmRegiste {
    return GenPagesRegisteConfirmRegiste(instance, renderer)
}
)
val default__25 = "/static/register/amount-icon.png"
val GenPagesOutpatientPaymentPendingPaymentClass = CreateVueComponent(GenPagesOutpatientPaymentPendingPayment::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesOutpatientPaymentPendingPayment.inheritAttrs, inject = GenPagesOutpatientPaymentPendingPayment.inject, props = GenPagesOutpatientPaymentPendingPayment.props, propsNeedCastKeys = GenPagesOutpatientPaymentPendingPayment.propsNeedCastKeys, emits = GenPagesOutpatientPaymentPendingPayment.emits, components = GenPagesOutpatientPaymentPendingPayment.components, styles = GenPagesOutpatientPaymentPendingPayment.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesOutpatientPaymentPendingPayment.setup(props as GenPagesOutpatientPaymentPendingPayment)
    }
    )
}
, fun(instance, renderer): GenPagesOutpatientPaymentPendingPayment {
    return GenPagesOutpatientPaymentPendingPayment(instance, renderer)
}
)
val GenPagesOutpatientPaymentDetailsClass = CreateVueComponent(GenPagesOutpatientPaymentDetails::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesOutpatientPaymentDetails.inheritAttrs, inject = GenPagesOutpatientPaymentDetails.inject, props = GenPagesOutpatientPaymentDetails.props, propsNeedCastKeys = GenPagesOutpatientPaymentDetails.propsNeedCastKeys, emits = GenPagesOutpatientPaymentDetails.emits, components = GenPagesOutpatientPaymentDetails.components, styles = GenPagesOutpatientPaymentDetails.styles)
}
, fun(instance, renderer): GenPagesOutpatientPaymentDetails {
    return GenPagesOutpatientPaymentDetails(instance, renderer)
}
)
val GenPagesOutpatientPaymentConfirmPaymentClass = CreateVueComponent(GenPagesOutpatientPaymentConfirmPayment::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesOutpatientPaymentConfirmPayment.inheritAttrs, inject = GenPagesOutpatientPaymentConfirmPayment.inject, props = GenPagesOutpatientPaymentConfirmPayment.props, propsNeedCastKeys = GenPagesOutpatientPaymentConfirmPayment.propsNeedCastKeys, emits = GenPagesOutpatientPaymentConfirmPayment.emits, components = GenPagesOutpatientPaymentConfirmPayment.components, styles = GenPagesOutpatientPaymentConfirmPayment.styles)
}
, fun(instance, renderer): GenPagesOutpatientPaymentConfirmPayment {
    return GenPagesOutpatientPaymentConfirmPayment(instance, renderer)
}
)
val GenUniModulesXQrcodeComponentsXQrcodeXQrcodeClass = CreateVueComponent(GenUniModulesXQrcodeComponentsXQrcodeXQrcode::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = "", inheritAttrs = GenUniModulesXQrcodeComponentsXQrcodeXQrcode.inheritAttrs, inject = GenUniModulesXQrcodeComponentsXQrcodeXQrcode.inject, props = GenUniModulesXQrcodeComponentsXQrcodeXQrcode.props, propsNeedCastKeys = GenUniModulesXQrcodeComponentsXQrcodeXQrcode.propsNeedCastKeys, emits = GenUniModulesXQrcodeComponentsXQrcodeXQrcode.emits, components = GenUniModulesXQrcodeComponentsXQrcodeXQrcode.components, styles = GenUniModulesXQrcodeComponentsXQrcodeXQrcode.styles)
}
, fun(instance, renderer): GenUniModulesXQrcodeComponentsXQrcodeXQrcode {
    return GenUniModulesXQrcodeComponentsXQrcodeXQrcode(instance)
}
)
val GenPagesConfigIndexClass = CreateVueComponent(GenPagesConfigIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesConfigIndex.inheritAttrs, inject = GenPagesConfigIndex.inject, props = GenPagesConfigIndex.props, propsNeedCastKeys = GenPagesConfigIndex.propsNeedCastKeys, emits = GenPagesConfigIndex.emits, components = GenPagesConfigIndex.components, styles = GenPagesConfigIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesConfigIndex.setup(props as GenPagesConfigIndex)
    }
    )
}
, fun(instance, renderer): GenPagesConfigIndex {
    return GenPagesConfigIndex(instance, renderer)
}
)
fun createApp(): UTSJSONObject {
    val app = createSSRApp(GenAppClass)
    app.component("navigationBar", GenComponentsNavigationBarClass)
    app.component("commonBgImg", GenComponentsCommonBgImgClass)
    app.component("backPageBtn", GenComponentsBackPageBtnClass)
    app.component("leftAndRightLayout", GenComponentsLeftAndRightLayoutClass)
    return _uO("app" to app)
}
fun main(app: IApp) {
    definePageRoutes()
    defineAppConfig()
    (createApp()["app"] as VueApp).mount(app, GenUniApp())
}
open class UniAppConfig : io.dcloud.uniapp.appframe.AppConfig {
    override var name: String = "方鼎医疗平板终端"
    override var appid: String = "__UNI__02D379B"
    override var versionName: String = "1.0.4"
    override var versionCode: String = "105"
    override var uniCompilerVersion: String = "5.07"
    constructor() : super() {}
}
fun definePageRoutes() {
    __uniRoutes.push(UniPageRoute(path = "pages/index/index", component = GenPagesIndexIndexClass, meta = UniPageMeta(isQuit = true), style = _uM("navigationBarTitleText" to "uni-app x")))
    __uniRoutes.push(UniPageRoute(path = "pages/auth/selectAuth", component = GenPagesAuthSelectAuthClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/auth/inputAuth", component = GenPagesAuthInputAuthClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/emergentRegister/selectDoctor", component = GenPagesEmergentRegisterSelectDoctorClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/emergentRegister/result", component = GenPagesEmergentRegisterResultClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/registe/selectDate", component = GenPagesRegisteSelectDateClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/registe/selectDepartment", component = GenPagesRegisteSelectDepartmentClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/registe/selectDoctor", component = GenPagesRegisteSelectDoctorClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/registe/selectDayTime", component = GenPagesRegisteSelectDayTimeClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/registe/selectDoctorTime", component = GenPagesRegisteSelectDoctorTimeClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/registe/selectSettlementType", component = GenPagesRegisteSelectSettlementTypeClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/registe/confirmRegiste", component = GenPagesRegisteConfirmRegisteClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/outpatientPayment/pendingPayment", component = GenPagesOutpatientPaymentPendingPaymentClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/outpatientPayment/details", component = GenPagesOutpatientPaymentDetailsClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/outpatientPayment/confirmPayment", component = GenPagesOutpatientPaymentConfirmPaymentClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
    __uniRoutes.push(UniPageRoute(path = "pages/config/index", component = GenPagesConfigIndexClass, meta = UniPageMeta(isQuit = false), style = _uM("navigationBarTitleText" to "")))
}
val __uniLaunchPage: Map<String, Any?> = _uM("url" to "pages/index/index", "style" to _uM("navigationBarTitleText" to "uni-app x"))
fun defineAppConfig() {
    __uniConfig.entryPagePath = "/pages/index/index"
    __uniConfig.globalStyle = _uM("navigationBarTextStyle" to "black", "navigationBarTitleText" to "uni-app x", "navigationBarBackgroundColor" to "#F8F8F8", "backgroundColor" to "#F8F8F8", "pageOrientation" to "auto", "navigationStyle" to "custom")
    __uniConfig.getTabBarConfig = fun(): Map<String, Any>? {
        return null
    }
    __uniConfig.tabBar = __uniConfig.getTabBarConfig()
    __uniConfig.conditionUrl = ""
    __uniConfig.uniIdRouter = _uM()
    __uniConfig.ready = true
}
open class GenUniApp : UniAppImpl() {
    open val vm: GenApp?
        get() {
            return getAppVm() as GenApp?
        }
    open val `$vm`: GenApp?
        get() {
            return getAppVm() as GenApp?
        }
}
fun getApp(): GenUniApp {
    return getUniApp() as GenUniApp
}
