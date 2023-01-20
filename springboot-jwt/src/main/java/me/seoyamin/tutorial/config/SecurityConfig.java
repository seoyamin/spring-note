package me.seoyamin.tutorial.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {   //  기본 Security 설정

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
                .authorizeRequests()                                  //  HttpServletRequest 사용하는 요청들에 대한 접근제한을 설정
                .antMatchers("/api/hello").permitAll()     //  /api/hello 에 대한 요청은 인증없이 접근을 허용
                .anyRequest().authenticated();                        //  나머지 요청들은 모두 인증이 필요함
    }
}
