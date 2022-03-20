package yes.tdd.users.domain;

import java.util.List;

public interface UserRepository {
    User save(User user);
    User findUserById(String id);
    User findUserByEmail(String email);
    List<User> findAllUsers();
    void removeAll();
}
