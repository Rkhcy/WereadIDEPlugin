#!/bin/bash

# WeRead JetBrains Plugin 运行脚本

set -e

echo "======================================"
echo "WeRead JetBrains Plugin 运行脚本"
echo "======================================"
echo ""
echo "正在启动测试 IDE..."
echo "插件将自动加载到新的 IDE 实例中"
echo ""

./gradlew runIde
