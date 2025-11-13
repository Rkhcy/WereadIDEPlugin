package com.github.wereadjetbrainsplugin.listeners

import com.intellij.openapi.application.ApplicationActivationListener
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.wm.IdeFrame

/**
 * 应用程序激活监听器
 * 用于监听 IDE 窗口的激活和失活事件
 */
internal class WeReadApplicationActivationListener : ApplicationActivationListener {

    override fun applicationActivated(ideFrame: IdeFrame) {
        thisLogger().info("WeRead plugin: Application activated")
    }

    override fun applicationDeactivated(ideFrame: IdeFrame) {
        thisLogger().info("WeRead plugin: Application deactivated")
    }
}
