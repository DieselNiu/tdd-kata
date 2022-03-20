package yes.tdd.users.application;

import lombok.AllArgsConstructor;
import yes.tdd.users.domain.User;

@AllArgsConstructor
public class UserInput {
    private final String name;
    private final String email;

    public User asDomain() {
        return User.newInstance(name, email);
    }
}
