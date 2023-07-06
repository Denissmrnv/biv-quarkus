package edu.my._test;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithName;

@ConfigMapping(prefix = "server")
public interface Server {
    String host();

    int port();

    Log log();

    interface Log {
        @WithName("enabled")
        boolean enabled();

        String suffix();

        boolean rotate();
    }
}
