package main

import "fmt"

func main() {
	var year int

	fmt.Printf("Type a number: ")
	fmt.Scan(&year)

	if year%4 == 0 {
		if year%100 != 0 && year%400 != 0 {
			fmt.Println("Leap year.")
		} else if year%100 == 0 {
			fmt.Println("Not leap year.")
		} else {
			fmt.Println("Leap year.")
		}
	} else {
		fmt.Println("Not leap year.")
	}
}
