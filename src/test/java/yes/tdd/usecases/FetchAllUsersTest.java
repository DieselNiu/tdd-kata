package yes.tdd.usecases;

import org.junit.jupiter.api.*;
import yes.tdd.*;
import yes.tdd.users.domain.*;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.OK;

public class FetchAllUsersTest extends IntegrationTest {
    private @Resource UserRepository userRepository;

    @BeforeEach
    void setUp() {
        User.newInstance("John", "john.smith@email.com").save(userRepository);
        User.newInstance("Neil Wang", "webmaster@neilwang.wiki").save(userRepository);
    }

    @Test
    void should_be_able_to_fetch_all_users() {
        TestResponse response = get("/users/all");
        assertEquals(response.statusCode(), OK);
        assertEquals(response.jsonValues("$.users").length, 2);
        assertEquals(response.value("$.users[0].name"), "John");
        assertEquals(response.value("$.users[0].email"), "john.smith@email.com");
        assertEquals(response.value("$.users[1].name"), "Neil Wang");
        assertEquals(response.value("$.users[1].email"), "webmaster@neilwang.wiki");
    }

    @AfterEach
    void tearDown() {
        userRepository.removeAll();
    }
}
