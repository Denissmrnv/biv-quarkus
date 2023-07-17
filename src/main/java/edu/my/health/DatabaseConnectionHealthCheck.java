package edu.my.health;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Readiness
@ApplicationScoped
public class DatabaseConnectionHealthCheck implements HealthCheck {

    @Inject
    DataSource dataSource;

    @Override
    public HealthCheckResponse call() {

        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("Custom database connection health check ");

        try {
            Connection connection =  dataSource.getConnection();
            responseBuilder.up();
        } catch (SQLException e) {
            responseBuilder.down();
        }
        return responseBuilder.build();
    }
}