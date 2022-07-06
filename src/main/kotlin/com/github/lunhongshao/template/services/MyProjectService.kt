package com.github.lunhongshao.template.services

import com.intellij.openapi.project.Project
import com.github.lunhongshao.template.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
