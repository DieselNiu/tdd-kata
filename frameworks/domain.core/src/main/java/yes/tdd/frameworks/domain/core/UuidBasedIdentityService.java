package yes.tdd.frameworks.domain.core;

import com.fasterxml.uuid.Generators;
import org.apache.commons.lang3.RandomUtils;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class UuidBasedIdentityService implements IdentityService {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSS");
    private static final long A = 10000000;
    private static final long B = 12219292800L;
    private static final long C = 1000000;
    private static final long D = 100;
    private static final int E = 8;
    public static final int END_EXCLUSIVE = 10;

    @Override
    public String next() {
        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
    }

    @Override
    public String nextReadable() {
        UUID uuid = Generators.timeBasedGenerator().generate();
        return Long.parseLong((formatUuidTimestamp(uuid.timestamp()))) + RandomUtils.nextLong(0, END_EXCLUSIVE) + "";
    }

    private String formatUuidTimestamp(long timestamp) {
        return FORMATTER.format(Instant.ofEpochSecond(timestamp / A - B, timestamp % C * D).atZone(ZoneOffset.ofHours(E)));
    }
}
