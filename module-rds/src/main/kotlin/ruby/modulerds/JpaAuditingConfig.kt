package ruby.modulerds

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EntityScan("ruby.modulerds.entity")
@EnableJpaRepositories(basePackages = ["ruby.modulerds.repository"])
@ComponentScan(basePackages = ["ruby.modulerds"])
@EnableJpaAuditing
class JpaAuditingConfig