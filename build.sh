#!/bin/bash

# WeRead JetBrains Plugin 构建脚本

set -e

echo "======================================"
echo "WeRead JetBrains Plugin 构建脚本"
echo "======================================"
echo ""

# 清理之前的构建
echo "1. 清理之前的构建..."
./gradlew clean

# 构建插件
echo ""
echo "2. 构建插件..."
./gradlew buildPlugin

# 检查构建结果
if [ -f "build/distributions/WereadJetbrainsPlugin-1.0.0.zip" ]; then
    echo ""
    echo "======================================"
    echo "✅ 构建成功！"
    echo "======================================"
    echo ""
    echo "插件文件位置："
    echo "  build/distributions/WereadJetbrainsPlugin-1.0.0.zip"
    echo ""
    echo "安装方法："
    echo "  1. 打开 Android Studio 或其他 JetBrains IDE"
    echo "  2. 进入 Settings/Preferences → Plugins"
    echo "  3. 点击 ⚙️ → Install Plugin from Disk..."
    echo "  4. 选择上述 zip 文件"
    echo "  5. 重启 IDE"
    echo ""
    echo "或者运行以下命令在测试 IDE 中运行："
    echo "  ./gradlew runIde"
    echo ""
else
    echo ""
    echo "❌ 构建失败，请检查错误信息"
    exit 1
fi
