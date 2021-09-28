package grpc.example.server;

import grpc.example.grpc.ExampleGrpc;
import grpc.example.grpc.ExampleOuterClass.HelloReplay;
import grpc.example.grpc.ExampleOuterClass.HelloRequest;

public class ExampleImpl extends ExampleGrpc.ExampleImplBase {
    @Override
    public void sayHello(HelloRequest request, io.grpc.stub.StreamObserver<HelloReplay> responseObserver) {
        System.err.println("request name: " + request.getName());
        HelloReplay replay = HelloReplay.newBuilder().setMessage("Hello " + request.getName() + " from Java !!!")
                .build();
        responseObserver.onNext(replay);
        responseObserver.onCompleted();
    }
}
