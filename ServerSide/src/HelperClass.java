import java.sql.Statement;
import java.util.regex.Pattern;

public class HelperClass {

    public static boolean userEmailTest(String email){
        {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                    "A-Z]{2,7}$";

            Pattern pat = Pattern.compile(emailRegex);
            if (email == null)
                return false;
            return pat.matcher(email).matches();
        }
    }

    /**
     * data base section
     */


    /**
     * inner class for login
     */
    public static class Login{
        private String username;
        private String password;
        private final String TYPE = "Password";

        public Login(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public Login(Login login){
            this.username = login.getUsername();
            this.password = login.getPassword();
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getTYPE() {
            return TYPE;
        }
    }
}
