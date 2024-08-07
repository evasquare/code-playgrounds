package main

import (
	"encoding/json"
	"fmt"
	"net/http"
	"sync"
	"time"
)

/*
# References
- Tutorial: https://youtu.be/B9uR2gLM80E
- Goroutines: https://go.dev/tour/concurrency/1
- Go by Example: https://gobyexample.com/goroutines
*/

const apiKey = ""

/*
ChatGPT:
ch chan<- string is a send-only channel of strings in Go.

Channels are the pipes that connect concurrent goroutines.
You can send values into channels from one goroutine
and receive those values into another goroutine.

The chan<- syntax means that this channel is send-only,
meaning you can only send data to it, but not receive data from it.
This is a way to enforce certain usage patterns when using channels.

In the context of the fetchWeather function,
`ch chan<- string` is used to send a string message to another
goroutine which is responsible for receiving and processing this message.
*/
func fetchWeather(city string, ch chan<- string, wg *sync.WaitGroup) interface{} {
	// Anonymous struct
	var data struct {
		Main struct {
			Temp float64 `json:"temp"`
		} `json:"main"`
	}

	defer wg.Done()

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

	ch <- fmt.Sprintf("This is the %s", city)

	return data
}

func main() {
	startNow := time.Now()
	cities := []string{"Toronto", "London", "Paris", "Tokyo"}

	ch := make(chan string)
	var wg sync.WaitGroup

	for _, city := range cities {
		/*
			This is done to tell the WaitGroup that there's
			one more goroutine it needs to wait for.
		*/
		wg.Add(1)
		go fetchWeather(city, ch, &wg)

		/*
			This goroutine waits for the WaitGroup counter to
			reach 0 with `wg.Wait()`, meaning all fetchWeather
			goroutines have finished, and then it closes the ch channel.
		*/
		go func() {
			wg.Wait()
			close(ch)
		}()

		for result := range ch {
			fmt.Println(result)
		}
	}

	fmt.Println("This operation took:", time.Since(startNow))
}
