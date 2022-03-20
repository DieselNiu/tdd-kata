package yes.tdd.usecases;

import org.junit.jupiter.api.*;
import yes.tdd.*;
import yes.tdd.users.domain.*;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.OK;

public class SearchUserTest extends IntegrationTest {
    private @Resource UserRepository userRepository;
    private User john;

    @BeforeEach
    void setUp() {
        john = User.newInstance("John", "john.smith@email.com");
        john.save(userRepository);
    }

    @Test
    void should_be_able_to_fetch_one_user() {
        TestResponse response = get("/users/" + john.id());
        assertEquals(response.statusCode(), OK);
        assertEquals(response.value("$.id"), john.id());
        assertEquals(response.value("$.name"), john.name());
        assertEquals(response.value("$.email"), john.email());
    }

    @AfterEach
    void tearDown() {
        userRepository.removeAll();
    }
}
