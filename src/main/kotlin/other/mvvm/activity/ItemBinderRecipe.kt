package other.mvvm.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import other.mvvm.activity.res.layout.itemBinderXml
import other.mvvm.activity.res.layout.mvvmActivityXml
import other.mvvm.itemBinder.itemBinderAnyKt
import other.mvvm.itemBinder.itemBinderBeanKt
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
    beanClassName: String,
    needCreateBean: Boolean,
    createBeanName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
    val itemBinder = if (needCreateBean) {
        itemBinderKt(
            projectData.applicationPackage,
            className,
            packageName,
            beanClassName = "${createBeanName}Resp",
        )
    } else if (beanClassName == "Any") {
        itemBinderAnyKt(
            projectData.applicationPackage,
            className,
            packageName,
            beanClassName = beanClassName,
        )
    } else {
        itemBinderKt(
            projectData.applicationPackage,
            className,
            packageName,
            beanClassName = beanClassName,
        )
    }
    if (needCreateBean) {
        save(
            itemBinderBeanKt(
                projectData.applicationPackage,
                className,
                packageName,
                beanClassName,
                createBeanName
            ),
            moduleData.rootDir.resolve("src/main/java/com/youloft/daziplan/beans/resp/${createBeanName}Resp.${ktOrJavaExt}")
        )
    }
    // 保存
    save(itemBinder, srcOut.resolve("${className}ItemBinder.${ktOrJavaExt}"))
    // 保存xml
    save(itemBinderXml(), resOut.resolve("layout/${layoutName}.xml"))
}