package guru.springframework;

public class Dollar {

    private final int amount;

    public Dollar (int amount) {
        this.amount = amount;
    }

    Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass())
            return false;
        Dollar dollar = (Dollar) obj;
        return amount == dollar.amount;
    }
}
