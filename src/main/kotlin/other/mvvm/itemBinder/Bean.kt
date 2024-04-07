package other.mvvm.itemBinder

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
/**
 *
 * @param applicationPackage 包名
 * @param className itembinder类名
 * @param packageName 鼠标位置包名
 * @param beanClassName 实体类名
 */
fun itemBinderBeanKt(
    applicationPackage: String?,
    className: String,
    packageName: String,
    beanClassName: String,
    createBeanName:String
) = """
package ${applicationPackage}.beans.resp

data class ${createBeanName}Resp()
"""
