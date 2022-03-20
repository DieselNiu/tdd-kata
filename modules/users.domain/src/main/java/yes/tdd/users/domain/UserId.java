package yes.tdd.users.domain;

import yes.tdd.frameworks.domain.core.DomainField;

public class UserId extends DomainField<String> {
    public UserId(String id) {
        super(id, "error.id-too-long");
    }

    public String id() {
        return super.get();
    }
}
