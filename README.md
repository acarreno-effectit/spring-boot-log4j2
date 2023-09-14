# spring-boot-log4j2

### Example Project to configure Log files.

---
### 1. Exclude default library:
```XML
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
    <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-logging</artifactId>
        </exclusion>
    </exclusions>
</dependency>
``` 
---
### 2. Add Log4j2 library:
```XML
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-log4j2</artifactId>
</dependency>
```
### 3. If the configuration file is in format .yaml is necessary to add the following libraries:
```XML
<dependency>
    <groupId>com.fasterxml.jackson.dataformat</groupId>
    <artifactId>jackson-dataformat-yaml</artifactId>
</dependency>
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
</dependency>
```
### 4. Creation of configuration file:
```YAML
Configuration:
  name: Default
  Properties:
    Property:
    - name: pattern
      value: '[Thread: %tid] %d{HH:mm:ss.SSS} [%logger{36}] %-5level - %msg%n' # Pattern of each log line
    - name: path
      value: logs # Route of Log Files
  Appenders: # Configuration of Appender, it's possible to configure differents appenders
    Console:
      name: Console
      target: SYSTEM_OUT
      PatternLayout:
        pattern: ${pattern}
    RollingFile:
      name: RollingFile
      fileName: ${path}/app.log
      filePattern: ${path}/archive/app.%d{yyyy-MM-dd}.%i.log
      PatternLayout:
        pattern: ${pattern}
      Policies:
        SizeBasedTriggeringPolicy:
          size: 10 MB
      DefaultRollOverStrategy:
        max: 30
  Loggers:
    Logger:
    - name: com.spring.boot.log4j2 # Package
      additivity: false
      level: trace
      AppenderRef:
      - ref: Console
        level: debug # Level to print for console appender
      - ref: RollingFile
        level: info # # Level to print for rolling appender
    Root:
      AppenderRef:
      - ref: Console
```