public class EmailValidator {
    String email;

    public EmailValidator(String email) {
        this.email = email;
    }

    public boolean isValid() {
        return email.contains("@") && email.contains(".");
    }
}
