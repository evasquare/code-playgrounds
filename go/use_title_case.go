package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
	// "golang.org/x/text/cases"
	// "golang.org/x/text/language"
)

// func main() {
// 	reader := bufio.NewReader(os.Stdin)
// 	fmt.Print("Enter text: ")
// 	text, _ := reader.ReadString('\n')

// 	titleCaser := cases.Title(language.English)
// 	title_cased_input := titleCaser.String(text)

// 	fmt.Println(title_cased_input)
// }

/*
This is an implementation without `cases` dependency.
You can also use the commented function above.
*/
func main() {
	reader := bufio.NewReader(os.Stdin)
	fmt.Print("Enter text: ")
	text, _ := reader.ReadString('\n')

	title_cased_input := use_title_case(text)
	fmt.Println(title_cased_input)
}

func contains(slice []string, item string) bool {
	for _, a := range slice {
		if a == item {
			return true
		}
	}
	return false
}
func use_title_case(input string) string {
	var title_cased_input string
	var words = strings.Split(input, " ")

	for i, word := range words {
		if contains(articles[:], word) || contains(prepositions[:], word) {
			title_cased_input += strings.ToLower(word)
		} else {
			uppercased_first_letter := strings.ToUpper(string(word[0]))
			var the_other_letters string

			for i := 1; i < len(word); i++ {
				the_other_letters += string(word[i])
			}

			title_cased_input += uppercased_first_letter + the_other_letters
		}

		if i != len(words)-1 {
			title_cased_input += " "
		}
	}

	return title_cased_input
}

var articles = [...]string{
	"a",
	"an",
	"the",
}
var prepositions = [...]string{
	"about",
	"above",
	"across",
	"after",
	"against",
	"along",
	"amid",
	"among",
	"around",
	"at",
	"before",
	"behind",
	"below",
	"beneath",
	"beside",
	"between",
	"beyond",
	"by",
	"concerning",
	"considering",
	"despite",
	"down",
	"during",
	"except",
	"for",
	"from",
	"in",
	"inside",
	"into",
	"like",
	"near",
	"of",
	"on",
	"onto",
	"out",
	"outside",
	"over",
	"past",
	"regarding",
	"round",
	"since",
	"through",
	"to",
	"toward",
	"under",
	"until",
	"up",
	"with",
	"within",
	"without",
}
