---
kind: build_system
name: Maven 构建与 LeetCode Editor 题解工程
category: build_system
scope:
    - '**'
source_files:
    - pom.xml
---

本仓库是一个以 Maven 为唯一构建系统的 Java 题解集合，所有源码由 LeetCode Editor 插件生成并直接纳入 src/main/java 目录，未采用多模块拆分。

- 构建工具：Maven（根 pom.xml），Java 编译源/目标版本固定为 25，编码 UTF-8。
- 依赖管理：集中声明在根 POM 的 dependencies 中，包含 JUnit 4.13.1、Jackson XML 2.18.6、Lombok 1.18.42、SLF4J Simple 2.0.13。
- 插件配置：通过 pluginManagement 锁定 clean/resources/compiler/surefire/jar/install/deploy/site 等核心插件版本；maven-compiler-plugin 显式设置 source/target=25。
- 测试：使用 Surefire 3.0.0 + JUnit 4，但源码中未见标准 src/test/java 结构，测试用例散落在题目文件内或外部脚本。
- 打包产物：默认生成 target/*.jar，无自定义 packaging 或 assembly 配置。
- CI/容器化：仓库中不存在 .github/workflows、Dockerfile、Makefile、build.sh 等持续集成或容器化脚本，本地开发主要依赖 IDE（.idea/、leetcode.iml、leetcode.code-workspace）和 mvn compile/test/package。
- 辅助脚本：根目录提供 export_leetcode.py 用于从 LeetCode 导出题目数据，非构建系统一部分。

开发者约定：
- 新增题目后只需将生成的 .java 文件放入对应包路径，无需修改 POM。
- 如需引入新依赖，统一在根 POM 的 dependencies 中声明，避免在各子目录重复定义。
- 保持 Java 25 兼容性，不要引入低于该版本的 API。
- 单元测试建议遵循 JUnit 4 风格并放在 src/test/java 下以便被 Surefire 自动发现。