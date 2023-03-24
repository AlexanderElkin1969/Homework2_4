public class Main {
    public static void main(String[] args) {
        String login, password,  confirmPassword;
        login = "11111111111111111111";
        password = "dr_AAA";
        confirmPassword = password;

        System.out.println("Значения параметров подходят под ограничения? \n" +
                checkLogin( login, password, confirmPassword));
    }
    public static boolean checkLogin (String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{
        boolean result = true;
        try {
            char[] log = login.toCharArray();
            if (log.length == 0) {
                throw new NullPointerException("");
            }
            if (log.length > 20) {
                throw new WrongLoginException("");
            }
            for (int i = 0; i < log.length; i++) {
                if (!checkSymbol(log[i])) {
                    return false;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Поле 'Login' не должно быть пустым.");
            return false;
        } catch (WrongLoginException e) {
            System.out.println("Число символов в поле 'Login' не должно превышать 20.");
            return false;
        }finally {
            System.out.println("Проверка завершена");
        }
        try {
            char[] pas = password.toCharArray();
            char[] confPas = confirmPassword.toCharArray();
            if (pas.length == 0 || confPas.length == 0) {
                throw new NullPointerException("");
            }
            if (pas.length != confPas.length || pas.length >= 20) {
                throw new WrongPasswordException("");
            }
            for (int i = 0; i < pas.length; i++) {
                if (!checkSymbol(pas[i]) || pas[i] != confPas[i]) {
                    return false;
                }
            }
        }catch (NullPointerException e) {
            System.out.println("Поля 'Password' и 'ConfirmPassword' не должны быть пустыми.");
            return false;
        } catch (WrongPasswordException e) {
            System.out.println("Поля 'Password' и 'ConfirmPassword' должны совпадать и не превышать 19 символов.");
            return false;
        }
        return result;
    }

    public static boolean checkSymbol(char symbol) {
        int c = symbol;
        return  (48 <= c && c <= 57) || (65 <= c && c <= 90) || c == 95 || (97 <= c && c <= 122);
    }
}