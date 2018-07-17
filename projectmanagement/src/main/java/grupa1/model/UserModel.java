package grupa1.model;

import grupa1.Entity.User;

    public class UserModel {

        public static final String KEY = "UserModel";

        private int id;
        private String username;
        private String lastName;
        private String firstName;
        private String password;
        private String email;

        public UserModel(User user) {
            super();
            this.id = user.getUserId();
            this.username = user.getUserName();
            this.lastName = user.getLastName();
            this.firstName = user.getFirstName();
            this.password = user.getUserPass();
            this.email = user.getEmail();
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getPassportNumber() {
            return password;
        }

        public void setPassportNumber(String passportNumber) {
            this.password = passportNumber;
        }


        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }


