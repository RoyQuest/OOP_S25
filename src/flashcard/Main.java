package flashcard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    private FlashcardDeck deck = new FlashcardDeck();
    private Label questionLabel = new Label();
    private Label answerLabel = new Label();

    @Override
    public void start(Stage stage) {
        // Add sample flashcards
        deck.addCard(new Flashcard("What is Gils Last Name?", "Salu"));
        deck.addCard(new Flashcard("Who is the best at OOP?", "Roy"));
        deck.addCard(new Flashcard("On a scale of 1-10 how good is this project?", "10"));

        // UI Buttons
        Button showAnswerBtn = new Button("Show Answer");
        Button nextBtn = new Button("Next");

        showAnswerBtn.setOnAction(e -> {
            Flashcard current = deck.getCurrentCard();
            answerLabel.setText(current.getAnswer());
        });

        nextBtn.setOnAction(e -> {
            Flashcard next = deck.nextCard();
            questionLabel.setText(next.getQuestion());
            answerLabel.setText("");
        });

        // Show first card
        Flashcard first = deck.getCurrentCard();
        questionLabel.setText(first.getQuestion());

        VBox root = new VBox(10, questionLabel, answerLabel, showAnswerBtn, nextBtn);
        root.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-font-size: 14px;");
        Scene scene = new Scene(root, 400, 200);

        stage.setScene(scene);
        stage.setTitle("Flashcard Quiz App");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

