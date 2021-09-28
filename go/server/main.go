package main

import (
	"context"
	"fmt"
	"log"
	"net"
	"os"
	"strconv"

	example "github.com/qqtou/grpc-example/go/proto"
	"google.golang.org/grpc"
	"google.golang.org/grpc/reflection"
)

var (
	port = 6012
)

type Server struct{}

// NewGRPCServer new a server struct to server interface
func NewGRPCServer() example.ExampleServer {
	return &Server{}
}

func (s *Server) SayHello(ctx context.Context, req *example.HelloRequest) (*example.HelloReplay, error) {
	fmt.Println(req.Name)
	return &example.HelloReplay{Message: fmt.Sprintf("Hello %s !!! from Golang", req.Name)}, nil
}

func main() {
	if len(os.Args) > 1 && len(os.Args[1]) > 0 {
		var err error
		port, err = strconv.Atoi(os.Args[1])
		if err != nil {
			fmt.Printf("strconv.Atoi(os.Args[1][%s]) err:%s\n", os.Args[1], err.Error())
			return
		}
	}

	address := fmt.Sprintf(":%d", port)
	fmt.Println("start a server on", address)

	lis, err := net.Listen("tcp", address)
	if err != nil {
		log.Fatal("fail to listen")
	}

	s := grpc.NewServer()
	example.RegisterExampleServer(s, NewGRPCServer())

	reflection.Register(s)
	if err := s.Serve(lis); err != nil {
		log.Fatal("fail to server")
	}
}
