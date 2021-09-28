package grpc.example.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class ExampleServer {
    private int port;
    private Server server;

    public ExampleServer() {
        this.port = 6011;
    }

    public ExampleServer(int _port) {
        this.port = _port;
    }

    public void Start() throws IOException {
        this.server = ServerBuilder.forPort(port).addService(new ExampleImpl()).build().start();
        System.err.println("Server started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {

            @Override
            public void run() {
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                ExampleServer.this.stop();
                System.err.println("*** server shut down");
            }
        });
    }

    public void stop() {
        if (this.server != null) {
            this.server.shutdown();
        }
    }

    // block 一直到退出程序
    public void blockUntilShutdown() throws InterruptedException {
        if (this.server != null) {
            this.server.awaitTermination();
        }
    }
}
