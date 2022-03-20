package yes.tdd.frameworks.domain.core;

import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class DomainFieldTest {

    @Test
    void should_throw_exception_when_list_too_large() {
        Throwable throwable = catchThrowable(() -> new DomainField<>(of(1, 2, 3, 4), 2, "error.list-size-too-large"));
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("error.list-size-too-large");
    }

    @Test
    void should_throw_exception_when_name_too_large() {
        Throwable throwable = catchThrowable(() -> new DomainField<>("namenamenamenamenamenamenamenamenamenamenamename" +
                "namenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamename" +
                "namenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamename" +
                "namenamenamenamenamenamenamenamenamenamename", "error.string-size-too-large"));
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("error.string-size-too-large");
    }

    @Test
    void should_be_able_to_create_name_not_large() {
        Throwable throwable = catchThrowable(() -> new DomainField<>("name", "error.string-size-too-large"));
        assertThat(throwable).isNull();
    }

    @Test
    void should_be_able_to_check_list() {
        Throwable throwable = catchThrowable(() -> new DomainField<>(of(1, 2, 3, 4), 5, "error.list-size-too-large"));
        assertThat(throwable).isNull();
    }

    @Test
    void should_true_when_no_this_class() {
        Throwable throwable = catchThrowable(() -> new DomainField<>(1, 10, "123"));
        assertThat(throwable).isNull();
    }

    @Test
    void should_throw_exception_when_null() {
        Throwable throwable = catchThrowable(() -> new DomainField<>(null, 10, "123"));
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("123");
    }

    @Test
    void should_set_value() {
        DomainField<String> field = new DomainField<>("1", 2, "123");
        field.set("2");
        assertThat(field.get()).isEqualTo("2");
    }
}
