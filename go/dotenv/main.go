package main

import (
	"fmt"
	"github.com/joho/godotenv"
	"os"
)

func main() {
	godotenv.Load(".env")
	value := os.Getenv("TEST")

	fmt.Println("The value of TEST:", value)
}
