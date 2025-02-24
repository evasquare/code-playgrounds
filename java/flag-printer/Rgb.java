public class Rgb {
    private String colorString;

    public Rgb(int r, int g, int b) {
        this.colorString = "\033[38;2;" + r + ";" + g + ";" + b + "m";
    }

    public String getColorString() {
        return colorString;
    }
}