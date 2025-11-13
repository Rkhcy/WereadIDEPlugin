# WeRead JetBrains Plugin 使用指南

## 快速开始

### 1. 构建插件

在项目根目录执行以下命令：

```bash
./gradlew buildPlugin
```

构建完成后，插件文件将位于 `build/distributions/` 目录下。

### 2. 在 IDE 中测试插件

运行以下命令将启动一个带有插件的 IDE 实例：

```bash
./gradlew runIde
```

这将启动一个新的 IntelliJ IDEA 或 Android Studio 实例，插件已经预装其中。

### 3. 安装插件

#### 方式一：从本地安装

1. 构建插件：`./gradlew buildPlugin`
2. 打开 Android Studio 或其他 JetBrains IDE
3. 进入 `Settings/Preferences` → `Plugins` → `⚙️` → `Install Plugin from Disk...`
4. 选择 `build/distributions/WereadJetbrainsPlugin-1.0.0.zip`
5. 重启 IDE

#### 方式二：发布到 JetBrains Marketplace（可选）

1. 注册 [JetBrains Marketplace](https://plugins.jetbrains.com/) 账号
2. 配置发布 token
3. 运行 `./gradlew publishPlugin`

## 使用插件

### 打开微信读书

1. 安装插件后，在 IDE 右侧工具栏找到 "WeRead" 图标
2. 点击图标打开微信读书工具窗口
3. 首次使用需要登录微信读书账号
4. 登录后即可开始阅读

### 功能说明

- **完整的微信读书体验**：支持所有微信读书网页版功能
- **方向键导航**：可以使用键盘方向键翻页
- **窗口调整**：可以自由调整工具窗口大小以获得最佳阅读体验
- **多平台支持**：支持所有 JetBrains IDE（Android Studio、IntelliJ IDEA、PyCharm 等）

### 快捷键

- 工具窗口默认停靠在右侧，可以拖动到其他位置
- 可以通过 `View` → `Tool Windows` → `WeRead` 打开/关闭窗口

## 开发说明

### 项目结构

```
WereadJetbrainsPlugin/
├── src/
│   └── main/
│       ├── kotlin/
│       │   └── com/github/wereadjetbrainsplugin/
│       │       ├── MyBundle.kt                    # 国际化资源管理
│       │       ├── toolWindow/
│       │       │   └── WeReadToolWindowFactory.kt # 工具窗口工厂
│       │       └── listeners/
│       │           └── WeReadApplicationActivationListener.kt # 应用监听器
│       └── resources/
│           ├── META-INF/
│           │   └── plugin.xml                     # 插件配置文件
│           ├── icons/
│           │   └── toolWindowIcon.svg             # 工具窗口图标
│           └── messages/
│               ├── MyBundle.properties            # 英文资源
│               └── MyBundle_zh_CN.properties      # 中文资源
├── build.gradle.kts                               # Gradle 构建配置
├── gradle.properties                              # Gradle 属性配置
└── settings.gradle.kts                            # Gradle 设置
```

### 修改插件

#### 更改插件名称或 ID

编辑 `gradle.properties`：

```properties
pluginGroup = com.github.wereadjetbrainsplugin
pluginName = WeRead
```

编辑 `src/main/resources/META-INF/plugin.xml`：

```xml
<id>com.github.wereadjetbrainsplugin</id>
<name>WeRead</name>
```

#### 更改支持的 IDE 版本

编辑 `gradle.properties`：

```properties
pluginSinceBuild = 223        # 最低支持版本
pluginUntilBuild = 242.*      # 最高支持版本
platformVersion = 2022.3      # 开发使用的平台版本
```

#### 添加新功能

1. 在 `src/main/kotlin/com/github/wereadjetbrainsplugin/` 下创建新的 Kotlin 文件
2. 在 `plugin.xml` 中注册新的扩展点或动作
3. 重新构建插件

### 常用 Gradle 任务

```bash
# 清理构建
./gradlew clean

# 构建插件
./gradlew buildPlugin

# 运行插件（启动测试 IDE）
./gradlew runIde

# 验证插件
./gradlew verifyPlugin

# 运行测试
./gradlew test

# 发布插件
./gradlew publishPlugin
```

## 故障排除

### JCEF 不支持

如果看到 "JCEF is not supported on this platform" 错误：

- 确保使用的是较新版本的 JetBrains IDE（2022.3+）
- 某些平台可能不支持 JCEF，请升级 IDE 或更换平台

### 插件无法加载

1. 检查 IDE 版本是否在支持范围内（2022.3 - 2024.2）
2. 查看 IDE 日志：`Help` → `Show Log in Finder/Explorer`
3. 确保插件文件完整且未损坏

### 构建失败

1. 确保 Java 17 已安装
2. 清理 Gradle 缓存：`./gradlew clean`
3. 删除 `.gradle` 和 `build` 目录后重新构建

## 技术细节

### 使用的技术

- **Kotlin**：插件开发语言
- **IntelliJ Platform SDK**：JetBrains 插件开发框架
- **JCEF (Java Chromium Embedded Framework)**：内嵌浏览器
- **Gradle**：构建工具

### 工作原理

1. 插件在 IDE 右侧创建一个工具窗口
2. 使用 JCEF 在工具窗口中嵌入 Chromium 浏览器
3. 浏览器加载微信读书网页版 (https://weread.qq.com/)
4. 用户可以像在普通浏览器中一样使用微信读书

## 贡献

欢迎提交 Issue 和 Pull Request！

如有问题，请访问：https://github.com/yourusername/WereadJetbrainsPlugin/issues
