package yes.tdd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import yes.tdd.frameworks.domain.core.GlobalIdentityServiceResetter;
import yes.tdd.frameworks.domain.core.IdentityService;
import yes.tdd.frameworks.domain.core.UuidBasedIdentityService;

@Configuration
@EnableScheduling
@EnableAsync
@ComponentScan(basePackageClasses = TddYesConfiguration.class)
public class TddYesConfiguration {
    static {
        GlobalIdentityServiceResetter.reset(new UuidBasedIdentityService());
    }

    @Bean
    public IdentityService idService() {
        return new UuidBasedIdentityService();
    }
}
