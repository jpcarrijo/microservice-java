package com.microservice.hroauth.services.security;

import com.microservice.hroauth.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class Details implements UserDetails, Serializable {

  private static final long serialVersionUID = 1L;

  final User user;

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return user.getRoleSet().stream()
        .map(e -> new SimpleGrantedAuthority(e.getRoleName()))
        .collect(Collectors.toList());
  }

  @Override
  public String getPassword() {
    return this.user.getPassword();
  }

  @Override
  public String getUsername() {
    return this.user.getEmail();
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
}
