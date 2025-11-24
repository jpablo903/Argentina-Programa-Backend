package com.PorfolioArgPrograma.Porfolio.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Configuración de JPA Auditing para rastrear automáticamente
 * la creación y modificación de entidades
 * @author Juan Pablo
 */
@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig {
}
