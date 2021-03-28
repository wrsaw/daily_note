### 安装使用nexus3

- 下载解压
- /bin目录下执行./nexus.exe /run

- http://127.0.0.1:8081/

### 配置Maven从Nexus下载构件

- POM文件配置

```xml
<project>
	...
    <repositories>
    	<repository>
        	<id>nexus</id>
            <name>Nexus</name>
            <url>http://localhost:8081/nuxus/content/groups/public/</url>
            <releases>
            	<enabled>true</enabled>
            </releases>
            <snapshots>
            	<enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>
    <pluginRepositories>
    	<pluginRepository>
        	<id>nexus</id>
            <name>Nexus</name>
            <url>http://localhost:8081/nuxus/content/groups/public/</url>
            <releases>
            	<enabled>true</enabled>
            </releases>
            <snapshots>
            	<enabled>true</enabled>
            </snapshots>
        </pluginRepository>
    </pluginRepositories>
    ...
</project>
```

- settings.xml配置

```xml
<settings>
	...
    <profiles>
    	<profile>
        	<id>nexus</id>
            <repositories>
                <repository>
                    <id>nexus</id>
                    <name>Nexus</name>
                	<url>http://localhost:8081/nuxus/content/groups/public/</url>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                </repository>
            </repositories>
            <pluginRepositories>
                <pluginRepository>
                    <id>nexus</id>
                    <name>Nexus</name>
                    <url>http://localhost:8081/nuxus/content/groups/public/</url>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                </pluginRepository>
            </pluginRepositories>
        </profile>
    </profiles>
    <activeProfiles>
    	<activeProfile>nexus</activeProfile>
    </activeProfiles>
    ...
</settings>
```

```xml
<settings>
	...
    <mirrors>
        <mirror>
        	<id>nexus</id>
            <mirrorOf>*</mirrorOf>
            <url>http://localhost:8081/nuxus/content/groups/public/</url>
        </mirror>
    </mirrors>
    <profiles>
    	<profile>
        	<id>nexus</id>
            <repositories>
                <repository>
                    <id>nexus</id>
                    <name>Nexus</name>
                	<url>http://localhost:8081/nuxus/content/groups/public/</url>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                </repository>
            </repositories>
            <pluginRepositories>
                <pluginRepository>
                    <id>nexus</id>
                    <name>Nexus</name>
                    <url>http://localhost:8081/nuxus/content/groups/public/</url>
                    <releases>
                        <enabled>true</enabled>
                    </releases>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                </pluginRepository>
            </pluginRepositories>
        </profile>
    </profiles>
    <activeProfiles>
    	<activeProfile>nexus</activeProfile>
    </activeProfiles>
    ...
</settings>
```

### 部署构件至Nexus

```xml
<project>
	...
    <distributionManagement>
        <repository>
        	<id>nexus-release</id>
            <name>Nexus Release Repository</name>
            <url>http://localhost:8081/nuxus/content/groups/release/</url>
        </repository>
    	<snapshotRepository>
        	<id>nexus-snapshot</id>
            <name>Nexus Snapshot Repository</name>
            <url>http://localhost:8081/nuxus/content/groups/snapshot/</url>
        </snapshotRepository>
    </distributionManagement>
    ...
</project>
```

```xml
<setting>
	...
    <servers>
    	<server>
        	<id>nexus-release</id>
            <userName>admin</userName>
            <password>test</password>
        </server>
        <server>
        	<id>nexus-snapshot</id>
            <userName>admin</userName>
            <password>test</password>
        </server>
    </servers>
</setting>
```

