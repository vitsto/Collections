package sponsors;

public class LegalEntity extends Contributor{
    private final String companyTitle;

    public LegalEntity(String companyTitle, double amount) {
        super(amount);
        this.companyTitle = companyTitle;
    }

    @Override
    public void sponsor() {
        System.out.println(companyTitle + " спонсирует заезд в сумме " + getAmount());
    }

    @Override
    public String toString() {
        return "Юридическое лицо: " + companyTitle;
    }
}
