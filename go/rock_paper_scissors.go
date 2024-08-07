package main

import (
	"fmt"
	"math/rand"
)

var choices = [3]string{`
    _______
---'   ____)
      (_____)
      (_____)
      (____)
---.__(___)
`, `
    _______
---'   ____)____
          ______)
          _______)
         _______)
---.__________)
`, `
    _______
---'   ____)____
          ______)
       __________)
      (____)
---.__(___)
`,
}
var results = [][]string{
	{"It's a draw", "You lose", "You win"},
	{"You win", "It's a draw", "You lose"},
	{"You lose", "You win", "It's a draw"},
}

func main() {
	rockPaperScissors()
}

func rockPaperScissors() {
	var user_selection int
	fmt.Printf("What do you choose? Type 0 for Rock, 1 for Paper or 2 for Scissors. ")
	fmt.Scan(&user_selection)
	comparing_value := rand.Intn(2)

	if user_selection < 0 || user_selection > 2 {
		fmt.Println("ERROR: INVALID INPUT!")
		rockPaperScissors()
	} else {
		fmt.Println(choices[user_selection])
		fmt.Printf("Your computer chose:\n%s\n", choices[comparing_value])
		fmt.Println(results[user_selection][comparing_value])

		if results[user_selection][comparing_value] == "It's a draw" {
			rockPaperScissors()
		}
	}

}
