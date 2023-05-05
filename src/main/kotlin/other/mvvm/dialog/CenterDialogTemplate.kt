package other.mvvm.itemBinder

import android.databinding.tool.ext.toCamelCase
import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import other.mvvm.activity.defaultPackageNameParameter
import other.mvvm.activity.itemBinderRecipe
import other.mvvm.activity.mvvmActivityRecipe

/**
 *
 * @Description:
 * @Author:         slh
 * @CreateDate:     2023/3/14 23:34
 * @UpdateUser:     更新者：
 * @UpdateDate:     2023/3/14 23:34
 * @UpdateRemark:   更新说明：
 * @Version:        2.6.0
 */
val itemBinderTemplate
    get() = template {
        name = "itemBinder"
        description = "适用于bindingItemBinder"
        minApi = MIN_API
//        minBuildApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(
            WizardUiContext.ActivityGallery,
            WizardUiContext.MenuEntry,
            WizardUiContext.NewProject,
            WizardUiContext.NewModule
        )

        lateinit var layoutName: StringParameter
        val itemBinderClass = stringParameter {
            name = "itemBinder Name"
            default = "Main"
            help = "只输入名字，不要包含ItemBinder"
            constraints = listOf(Constraint.NONEMPTY)
        }
        layoutName = stringParameter {
            name = "Layout Name"
            default = "item_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "item_${itemBinderClass.value.toCamelCase().toLowerCase()}_layout" }
        }
        val beanName = stringParameter {
            name = "bean name"
            default = "Any"
            help = "请输入实体类的名字"
            constraints = listOf(Constraint.CLASS, Constraint.UNIQUE, Constraint.NONEMPTY)
        }
        val packageName = defaultPackageNameParameter

        widgets(
            TextFieldWidget(itemBinderClass),
            TextFieldWidget(layoutName),
            TextFieldWidget(beanName),
            PackageNameWidget(packageName),
        )
        recipe = { data: TemplateData ->
            itemBinderRecipe(
                data as ModuleTemplateData,
                itemBinderClass.value,
                layoutName.value,
                packageName.value,
                beanPackageName = "com.youloft.schedule.beans.resp",
                beanClassName = beanName.value
            )
        }
    }
