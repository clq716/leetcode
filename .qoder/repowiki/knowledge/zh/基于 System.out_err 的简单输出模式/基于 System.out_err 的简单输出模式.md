---
kind: logging_system
name: 基于 System.out/err 的简单输出模式
category: logging_system
scope:
    - '**'
source_files:
    - src/main/java/utils/Printer.java
    - pom.xml
    - src/main/java/leetcode/JacksonCheatParser.java
---

该 LeetCode 题解聚合仓库未实现正式的日志系统，仅使用最基础的 Java 标准输出方式进行调试和结果打印：

**输出方式**
- `System.out.println()`：用于直接打印算法运行结果和中间状态，在绝大多数题解文件的 main 方法中使用
- `System.err.println()`：仅在工具类 JacksonCheatParser.java 中用于错误提示和使用说明
- `utils.Printer.print()`：自定义的便捷输出封装，对 System.out.println 进行简单包装，支持可变参数

**依赖配置**
- pom.xml 中声明了 `org.slf4j:slf4j-simple:2.0.13` 依赖，但代码中并未实际使用 SLF4J API
- 存在 Lombok 依赖（1.18.42），但从 GitHub Actions 钩子记录可见曾尝试移除 @Slf4j 注解以避免编译问题

**使用模式**
- 每个题解文件独立包含 main 方法进行本地测试验证
- 输出内容主要是算法执行结果的字符串拼接，无结构化日志格式
- 无日志级别管理、无日志文件输出、无异步处理机制

**结论**
该项目作为算法题解集合，采用最直接的 System.out 输出方式满足本地调试需求，未引入任何专业日志框架。SLF4J 依赖可能是历史遗留或为未来扩展预留，当前代码库中不存在实际的日志系统架构。