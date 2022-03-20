package yes.tdd.users.application.vo;

import lombok.Getter;
import yes.tdd.users.domain.Users;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public final class UserOutputs {
    private final List<UserOutput> users;

    public UserOutputs(Users users) {
        this.users = users.users().stream().map(UserOutput::from).collect(Collectors.toList());
    }

    public static UserOutputs from(Users users) {
        return new UserOutputs(users);
    }
}
