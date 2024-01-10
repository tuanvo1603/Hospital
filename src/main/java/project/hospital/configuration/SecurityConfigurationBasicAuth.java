package project.hospital.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableMethodSecurity
public class SecurityConfigurationBasicAuth{

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails residentDoctor1 = User.builder()
                .username("residentdoctor1")
                .password(encoder().encode("residentdoctor1"))
                .roles("RESIDENT_DOCTOR", "EMPLOYEE")
                .build();

        UserDetails residentDoctor2 = User.builder()
                .username("residentdoctor2")
                .password(encoder().encode("residentdoctor2"))
                .roles("RESIDENT_DOCTOR", "EMPLOYEE")
                .build();

        UserDetails nurse1 = User.builder()
                .username("nurse1")
                .password(encoder().encode("nurse1"))
                .roles("NURSE", "EMPLOYEE")
                .build();

        UserDetails nurse2 = User.builder()
                .username("nurse2")
                .password(encoder().encode("nurse2"))
                .roles("NURSE", "EMPLOYEE")
                .build();

        UserDetails admin1 = User.builder()
                .username("admin1")
                .password(encoder().encode("admin1"))
                .roles("ADMINISTRATOR", "EMPLOYEE")
                .build();

        UserDetails admin2 = User.builder()
                .username("admin2")
                .password(encoder().encode("admin2"))
                .roles("ADMINISTRATOR", "EMPLOYEE")
                .build();

        UserDetails specialistDoctor1 = User.builder()
                .username("specialistdoctor1")
                .password(encoder().encode("specialistdoctor1"))
                .roles("SPECIALIST_DOCTOR", "EMPLOYEE")
                .build();

        UserDetails specialistDoctor2 = User.builder()
                .username("specialistdoctor2")
                .password(encoder().encode("specialistdoctor2"))
                .roles("SPECIALIST_DOCTOR", "EMPLOYEE")
                .build();

        UserDetails dean1 = User.builder()
                .username("dean1")
                .password(encoder().encode("dean1"))
                .roles("DEAN", "EMPLOYEE")
                .build();

        UserDetails dean2 = User.builder()
                .username("dean2")
                .password(encoder().encode("dean2"))
                .roles("DEAN", "EMPLOYEE")
                .build();

        UserDetails technician1 = User.builder()
                .username("technician1")
                .password(encoder().encode("technician1"))
                .roles("TECHNICIAN", "EMPLOYEE")
                .build();

        UserDetails technician2 = User.builder()
                .username("technician2")
                .password(encoder().encode("technician2"))
                .roles("TECHNICIAN", "EMPLOYEE")
                .build();

        UserDetails patient1 = User.builder()
                .username("patient1")
                .password(encoder().encode("patient1"))
                .roles("PATIENT")
                .build();

        UserDetails patient2 = User.builder()
                .username("patient2")
                .password(encoder().encode("patient2"))
                .roles("PATIENT")
                .build();

        return new InMemoryUserDetailsManager(residentDoctor1,
                residentDoctor2,
                nurse1,
                nurse2,
                admin1,
                admin2,
                specialistDoctor1,
                specialistDoctor2,
                dean1,
                dean2,
                technician1,
                technician2,
                patient1,
                patient2);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated())
                .formLogin(formLogin -> formLogin
                        .defaultSuccessUrl("/home", true)
                )
                .httpBasic(Customizer.withDefaults())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                        .permitAll());

        return http.build();
    }
}
