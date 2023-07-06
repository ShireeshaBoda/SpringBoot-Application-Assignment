package com.taashee.training.SpringMinorProject.entity;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.taashee.training.SpringMinorProject.security.UserRole;

@Entity
public class Admin implements UserDetails{
	@Id
	@Column(name="admin_id")
	private int id;
	private String name;
	private String username;
	private String password;
	@ColumnDefault("ADMIN")
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public Set<SimpleGrantedAuthority> getAuthorities(){
		UserRole userRole=UserRole.ADMIN;
		if(role.equals(userRole.INSTRUCTOR.name()))
			userRole=UserRole.INSTRUCTOR;
		if(role.equals(userRole.STUDENT.name()))
			userRole=UserRole.STUDENT;
		Set<SimpleGrantedAuthority> permission=userRole.getPermission().stream().map(permissions->new SimpleGrantedAuthority(permissions.getPermission())).collect(Collectors.toSet());
		permission.add(new SimpleGrantedAuthority("ROLE_"+role));
		return permission;
	}

}
