using System.Text;

namespace breaker;

class Breaker
{
    string? Contents;
    int MaxLineLength;
    string? Output;

    public string GetOutput()
    {
        try
        {
            ReadContents();
            if (string.IsNullOrEmpty(Contents)) return "";
            ReadMaxLineLength();
            GenerateOutput(Contents.Split(new char[] { ' ', '\n' }));
        }
        catch (ArgumentException ex)
        {
            Console.WriteLine($"Input Error: {ex}");
        }
        catch (IOException ex)
        {
            Console.WriteLine($"File Error: {ex}");
        }
        catch (Exception ex)
        {
            Console.WriteLine($"Unexpected Error: {ex}");
        }

        return Output ?? "";
    }

    private void ReadContents()
    {
        Console.Write("> Enter Absolute File Path: ");
        var userInput = Console.ReadLine();

        if (string.IsNullOrEmpty(userInput))
        {
            throw new ArgumentNullException("File path cannot be empty!");
        }

        try
        {
            Contents = File.ReadAllText(userInput);
        }
        catch (Exception ex)
        {
            throw new IOException("An error occurred while reading the file.", ex);
        }
    }

    private void ReadMaxLineLength()
    {
        Console.Write("> Set max line length: ");
        var userInput = Console.ReadLine();

        if (string.IsNullOrEmpty(userInput))
        {
            throw new ArgumentNullException("Max line length cannot be empty!");
        }

        if (!int.TryParse(userInput, out this.MaxLineLength) || this.MaxLineLength <= 0)
        {
            throw new ArgumentException("Max line length must be a positive integer.");
        }
    }

    private void GenerateOutput(string[] splittedContents)
    {
        if (splittedContents.Length == 0)
        {
            return;
        }

        var builder = new StringBuilder();
        var outputList = new List<string>();
        var lastItem = splittedContents.Last();

        foreach (var item in splittedContents)
        {
            if (builder.Length != 0)
            {
                builder.Append(" ");
            }
            builder.Append(item);

            bool isLast = lastItem == item;
            if (isLast || builder.Length > MaxLineLength)
            {
                outputList.Add(builder.ToString());
                builder = new StringBuilder();
            }
        }

        Output = string.Join("\n", outputList);
    }
}