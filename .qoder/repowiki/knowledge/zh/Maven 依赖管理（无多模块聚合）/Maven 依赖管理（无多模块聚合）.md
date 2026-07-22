---
kind: dependency_management
name: Maven 依赖管理（无多模块聚合）
category: dependency_management
scope:
    - '**'
source_files:
    - pom.xml
---

本仓库是一个 LeetCode 题解集合，采用单模块 Maven 工程组织，所有第三方依赖集中在根目录 `pom.xml` 中声明。未发现 Go、Node.js、Python 等语言的依赖清单文件，也未使用 vendoring 策略或私有仓库配置。

**使用的系统/工具**
- **Maven**：作为唯一的构建与依赖解析工具，通过 `pom.xml` 声明依赖。
- **JDK 25**：通过 `<maven.compiler.source>` / `<maven.compiler.target>` 属性统一指定。

**核心依赖清单**（来自 `pom.xml`）
- `junit:junit:4.13.1`（test scope）— 单元测试框架
- `com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.18.6` — XML 数据格式支持
- `org.projectlombok:lombok:1.18.42`（compile scope）— 注解处理器，用于简化样板代码
- `org.slf4j:slf4j-simple:2.0.13` — SLF4J 的简单实现

**插件版本锁定**
在 `<pluginManagement>` 中对常用 Maven 插件（clean、resources、compiler、surefire、jar、install、deploy、site、project-info-reports）进行了版本锁定，避免使用 Maven 默认版本带来的不确定性。

**约定与约束**
- 所有依赖均直接声明在根 `pom.xml`，不存在子模块 POM 或 BOM 聚合模式。
- 未引入 `dependencyManagement` 标签集中管理版本，每个依赖自行声明版本号。
- 未配置任何私有 Maven 仓库（`<repositories>` / `<pluginRepositories>`），完全依赖 Maven Central。
- 未使用 lockfile（如 `mvn dependency:tree` 输出快照），也不存在 `vendor/` 目录进行源码级 vendoring。
- `.venv/` 被 IntelliJ IDEA 排除（`.iml` 中可见），但仓库内并无 Python 依赖清单，该虚拟环境为本地开发残留。

**开发者应遵循的规则**
1. 新增依赖时直接在根 `pom.xml` 的 `<dependencies>` 中添加，并显式指定版本号。
2. 保持 JDK 编译目标与属性一致（当前为 25）。
3. 测试相关依赖使用 `<scope>test</scope>`，避免污染运行时类路径。
4. 如需引入新插件，优先放入 `<pluginManagement>` 以统一版本管理。
5. 由于未使用 BOM 或父 POM，跨模块共享依赖时需手动同步版本号。