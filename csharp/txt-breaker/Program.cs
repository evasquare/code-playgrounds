namespace breaker;

class Program
{
    static void Main(string[] args)
    {
        var breaker = new Breaker();
        var output = breaker.GetOutput();
        Console.WriteLine(output);
    }
}
