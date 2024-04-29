package com.timmy.codelab.lint.checks.sunset

import com.android.tools.lint.client.api.UElementHandler
import com.android.tools.lint.detector.api.Category
import com.android.tools.lint.detector.api.Detector
import com.android.tools.lint.detector.api.Implementation
import com.android.tools.lint.detector.api.Issue.Companion.create
import com.android.tools.lint.detector.api.JavaContext
import com.android.tools.lint.detector.api.Scope
import com.android.tools.lint.detector.api.Severity
import org.jetbrains.uast.UAnnotation
import org.jetbrains.uast.UElement

internal class SunsetAnnotationDetector : Detector(), Detector.UastScanner {

    companion object {

        private val IMPLEMENTATION = Implementation(
            SunsetAnnotationDetector::class.java,
            Scope.JAVA_FILE_SCOPE,
        )

        @JvmField
        val ISSUE = create(
            id = "Sunset",
            briefDescription = "Sunset 簡介",
            explanation = "Sunset 解釋",
            category = Category.CUSTOM_LINT_CHECKS,
            priority = 5,
            severity = Severity.INFORMATIONAL,
            implementation = IMPLEMENTATION
        )
    }

    override fun getApplicableUastTypes(): List<Class<out UElement>> {
        return listOf(UAnnotation::class.java)
    }

    override fun createUastHandler(context: JavaContext): UElementHandler? {
        return object : UElementHandler() {
            override fun visitAnnotation(node: UAnnotation) {
//                super.visitAnnotation(node)
                println("A => ${Sunset::class.java.name}")
                val name = node.qualifiedName
                println("B => ${name}")
                if (Sunset::class.java.name.equals(name)) {
                    context.report(ISSUE, node, context.getLocation(node), "已被標記為 sunset");
                }
            }
        }
    }
}