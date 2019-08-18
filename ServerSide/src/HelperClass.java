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

}
