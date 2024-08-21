package org.zerock.datie_boot.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.zerock.datie_boot.entity.User;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private final User userEntity;

    public CustomUserDetails(User userEntity) {
        this.userEntity = userEntity;
    }

    // UserDetails 인터페이스의 메소드 구현
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 권한 반환 로직
        return null; // 실제 권한 로직 구현 필요
    }

    @Override
    public String getPassword() {
        return userEntity.getPw();
    }

    public String getId() {
        return userEntity.getId();
    }

    @Override
    public String getUsername() {
        return userEntity.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 계정 만료 여부
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 계정 잠금 여부
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 인증 정보 만료 여부
    }

    @Override
    public boolean isEnabled() {
        return true; // 계정 활성화 여부
    }

    public Integer getUserno() {
        return userEntity.getUserno();
    }
}
