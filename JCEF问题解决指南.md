# JCEF 问题解决指南

## 问题描述

当你打开 WeRead 插件时，看到以下错误信息：
```
JCEF is not supported on this platform. Cannot display WeRead.
```

## 🔍 问题原因

Android Studio 默认可能使用的是不支持 JCEF 的 Java Runtime，或者 JCEF 功能未启用。

JCEF（Java Chromium Embedded Framework）是一个将 Chromium 浏览器嵌入到 Java 应用的框架，WeRead 插件需要它来显示微信读书网页版。

---

## ✅ 解决方案

### 方案一：切换到支持 JCEF 的 JBR（推荐）

#### 步骤 1：打开 Runtime 选择器

1. 在 Android Studio 中按 `⌘⇧A` (macOS) 或 `Ctrl+Shift+A` (Windows/Linux)
2. 输入 `Choose Boot Java Runtime for the IDE`
3. 选择该选项

或者通过菜单：
- `Help` → `Find Action...` → 搜索 `Choose Boot Java Runtime`

#### 步骤 2：选择支持 JCEF 的 Runtime

在弹出的对话框中：

1. 查看 **Runtime** 列表
2. 选择一个包含 **JCEF** 的版本，例如：
   - `17.0.x-jcef-b123.456` 
   - `21.0.x-jcef-b789.012`
   
   **注意**：确保选择的版本名称中包含 `jcef` 字样

3. 如果列表中没有 JCEF 版本：
   - 点击 `Download...` 按钮
   - 选择最新的带 JCEF 的 JBR 版本下载

4. 点击 `OK`

#### 步骤 3：重启 Android Studio

选择 Runtime 后，Android Studio 会提示重启。重启后 JCEF 应该就可用了。

---

### 方案二：检查当前 Runtime

#### 查看当前使用的 Runtime

1. 打开 `Help` → `About`
2. 查看 Runtime version 信息
3. 确认是否包含 `jcef` 字样

如果不包含，按照方案一切换到支持 JCEF 的版本。

---

### 方案三：使用外部浏览器（临时方案）

如果无法启用 JCEF，新版本的插件提供了一个按钮：

1. 打开 WeRead 工具窗口
2. 点击 **"在浏览器中打开微信读书"** 按钮
3. 会在你的默认浏览器中打开微信读书

虽然这样无法在 IDE 内阅读，但可以作为临时解决方案。

---

## 🔧 验证 JCEF 是否可用

### 方法 1：查看插件窗口

重新安装插件后：
1. 打开 WeRead 工具窗口
2. 如果看到微信读书网页，说明 JCEF 已启用
3. 如果仍然看到错误提示，说明 JCEF 未启用

### 方法 2：查看日志

1. 打开 `Help` → `Show Log in Finder` (macOS) 或 `Show Log in Explorer` (Windows)
2. 搜索 `JCEF supported`
3. 查看日志中的值：
   - `JCEF supported: true` ✅ 已启用
   - `JCEF supported: false` ❌ 未启用

---

## 📋 详细步骤（macOS）

### 1. 检查当前 Runtime

```bash
# 在终端中查看 Android Studio 使用的 Java 版本
/Applications/Android\ Studio.app/Contents/jbr/Contents/Home/bin/java -version
```

### 2. 切换 Runtime

1. 打开 Android Studio
2. 按 `⌘⇧A`
3. 输入 `Choose Boot Java Runtime`
4. 选择带 `jcef` 的版本
5. 重启

### 3. 重新安装插件

```bash
# 重新构建插件
cd /Users/huchengyang/as/WereadJetbrainsPlugin
./gradlew clean buildPlugin
```

然后在 Android Studio 中：
1. `Settings` → `Plugins` → `Installed`
2. 卸载旧版本的 WeRead
3. `Settings` → `Plugins` → `⚙️` → `Install Plugin from Disk`
4. 选择 `build/distributions/WeRead-1.0.0.zip`
5. 重启

---

## 📋 详细步骤（Windows）

### 1. 切换 Runtime

1. 打开 Android Studio
2. 按 `Ctrl+Shift+A`
3. 输入 `Choose Boot Java Runtime`
4. 选择带 `jcef` 的版本
5. 重启

### 2. 重新安装插件

```cmd
# 重新构建插件
cd C:\path\to\WereadJetbrainsPlugin
gradlew.bat clean buildPlugin
```

然后在 Android Studio 中：
1. `File` → `Settings` → `Plugins` → `Installed`
2. 卸载旧版本的 WeRead
3. `File` → `Settings` → `Plugins` → `⚙️` → `Install Plugin from Disk`
4. 选择 `build\distributions\WeRead-1.0.0.zip`
5. 重启

---

## ❓ 常见问题

### Q1: 找不到 "Choose Boot Java Runtime" 选项

**A**: 这个功能在较新版本的 Android Studio 中才有。如果找不到：

1. 更新 Android Studio 到最新版本
2. 或者手动下载 JBR with JCEF：
   - 访问 https://github.com/JetBrains/JetBrainsRuntime/releases
   - 下载对应平台的 JCEF 版本
   - 手动配置 Android Studio 使用该 Runtime

### Q2: 下载 JCEF Runtime 很慢

**A**: 
- 使用代理或 VPN
- 或者从国内镜像下载（如果有）

### Q3: 切换 Runtime 后 Android Studio 无法启动

**A**:
1. 删除 Android Studio 的配置目录中的 `studio.jdk` 文件
2. 重新启动 Android Studio
3. 它会使用默认的 Runtime

### Q4: 仍然不工作

**A**: 
1. 查看 IDE 日志文件（`Help` → `Show Log`）
2. 搜索 `JCEF` 或 `WeRead` 相关的错误信息
3. 将错误信息反馈给开发者

---

## 🎯 推荐配置

### 推荐的 JBR 版本

- **Java 17**: `17.0.x-jcef-bxxx.xxx`
- **Java 21**: `21.0.x-jcef-bxxx.xxx`

选择与你的 Android Studio 版本兼容的最新 JCEF Runtime。

### 验证配置成功

成功配置后，你应该能够：
1. ✅ 在 WeRead 工具窗口中看到微信读书网页
2. ✅ 正常登录和阅读
3. ✅ 使用方向键翻页

---

## 📞 需要帮助？

如果按照以上步骤仍然无法解决问题：

1. 查看 IDE 日志：`Help` → `Show Log in Finder/Explorer`
2. 搜索包含 `JCEF` 或 `WeRead` 的错误信息
3. 提交 Issue 并附上：
   - Android Studio 版本
   - 当前使用的 Java Runtime 版本
   - 错误日志

---

## 📚 相关资源

- [JetBrains Runtime 下载](https://github.com/JetBrains/JetBrainsRuntime/releases)
- [JCEF 官方文档](https://plugins.jetbrains.com/docs/intellij/jcef.html)
- [IntelliJ Platform SDK](https://plugins.jetbrains.com/docs/intellij/welcome.html)

---

**祝你使用愉快！** 📚✨
