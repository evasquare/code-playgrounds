package main

import (
	"fmt"
	"math/rand"
	"strings"
)

func main() {
	fmt.Print("\033[H\033[2J") // Clear terminal
	fmt.Println(logo)

	end_of_game := false
	lives := 6

	chosen_word := word_list[rand.Intn(len(word_list)-1)]

	// fmt.Printf("(Psst, here's the answer: %s)\n", chosen_word)

	display := []string{}
	for i := 0; i < len(chosen_word); i++ {
		display = append(display, "_")
	}

	for !end_of_game {
		fmt.Print("Guess a letter: ")
		var user_guess string
		fmt.Scan(&user_guess)
		user_guess = strings.ToLower(user_guess)

		fmt.Print("\033[H\033[2J") // Clear terminal

		letter_found := false

		if len(user_guess) == 1 {
			for i := 0; i < len(display); i++ {
				if display[i] == user_guess {
					fmt.Printf("> MESSAGE: You've already guessed %s\n", user_guess)
					break
				}
			}

			// Check `user_guess` letter
			for i := 0; i < len(chosen_word); i++ {
				checking_letter := string(chosen_word[i])

				if user_guess == checking_letter {
					if !letter_found {
						letter_found = true
					}

					display[i] = checking_letter
				}
			}
		} else {
			fmt.Println("> MESSAGE: Please enter a single character.")
		}

		// Check if the user guess is in the chosen word.
		{
			item_found := false
			for _, item := range display {
				if item == "_" {
					item_found = true
				}
			}
			if !item_found {
				end_of_game = true
				fmt.Println("You win.")
			}

			if !letter_found {
				fmt.Printf("> MESSAGE: You guessed '%s', that's not in the word. You lose a life.\n", user_guess)
				lives -= 1

				if lives == 0 {
					end_of_game = true
					fmt.Println("You lose.")
				}

				fmt.Println()
			}
		}

		fmt.Printf("%s\n", strings.Join(display, " ")) // Draw `display`
		fmt.Println(stages[lives])                     // Draw hangman

	}
}
