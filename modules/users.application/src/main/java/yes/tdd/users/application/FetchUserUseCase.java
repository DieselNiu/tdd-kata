package yes.tdd.users.application;

import yes.tdd.frameworks.application.core.UseCase;
import yes.tdd.users.application.vo.UserOutput;
import yes.tdd.users.domain.*;

@UseCase
public class FetchUserUseCase {
    private final UserRepository userRepository;

    public FetchUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserOutput execute(String id) {
        return UserOutput.from(User.fetchById(id, userRepository));
    }
}
