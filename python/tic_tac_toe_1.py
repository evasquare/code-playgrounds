import random
import math
import copy

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


def display_board(board: list[list[str]]) -> None:
    for item in board:
        print(item)


def check_win(board: list[list[str]], current_player: str) -> bool:
    checking_board = copy.deepcopy(board)

    for i, item_i in enumerate(checking_board):
        for j, item_j in enumerate(item_i):
            if item_j == current_player:
                checking_board[i][j] = "*"
            else:
                checking_board[i][j] = ""

    for case in winning_patterns:
        if checking_board == case:
            return True

    return False


# Define players
player_1 = "O"
player_2 = "X"

# Randomly select who starts first
current_player = random.choice([player_1, player_2])

board = [
    ["_", "_", "_"],
    ["_", "_", "_"],
    ["_", "_", "_"]
]
is_over = False

while not is_over:
    print()

    display_board(board)

    selected_place = int(input(
        f"* Select the place of your choice.\n* Current Player: {current_player}\n> "))

    # Validate input and get row and column number of choice
    if selected_place < 1 or selected_place > 9:
        print("* Select valid number: (Valid input range: 1~9)")
        continue
    row = math.ceil(selected_place / 3) - 1
    column = selected_place % 3 - 1
    if board[row][column] != "_":
        print("* This cell is already occupied.")
        continue

    board[row][column] = current_player

    # Check if the current player has won
    if check_win(board, current_player):
        print(f"* Winner is.. {current_player}")
        display_board(board)
        break

    # Check for a draw (no empty cells left)
    has_empty_place = False
    for item_1 in board:
        for item_2 in item_1:
            if item_2 == "_":
                has_empty_place = True
    if has_empty_place is False:
        print("* The game has ended in a draw!")
        break

    # Switch current player
    if current_player is player_1:
        current_player = player_2
    elif current_player is player_2:
        current_player = player_1
