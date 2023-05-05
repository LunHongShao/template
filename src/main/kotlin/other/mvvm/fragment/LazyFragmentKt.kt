package other.mvvm.fragment

/**
 *
 * @Description:
 * @Author:         slh
 * @CreateDate:     2023/3/14 23:47
 * @UpdateUser:     更新者：
 * @UpdateDate:     2023/3/14 23:47
 * @UpdateRemark:   更新说明：
 * @Version:        2.6.0
 */
fun fragmentKt(
    applicationPackage: String?,
    className: String,
    packageName: String
)="""
package ${packageName}

import ${applicationPackage}.R
import me.simple.nm.LazyFragment
import ${applicationPackage}.databinding.Fragment${className}Binding
class ${className}Fragment : LazyFragment<Fragment${className}Binding>() {
      override fun init() {
    }

    override fun initView() {
    }

    override fun initData() {
    }

    override fun lazyLoad() {
    }
    }
"""