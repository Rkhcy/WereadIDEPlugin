# WeRead JetBrains Plugin - 开发者指南

## 🛠️ 开发环境设置

### 前置要求

- **JDK**: Java 17 或更高版本
- **IDE**: IntelliJ IDEA (推荐使用 Community Edition 2022.3+)
- **Gradle**: 8.5+ (项目自带 Gradle Wrapper)
- **Git**: 用于版本控制

### 导入项目

1. 打开 IntelliJ IDEA
2. 选择 `File` → `Open`
3. 选择项目根目录
4. 等待 Gradle 同步完成

## 📂 项目结构详解

### 源代码结构

```
src/main/kotlin/com/github/wereadjetbrainsplugin/
├── MyBundle.kt                          # 国际化资源管理
├── toolWindow/
│   └── WeReadToolWindowFactory.kt      # 工具窗口工厂
└── listeners/
    └── WeReadApplicationActivationListener.kt  # 应用监听器
```

### 资源文件结构

```
src/main/resources/
├── META-INF/
│   └── plugin.xml                      # 插件配置文件
├── icons/
│   └── toolWindowIcon.svg              # 工具窗口图标
└── messages/
    ├── MyBundle.properties             # 英文资源
    └── MyBundle_zh_CN.properties       # 中文资源
```

## 🔍 核心类详解

### 1. MyBundle.kt

国际化资源管理类，负责加载和提供多语言文本。

```kotlin
object MyBundle : DynamicBundle(BUNDLE) {
    @JvmStatic
    fun message(key: String, vararg params: Any) = getMessage(key, *params)
}
```

**使用方式**:
```kotlin
val text = MyBundle.message("noSupport")
```

### 2. WeReadToolWindowFactory.kt

工具窗口工厂类，负责创建和初始化工具窗口。

**关键方法**:
- `createToolWindowContent()`: 创建工具窗口内容
- `shouldBeAvailable()`: 判断工具窗口是否可用

**JCEF 集成**:
```kotlin
if (JBCefApp.isSupported()) {
    val jbcef = JBCefBrowser()
    jbcef.loadURL("https://weread.qq.com/")
    add(jbcef.component, BorderLayout.CENTER)
}
```

### 3. WeReadApplicationActivationListener.kt

应用程序激活监听器，监听 IDE 窗口的激活和失活事件。

**事件处理**:
- `applicationActivated()`: IDE 窗口激活时触发
- `applicationDeactivated()`: IDE 窗口失活时触发

## 📝 配置文件详解

### plugin.xml

插件的核心配置文件。

#### 基本信息
```xml
<id>com.github.wereadjetbrainsplugin</id>
<name>WeRead</name>
<vendor email="support@example.com" url="...">WeRead Plugin</vendor>
```

#### 依赖声明
```xml
<depends>com.intellij.modules.platform</depends>
```

#### 扩展点注册
```xml
<extensions defaultExtensionNs="com.intellij">
    <toolWindow factoryClass="..." icon="..." id="WeRead" anchor="right"/>
</extensions>
```

#### 监听器注册
```xml
<applicationListeners>
    <listener class="..." topic="..."/>
</applicationListeners>
```

### gradle.properties

插件属性配置。

**重要属性**:
- `pluginGroup`: 插件组 ID
- `pluginName`: 插件名称
- `pluginVersion`: 插件版本（遵循 SemVer）
- `pluginSinceBuild`: 最低支持的 IDE 版本
- `pluginUntilBuild`: 最高支持的 IDE 版本
- `platformType`: 平台类型（IC = IntelliJ IDEA Community）
- `platformVersion`: 开发使用的平台版本

## 🔨 常用开发任务

### 构建插件

```bash
./gradlew buildPlugin
```

生成的插件位于：`build/distributions/`

### 运行插件（测试）

```bash
./gradlew runIde
```

这会启动一个新的 IDE 实例，插件已预装。

### 清理构建

```bash
./gradlew clean
```

### 验证插件

```bash
./gradlew verifyPlugin
```

检查插件是否符合 JetBrains 规范。

### 运行测试

```bash
./gradlew test
```

### 发布插件

```bash
./gradlew publishPlugin
```

需要先配置 `PUBLISH_TOKEN` 环境变量。

## 🐛 调试插件

### 1. 在测试 IDE 中调试

1. 在 IntelliJ IDEA 中打开项目
2. 在代码中设置断点
3. 点击 Gradle 面板中的 `runIde` 任务
4. 选择 "Debug" 模式运行
5. 在新打开的 IDE 中触发断点

### 2. 查看日志

**在测试 IDE 中**:
- `Help` → `Show Log in Finder/Explorer`

**日志位置**:
- macOS: `~/Library/Logs/JetBrains/<IDE>/idea.log`
- Windows: `%USERPROFILE%\AppData\Local\JetBrains\<IDE>\log\idea.log`
- Linux: `~/.cache/JetBrains/<IDE>/log/idea.log`

### 3. 使用日志记录

```kotlin
import com.intellij.openapi.diagnostic.thisLogger

thisLogger().info("Information message")
thisLogger().warn("Warning message")
thisLogger().error("Error message")
```

## 🎨 添加新功能

### 1. 添加新的工具窗口

1. 创建新的 `ToolWindowFactory` 类
2. 在 `plugin.xml` 中注册：
```xml
<toolWindow factoryClass="..." icon="..." id="MyWindow"/>
```

### 2. 添加新的 Action

1. 创建继承自 `AnAction` 的类
2. 在 `plugin.xml` 中注册：
```xml
<actions>
    <action id="..." class="..." text="..." description="...">
        <add-to-group group-id="..." anchor="..."/>
    </action>
</actions>
```

### 3. 添加设置页面

1. 创建实现 `Configurable` 接口的类
2. 在 `plugin.xml` 中注册：
```xml
<extensions defaultExtensionNs="com.intellij">
    <applicationConfigurable instance="..."/>
</extensions>
```

### 4. 添加快捷键

在 `plugin.xml` 中定义：
```xml
<actions>
    <action id="..." class="...">
        <keyboard-shortcut keymap="$default" first-keystroke="..."/>
    </action>
</actions>
```

## 📦 依赖管理

### 添加新依赖

1. 编辑 `gradle/libs.versions.toml`：
```toml
[versions]
mylib = "1.0.0"

[libraries]
mylib = { group = "com.example", name = "mylib", version.ref = "mylib" }
```

2. 在 `build.gradle.kts` 中使用：
```kotlin
dependencies {
    implementation(libs.mylib)
}
```

### 添加 IntelliJ 平台插件依赖

编辑 `gradle.properties`：
```properties
platformPlugins = com.intellij.java, org.jetbrains.kotlin
```

## 🧪 测试

### 创建单元测试

1. 在 `src/test/kotlin/` 下创建测试类
2. 继承 `BasePlatformTestCase` 或 `LightPlatformTestCase`
3. 编写测试方法

示例：
```kotlin
class MyBundleTest : BasePlatformTestCase() {
    fun testMessage() {
        val message = MyBundle.message("noSupport")
        assertNotNull(message)
    }
}
```

### 运行测试

```bash
./gradlew test
```

## 🔄 版本管理

### 更新版本号

编辑 `gradle.properties`：
```properties
pluginVersion = 1.1.0
```

### 更新 CHANGELOG

编辑 `CHANGELOG.md`，添加新版本的变更记录。

### 创建 Git 标签

```bash
git tag -a v1.1.0 -m "Release version 1.1.0"
git push origin v1.1.0
```

## 🚀 发布流程

### 1. 准备发布

1. 更新版本号
2. 更新 CHANGELOG.md
3. 运行测试：`./gradlew test`
4. 验证插件：`./gradlew verifyPlugin`
5. 构建插件：`./gradlew buildPlugin`

### 2. 手动发布

1. 访问 [JetBrains Marketplace](https://plugins.jetbrains.com/)
2. 登录账号
3. 上传 `build/distributions/WereadJetbrainsPlugin-x.x.x.zip`
4. 填写发布信息
5. 提交审核

### 3. 自动发布（CI/CD）

配置环境变量：
```bash
export PUBLISH_TOKEN=your_token_here
```

运行发布任务：
```bash
./gradlew publishPlugin
```

## 🎯 最佳实践

### 1. 代码风格

- 遵循 Kotlin 官方代码风格
- 使用有意义的变量和函数名
- 添加必要的注释

### 2. 性能优化

- 避免在 UI 线程执行耗时操作
- 使用 `ApplicationManager.getApplication().executeOnPooledThread()` 执行后台任务
- 延迟初始化重量级组件

### 3. 错误处理

- 使用 try-catch 捕获异常
- 记录错误日志
- 向用户显示友好的错误消息

### 4. 国际化

- 所有用户可见的文本都应该放在资源文件中
- 使用 `MyBundle.message()` 获取文本
- 为每种语言创建对应的 `.properties` 文件

## 📚 学习资源

### 官方文档

- [IntelliJ Platform SDK](https://plugins.jetbrains.com/docs/intellij/welcome.html)
- [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template)
- [Kotlin 文档](https://kotlinlang.org/docs/home.html)

### 示例项目

- [cirry/Weread-Jetbrains-Plugin](https://github.com/cirry/Weread-Jetbrains-Plugin)
- [JetBrains 官方插件](https://github.com/JetBrains/intellij-plugins)

### 社区

- [JetBrains Platform Slack](https://plugins.jetbrains.com/slack)
- [IntelliJ Platform 论坛](https://intellij-support.jetbrains.com/hc/en-us/community/topics)

## 🤝 贡献指南

### 提交代码

1. Fork 项目
2. 创建特性分支：`git checkout -b feature/my-feature`
3. 提交更改：`git commit -am 'Add some feature'`
4. 推送到分支：`git push origin feature/my-feature`
5. 创建 Pull Request

### 代码审查

- 确保代码通过所有测试
- 遵循项目代码风格
- 添加必要的文档和注释
- 更新 CHANGELOG.md

## 🐛 故障排除

### Gradle 同步失败

```bash
# 清理 Gradle 缓存
rm -rf ~/.gradle/caches/
./gradlew clean
```

### JCEF 不可用

- 确保使用的 IDE 版本支持 JCEF（≥ 2022.3）
- 检查 JDK 版本（需要 Java 17+）

### 插件无法加载

- 检查 `plugin.xml` 配置是否正确
- 查看 IDE 日志文件
- 验证插件：`./gradlew verifyPlugin`

## 📞 获取帮助

- 查看文档：[README.md](README.md)、[USAGE.md](USAGE.md)
- 提交 Issue：https://github.com/yourusername/WereadJetbrainsPlugin/issues
- 参考官方文档：https://plugins.jetbrains.com/docs/intellij/

---

Happy Coding! 🎉
