package other.mvvm.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.mvvm.activity.res.layout.itemBinderXml
import other.mvvm.activity.res.layout.mvvmActivityXml
import other.mvvm.itemBinder.itemBinderKt

/**
 *
 * @Description:
 * @Author:         slh
 * @CreateDate:     2023/3/14 23:44
 * @UpdateUser:     更新者：
 * @UpdateDate:     2023/3/14 23:44
 * @UpdateRemark:   更新说明：
 * @Version:        2.6.0
 */

fun RecipeExecutor.itemBinderRecipe(
    moduleData: ModuleTemplateData,
    className: String,
    layoutName: String,
    packageName: String,
    beanPackageName: String,
    beanClassName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
    val itemBinder = itemBinderKt(
        projectData.applicationPackage,
        className,
        packageName,
        beanClassName = beanClassName,
        beanPackageName = beanPackageName
    )
    // 保存Activity
    save(itemBinder, srcOut.resolve("${className}ItemBinder.${ktOrJavaExt}"))
    // 保存xml
    save(itemBinderXml(), resOut.resolve("layout/${layoutName}.xml"))
}