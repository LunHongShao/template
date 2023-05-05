package other

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import other.mvvm.activity.mvvmActivityTemplate
import other.mvvm.dialog.centerDialogTemplate
import other.mvvm.itemBinder.itemBinderTemplate
import other.mvvm.fragment.lazyFragmentTemplate

class SamplePluginTemplateProviderImpl : WizardTemplateProvider() {

    override fun getTemplates(): List<Template> = listOf(
        // activity的模板
        mvvmActivityTemplate,
        //itemBinder模板
        itemBinderTemplate,
        //centerDialog模板
        centerDialogTemplate,
        lazyFragmentTemplate
    )
}