package curso.springboot.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class WebConfigSecurity {

    @Autowired
    private ImplementacaoUserDetailsService implementacaoUserDetailsService;

    @Bean // Configura as solicitações de acesso por Http
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desativa as configurações padrão de proteção CSRF
            .authorizeHttpRequests(authorizeRequests -> 
                authorizeRequests
                .requestMatchers(HttpMethod.GET, "/").permitAll() // Permite qualquer usuário acessar a página inicial
                .requestMatchers(HttpMethod.GET, "/cadastropessoa").hasAnyRole("ADMIN") // SOMENTE ADMIN
                    .anyRequest().authenticated() // Qualquer outra requisição precisa de autenticação
            )
            .formLogin(formLogin -> 
                formLogin
                    .permitAll() // Permite o formulário de login para todos
            )
            .logout(logout -> 
                logout
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Mapeia a URL de logout
            );

        return http.build();
    }

    
    @Bean
    public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder(); // Use o codificador BCrypt, que é uma opção segura
    }


    // Ignora URL especificas
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/materialize/**");
    }

}






















//package curso.springboot.springboot.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//public class WebConfigSecurity {
//	
//	@Autowired
//	private ImplementacaoUserDetailsService implementacaoUserDetailsService;
//	
//
//    @Bean // Configura as solicitações de acesso por Http
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable() // Desativa as configurações padrão de proteção CSRF
//            .authorizeHttpRequests(authorizeRequests -> 
//                authorizeRequests
//                    .requestMatchers(HttpMethod.GET, "/").permitAll() // Permite qualquer usuário acessar a página inicial
//                    .anyRequest().authenticated() // Qualquer outra requisição precisa de autenticação
//            )
//            .formLogin(formLogin -> 
//                formLogin.permitAll() // Permite o formulário de login para todos
//            )
//            .logout(logout -> 
//                logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // Mapeia a URL de logout
//            );
//
//        return http.build();
//    }
//
//    @Bean // Cria autenticação do usuário com banco de dados ou em memória
//    public UserDetailsService userDetailsService() {
//    	
//    	
//    	auth.userDetailsService(implementacaoUserDetailsService)
//    	.passwordEncoder(new BCryptPasswordEncoder());
//    	
////        UserDetails user = User.withUsername("aam")
////                .password("{noop}123")  // {noop} para não criptografar a senha
////                .password("$2a$10$Xnjw09p8DffXlccIuqEV.OcmmdBGd71QrqmtLrvTAqiZIqa6rtky6")  // 123 criptografado                
////                .roles("ADMIN")
////                .build();
////        return new InMemoryUserDetailsManager(user);
//    }
//    
//
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder(); // Usando BCrypt, recomendável para produção
////    }
//    
//    
//    @Bean // Ignora URL especificas
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/materialize/**");
//    }
//    
//    
//
//    
//}
