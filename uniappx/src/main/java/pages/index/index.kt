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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo
open class GenPagesIndexIndex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesIndexIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesIndexIndex
            val _cache = __ins.renderCache
            onPageShow(fun(){
                initCommonState()
            }
            )
            val toConfig = fun(){
                console.log("去配置页")
                uni_navigateTo(NavigateToOptions(url = "/pages/config/index"))
            }
            val toPage = fun(item: Menu){
                toConfig()
            }
            val menuMain = Menu(icon = "../static/home/emergent-register.png", isAuth = true, pageUrl = "/pages/emergentRegister/selectDoctor", key = "emergentRegister", title = "急诊挂号", bgColor = "")
            val menuList = _uA(
                Menu(icon = "../static/home/outpatient-registe.png", isAuth = true, pageUrl = "/pages/registe/selectDate", key = "outpatientRegiste", title = "门诊挂号", bgColor = "linear-gradient(to bottom, #5DD7FF, #0ABEF4)"),
                Menu(icon = "../static/home/outpatient-payment.png", isAuth = true, pageUrl = "/pages/outpatientPayment/pendingPayment", key = "outpatientPayment", title = "门诊缴费", bgColor = "linear-gradient(to bottom, #89B9FF ,#4B95FA)"),
                Menu(icon = "../static/home/hospital-register.png", isAuth = true, pageUrl = "/pages/create/create", key = "hospitalRegister", title = "入院登记", bgColor = "linear-gradient(to bottom, #ACAAFF,#8986FF)"),
                Menu(icon = "../static/home/nucleic-acid.png", isAuth = true, pageUrl = "/pages/create/create", key = "nucleicAcid", title = "核酸开单", bgColor = "linear-gradient(to bottom, #59E7D8,#1EC5B4)"),
                Menu(icon = "../static/home/margin-call.png", isAuth = true, pageUrl = "/pages/create/create", key = "marginCall", title = "补交诊金", bgColor = "linear-gradient(to bottom, #5E9AFF,#8DB7FF)"),
                Menu(icon = "../static/home/yb-registration.png", isAuth = true, pageUrl = "/pages/create/create", key = "ybRegistration", title = "医保登记", bgColor = "linear-gradient(to bottom, #59E7D8,#1EC5B4)"),
                Menu(icon = "../static/home/offer-number.png", isAuth = true, pageUrl = "/pages/create/create", key = "offerNumber", title = "预约报道", bgColor = "linear-gradient(to bottom, #67BFFF,#3EAEFF)"),
                Menu(icon = "../static/home/return-number.png", isAuth = true, pageUrl = "/pages/create/create", key = "returnNumber", title = "自助退号", bgColor = "linear-gradient(to bottom, #ACAAFF,#8986FF)"),
                Menu(icon = "../static/home/care-worker-fees.png", isAuth = true, pageUrl = "/pages/create/create", key = "careWorkerFees", title = "护工收费", bgColor = "linear-gradient(to bottom, #5DD7FF,#0ABEF4)"),
                Menu(icon = "../static/home/margin-call.png", isAuth = true, pageUrl = "/pages/create/create", key = "hospitalizationDeposit", title = "住院押金", bgColor = "linear-gradient(to bottom, #5E9AFF,#8DB7FF)"),
                Menu(icon = "../static/home/tickertape-patchwork.png", isAuth = true, pageUrl = "/pages/create/create", key = "tickertapePatchwork", title = "凭条补打", bgColor = "linear-gradient(to bottom, #ACAAFF,#8986FF)"),
                Menu(icon = "../static/home/create.png", isAuth = true, pageUrl = "/pages/create/create", key = "create", title = "初诊建档", bgColor = "linear-gradient(to bottom, #5DD7FF,#0ABEF4)"),
                Menu(icon = "../static/home/hospitalization-list.png", isAuth = true, pageUrl = "/pages/create/create", key = "hospitalizationList", title = "住院清单", bgColor = "linear-gradient(to bottom, #67BFFF,#3EAEFF)"),
                Menu(icon = "../static/home/discharge-settlement.png", isAuth = true, pageUrl = "/pages/create/create", key = "dischargeSettlement", title = "出院结算", bgColor = "linear-gradient(to bottom, #59E7D8,#1EC5B4)")
            ) as UTSArray<Menu>
            return fun(): Any? {
                val _component_navigationBar = resolveComponent("navigationBar")
                return _cE("view", _uM("class" to "page-container"), _uA(
                    _cE("image", _uM("class" to "page-bg-img", "src" to default__8)),
                    _cV(_component_navigationBar),
                    _cE("view", _uM("class" to "menu-content"), _uA(
                        _cE("view", _uM("class" to "", "style" to _nS(_uM("flex-direction" to "row", "padding" to "20px 20px 0px 20px"))), _uA(
                            _cE("view", _uM("class" to "menu-main", "onClick" to fun(){
                                toPage(menuMain)
                            }
                            ), _uA(
                                _cE("image", _uM("class" to "icon-img", "src" to menuMain.icon), null, 8, _uA(
                                    "src"
                                )),
                                _cE("text", _uM("class" to "icon-text"), _tD(menuMain.title), 1)
                            ), 8, _uA(
                                "onClick"
                            )),
                            _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "flex-wrap" to "wrap", "align-items" to "center"))), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(menuList.slice(0, 6), fun(item, index, __index, _cached): Any {
                                    return _cE("view", _uM("class" to "menu-item", "onClick" to fun(){
                                        toPage(item)
                                    }
                                    , "key" to index, "style" to _nS(_uM("backgroundImage" to item.bgColor))), _uA(
                                        _cE("image", _uM("class" to "icon-img", "src" to item.icon), null, 8, _uA(
                                            "src"
                                        )),
                                        _cE("text", _uM("class" to "icon-text"), _tD(item.title), 1)
                                    ), 12, _uA(
                                        "onClick"
                                    ))
                                }
                                ), 128)
                            ), 4)
                        ), 4),
                        _cE("view", _uM("style" to _nS(_uM("flex-direction" to "row", "flex-wrap" to "wrap", "padding-left" to "20px"))), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(menuList.slice(6), fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("class" to "menu-item", "key" to index, "style" to _nS(_uM("backgroundImage" to item.bgColor))), _uA(
                                    _cE("image", _uM("class" to "icon-img", "src" to item.icon), null, 8, _uA(
                                        "src"
                                    )),
                                    _cE("text", _uM("class" to "icon-text"), _tD(item.title), 1)
                                ), 4)
                            }
                            ), 128)
                        ), 4)
                    )),
                    _cE("view", _uM("class" to "footer"), _uA(
                        _cE("image", _uM("mode" to "aspectFit", "class" to "img", "src" to default__9)),
                        _cE("image", _uM("onLongpress" to toConfig, "mode" to "aspectFit", "class" to "img", "src" to default__10), null, 32),
                        _cE("text", _uM("class" to "text"), "终端号：11111"),
                        _cE("text", _uM("class" to "text"), "版本号：11111")
                    ))
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("page-bg-img" to _pS(_uM("height" to 800, "width" to 1280, "position" to "absolute")), "footer" to _pS(_uM("display" to "flex", "flexDirection" to "row", "top" to 18, "justifyContent" to "center", "alignItems" to "center")), "img" to _uM(".footer " to _uM("width" to 200, "height" to 30)), "text" to _uM(".footer " to _uM("fontSize" to 18, "marginLeft" to 70)), "menu-content" to _pS(_uM("height" to "84%")), "menu-item" to _uM(".menu-content " to _uM("width" to 295, "height" to 135, "display" to "flex", "flexDirection" to "row", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "alignItems" to "center", "marginRight" to 18, "marginBottom" to 20)), "icon-img" to _uM(".menu-content .menu-item " to _uM("width" to 85, "height" to 85, "left" to 20), ".menu-content .menu-main " to _uM("width" to 110, "height" to 110, "top" to -15)), "icon-text" to _uM(".menu-content .menu-item " to _uM("color" to "#ffffff", "left" to 39, "fontSize" to 27, "top" to 5), ".menu-content .menu-main " to _uM("color" to "#ffffff", "top" to 10, "fontSize" to 30)), "menu-main" to _uM(".menu-content " to _uM("backgroundImage" to "linear-gradient(to bottom, #89B9FF, #4B95FA)", "width" to 295, "height" to 305, "display" to "flex", "justifyContent" to "center", "alignItems" to "center", "borderTopLeftRadius" to 10, "borderTopRightRadius" to 10, "borderBottomRightRadius" to 10, "borderBottomLeftRadius" to 10, "marginRight" to 15, "marginBottom" to 20)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
