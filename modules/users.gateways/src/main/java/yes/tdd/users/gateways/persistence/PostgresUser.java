package yes.tdd.users.gateways.persistence;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import yes.tdd.users.domain.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"user\"")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostgresUser {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    public PostgresUser(User user) {
        this.id = user.id();
        this.name = user.name();
        this.email = user.email();
    }

    public User asDomain() {
        return User.of(id, name, email);
    }
}
