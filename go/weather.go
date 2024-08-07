package main

import (
	"encoding/json"
	"fmt"
	"net/http"
	"time"
)

// Tutorial: https://youtu.be/B9uR2gLM80E

const apiKey = ""

/*
An interface type specifies a method set called its interface.
A variable of interface type can store a value of any type with
a method set that is any superset of the interface. Such a type is
said to implement the interface.
*/
func fetchWeather(city string) interface{} {
	// Anonymous struct
	var data struct {
		Main struct {
			Temp float64 `json:"temp"`
		} `json:"main"`
	}

	// Sprintf formats according to a format specifier and returns the resulting string.
	url := fmt.Sprintf("http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s", city, apiKey)
	resp, err := http.Get(url)

	if err != nil {
		fmt.Printf("Error fetching weather for %s: %s\n", city, err)
		return data
	}

	/*
		A defer statement defers the execution of a function
		until the surrounding function returns.

		The deferred call's arguments are evaluated immediately,
		but the function call is not executed until the surrounding function returns.
	*/
	defer resp.Body.Close()

	if err := json.NewDecoder(resp.Body).Decode(&data); err != nil {
		fmt.Printf("Error decoding weather data for %s: %s\n", city, err)
		return data
	}

	return data
}

func main() {
	startNow := time.Now()
	cities := []string{"Toronto", "London", "Paris", "Tokyo"}

	for _, city := range cities {
		data := fetchWeather(city)

		fmt.Println("This is the data", data)
	}

	fmt.Println("This operation took:", time.Since(startNow))
}
