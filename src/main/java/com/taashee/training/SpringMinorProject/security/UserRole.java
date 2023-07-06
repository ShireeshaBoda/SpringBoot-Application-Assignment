package com.taashee.training.SpringMinorProject.security;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum UserRole {
  STUDENT(new HashSet<>(Arrays.asList(UserPermission.READ))),
  ADMIN(new HashSet<>(Arrays.asList(UserPermission.READ ,UserPermission.WRITE))),
	INSTRUCTOR(new HashSet<>(Arrays.asList(UserPermission.READ ,UserPermission.WRITE)));
  private final Set<UserPermission> permissions;

public  Set<UserPermission> getPermission() {
	 return permissions;
}

private UserRole(Set<UserPermission> permissions) {
	this.permissions = permissions;
}
public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
	Set<SimpleGrantedAuthority> permission= getPermission().stream().map(permissions->new SimpleGrantedAuthority(permissions.getPermission())).collect(Collectors.toSet());
	return permission;
}
}
