package com.timmy.codelab.lint.checks

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.client.api.Vendor
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue
import com.timmy.codelab.lint.checks.sunset.SunsetAnnotationDetector

internal class CustomizationIssueRegistry : IssueRegistry() {

    override val vendor: Vendor = AOSP_VENDOR

    override val api: Int
        get() = CURRENT_API

    override val issues: List<Issue>
        get() = listOf(SunsetAnnotationDetector.ISSUE)
}