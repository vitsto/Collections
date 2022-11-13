package transport.types;

import transport.Transport;

public enum BodyType {
    SEDAN("седан"),
    HATCHBACK("хэтчбек"),
    COUPE("купе"),
    UNIVERSAL("универсал"),
    SUV("внедорожник"),
    CROSSOVER("кроссовер"),
    PICKUP("пикап"),
    VAN("фургон"),
    MINIVAN("минивен");

    private final String bodyType;

    BodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void getType(Transport transport) {

    }
}