package other.mvvm.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.mvvm.activity.res.layout.itemBinderXml
import other.mvvm.activity.res.layout.mvvmActivityXml
import other.mvvm.fragment.fragmentKt

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

fun RecipeExecutor.lazyFragmentRecipe(
    moduleData: ModuleTemplateData,
    className: String,
    layoutName: String,
    packageName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
    val fragment = fragmentKt(
        projectData.applicationPackage,
        className,
        packageName
    )
    // 保存Activity
    save(fragment, srcOut.resolve("${className}Fragment.${ktOrJavaExt}"))
    // 保存xml
    save(itemBinderXml(), resOut.resolve("layout/${layoutName}.xml"))
}