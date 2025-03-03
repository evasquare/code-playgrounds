package lombokpractice;

record InnerCat(String name, float weight, int age) {

}


public class App {
    public static void main(String[] args) {
        var cat = new Cat();
        cat.getAge();
        System.out.println(cat);

        var cat2 = new InnerCat("Tom", 5.0f, 3);
        System.out.println(cat2);
    }
}
