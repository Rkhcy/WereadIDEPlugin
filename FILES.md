# WeRead JetBrains Plugin - 文件清单

## 📋 项目文件完整列表

### 📚 文档文件 (8 个)

| 文件名 | 说明 | 用途 |
|--------|------|------|
| `README.md` | 项目主文档 | 项目介绍、功能说明、安装使用指南 |
| `QUICKSTART.md` | 快速开始指南 | 5 分钟快速上手教程 |
| `INSTALL.md` | 安装指南 | 详细的安装步骤和故障排除 |
| `USAGE.md` | 使用指南 | 详细的使用说明和开发指南 |
| `DEVELOPMENT.md` | 开发者指南 | 开发环境设置、代码结构、最佳实践 |
| `PROJECT_OVERVIEW.md` | 项目概览 | 项目结构、技术栈、实现细节 |
| `PROJECT_SUMMARY.md` | 项目总结 | 完成工作总结、项目统计 |
| `CHANGELOG.md` | 更新日志 | 版本历史和变更记录 |

### 🔧 配置文件 (5 个)

| 文件名 | 说明 | 用途 |
|--------|------|------|
| `build.gradle.kts` | Gradle 构建脚本 | 定义构建配置、依赖、任务 |
| `settings.gradle.kts` | Gradle 设置 | 项目设置和插件配置 |
| `gradle.properties` | Gradle 属性 | 插件元数据、版本信息 |
| `gradle/libs.versions.toml` | 依赖版本管理 | 统一管理所有依赖版本 |
| `.gitignore` | Git 忽略规则 | 定义不需要版本控制的文件 |

### 💻 源代码文件 (3 个)

| 文件路径 | 说明 |
|----------|------|
| `src/main/kotlin/com/github/wereadjetbrainsplugin/MyBundle.kt` | 国际化资源管理类 |
| `src/main/kotlin/com/github/wereadjetbrainsplugin/toolWindow/WeReadToolWindowFactory.kt` | 工具窗口工厂类 |
| `src/main/kotlin/com/github/wereadjetbrainsplugin/listeners/WeReadApplicationActivationListener.kt` | 应用激活监听器 |

### 📦 资源文件 (5 个)

| 文件路径 | 说明 |
|----------|------|
| `src/main/resources/META-INF/plugin.xml` | 插件配置文件 |
| `src/main/resources/icons/toolWindowIcon.svg` | 工具窗口图标 |
| `src/main/resources/messages/MyBundle.properties` | 英文资源文件 |
| `src/main/resources/messages/MyBundle_zh_CN.properties` | 中文资源文件 |

### 🛠️ 辅助脚本 (2 个)

| 文件名 | 说明 | 用途 |
|--------|------|------|
| `build.sh` | 构建脚本 | 一键构建插件（带提示信息） |
| `run.sh` | 运行脚本 | 一键启动测试 IDE |

### 📁 Gradle 相关文件

| 文件/目录 | 说明 |
|-----------|------|
| `gradlew` | Gradle Wrapper 脚本 (Unix/macOS) |
| `gradlew.bat` | Gradle Wrapper 脚本 (Windows) |
| `gradle/wrapper/` | Gradle Wrapper 配置和 JAR |

## 📊 文件统计

- **总文件数**: 23+ 个
- **文档文件**: 8 个 (~1500 行)
- **配置文件**: 5 个
- **源代码文件**: 3 个 (~200 行)
- **资源文件**: 5 个
- **辅助脚本**: 2 个

## 🗂️ 目录结构

```
WereadJetbrainsPlugin/
├── 📚 文档
│   ├── README.md
│   ├── QUICKSTART.md
│   ├── INSTALL.md
│   ├── USAGE.md
│   ├── DEVELOPMENT.md
│   ├── PROJECT_OVERVIEW.md
│   ├── PROJECT_SUMMARY.md
│   ├── CHANGELOG.md
│   └── FILES.md (本文件)
│
├── 🔧 配置
│   ├── build.gradle.kts
│   ├── settings.gradle.kts
│   ├── gradle.properties
│   ├── .gitignore
│   └── gradle/
│       └── libs.versions.toml
│
├── 💻 源代码
│   └── src/main/kotlin/com/github/wereadjetbrainsplugin/
│       ├── MyBundle.kt
│       ├── toolWindow/
│       │   └── WeReadToolWindowFactory.kt
│       └── listeners/
│           └── WeReadApplicationActivationListener.kt
│
├── 📦 资源
│   └── src/main/resources/
│       ├── META-INF/
│       │   └── plugin.xml
│       ├── icons/
│       │   └── toolWindowIcon.svg
│       └── messages/
│           ├── MyBundle.properties
│           └── MyBundle_zh_CN.properties
│
├── 🛠️ 脚本
│   ├── build.sh
│   └── run.sh
│
└── 📦 Gradle
    ├── gradlew
    ├── gradlew.bat
    └── gradle/wrapper/
```

## 📖 文档阅读顺序建议

### 新手用户
1. `QUICKSTART.md` - 快速开始
2. `README.md` - 了解项目
3. `INSTALL.md` - 详细安装

### 开发者
1. `README.md` - 项目概述
2. `PROJECT_OVERVIEW.md` - 项目结构
3. `DEVELOPMENT.md` - 开发指南
4. `USAGE.md` - 使用说明

### 贡献者
1. `DEVELOPMENT.md` - 开发环境设置
2. `PROJECT_OVERVIEW.md` - 技术细节
3. `CHANGELOG.md` - 版本历史

## 🎯 核心文件说明

### 必读文件

1. **README.md** - 项目的门面，包含最重要的信息
2. **QUICKSTART.md** - 最快上手的方式
3. **plugin.xml** - 插件的核心配置

### 开发必读

1. **build.gradle.kts** - 构建配置
2. **WeReadToolWindowFactory.kt** - 核心功能实现
3. **DEVELOPMENT.md** - 开发指南

### 可选阅读

1. **PROJECT_SUMMARY.md** - 项目总结
2. **FILES.md** - 文件清单（本文件）
3. **USAGE.md** - 详细使用说明

## 🔍 查找文件

### 按功能查找

- **想快速开始**: `QUICKSTART.md`
- **想了解安装**: `INSTALL.md`
- **想了解使用**: `USAGE.md`
- **想参与开发**: `DEVELOPMENT.md`
- **想了解结构**: `PROJECT_OVERVIEW.md`
- **想查看变更**: `CHANGELOG.md`

### 按类型查找

- **文档**: `*.md` 文件
- **配置**: `*.gradle.kts`, `*.properties`, `*.toml`
- **源代码**: `src/main/kotlin/**/*.kt`
- **资源**: `src/main/resources/**/*`
- **脚本**: `*.sh`

## 📝 文件维护

### 需要定期更新的文件

- `CHANGELOG.md` - 每次发布新版本时更新
- `gradle.properties` - 更新版本号时修改
- `README.md` - 功能变更时更新

### 不需要手动修改的文件

- `gradlew`, `gradlew.bat` - 由 Gradle Wrapper 管理
- `gradle/wrapper/` - 由 Gradle Wrapper 管理
- `build/` - 构建生成的目录

## 🎨 文件命名规范

- **文档文件**: 全大写 + `.md` 扩展名（如 `README.md`）
- **配置文件**: 小写 + 特定扩展名（如 `build.gradle.kts`）
- **源代码**: PascalCase + `.kt` 扩展名（如 `MyBundle.kt`）
- **脚本文件**: 小写 + `.sh` 扩展名（如 `build.sh`）

## 📦 构建产物

构建后会生成以下文件/目录：

```
build/
├── distributions/
│   └── WereadJetbrainsPlugin-1.0.0.zip  # 可分发的插件包
├── libs/
│   └── WereadJetbrainsPlugin-1.0.0.jar  # 编译后的 JAR
└── reports/                              # 各种报告
```

## 🚀 快速导航

- 📖 **快速开始**: [QUICKSTART.md](QUICKSTART.md)
- 📦 **安装指南**: [INSTALL.md](INSTALL.md)
- 📚 **使用说明**: [USAGE.md](USAGE.md)
- 🛠️ **开发指南**: [DEVELOPMENT.md](DEVELOPMENT.md)
- 📊 **项目概览**: [PROJECT_OVERVIEW.md](PROJECT_OVERVIEW.md)
- 📝 **项目总结**: [PROJECT_SUMMARY.md](PROJECT_SUMMARY.md)
- 🔄 **更新日志**: [CHANGELOG.md](CHANGELOG.md)

---

**提示**: 如果你是第一次使用，建议从 [QUICKSTART.md](QUICKSTART.md) 开始！
