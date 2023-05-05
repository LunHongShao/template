package other.mvvm.activity.src.app_package


fun mvvmRepository(
        packageName:String,
        activityClass:String
)="""
package ${packageName}

import androidx.lifecycle.MutableLiveData
import com.shide.baselib.base.basemvvm.BaseRepository
import com.shide.baselib.base.basemvvm.BaseViewModel
import com.shide.baselib.net.exception.ShideApiException
import kotlinx.coroutines.CoroutineScope

class ${activityClass}Repository(
    baseViewModel: BaseViewModel,
    coroutineScope: CoroutineScope,
    errorLiveData: MutableLiveData<ShideApiException>
) : BaseRepository(baseViewModel, coroutineScope, errorLiveData) {
}
"""