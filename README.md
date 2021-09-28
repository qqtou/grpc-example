# grpc-example  
示例为Golang和Java的GRPC接口互相调用示例

## 环境
- 运行环境为Windows
- 安装Golang和Java运行环境
- 安装proto、gogofaster、protoc-gen-grpc-java  
    - 把protoc和protoc-gen-grpc-java放到C:\Windows\System32\目录下
    - gogofaster.exe可放到GOPATH目录下

## go  
- client（Go语言的GRPC客户端示例）
- server（Go语言的GRPC服务端示例）
- proto（Go语言的proto pb文件）

### 在根目录下执行命令：
```
    # 生成Go的pb文件，生成文件的目录为go\proto
    protoc --gogofaster_out=plugins=grpc:. .\proto\example.proto
```
## Java
- client（Java的GRPC客户端示例）
    - 包（java\src\main\java\grpc\example\client）
- grpc（Java的proto生成文件）
    - 包（java\src\main\java\grpc\example\grpc）
- server（Java的GRPC服务器端示例）
    - 包（java\src\main\java\grpc\example\server）

### 生成基础类
```
    # 生成Java类文件，生成文件的目录为java\src\main\java\grpc\example\grpc
    protoc -I proto --plugin=protoc-gen-grpc-java=protoc-gen-grpc-java --java_out=java/src/main/java  proto/example.proto
```
### 生成server类
```
    # 生成Java服务类文件，生成文件的目录为java\src\main\java\grpc\example\grpc
    protoc -I proto --plugin=protoc-gen-grpc-java=C:\Windows\System32\protoc-gen-grpc-java.exe --grpc-java_out=java/src/main/java proto/example.proto
```

## 测试
### Go语言GRPC服务器
- 启动服务
```
    # 在go\server目录下
    go run main.go
    # 自定义启动端口号
    go run main.go 6012
```
- 使用Java客户端访问
```
    # 在java\src\main\java\grpc\example\client目录下的
    # App.java中修改端口号为6012
    # 点击main函数上的debug进行测试

```
- 使用Go客户端访问
```
    # 在go\client目录下的main.go中，修改端口号为6012
    go run main.go
```

### Java语言的GRPC服务器
- 启动服务
```
    # 在java\src\main\java\grpc\example\server目录下的
    # App.java中点击main函数上的run启动服务
    # 默认端口号为6011，在当前目录下的ExampleServer.java修改端口号
```

- 使用Java客户端访问
```
    # 在java\src\main\java\grpc\example\client目录下的
    # App.java中修改端口号为6011
    # 点击main函数上的debug进行测试
```

- 使用Go客户端访问
```
    # 在go\client目录下的main.go中，修改端口号为6011
    go run main.go
```
