package yes.tdd.users.domain;

import yes.tdd.frameworks.domain.core.DomainField;

public class UserEmail extends DomainField<String> {
    public UserEmail(String email) {
        super(email.trim(), "error.email-too-long");
    }

    public String email() {
        return super.get();
    }
}
