package yes.tdd.users.application.vo;

import lombok.*;
import yes.tdd.users.domain.User;

@Getter
public final class UserOutput {
    private final String id;
    private final String name;
    private final String email;

    public static UserOutput from(User user) {
        return new UserOutput(user);
    }

    private UserOutput(User user) {
        this.id = user.id();
        this.name = user.name();
        this.email = user.email();
    }
}
