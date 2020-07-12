* spring源码环境配置
1. 配置gradle环境（系统变量配置，设置仓库地址，最好和maven共用仓库）   
2. 从github拉取spring源码至本地 
3. 参考源码中《import-into-idea.md》文件内容。
    将spring-aspects模块排除出去，在settings.gradle文件中注解掉
    [include "spring-aspects"]
4. 修改仓库地址，从国内的镜像仓库下载jar包，提高效率。
    修改 build.gradle文件。

    buildscript {
        repositories {
            mavenLocal()
            maven { url "https://maven.aliyun.com/repository/spring-plugin" }
            maven { url "https://maven.aliyun.com/nexus/content/repositories/spring-plugin" }
            maven { url "https://repo.spring.io/plugins-release" }
        }
        dependencies {
            classpath("io.spring.gradle:propdeps-plugin:0.0.9.RELEASE")
            classpath("io.spring.gradle:docbook-reference-plugin:0.3.1")
            classpath("org.asciidoctor:asciidoctorj-pdf:1.5.0-alpha.16")
            classpath("org.asciidoctor:asciidoctorj-epub3:1.5.0-alpha.7")
        }
    }

    test {
            systemProperty("java.awt.headless", "true")
            systemProperty("testGroups", project.properties.get("testGroups"))
            scanForTestClasses = false
            include(["**/*Tests.class", "**/*Test.class"])
            // Since we set scanForTestClasses to false, we need to filter out inner
            // classes with the "$" pattern; otherwise, using -Dtest.single=MyTests to
            // run MyTests by itself will fail if MyTests contains any inner classes.
            exclude(["**/Abstract*.class", '**/*$*'])
            reports.junitXml.setDestination(file("$buildDir/test-results"))
        }

    repositories {
         mavenLocal()
         maven { url "https://maven.aliyun.com/repository/central" }
             maven { url "https://repo.spring.io/libs-release" }
    }

5. 打开源码文件夹，进入cmd.。执行gradlew :spring-oxm:compileTestJava命令。
    构建成功后，按照步骤Import into IntelliJ (File -> New -> Project from Existing Sources -> Navigate to directory -> Select build.gradle)
    成功将源项目导入idea中。
    

# <img src="src/docs/asciidoc/images/spring-framework.png" width="80" height="80"> Spring Framework

This is the home of the Spring Framework, the foundation for all
[Spring projects](https://spring.io/projects). Together the Spring Framework and the family of Spring projects make up what we call "Spring". 

Spring provides everything you need beyond the Java language to create enterprise
applications in a wide range of scenarios and architectures. Please read the
[Overview](https://docs.spring.io/spring/docs/current/spring-framework-reference/overview.html#spring-introduction)
section in the reference for a more complete introduction.

## Code of Conduct

This project is governed by the [Spring Code of Conduct](CODE_OF_CONDUCT.adoc).
By participating you are expected to uphold this code.
Please report unacceptable behavior to spring-code-of-conduct@pivotal.io.

## Access to Binaries

For access to artifacts or a distribution zip, see the
[Spring Framework Artifacts](https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-Artifacts)
wiki page.

## Documentation

The Spring Frameworks maintains reference documentation
([published](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/) and
[source](src/docs/asciidoc)),
Github [wiki pages](https://github.com/spring-projects/spring-framework/wiki), and an
[API reference](https://docs.spring.io/spring-framework/docs/current/javadoc-api/).
There are also [guides and tutorials](https://spring.io/guides) across Spring projects.

## Build from Source

See the [Build from Source](https://github.com/spring-projects/spring-framework/wiki/Build-from-Source)
wiki page and also [CONTRIBUTING.md](CONTRIBUTING.md).

## Stay in Touch

Follow [@SpringCentral](https://twitter.com/springcentral),
[@SpringFramework](https://twitter.com/springframework), and its
[team members](https://twitter.com/springframework/lists/team/members) on Twitter.
In-depth articles can be found at [The Spring Blog](https://spring.io/blog/),
and releases are announced via our [news feed](https://spring.io/blog/category/news).

## License

The Spring Framework is released under version 2.0 of the
[Apache License](https://www.apache.org/licenses/LICENSE-2.0).
