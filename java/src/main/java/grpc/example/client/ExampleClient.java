package grpc.example.client;

import java.util.concurrent.TimeUnit;

import grpc.example.grpc.ExampleGrpc;
import grpc.example.grpc.ExampleOuterClass;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ExampleClient {
    private final ManagedChannel channel;
    private final ExampleGrpc.ExampleBlockingStub blockingStub;

    public ExampleClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port).usePlaintext());
    }

    private ExampleClient(ManagedChannelBuilder<?> channelBuilder) {
        channel = channelBuilder.build();
        blockingStub = ExampleGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public String sayHello(String name) {
        ExampleOuterClass.HelloRequest req = ExampleOuterClass.HelloRequest.newBuilder().setName(name).build();
        ExampleOuterClass.HelloReplay replay = blockingStub.sayHello(req);
        return replay.getMessage();
    }
}
