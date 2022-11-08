package exceptions;

import java.util.regex.Pattern;

public class CheckAuthorization {

    public static boolean checkAuthorization(String login, String password, String confirmPassword) throws
            WrongLoginException, WrongPasswordException {
        String regex = "\\w{1,20}";
        if (!Pattern.matches(regex, login)) {
            throw new WrongLoginException("Неккоректный логин");
        }
        if (!(Pattern.matches(regex, password) && password.equals(confirmPassword))) {
            throw new WrongPasswordException("Некоректный пароль");
        }

        return true;
    }
}
