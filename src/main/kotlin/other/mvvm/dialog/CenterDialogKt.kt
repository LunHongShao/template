package other.mvvm.dialog

/**
 *
 * @Description:
 * @Author:         slh
 * @CreateDate:     2023/3/14 23:47
 * @UpdateUser:     更新者：
 * @UpdateDate:     2023/3/14 23:47
 * @UpdateRemark:   更新说明：
 * @Version:        2.6.0
 */
fun centerDialogKt(
    applicationPackage: String?,
    className: String,
    packageName: String
) = """
package ${packageName}

import android.os.Bundle
import com.hi.dhl.binding.viewbind
import ${applicationPackage}.databinding.Dialog${className}LayoutBinding
import me.simple.nicedialog.NiceFullScreenDialog
import ${applicationPackage}.R
import me.simple.nm.NiceActivity
import me.simple.ktx.singleClick


class ${className}Dialog(val ctx: NiceActivity<*>) : NiceFullScreenDialog(ctx) {
private val binding: Dialog${className}LayoutBinding by viewbind()
   override fun onCreateAfter(savedInstanceState: Bundle?) {
        binding.apply {
            rootLayout.singleClick { dismiss() }
            contentLayout.singleClick { }
            
        }
    }
     override fun setLayoutRes(): Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        onCreateBefore(savedInstanceState)
        setContentView(binding.root)

        onCreateAfter(savedInstanceState)
    }
    } 
    
"""