import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class User {
        private String email,id,firstName,lastName,password,type;
        private LocalDate birthDate;


        /**
         * Constructor for User class.
         * @param email
         * @param id
         * @param firstName
         * @param lastName
         * @param year
         * @param month
         * @param day
         */
        public User(String email, String id, String firstName, String lastName, int year, int month, int day, String password) {
            this.email = email;
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = LocalDate.of(year,month,day);
            this.password = password;
        }

        public User(String email, String password, String type){
            this.password = password;
            this.email = email;
            this.type = type;

        }

        public User (User user){
            this.email = user.email;
            this.password = user.password;
            this.id = user.id;
            this.firstName = user.firstName;
            this.lastName = user.lastName;
            this.birthDate = user.birthDate;
            this.type = user.type;
        }

        public User(String id, String firstName, String lastName, LocalDate birthDate) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = birthDate;
        }

        /**
         *
         * @return String email.
         */
        public String getEmail() {
            return email;
        }

        /**
         * Takes String parameter for the email.
         * @param email
         */
        public void setEmail(String email) {
            this.email = email;
        }

        /**
         *
         * @return String Id
         */
        public String getId() {
            return id;
        }

        /**
         * Takes String parameter for Id.
         * @param id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         *
         * @return String first name.
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         * Takes String parameter for first name of the user.
         * @param firstName
         */
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        /**
         *
         * @return String last name.
         */
        public String getLastName() {
            return lastName;
        }

        /**
         * Takes String parameter for user last name.
         * @param lastName
         */
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        /**
         * Returns user birthDate
         * @return LocalDate
         */
        public LocalDate getBirthDate() {
            return birthDate;
        }

    /**
     *
     * @param year
     * @param month
     * @param day
     */
        public void setBirthDate(int year, int month, int day) {
            this.birthDate = LocalDate.of(year, month, day);
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

