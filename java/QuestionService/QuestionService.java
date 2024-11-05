import java.util.Scanner;

public class QuestionService {
    Question[] questions = new Question[5];
    String[] selections = new String[5];

    public QuestionService() {
        questions[0] = new Question(
                0,
                "What are we learning?",
                "Java",
                "C++",
                "Python",
                "C#",
                "1");
        questions[1] = new Question(
                1,
                "What is Wordpress?",
                "CDN",
                "CMS",
                "Programming Language",
                "Operating System",
                "2");
        questions[2] = new Question(
                2,
                "Who created Undertale?",
                "Toby Fox",
                "Tim Cook",
                "Lena Raine",
                "Steve Jobs",
                "1");
        questions[3] = new Question(
                3,
                "What does 'Was?' mean in German?",
                "Hello?",
                "Who are you?",
                "What?",
                "What do I call it?",
                "3");
        questions[4] = new Question(
                4,
                "Which one is a Germanic language?",
                "French",
                "English",
                "Japanese",
                "Spanish",
                "2");
    }

    public void playQuiz() {
        int i = 0;

        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            System.out.println(String.format(
                    "Question No. %d", question.getId()));
            System.out.println(question.getQuestion());

            System.out.println(String.format(
                    "1) %s", question.getOption1()));
            System.out.println(String.format(
                    "2) %s", question.getOption2()));
            System.out.println(String.format(
                    "3) %s", question.getOption3()));
            System.out.println(String.format(
                    "4) %s", question.getOption4()));


            selections[i] = scanner.nextLine();

            i++;
        }
        scanner.close();

        // for (String selection : selections) {
        // System.out.println(selection);
        // }
    }

    public void printScore() {
        int score = 0;
        for (int i = 0; i < questions.length; i++) {
            Question question = questions[i];
            String correctAnswer = question.getAnswer();
            String userAnswer = selections[i];

            if (correctAnswer.equals(userAnswer)) {
                score++;
            }
        }

        System.out.println(String.format(
                "Your score is: %d/5", score));
    }
}
