# WeRead JetBrains Plugin 安装指南

## 前置要求

### 系统要求

- **操作系统**: macOS, Windows, Linux
- **JDK**: Java 17 或更高版本
- **IDE**: 以下任一 JetBrains IDE（版本 2022.3 或更高）
  - Android Studio
  - IntelliJ IDEA (Community 或 Ultimate)
  - PyCharm (Community 或 Professional)
  - WebStorm
  - PhpStorm
  - GoLand
  - 其他 JetBrains IDE

### 检查 Java 版本

```bash
java -version
```

应该显示 Java 17 或更高版本。如果没有，请先安装 JDK 17。

## 方法一：从源码构建并安装（推荐）

### 1. 克隆或下载项目

如果你已经有项目代码，跳过此步骤。

### 2. 构建插件

在项目根目录执行：

```bash
# macOS/Linux
./build.sh

# 或者直接使用 Gradle
./gradlew clean buildPlugin
```

```powershell
# Windows
gradlew.bat clean buildPlugin
```

构建成功后，插件文件将位于：
```
build/distributions/WereadJetbrainsPlugin-1.0.0.zip
```

### 3. 安装插件到 IDE

#### 步骤：

1. 打开你的 JetBrains IDE（如 Android Studio）
2. 进入设置：
   - **macOS**: `Android Studio` → `Settings...` 或 `⌘,`
   - **Windows/Linux**: `File` → `Settings` 或 `Ctrl+Alt+S`
3. 在左侧菜单选择 `Plugins`
4. 点击右上角的 `⚙️` (齿轮图标)
5. 选择 `Install Plugin from Disk...`
6. 浏览并选择 `build/distributions/WereadJetbrainsPlugin-1.0.0.zip`
7. 点击 `OK`
8. 重启 IDE

## 方法二：在测试 IDE 中运行（开发测试）

如果你想在不安装到主 IDE 的情况下测试插件：

```bash
# macOS/Linux
./run.sh

# 或者直接使用 Gradle
./gradlew runIde
```

```powershell
# Windows
gradlew.bat runIde
```

这将启动一个新的 IDE 实例，插件已经预装其中。

## 方法三：从 JetBrains Marketplace 安装（未来）

> 注意：此方法需要先将插件发布到 JetBrains Marketplace

1. 打开 IDE 设置
2. 进入 `Plugins` → `Marketplace`
3. 搜索 "WeRead"
4. 点击 `Install`
5. 重启 IDE

## 验证安装

### 1. 检查插件是否已安装

1. 打开 IDE 设置
2. 进入 `Plugins` → `Installed`
3. 查找 "WeRead" 插件
4. 确认状态为 "Enabled"

### 2. 查找工具窗口

安装成功后，你应该能在以下位置找到 WeRead：

- **工具栏**: IDE 右侧工具栏应该有一个 "WeRead" 图标
- **菜单**: `View` → `Tool Windows` → `WeRead`

### 3. 打开微信读书

1. 点击右侧工具栏的 "WeRead" 图标
2. 工具窗口将打开并加载微信读书网页版
3. 登录你的微信读书账号
4. 开始阅读！

## 常见问题

### Q1: 构建失败，提示 "Could not find or load main class"

**解决方法**:
- 确保已安装 Java 17 或更高版本
- 运行 `./gradlew clean` 清理缓存后重试

### Q2: 插件安装后看不到工具窗口

**解决方法**:
1. 检查插件是否已启用：`Settings` → `Plugins` → `Installed`
2. 尝试通过菜单打开：`View` → `Tool Windows` → `WeRead`
3. 重启 IDE

### Q3: 显示 "JCEF is not supported on this platform"

**解决方法**:
- 确保使用的 IDE 版本是 2022.3 或更高
- 某些旧版本或特殊构建的 IDE 可能不支持 JCEF
- 尝试更新到最新版本的 IDE

### Q4: 微信读书页面无法加载

**解决方法**:
- 检查网络连接
- 确认可以在浏览器中访问 https://weread.qq.com/
- 检查 IDE 的代理设置：`Settings` → `Appearance & Behavior` → `System Settings` → `HTTP Proxy`

### Q5: 构建时下载依赖很慢

**解决方法**:
- 配置 Gradle 使用国内镜像源
- 编辑 `build.gradle.kts`，在 `repositories` 中添加阿里云镜像：
  ```kotlin
  repositories {
      maven { url = uri("https://maven.aliyun.com/repository/public") }
      maven { url = uri("https://maven.aliyun.com/repository/gradle-plugin") }
      mavenCentral()
  }
  ```

### Q6: IDE 版本不兼容

**解决方法**:
- 检查你的 IDE 版本是否在支持范围内（2022.3 - 2024.2）
- 如果 IDE 版本过低，请升级 IDE
- 如果 IDE 版本过高，可以修改 `gradle.properties` 中的 `pluginUntilBuild` 值

## 卸载插件

1. 打开 IDE 设置
2. 进入 `Plugins` → `Installed`
3. 找到 "WeRead" 插件
4. 点击插件右侧的 `⚙️` 图标
5. 选择 `Uninstall`
6. 重启 IDE

## 更新插件

### 从本地文件更新

1. 构建新版本的插件
2. 按照安装步骤重新安装
3. IDE 会自动替换旧版本

### 从 Marketplace 更新（未来）

1. 打开 IDE 设置
2. 进入 `Plugins` → `Installed`
3. 如果有更新，"WeRead" 插件旁边会显示 "Update" 按钮
4. 点击 "Update"
5. 重启 IDE

## 开发者选项

### 启用插件开发模式

如果你想修改插件代码：

1. 在 IntelliJ IDEA 中打开项目
2. 等待 Gradle 同步完成
3. 修改代码
4. 运行 `./gradlew runIde` 测试修改

### 调试插件

1. 在 IntelliJ IDEA 中打开项目
2. 设置断点
3. 运行 Gradle 任务：`runIde` (Debug 模式)
4. 在新打开的 IDE 中触发断点

### 查看插件日志

- **macOS**: `~/Library/Logs/JetBrains/<IDE>/idea.log`
- **Windows**: `%USERPROFILE%\AppData\Local\JetBrains\<IDE>\log\idea.log`
- **Linux**: `~/.cache/JetBrains/<IDE>/log/idea.log`

或者在 IDE 中：`Help` → `Show Log in Finder/Explorer`

## 获取帮助

如果遇到问题：

1. 查看 [README.md](README.md) 和 [USAGE.md](USAGE.md)
2. 查看项目 Issues: https://github.com/yourusername/WereadJetbrainsPlugin/issues
3. 提交新的 Issue 描述你的问题

## 贡献

欢迎贡献代码！请查看 [README.md](README.md) 了解如何贡献。
