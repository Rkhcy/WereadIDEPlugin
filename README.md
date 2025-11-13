# WeRead JetBrains Plugin

![Build](https://github.com/yourusername/WereadJetbrainsPlugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

<!-- Plugin description -->
一个支持在 Android Studio 和其他 JetBrains IDE 中打开微信读书的插件。

**主要功能：**
- 在 IDE 工具窗口中直接访问微信读书网页版
- 支持完整的微信读书功能
- 可以使用方向键进行阅读导航
- 无需离开开发环境即可享受阅读

**使用建议：**
- 请在使用前将窗口调整到合适的大小以获得最佳阅读体验
- 支持所有 JetBrains IDE，包括 Android Studio、IntelliJ IDEA、PyCharm 等
<!-- Plugin description end -->

## 安装

### 使用 IDE 内置插件系统：

<kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>搜索 "WeRead"</kbd> >
<kbd>Install</kbd>

### 手动安装：

下载 [最新版本](https://github.com/yourusername/WereadJetbrainsPlugin/releases/latest) 并手动安装：

<kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

## 使用方法

1. 安装插件后，在 IDE 右侧工具栏会出现 "WeRead" 图标
2. 点击图标打开微信读书工具窗口
3. 在窗口中登录你的微信读书账号
4. 开始阅读！

### ⚠️ 如果看到 "JCEF is not supported" 错误

这说明你的 Android Studio 没有启用 JCEF 支持。请按以下步骤解决：

1. 按 `⌘⇧A` (macOS) 或 `Ctrl+Shift+A` (Windows/Linux)
2. 搜索 `Choose Boot Java Runtime for the IDE`
3. 选择一个包含 **JCEF** 的 Runtime 版本（如 `17.0.x-jcef-bxxx`）
4. 重启 Android Studio

详细解决方案请查看：[JCEF问题解决指南.md](JCEF问题解决指南.md)

## 系统要求

- IntelliJ Platform 版本：2022.3 (Build 223) 或更高
- 支持到 Android Studio AI-251 及更新版本
- 需要支持 JCEF（Java Chromium Embedded Framework）的平台

## 技术栈

- Kotlin
- IntelliJ Platform SDK
- JCEF (Java Chromium Embedded Framework)

## 开发

本插件基于 [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template) 开发。

### 构建插件

```bash
./gradlew buildPlugin
```

### 运行插件

```bash
./gradlew runIde
```

## 贡献

欢迎提交 Issue 和 Pull Request！

## 许可证

本项目采用 MIT 许可证。

## 致谢

- 参考项目：[cirry/Weread-Jetbrains-Plugin](https://github.com/cirry/Weread-Jetbrains-Plugin)
- [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template)

---

Plugin based on the [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template).
