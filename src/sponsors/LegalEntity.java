package sponsors;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LegalEntity that = (LegalEntity) o;
        return Objects.equals(companyTitle, that.companyTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyTitle);
    }
}
