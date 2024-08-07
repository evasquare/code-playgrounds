namespace OutputColors;

class Program
{
    static void Main(string[] args)
    {
        Console.Write("Enter a color for your output (\"none\" by default): ");
        string? userInput = Console.ReadLine();

        Console.Write("Enter your output: ");
        string output = Console.ReadLine() ?? "";

        try
        {
            if (!string.IsNullOrEmpty(userInput) && userInput != "none")
            {
                ConsoleColor color = GetConsoleColor(userInput.ToLower());
                Console.ForegroundColor = color;
            }
        }
        catch (ArgumentException ex)
        {
            Console.WriteLine(ex.Message);
        }

        Console.WriteLine(output);
        Console.ResetColor();
    }

    static ConsoleColor GetConsoleColor(string colorName)
    {
        return colorName switch
        {
            "black" => ConsoleColor.Black,
            "darkblue" => ConsoleColor.DarkBlue,
            "darkgreen" => ConsoleColor.DarkGreen,
            "darkcyan" => ConsoleColor.DarkCyan,
            "darkred" => ConsoleColor.DarkRed,
            "darkmagenta" => ConsoleColor.DarkMagenta,
            "darkyellow" => ConsoleColor.DarkYellow,
            "gray" => ConsoleColor.Gray,
            "darkgray" => ConsoleColor.DarkGray,
            "blue" => ConsoleColor.Blue,
            "green" => ConsoleColor.Green,
            "cyan" => ConsoleColor.Cyan,
            "red" => ConsoleColor.Red,
            "magenta" => ConsoleColor.Magenta,
            "yellow" => ConsoleColor.Yellow,
            "white" => ConsoleColor.White,
            _ => throw new ArgumentException("Invalid color input. Please enter a valid color.")
        };
    }
}