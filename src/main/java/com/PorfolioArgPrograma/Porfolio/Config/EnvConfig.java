package com.PorfolioArgPrograma.Porfolio.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

@Configuration
@PropertySource(value = "file:./.env", ignoreResourceNotFound = true)
public class EnvConfig {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(EnvConfig.class);

    @PostConstruct
    public void loadEnv() {
        logger.info("🚀 INICIANDO CARGA DE VARIABLES DE ENTORNO...");

        try {
            // Intentar cargar desde archivo .env en raíz del proyecto
            File envFile = new File(".env");
            if (envFile.exists()) {
                Properties envProps = new Properties();
                envProps.load(new FileInputStream(envFile));

                // Cargar cada variable al System Properties
                for (String key : envProps.stringPropertyNames()) {
                    String value = envProps.getProperty(key).trim();
                    System.setProperty(key, value);
                    logger.info("✅ {}: {}", key,
                            (key.contains("PASSWORD") || key.contains("SECRET")) ? "••••••••" : value);
                }
                logger.info("📁 Archivo .env cargado exitosamente desde: {}", envFile.getAbsolutePath());
            } else {
                logger.warn("⚠️  Archivo .env no encontrado en: {}", envFile.getAbsolutePath());
            }

            // Verificar que las variables críticas estén cargadas
            String[] criticalVars = {"DB_URL", "DB_USERNAME", "DB_PASSWORD"};
            logger.info("🔍 VERIFICACIÓN DE VARIABLES CRÍTICAS:");
            for (String var : criticalVars) {
                String value = System.getProperty(var);
                if (value != null && !value.isEmpty()) {
                    logger.info("   {}: ✅ CARGADO", var);
                } else {
                    logger.error("   {}: ❌ NO CARGADO", var);
                }
            }

        } catch (Exception e) {
            logger.error("❌ ERROR CARGANDO .env: {}", e.getMessage());
        }
    }
}