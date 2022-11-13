package sponsors;

public abstract class Contributor {
    private double amount;
    public Contributor(double amount) {
        this.amount = amount;
     }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public abstract void sponsor();
}
