package yes.tdd.dojo.domain.unit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static yes.tdd.dojo.domain.unit.Unit.UnitHub.*;

public class UnitTest {

    @Nested
    class IntegrationTest {
        @Test
        void should_be_able_to_transfer_13_5_dm_to_135_cm() {
            assertEquals(Unit.of(13.5, DM).to(CM), 135.0);
        }
    }

    @Nested
    class UnitInUnitTest {
        @ParameterizedTest
        @CsvSource({
            "1.0,   'M',    'CM',   100.0",
            "1.0,   'M',    'DM',   10.0",
            "1.0,   'M',    'M',    1.0",
            "100.0, 'CM',   'M',    1.0",
            "10.0,  'DM',   'M',    1.0"
        })
        void should_be_able_to_transfer_correctly(double sourceValue, Unit.UnitHub sourceUnit, Unit.UnitHub targetUnit, double actual) {
            assertEquals(Unit.of(sourceValue, sourceUnit).to(targetUnit), actual);
        }
    }
}
