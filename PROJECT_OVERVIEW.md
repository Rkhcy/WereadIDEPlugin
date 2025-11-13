# WeRead JetBrains Plugin - 项目概览

## 项目简介

这是一个支持在 Android Studio 和其他 JetBrains IDE 中打开微信读书的插件。用户可以在不离开开发环境的情况下享受阅读体验。

## 已完成的工作

### ✅ 1. 项目配置文件

- **build.gradle.kts**: 完整的 Gradle 构建配置，包含 IntelliJ Platform 插件开发所需的所有依赖
- **settings.gradle.kts**: Gradle 项目设置
- **gradle.properties**: 插件元数据配置（版本、支持的 IDE 版本等）
- **gradle/libs.versions.toml**: 依赖版本管理

### ✅ 2. 插件核心文件

#### 配置文件
- **src/main/resources/META-INF/plugin.xml**: 插件配置文件
  - 定义插件 ID、名称、供应商信息
  - 注册工具窗口扩展点
  - 注册应用程序监听器

#### Kotlin 源代码
- **MyBundle.kt**: 国际化资源管理类
  - 提供多语言支持
  - 管理资源文件访问

- **WeReadToolWindowFactory.kt**: 工具窗口工厂类
  - 创建和初始化工具窗口
  - 使用 JCEF 嵌入 Chromium 浏览器
  - 加载微信读书网页版

- **WeReadApplicationActivationListener.kt**: 应用程序激活监听器
  - 监听 IDE 窗口激活/失活事件
  - 提供日志记录

### ✅ 3. 资源文件

#### 国际化资源
- **messages/MyBundle.properties**: 英文资源
- **messages/MyBundle_zh_CN.properties**: 中文资源

#### 图标
- **icons/toolWindowIcon.svg**: 工具窗口图标（绿色书本图标）

### ✅ 4. 文档

- **README.md**: 项目说明文档
  - 功能介绍
  - 安装方法
  - 使用说明
  - 开发指南

- **CHANGELOG.md**: 版本更新日志
- **USAGE.md**: 详细使用指南
- **PROJECT_OVERVIEW.md**: 项目概览（本文件）

### ✅ 5. 其他配置

- **.gitignore**: Git 忽略文件配置，适配 JetBrains 插件项目

## 项目结构

```
WereadJetbrainsPlugin/
├── gradle/                                    # Gradle 配置
│   └── libs.versions.toml                    # 依赖版本管理
├── src/
│   └── main/
│       ├── kotlin/                           # Kotlin 源代码
│       │   └── com/github/wereadjetbrainsplugin/
│       │       ├── MyBundle.kt               # 国际化资源管理
│       │       ├── toolWindow/
│       │       │   └── WeReadToolWindowFactory.kt  # 工具窗口
│       │       └── listeners/
│       │           └── WeReadApplicationActivationListener.kt
│       └── resources/                        # 资源文件
│           ├── META-INF/
│           │   └── plugin.xml               # 插件配置
│           ├── icons/
│           │   └── toolWindowIcon.svg       # 图标
│           └── messages/                    # 国际化文本
│               ├── MyBundle.properties
│               └── MyBundle_zh_CN.properties
├── build.gradle.kts                         # Gradle 构建脚本
├── gradle.properties                        # Gradle 属性
├── settings.gradle.kts                      # Gradle 设置
├── README.md                                # 项目说明
├── CHANGELOG.md                             # 更新日志
├── USAGE.md                                 # 使用指南
└── .gitignore                               # Git 忽略配置
```

## 核心功能实现

### 1. 工具窗口集成

插件在 IDE 右侧创建一个工具窗口，通过 `plugin.xml` 注册：

```xml
<extensions defaultExtensionNs="com.intellij">
    <toolWindow factoryClass="com.github.wereadjetbrainsplugin.toolWindow.WeReadToolWindowFactory" 
                icon="/icons/toolWindowIcon.svg" 
                id="WeRead"
                anchor="right"/>
</extensions>
```

### 2. JCEF 浏览器嵌入

使用 JetBrains 提供的 JCEF（Java Chromium Embedded Framework）在工具窗口中嵌入浏览器：

```kotlin
if (JBCefApp.isSupported()) {
    val jbcef = JBCefBrowser()
    jbcef.loadURL("https://weread.qq.com/")
    add(jbcef.component, BorderLayout.CENTER)
}
```

### 3. 多语言支持

通过 `MyBundle` 类和资源文件实现中英文支持：

- 英文：`MyBundle.properties`
- 中文：`MyBundle_zh_CN.properties`

### 4. 应用程序生命周期监听

通过 `WeReadApplicationActivationListener` 监听 IDE 窗口的激活和失活事件。

## 技术栈

- **开发语言**: Kotlin 1.9.21
- **构建工具**: Gradle 8.5
- **框架**: IntelliJ Platform SDK
- **浏览器引擎**: JCEF (Chromium)
- **最低 JDK 版本**: Java 17

## 支持的 IDE 版本

- **最低版本**: 2022.3 (Build 223)
- **最高版本**: 2024.2 (Build 242.*)
- **开发平台**: IntelliJ IDEA Community Edition 2022.3

## 支持的 IDE

- Android Studio
- IntelliJ IDEA (Community & Ultimate)
- PyCharm (Community & Professional)
- WebStorm
- PhpStorm
- GoLand
- RubyMine
- CLion
- DataGrip
- Rider
- AppCode

## 下一步工作

### 可选的增强功能

1. **添加快捷键支持**
   - 定义全局快捷键快速打开/关闭工具窗口
   - 添加阅读相关的快捷键

2. **添加设置页面**
   - 允许用户自定义窗口大小
   - 配置默认打开的书籍或书架

3. **添加书签功能**
   - 保存当前阅读位置
   - 快速跳转到书签位置

4. **添加夜间模式**
   - 自动跟随 IDE 主题
   - 独立的夜间模式开关

5. **性能优化**
   - 延迟加载浏览器
   - 内存使用优化

6. **添加单元测试**
   - 测试工具窗口创建
   - 测试国际化资源加载

## 如何使用

### 构建插件

```bash
./gradlew buildPlugin
```

插件将被打包到 `build/distributions/WereadJetbrainsPlugin-1.0.0.zip`

### 测试插件

```bash
./gradlew runIde
```

这将启动一个新的 IDE 实例，插件已预装其中。

### 安装插件

1. 在 IDE 中打开 `Settings/Preferences` → `Plugins`
2. 点击 `⚙️` → `Install Plugin from Disk...`
3. 选择构建好的 zip 文件
4. 重启 IDE

## 参考资料

- [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template)
- [IntelliJ Platform SDK 文档](https://plugins.jetbrains.com/docs/intellij/welcome.html)
- [参考项目: cirry/Weread-Jetbrains-Plugin](https://github.com/cirry/Weread-Jetbrains-Plugin)

## 许可证

MIT License

## 作者

基于 [cirry/Weread-Jetbrains-Plugin](https://github.com/cirry/Weread-Jetbrains-Plugin) 创建
