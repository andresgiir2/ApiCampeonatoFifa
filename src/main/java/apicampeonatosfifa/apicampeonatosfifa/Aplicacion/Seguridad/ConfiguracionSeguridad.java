package apicampeonatosfifa.apicampeonatosfifa.Aplicacion.Seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class ConfiguracionSeguridad {

    @Autowired
    private FiltroSeguridad filtroSeguridad;

    @Bean
    public UserDetailsService servicioUsuario() {
        return new UsuarioDetallesServicio();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authz -> authz
                                        .requestMatchers("/api/usuarios/login/**").permitAll()
                                        .anyRequest().authenticated()
                                )
        .addFilterAfter(filtroSeguridad, UsernamePasswordAuthenticationFilter.class)
        .build();
    }

}
