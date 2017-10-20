package io.swagger;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

public final class SwaggerTestApp extends ResourceConfig {
  public SwaggerTestApp() {
    super();

    property(ServerProperties.PROVIDER_PACKAGES,
             getClass().getPackage().getName());
  }
}
