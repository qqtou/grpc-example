package grpc.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(value = "by gRPC proto compiler (version 1.9.0)", comments = "Source: example.proto")
public final class ExampleGrpc {

  private ExampleGrpc() {
  }

  public static final String SERVICE_NAME = "Example";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getSayHelloMethod()} instead.
  public static final io.grpc.MethodDescriptor<grpc.example.grpc.ExampleOuterClass.HelloRequest, grpc.example.grpc.ExampleOuterClass.HelloReplay> METHOD_SAY_HELLO = getSayHelloMethod();

  private static volatile io.grpc.MethodDescriptor<grpc.example.grpc.ExampleOuterClass.HelloRequest, grpc.example.grpc.ExampleOuterClass.HelloReplay> getSayHelloMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<grpc.example.grpc.ExampleOuterClass.HelloRequest, grpc.example.grpc.ExampleOuterClass.HelloReplay> getSayHelloMethod() {
    io.grpc.MethodDescriptor<grpc.example.grpc.ExampleOuterClass.HelloRequest, grpc.example.grpc.ExampleOuterClass.HelloReplay> getSayHelloMethod;
    if ((getSayHelloMethod = ExampleGrpc.getSayHelloMethod) == null) {
      synchronized (ExampleGrpc.class) {
        if ((getSayHelloMethod = ExampleGrpc.getSayHelloMethod) == null) {
          ExampleGrpc.getSayHelloMethod = getSayHelloMethod = io.grpc.MethodDescriptor.<grpc.example.grpc.ExampleOuterClass.HelloRequest, grpc.example.grpc.ExampleOuterClass.HelloReplay>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName("Example", "SayHello")).setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils
                  .marshaller(grpc.example.grpc.ExampleOuterClass.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils
                  .marshaller(grpc.example.grpc.ExampleOuterClass.HelloReplay.getDefaultInstance()))
              .setSchemaDescriptor(new ExampleMethodDescriptorSupplier("SayHello")).build();
        }
      }
    }
    return getSayHelloMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ExampleStub newStub(io.grpc.Channel channel) {
    return new ExampleStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output
   * calls on the service
   */
  public static ExampleBlockingStub newBlockingStub(io.grpc.Channel channel) {
    return new ExampleBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the
   * service
   */
  public static ExampleFutureStub newFutureStub(io.grpc.Channel channel) {
    return new ExampleFutureStub(channel);
  }

  /**
   */
  public static abstract class ExampleImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHello(grpc.example.grpc.ExampleOuterClass.HelloRequest request,
        io.grpc.stub.StreamObserver<grpc.example.grpc.ExampleOuterClass.HelloReplay> responseObserver) {
      asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(getSayHelloMethod(), asyncUnaryCall(
              new MethodHandlers<grpc.example.grpc.ExampleOuterClass.HelloRequest, grpc.example.grpc.ExampleOuterClass.HelloReplay>(
                  this, METHODID_SAY_HELLO)))
          .build();
    }
  }

  /**
   */
  public static final class ExampleStub extends io.grpc.stub.AbstractStub<ExampleStub> {
    private ExampleStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExampleStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExampleStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(grpc.example.grpc.ExampleOuterClass.HelloRequest request,
        io.grpc.stub.StreamObserver<grpc.example.grpc.ExampleOuterClass.HelloReplay> responseObserver) {
      asyncUnaryCall(getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ExampleBlockingStub extends io.grpc.stub.AbstractStub<ExampleBlockingStub> {
    private ExampleBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExampleBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExampleBlockingStub(channel, callOptions);
    }

    /**
     */
    public grpc.example.grpc.ExampleOuterClass.HelloReplay sayHello(
        grpc.example.grpc.ExampleOuterClass.HelloRequest request) {
      return blockingUnaryCall(getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ExampleFutureStub extends io.grpc.stub.AbstractStub<ExampleFutureStub> {
    private ExampleFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExampleFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExampleFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.example.grpc.ExampleOuterClass.HelloReplay> sayHello(
        grpc.example.grpc.ExampleOuterClass.HelloRequest request) {
      return futureUnaryCall(getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;

  private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ExampleImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ExampleImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((grpc.example.grpc.ExampleOuterClass.HelloRequest) request,
              (io.grpc.stub.StreamObserver<grpc.example.grpc.ExampleOuterClass.HelloReplay>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ExampleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExampleBaseDescriptorSupplier() {
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.example.grpc.ExampleOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Example");
    }
  }

  private static final class ExampleFileDescriptorSupplier extends ExampleBaseDescriptorSupplier {
    ExampleFileDescriptorSupplier() {
    }
  }

  private static final class ExampleMethodDescriptorSupplier extends ExampleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ExampleMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ExampleGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ExampleFileDescriptorSupplier()).addMethod(getSayHelloMethod()).build();
        }
      }
    }
    return result;
  }
}
