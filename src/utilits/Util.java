package utilits;

import java.util.regex.Pattern;

public class Util {
    public static boolean isDefine(String str) {
        return !(str == null || str.isEmpty() || str.isBlank());
    }

    public static boolean isValidSerialNumber(String serialNumber) {
        if (Pattern.matches("[а-яА-Яa-zA-Z0-9]{9}", serialNumber)) {
            return true;
        } else {
            System.out.println("Номер страховки некорректный");
            return false;
        }
    }

    public static boolean isValidRegistrationNumber(String registrationNumber) {
        return Pattern.matches("[а-я][0-9]{3}[а-я]{2}[0-9]{3}", registrationNumber);
    }

}
