Nicotine [![License](https://img.shields.io/github/license/CKATEPTb/Nicotine)](https://github.com/CKATEPTb/Nicotine/blob/master/LICENSE)
[![Discord](https://img.shields.io/discord/925686623222505482.svg?label=&logo=discord&logoColor=ffffff&color=7389D8&labelColor=6A7EC2)](https://discord.gg/P7FaqjcATp)
[![Release](https://jitpack.io/v/ru.ckateptb/Nicotine.svg)](https://jitpack.io/#ru.ckateptb/Nicotine)
===========

Annotation based IoC/DI implementation like spring

Features
------
- [x] Annotation based Component/Bean registration
- [x] Automatic Listener registration
- [x] Support Async/Sync Bukkit Scheduler
- [x] PostConstruct implementation
- [x] Autowired and Qualifier

How To
------
* Maven Repo:
```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>
```
* Artifact Information:
```xml
<dependency>
    <groupId>ru.ckateptb</groupId>
    <artifactId>Nicotine</artifactId>
    <version>{{version}}</version>
</dependency>
 ```

**Or alternatively**

***with Gradle***:
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'ru.ckateptb:Nicotine:{{version}}'
}
```
***with Kotlin:***
```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("ru.ckateptb:Nicotine:{{version}}")
}
```

Usage
------

To initialize all components use the init method in onEnable of your plugin

```java
public final class MyPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        IoC.init(this, s -> !s.contains("do.not.scan.this.package.recursive") && !s.contains("do.not.scan.other.package.recursive"));
    }
}
```

To get an instance of a class use

```java
    IoC.get(MyClass.class);
```

An example of full use

```java
public final class MyPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        IoC.init(this);
    }
}

@Component
public class MyComponent {
    public String getWord() {
        return "Hello";
    }
}

@Component
public class MyOtherComponent {
    public String getWorld() {
        return "World";
    }
}

@Component
public class FinalComponent {
    public FinalComponent(MyComponent component, MyOtherComponent otherComponent) {
        System.out.println(component.getWord() + " " + otherComponent.getWorld());
    }
}
```

Output

```text
Hello World
```

To understand how [other annotations](https://github.com/CKATEPTb/Nicotine/tree/master/src/main/java/ru/ckateptb/nicotine/annotation) work, look for the Spring documentation.