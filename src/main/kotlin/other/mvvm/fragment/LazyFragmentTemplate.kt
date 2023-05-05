package other.mvvm.fragment

import android.databinding.tool.ext.toCamelCase
import com.android.tools.idea.wizard.template.*
import other.mvvm.activity.defaultPackageNameParameter
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API
import other.mvvm.activity.lazyFragmentRecipe
import java.io.File


val lazyFragmentTemplate
    get() = template {
//        revision = 1
        name = "LazyFragment"
        description = "适用于Nice框架的Fragment"
        minApi = MIN_API
//        minBuildApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery,WizardUiContext.FragmentGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        lateinit var layoutName: StringParameter

        val activityClass = stringParameter {
            name = "Fragment Name"
            default = "Main"
            help = "只输入名字，不要包含Fragment"
            constraints = listOf(Constraint.NONEMPTY)
        }

        layoutName = stringParameter {
            name = "Layout Name"
            default = "fragment_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.LAYOUT, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "${fragmentToLayout(activityClass.value.toCamelCase())}" }
        }

        val packageName = defaultPackageNameParameter

        widgets(
                TextFieldWidget(activityClass),
                TextFieldWidget(layoutName),
                PackageNameWidget(packageName)
        )
        thumb { File("logo.png") }
        recipe = { data: TemplateData ->
            lazyFragmentRecipe(
                    data as ModuleTemplateData,
                    activityClass.value,
                    layoutName.value,
                    packageName.value)
        }
    }


