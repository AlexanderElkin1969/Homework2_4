public class Main {
    public static void main(String[] args) {
        String login, password,  confirmPassword;
        login = "abc_ABC";
        password = "12345";
        confirmPassword = password;

        System.out.println("Значения параметров подходят под ограничения ? " +
                checkLogin( login, password, confirmPassword));
    }
    public static boolean checkLogin(String login, String password, String confirmPassword){
        char[] log = login.toCharArray();
        char[] pas = password.toCharArray();
        char[] confPas = confirmPassword.toCharArray();
        boolean result = true;
        if(log.length>20 || pas.length != confPas.length || pas.length>=20){
            return false;
        }
        for (int i = 0; i < log.length; i++) {
            if (!checkSymbol(log[i])) {
                return false;
            }
        }
        for (int i = 0; i < pas.length; i++) {
            if (!checkSymbol(pas[i]) || pas[i] != confPas[i] ) {
                return false;
            }
        }
        return result;
    }

    public static boolean checkSymbol(char symbol) {
        int c = symbol;
        return  (48 <= c && c <= 57) || (65 <= c && c <= 90) || c == 95 || (97 <= c && c <= 122);
    }
}