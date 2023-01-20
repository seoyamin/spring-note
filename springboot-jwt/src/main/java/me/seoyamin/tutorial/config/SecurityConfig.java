package me.seoyamin.tutorial.config;

import me.seoyamin.tutorial.jwt.JwtAccessDeniedHandler;
import me.seoyamin.tutorial.jwt.JwtAuthenticationEntryPoint;
import me.seoyamin.tutorial.jwt.JwtSecurityConfig;
import me.seoyamin.tutorial.jwt.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {   //  기본 Security 설정

    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    public SecurityConfig(
            TokenProvider tokenProvider,
            JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,
            JwtAccessDeniedHandler jwtAccessDeniedHandler
    ) {
        this.tokenProvider = tokenProvider;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()                                           //  /h2-console 하위의 모든 요청과 favicon은 모두 ignore
                .antMatchers(
                        "/h2-console/**"
                        ,"/favicon.ico"
                );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()                                          // 우리는 토큰을 사용할 것이므로 csrf 설정 disabled

                .exceptionHandling()                                       // Exception Handling 할 때 커스텀한 클래스들을 이용
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)

                .and()                                                     // H2 콘솔 관련 설정
                .headers()
                .frameOptions()
                .sameOrigin()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)    // 세션 사용하지 않을 것이라 STATELESS로 설정

                .and()
                .authorizeRequests()                                       //  HttpServletRequest 사용하는 요청들에 대한 접근제한을 설정
                .antMatchers("/api/hello").permitAll()          //  /api/hello 에 대한 요청은 인증없이 접근을 허용
                .antMatchers("/api/authenticate").permitAll()
                .antMatchers("/api/signup").permitAll()
                .anyRequest().authenticated()                               //  나머지 요청들은 모두 인증이 필요함

                .and()
                .apply(new JwtSecurityConfig(tokenProvider));
    }

}
