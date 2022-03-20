package yes.tdd.usecases;

import org.junit.jupiter.api.*;
import yes.tdd.IntegrationTest;
import yes.tdd.users.domain.*;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveUserTest extends IntegrationTest {
    private @Resource UserRepository userRepository;
    private User john;

    @BeforeEach
    void setUp() {
        john = User.newInstance("John", "john.smith@email.com");
        john.save(userRepository);
    }

    @Test
    void should_be_able_to_save_one_user_and_loaded_saved_user() {
        User fount = User.fetchById(john.id(), userRepository);
        assertEquals(fount.id(), john.id());
        assertEquals(fount.name(), john.name());
        assertEquals(fount.email(), john.email());
    }

    @Test
    void should_be_able_to_load_saved_user_by_email() {
        User fount = User.findByEmail("john.smith@email.com", userRepository);
        assertEquals(fount.id(), john.id());
        assertEquals(fount.name(), john.name());
        assertEquals(fount.email(), john.email());
    }

    @AfterEach
    void tearDown() {
        userRepository.removeAll();
    }
}
