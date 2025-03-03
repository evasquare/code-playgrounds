/*
 * Original code source:
 * https://www.udemy.com/course/spring-5-with-spring-boot-2/
 */

class Program {
    public static void main(String[] var0) {
        QuestionService service = new QuestionService();
        service.playQuiz();
        service.printScore();
    }
}
