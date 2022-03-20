package yes.tdd.usecases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import yes.tdd.*;
import yes.tdd.users.domain.*;

import javax.annotation.Resource;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.HttpStatus.OK;

public class RegisterUserTest extends IntegrationTest {
    private @Resource UserRepository userRepository;

    @ParameterizedTest
    @CsvSource({"John,john.smith@email.com"})
    void should_be_able_to_register_a_user_via_api(String name, String email) {
        TestResponse response = post("/users", Map.of("name", name, "email", email));
        assertEquals(response.statusCode(), OK);
        User fount = User.fetchById(response.value("$"), userRepository);
        assertEquals(fount.name(), name);
        assertEquals(fount.email(), email);
    }

    @AfterEach
    void tearDown() {
        userRepository.removeAll();
    }
}
