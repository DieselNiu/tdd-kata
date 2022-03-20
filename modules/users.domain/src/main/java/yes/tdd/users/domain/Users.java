package yes.tdd.users.domain;

import java.util.List;

public final class Users {
    private final List<User> users;

    public static Users fetchAll(UserRepository userRepository) {
        return new Users(userRepository.findAllUsers());
    }

    public List<User> users() {
        return users;
    }

    private Users(List<User> users) {
        this.users = users;
    }
}
