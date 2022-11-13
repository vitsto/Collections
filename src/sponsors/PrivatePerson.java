package sponsors;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivatePerson that = (PrivatePerson) o;
        return Objects.equals(fullName, that.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }
}
