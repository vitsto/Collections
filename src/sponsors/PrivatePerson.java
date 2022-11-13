package sponsors;

public class PrivatePerson extends Contributor{
    private final String fullName;

    public PrivatePerson(String fullName, double amount) {
        super(amount);
        this.fullName = fullName;
    }

    @Override
    public void sponsor() {
        System.out.println(fullName + " спонсирует заезд в сумме " + getAmount());
    }

    @Override
    public String toString() {
        return "Физическое лицо: " + fullName;
    }
}
