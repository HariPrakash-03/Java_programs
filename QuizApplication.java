import java.util.Scanner;

class Question {
    String question;
    String[] options;
    int correctAnswer; // index of the correct option

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean askQuestion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        System.out.print("Enter your answer (1-" + options.length + "): ");
        int userAnswer = scanner.nextInt();
        return (userAnswer - 1) == correctAnswer;
    }
}

public class QuizApplication {
    public static void main(String[] args) {
        Question[] questions = new Question[5];
        
        // Creating sample questions
        questions[0] = new Question("What is the capital of France?",
                new String[]{"Berlin", "Paris", "Madrid", "Rome"}, 1);
        questions[1] = new Question("Which planet is known as the Red Planet?",
                new String[]{"Earth", "Venus", "Mars", "Jupiter"}, 2);
        questions[2] = new Question("Who wrote 'To Kill a Mockingbird'?",
                new String[]{"Harper Lee", "Mark Twain", "Ernest Hemingway", "J.K. Rowling"}, 0);
        questions[3] = new Question("Which is the largest ocean on Earth?",
                new String[]{"Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"}, 3);
        questions[4] = new Question("In which year did the Titanic sink?",
                new String[]{"1910", "1912", "1914", "1916"}, 1);

        int score = 0;

        // Loop through all questions
        for (Question question : questions) {
            boolean isCorrect = question.askQuestion();
            if (isCorrect) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Wrong!\n");
            }
        }

        // Display final score
        System.out.println("Quiz Over!");
        System.out.println("Your score is: " + score + "/" + questions.length);
    }
}
