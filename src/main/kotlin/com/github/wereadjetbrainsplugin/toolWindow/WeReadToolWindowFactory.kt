package com.github.wereadjetbrainsplugin.toolWindow

import com.github.wereadjetbrainsplugin.MyBundle
import com.intellij.ide.BrowserUtil
import com.intellij.openapi.diagnostic.thisLogger
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import com.intellij.ui.content.ContentFactory
import com.intellij.ui.jcef.JBCefApp
import com.intellij.ui.jcef.JBCefBrowser
import com.intellij.util.ui.JBUI
import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.BoxLayout
import javax.swing.JButton

/**
 * 微信读书工具窗口工厂类
 * 负责创建和初始化微信读书工具窗口
 */
class WeReadToolWindowFactory : ToolWindowFactory {

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val weReadToolWindow = WeReadToolWindow()
        val content = ContentFactory.getInstance().createContent(weReadToolWindow.getContent(), "", false)
        toolWindow.contentManager.addContent(content)
    }

    override fun shouldBeAvailable(project: Project) = true

    /**
     * 微信读书工具窗口内容类
     */
    class WeReadToolWindow {
        fun getContent() = JBPanel<JBPanel<*>>().apply {
            layout = BorderLayout()
            
            // 记录 JCEF 支持状态
            val isJcefSupported = JBCefApp.isSupported()
            thisLogger().info("JCEF supported: $isJcefSupported")
            
            if (isJcefSupported) {
                try {
                    // 创建 JCEF 浏览器实例
                    val jbcef = JBCefBrowser()
                    jbcef.component.preferredSize = Dimension(900, 900)
                    add(jbcef.component, BorderLayout.CENTER)
                    
                    // 加载微信读书网页版
                    jbcef.loadURL("https://weread.qq.com/")
                    thisLogger().info("WeRead loaded successfully")
                } catch (e: Exception) {
                    thisLogger().error("Failed to create JCEF browser", e)
                    add(createErrorPanel(e.message ?: "Unknown error"), BorderLayout.CENTER)
                }
            } else {
                // 如果不支持 JCEF，显示详细的错误信息和解决方案
                add(createJcefNotSupportedPanel(), BorderLayout.CENTER)
            }
        }
        
        /**
         * 创建 JCEF 不支持时的提示面板
         */
        private fun createJcefNotSupportedPanel() = JBPanel<JBPanel<*>>().apply {
            layout = BoxLayout(this, BoxLayout.Y_AXIS)
            border = JBUI.Borders.empty(20)
            
            // 错误标题
            add(JBLabel("<html><h2>⚠️ JCEF 不可用</h2></html>").apply {
                alignmentX = 0.5f
            })
            
            add(javax.swing.Box.createVerticalStrut(10))
            
            // 错误说明
            add(JBLabel("<html><p>当前 IDE 环境不支持 JCEF（Java Chromium Embedded Framework）。</p></html>").apply {
                alignmentX = 0.5f
            })
            
            add(javax.swing.Box.createVerticalStrut(20))
            
            // 解决方案
            add(JBLabel("<html><h3>解决方案：</h3></html>").apply {
                alignmentX = 0.5f
            })
            
            add(javax.swing.Box.createVerticalStrut(10))
            
            add(JBLabel("<html><p>1. 确保使用的是 JetBrains Runtime (JBR) 而不是普通 JDK</p></html>").apply {
                alignmentX = 0.5f
            })
            
            add(JBLabel("<html><p>2. 在 Android Studio 中启用 JCEF：</p></html>").apply {
                alignmentX = 0.5f
            })
            
            add(JBLabel("<html><p>&nbsp;&nbsp;&nbsp;Help → Find Action → 搜索 \"Choose Boot Java Runtime\"</p></html>").apply {
                alignmentX = 0.5f
            })
            
            add(JBLabel("<html><p>&nbsp;&nbsp;&nbsp;选择带有 JCEF 的 JBR 版本</p></html>").apply {
                alignmentX = 0.5f
            })
            
            add(javax.swing.Box.createVerticalStrut(10))
            
            add(JBLabel("<html><p>3. 或者在浏览器中打开微信读书：</p></html>").apply {
                alignmentX = 0.5f
            })
            
            add(javax.swing.Box.createVerticalStrut(10))
            
            // 在浏览器中打开按钮
            add(JButton("在浏览器中打开微信读书").apply {
                alignmentX = 0.5f
                addActionListener {
                    BrowserUtil.browse("https://weread.qq.com/")
                }
            })
            
            add(javax.swing.Box.createVerticalStrut(20))
            
            // 技术信息
            add(JBLabel("<html><p style='color:gray;font-size:10px;'>技术信息：JBCefApp.isSupported() = false</p></html>").apply {
                alignmentX = 0.5f
            })
        }
        
        /**
         * 创建错误信息面板
         */
        private fun createErrorPanel(errorMessage: String) = JBPanel<JBPanel<*>>().apply {
            layout = BoxLayout(this, BoxLayout.Y_AXIS)
            border = JBUI.Borders.empty(20)
            
            add(JBLabel("<html><h2>❌ 加载失败</h2></html>").apply {
                alignmentX = 0.5f
            })
            
            add(javax.swing.Box.createVerticalStrut(10))
            
            add(JBLabel("<html><p>错误信息：$errorMessage</p></html>").apply {
                alignmentX = 0.5f
            })
            
            add(javax.swing.Box.createVerticalStrut(20))
            
            add(JButton("在浏览器中打开").apply {
                alignmentX = 0.5f
                addActionListener {
                    BrowserUtil.browse("https://weread.qq.com/")
                }
            })
        }
    }
}
