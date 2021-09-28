package grpc.example.client;

public class App {
    public static void main(String[] args) {
        ExampleClient client = new ExampleClient("localhost", 6011);
        String replay = client.sayHello("zhousk");
        try {
            client.shutdown();
        } catch (InterruptedException e) {
            // logger.error("channel关闭异常：err={}", e.getMessage());
        }
        System.out.println(">>>>" + replay);
    }
}
