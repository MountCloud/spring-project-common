# Note
  After creating a project, you often need to do some repetitive work, such as copying the public components from the previous project. This project extracts the most basic toolkit, and constrains the entity id and basic attributes, and constrains the data of the rest interface format.
  
# 描述
  在创建项目之后，经常需要做一些重复的工作，比如复制之前项目中的公共组件，这个项目将最基础的工具包提取了出来，并且约束了实体的id以及基础属性，约束了rest接口的数据格式。
  
# Use 使用

```
<dependency>
	<groupId>org.mountcloud</groupId>
	<artifactId>spring-project-common</artifactId>
	<version>1.1</version>
</dependency>
```

# Files 文件列表

```
.
├── .gitignore
├── pom.xml
├── README.md
└── src
    └── main
        └── java
            └── org
                ├── mountcloud
                │   └── springproject
                │       └── common
                │           ├── entity 
                │           │   ├── annotation
                │           │   │   └── EntityId.java
                │           │   └── BaseEntity.java
                │           ├── result
                │           │   ├── PageBean.java
                │           │   ├── RestfulResult.java
                │           │   └── ResultData.java
                │           └── util
                │               ├── BigDecimalUtil.java
                │               ├── ExceptionUtil.java
                │               ├── GsonUtil.java
                │               ├── GZipUtils.java
                │               ├── HttpParam.java
                │               ├── ListUtil.java
                │               ├── LockUtil.java
                │               ├── LoggerUtil.java
                │               ├── MapUtil.java
                │               ├── ObjectUtil.java
                │               ├── OSUtils.java
                │               ├── part
                │               │   ├── Part.java
                │               │   ├── PartPageInfo.java
                │               │   └── PartUtil.java
                │               ├── ResultUtil.java
                │               ├── ReTryUtil.java
                │               ├── StringUtil.java
                │               ├── UUIDUtil.java
                │               └── WaitUtil.java
                └── springframework
                    └── data
                        └── annotation
                            └── Transient.java
```



