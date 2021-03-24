### 测试

`mvn test`

自动执行测试源码路径（src/test/java）下符合命名模式的测试类：

- **/Test *.java

- ** / *Test.java
- **/ *TestCase.java

### 跳过测试

`mvn package -DskipTests`

### 指定测试类

`mvn test -Dtest=Hello*ld`

### 包含与排除测试用例

```xml
<plugin>
	<groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>2.5</version>
    <configuration>
    	<includes>
        	<include>**/*HelloWorld2.java</include>
        </includes>
        <excludes>
        	<exclude>**/Hello*Test.java</exclude>
        </excludes>
    </configuration>
</plugin>
```

### 测试报告

target/surefire-reports目录下