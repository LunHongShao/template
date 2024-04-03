package other.mvvm.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import other.mvvm.activity.res.layout.mvvmActivityXml
import other.mvvm.activity.src.app_package.mvvmViewModel
import other.mvvm.activity.src.app_package.niceAcitivityKt
import other.mvvm.activity.src.app_package.niceActivityViewModelKt


fun RecipeExecutor.mvvmActivityRecipe(
    moduleData: ModuleTemplateData,
    activityClass: String,
    layoutName: String,
    packageName: String,
    needViewModel: Boolean
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
//    generateManifest(
//            moduleData = moduleData,
//            activityClass = "${activityClass}Activity",
//            activityTitle = activityClass,
//            packageName = packageName,
//            isLauncher = false,
//            hasNoActionBar = false,
//            generateActivityTitle = true,
//            requireTheme = false,
//            useMaterial2 = false
//    )
//    generateManifest(moduleData = moduleData, activityClass = "${activityClass}Activity", packageName = "${packageName.replace("/", ".")}",
//            isLauncher = false, hasNoActionBar = false, generateActivityTitle = false)
    val niceActivity = if (needViewModel) {
        niceActivityViewModelKt(projectData.applicationPackage, activityClass, packageName)
    } else {
        niceAcitivityKt(projectData.applicationPackage, activityClass, packageName)
    }
    // 保存Activity
    save(niceActivity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
    // 保存xml
    save(mvvmActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
    if (needViewModel) {
        // 保存viewmodel
        save(
            mvvmViewModel(packageName, activityClass),
            srcOut.resolve("viewModel/${activityClass}ViewModel.${ktOrJavaExt}")
        )
    }

    // 保存repository
//    save(mvvmRepository(packageName, activityClass), srcOut.resolve("${activityClass}Repository.${ktOrJavaExt}"))
}