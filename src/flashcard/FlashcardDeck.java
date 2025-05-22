package flashcard;

import java.util.ArrayList;

public class FlashcardDeck {
    private ArrayList<Flashcard> cards = new ArrayList<>();
    private int currentIndex = 0;

    public void addCard(Flashcard card) {
        cards.add(card);
    }

    public Flashcard getCurrentCard() {
        if (cards.isEmpty()) {
            return new Flashcard("No flashcards available!", "Please add some cards.");
        }
        return cards.get(currentIndex);
    }

    public Flashcard nextCard() {
        if (!cards.isEmpty()) {
            currentIndex = (currentIndex + 1) % cards.size();
        }
        return getCurrentCard();
    }
}
