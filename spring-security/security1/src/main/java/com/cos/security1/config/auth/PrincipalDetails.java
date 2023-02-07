package com.cos.security1.config.auth;

// Spring Security 는 /login 주소로 요청이 오면 낚아채서 로그인을 진행시킨다.
// 로그인이 완료되면 Security 자신만의 Session 에 해당 정보를 저장한다. (Security ContextHolder)
    // * ContextHolder 에 들어갈 수 있는 객체의 형태는 정해져 있다. = Authentication 타입의 객체
    // Authentication 안에 User 정보가 있어야 함
        // * User 될 수 있는 객체의 타입도 정해져 있음 : UserDetails 타입의 객체

// Security Session => Authentication 객체 => UserDetails (PrincipalDetails)


import com.cos.security1.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
public class PrincipalDetails implements UserDetails, OAuth2User {

    private User user;

    public PrincipalDetails(User user) {
        this.user = user;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    // 해당 유저의 권한을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new ArrayList<>();
        collection.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collection;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getName() {
        return null;
    }
}
