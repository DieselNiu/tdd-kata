package yes.tdd.users.domain;

import yes.tdd.frameworks.domain.core.DomainField;

public class UserName extends DomainField<String> {
    public UserName(String name) {
        super(name.trim(), "error.name-too-long");
    }

    public String name() {
        return super.get();
    }
}
