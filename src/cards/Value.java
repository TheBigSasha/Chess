package cards;

public enum Value {
    JOKER(0), KING(13), QUEEN(12), ACE(14), JACK(11);

    int strength;
    Value(int strength){
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }
}
