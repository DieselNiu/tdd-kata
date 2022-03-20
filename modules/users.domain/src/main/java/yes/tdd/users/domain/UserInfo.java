package yes.tdd.users.domain;

public class UserInfo {
    private final UserName name;
    private final UserEmail email;

    public UserInfo(String name, String email) {
        this.name = new UserName(name);
        this.email = new UserEmail(email);
    }

    public String name() {
        return this.name.name();
    }

    public String email() {
        return email.email();
    }
}
