package other.mvvm.activity

import com.android.tools.idea.wizard.template.ModuleTemplateData
import com.android.tools.idea.wizard.template.RecipeExecutor
import com.android.tools.idea.wizard.template.impl.activities.common.generateManifest
import kotlinx.coroutines.flow.merge
import org.jetbrains.kotlin.cli.common.arguments.mergeBeans
import other.mvvm.activity.res.layout.mvvmActivityXml
import other.mvvm.activity.src.app_package.mvvmRepository
import other.mvvm.activity.src.app_package.mvvmViewModel
import other.mvvm.activity.src.app_package.niceAcitivityKt


fun RecipeExecutor.mvvmActivityRecipe(
        moduleData: ModuleTemplateData,
        activityClass: String,
        layoutName: String,
        packageName: String
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
    generateManifest(moduleData = moduleData, activityClass = "${activityClass}Activity", packageName = "${packageName.replace("/", ".")}",
            isLauncher = false, hasNoActionBar = false, generateActivityTitle = false)
    val niceActivity = niceAcitivityKt(projectData.applicationPackage, activityClass, packageName)
    // 保存Activity
    save(niceActivity, srcOut.resolve("${activityClass}Activity.${ktOrJavaExt}"))
    // 保存xml
    save(mvvmActivityXml(packageName, activityClass), resOut.resolve("layout/${layoutName}.xml"))
    // 保存viewmodel
//    save(mvvmViewModel(packageName, activityClass), srcOut.resolve("${activityClass}ViewModel.${ktOrJavaExt}"))
    // 保存repository
//    save(mvvmRepository(packageName, activityClass), srcOut.resolve("${activityClass}Repository.${ktOrJavaExt}"))
}