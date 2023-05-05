package other.mvvm.activity.src.app_package

fun niceAcitivityKt(
        applicationPackage:String?,
        activityClass:String,
        packageName:String
)="""
package ${packageName}
import me.simple.nm.NiceActivity
import android.content.Context
import android.content.Intent
import ${applicationPackage}.R
import ${applicationPackage}.databinding.Activity${activityClass}Binding
class ${activityClass}Activity : NiceActivity<Activity${activityClass}Binding>() {
     override fun initView() {
    }

    override fun initData() {
    }

    override fun initListener() {
    }
    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, ${activityClass}Activity::class.java)
            context.startActivity(starter)
        }
    }
    } 
"""