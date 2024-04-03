package other.mvvm.itemBinder

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
fun itemBinderKt(
    applicationPackage: String?,
    className: String,
    packageName: String,
    beanClassName:String,
    beanPackageName:String
)="""
package ${packageName}
import ${applicationPackage}.itemBinder.base.BindingItemBinder
import ${applicationPackage}.itemBinder.base.BindingViewHolder
import ${applicationPackage}.R
import ${applicationPackage}.databinding.Item${className}LayoutBinding
class ${className}ItemBinder : BindingItemBinder<${beanClassName},Item${className}LayoutBinding>() {
   override fun onBindViewHolder(
        holder: BindingViewHolder<Item${className}LayoutBinding>,
        item: $beanClassName
    ) {
    }
    } 
"""