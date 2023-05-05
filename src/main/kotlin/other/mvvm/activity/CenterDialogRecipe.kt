package other.mvvm.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.mvvm.activity.res.layout.dialogXml
import other.mvvm.activity.res.layout.itemBinderXml
import other.mvvm.activity.res.layout.mvvmActivityXml
import other.mvvm.dialog.centerDialogKt
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

fun RecipeExecutor.centerDialogRecipe(
    moduleData: ModuleTemplateData,
    className: String,
    layoutName: String,
    packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
    val dialog = centerDialogKt(
        projectData.applicationPackage,
        className,
        packageName
    )
    // 保存Activity
    save(dialog, srcOut.resolve("${className}Dialog.${ktOrJavaExt}"))
    // 保存xml
    save(dialogXml(), resOut.resolve("layout/${layoutName}.xml"))
}