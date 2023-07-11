package edu.my.health;

import io.smallrye.health.checks.UrlHealthCheck;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Readiness;
import jakarta.ws.rs.HttpMethod;

@ApplicationScoped
public class CategoryHealth {
    @ConfigProperty(name = "application.server")
    String server;
    @ConfigProperty(name = "application.port")
    String port;

    @Readiness
    HealthCheck checkURL() {
        return new UrlHealthCheck("http://" + server + ":" + port + "/categories")
                .name("Categories get all health check").requestMethod(HttpMethod.GET).statusCode(200);
    }
}
