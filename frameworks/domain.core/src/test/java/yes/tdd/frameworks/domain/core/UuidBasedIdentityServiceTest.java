package yes.tdd.frameworks.domain.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UuidBasedIdentityServiceTest {
    private IdentityService identityService;

    @BeforeEach
    public void setUp() {
        identityService = new UuidBasedIdentityService();
    }

    @Test
    public void should_generate_identity_correctly() {
        assertThat(32).isEqualTo(identityService.next().length());
    }

    @Test
    public void should_generate_non_duplicated_identities() {
        String id = identityService.next();
        assertThat(id).isNotEqualTo(identityService.next());
    }

    @Test
    public void should_generate_readable_identity_correctly() {
        assertThat(identityService.nextReadable().length()).isEqualTo(18);
        assertThat(identityService.nextReadable().chars().allMatch(Character::isDigit)).isTrue();
    }
}
