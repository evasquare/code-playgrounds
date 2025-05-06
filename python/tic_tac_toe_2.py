import random
import math
import copy


class TicTacToe:
    def __init__(self):
        # Define players
        self.player_1 = "O"
        self.player_2 = "X"

        # This variable decides when to end the loop.
        self.is_finished = False

        self.board = [
            ["_", "_", "_"],
            ["_", "_", "_"],
            ["_", "_", "_"]
        ]
    
        # Randomly select who starts first
        self.current_player = random.choice([self.player_1, self.player_2])

    def start(self):
        while not self.is_finished:
            print()
            self.display_board()

            selected_place = int(input(
                f"* Select the place of your choice.\n* Current Player: {self.current_player}\n> "))

            # Validate input and get row and column number the user chose.
            if selected_place < 1 or selected_place > 9:
                print("* Select valid number: (Valid input range: 1~9)")
                continue
            row = math.ceil(selected_place / 3) - 1
            column = selected_place % 3 - 1
            if self.board[row][column] != "_":
                print("* This cell is already occupied.")
                continue

            self.board[row][column] = self.current_player

            # Check if the current player has won
            if self.is_win():
                print(f"* Winner is.. {self.current_player}")
                self.display_board()
                break

            # Check for a draw (no empty cells left)
            has_empty_place = False
            for item_1 in self.board:
                for item_2 in item_1:
                    if item_2 == "_":
                        has_empty_place = True
            if has_empty_place is False:
                print("* The game has ended in a draw!")
                break

            self.switch_player()


    def display_board(self) -> None:
        for item in self.board:
            print(item)

    def switch_player(self):
        # Switch current player
        if self.current_player is self.player_1:
            self.current_player = self.player_2
        elif self.current_player is self.player_2:
            self.current_player = self.player_1

    def is_win(self) -> bool:
        checking_board = copy.deepcopy(self.board)

        for i, item_i in enumerate(checking_board):
            for j, item_j in enumerate(item_i):
                if item_j == self.current_player:
                    checking_board[i][j] = "*"
                else:
                    checking_board[i][j] = ""

        for case in self.winning_patterns:
            if checking_board == case:
                return True

        return False

    winning_patterns = [
        [
            ["*", "*", "*"],
            ["", "", ""],
            ["", "", ""],
        ],
        [
            ["", "", ""],
            ["*", "*", "*"],
            ["", "", ""],
        ],
        [
            ["", "", ""],
            ["", "", ""],
            ["*", "*", "*"],
        ],
        [
            ["", "*", ""],
            ["", "*", ""],
            ["", "*", ""],
        ],
        [
            ["", "", "*"],
            ["", "", "*"],
            ["", "", "*"],
        ],
        [
            ["*", "", ""],
            ["", "*", ""],
            ["", "", "*"],
        ],
        [
            ["", "", "*"],
            ["", "*", ""],
            ["*", "", ""],
        ],
    ]



tic_tac_toe = TicTacToe()
tic_tac_toe.start()