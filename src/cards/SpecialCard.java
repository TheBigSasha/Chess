package cards;

public class SpecialCard extends Card{
    private Value value;

    public SpecialCard(Suit suit, Value value) {
        super(suit, value.getStrength());
        this.value = value;
    }
}
