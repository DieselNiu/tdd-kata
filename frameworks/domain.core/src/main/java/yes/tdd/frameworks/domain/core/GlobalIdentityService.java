package yes.tdd.frameworks.domain.core;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalIdentityService {
    private static IdentityService identityService;

    public static String next() {
        return identityService.next();
    }

    public static String nextReadable() {
        return identityService.nextReadable();
    }

    static void reset(IdentityService identityService) {
        GlobalIdentityService.identityService = identityService;
    }
}
