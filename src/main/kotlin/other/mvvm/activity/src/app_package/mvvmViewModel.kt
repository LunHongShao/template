package other.mvvm.activity.src.app_package
fun mvvmViewModel(
        packageName:String,
        activityClass:String
)="""
package ${packageName}
import androidx.lifecycle.viewModelScope
import com.bigademo.baselib.base.basemvvm.BaseViewModel
class ${activityClass}ViewModel : BaseViewModel() {
    private val repo by lazy { ${activityClass}Repository(this, viewModelScope, errorLiveData) }
}    
"""