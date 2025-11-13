# WeRead JetBrains Plugin - 快速开始

## 🚀 5 分钟快速上手

### 第一步：构建插件

在项目根目录打开终端，执行：

```bash
./build.sh
```

或者：

```bash
./gradlew clean buildPlugin
```

> ⏱️ 首次构建需要下载依赖，可能需要 5-10 分钟

### 第二步：安装插件

1. 打开 **Android Studio** 或其他 JetBrains IDE
2. 按 `⌘,` (macOS) 或 `Ctrl+Alt+S` (Windows/Linux) 打开设置
3. 选择 **Plugins** → 点击 `⚙️` → **Install Plugin from Disk...**
4. 选择 `build/distributions/WereadJetbrainsPlugin-1.0.0.zip`
5. 点击 **OK** 并重启 IDE

### 第三步：使用插件

1. 重启后，在 IDE **右侧工具栏**找到 **WeRead** 图标
2. 点击图标打开微信读书
3. 登录你的微信读书账号
4. 开始阅读！📚

---

## 🎯 或者直接测试（无需安装）

想快速体验？运行：

```bash
./run.sh
```

或者：

```bash
./gradlew runIde
```

这会启动一个新的 IDE 实例，插件已经加载好了！

---

## 📋 项目结构一览

```
WereadJetbrainsPlugin/
├── src/main/
│   ├── kotlin/                          # Kotlin 源代码
│   │   └── com/github/wereadjetbrainsplugin/
│   │       ├── MyBundle.kt              # 国际化
│   │       ├── toolWindow/              # 工具窗口
│   │       └── listeners/               # 监听器
│   └── resources/
│       ├── META-INF/plugin.xml          # 插件配置
│       ├── icons/                       # 图标
│       └── messages/                    # 多语言文本
├── build.gradle.kts                     # 构建配置
├── gradle.properties                    # 插件属性
└── README.md                            # 详细文档
```

---

## 🛠️ 常用命令

| 命令 | 说明 |
|------|------|
| `./gradlew buildPlugin` | 构建插件 |
| `./gradlew runIde` | 在测试 IDE 中运行 |
| `./gradlew clean` | 清理构建 |
| `./gradlew verifyPlugin` | 验证插件 |

---

## ✨ 主要功能

- ✅ 在 IDE 中直接访问微信读书
- ✅ 完整的微信读书功能
- ✅ 支持所有 JetBrains IDE
- ✅ 中英文界面
- ✅ 方向键导航

---

## 📚 更多文档

- [README.md](README.md) - 完整项目说明
- [INSTALL.md](INSTALL.md) - 详细安装指南
- [USAGE.md](USAGE.md) - 使用说明
- [PROJECT_OVERVIEW.md](PROJECT_OVERVIEW.md) - 项目概览

---

## ❓ 遇到问题？

### 构建失败
```bash
# 清理后重试
./gradlew clean
./gradlew buildPlugin
```

### 看不到工具窗口
- 检查：`View` → `Tool Windows` → `WeRead`
- 或者重启 IDE

### JCEF 不支持
- 确保 IDE 版本 ≥ 2022.3
- 更新到最新版本

---

## 🎉 完成！

现在你可以在 Android Studio 中边写代码边看书了！

有问题？查看 [INSTALL.md](INSTALL.md) 或提交 Issue。
