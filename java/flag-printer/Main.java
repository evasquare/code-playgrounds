import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        System.out.println();

        System.out.println("Choose your option.");

        int index = 1;
        for (var item : Flags.values()) {
            System.out.println(index + ". " + item.getName());
            index++;
        }

        int option;
        try (var reader = new Scanner(System.in)) {
            option = Integer.parseInt(reader.nextLine().trim());
            reader.close();
        }

        if (option > index || option < 1) {
            throw new RuntimeException("Invalid input.");
        }

        var flag = Flags.values()[option - 1];
        for (var color : flag.getColors()) {
            for (int i = 0; i < 20; i++) {
                System.out.print(color.getColorString() + "#");
            }
            System.out.print("\n");
        }

        System.out.println();
        System.out.println();
    }
}
