package grpc.example.server;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExampleServer server = new ExampleServer();
        server.Start();
        server.blockUntilShutdown();
    }
}
