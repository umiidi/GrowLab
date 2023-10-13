package az.growlab.GrowLab.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class JdbcTemplateConfuguration {

    @Bean
    public NamedParameterJdbcTemplate productJdbcTemplate(@Qualifier("DB-Product") DataSource ds) {
        return new NamedParameterJdbcTemplate(ds);
    }

}
