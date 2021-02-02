package cards;

public class Card {
    private int value;
    private Suit suit;

    public Card(Suit suit, int value){
        this.suit = suit;
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
