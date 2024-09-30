package com.Back_Finan;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // Reemplaza TuClasePrincipal con el nombre de tu clase principal de la aplicación Spring Boot
        return application.sources(BackFinanApplication.class);
    }
}
