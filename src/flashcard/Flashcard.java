package flashcard;

public class Flashcard extends Card {
    private String answer;

    public Flashcard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }
}
