package main

import (
	"fmt"
	"strconv"
)

func main() {
	fmt.Printf("Year: ")
	var year_input string
	fmt.Scan(&year_input)

	fmt.Printf("Month: ")
	var month_input string
	fmt.Scan(&month_input)

	year, err := strconv.Atoi(year_input)
	if err != nil {
		fmt.Println("Error parsing year.")
	}

	month, err := strconv.Atoi(month_input)
	if err != nil {
		fmt.Println("Error parsing month.")
	}

	fmt.Printf("-> Output: %d\n", daysInMonth(year, month))

}

func isLeap(year int) bool {
	if year%4 == 0 {
		if year%100 == 0 {
			if year%400 == 0 {
				return true
			} else {
				return false
			}
		} else {
			return false
		}
	} else {
		return false
	}
}

func daysInMonth(year int, month int) int {
	month_days := []int{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
	is_leap_year := isLeap(year)

	if !is_leap_year {
		return month_days[month-1]
	} else {
		if month == 2 {
			return 29
		} else {
			return month_days[month-1]
		}
	}
}
