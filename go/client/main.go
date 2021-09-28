package main

import (
	"context"
	"fmt"
	"log"
	"os"

	example "github.com/qqtou/grpc-example/go/proto"
	"google.golang.org/grpc"
)

const (
	address     = "localhost:6011"
	defaultName = "world"
)

func main() {
	// Set up a connection to the server.
	conn, err := grpc.Dial(address, grpc.WithInsecure())
	if err != nil {
		log.Fatalf("did not connect: %v", err)
	}
	defer conn.Close()

	client := example.NewExampleClient(conn)
	name := defaultName
	if len(os.Args) > 1 && len(os.Args[1]) > 0 {
		name = os.Args[1]
	}

	req := &example.HelloRequest{Name: name}
	res, err := client.SayHello(context.Background(), req)
	if err != nil {
		log.Fatalf("client.SayHello: %v", err)
	}
	fmt.Printf("say hello successfully, replay: %s\n", res.Message)
}
