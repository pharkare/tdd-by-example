package guru.springframework;

public class Franc {

    private final int amount;

    public Franc(int amount) {
        this.amount = amount;
    }

    Franc times(int multiplier) {
        return new Franc(amount * multiplier);
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        Franc franc = (Franc) obj;
        return amount == franc.amount;
    }
}
