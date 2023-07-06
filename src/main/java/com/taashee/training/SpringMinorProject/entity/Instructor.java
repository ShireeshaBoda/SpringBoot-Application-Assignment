package com.taashee.training.SpringMinorProject.entity;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.taashee.training.SpringMinorProject.security.UserRole;

@Entity
public class Instructor implements UserDetails {
   @Id
   @Column(name="instructor_id")
   private int id;
   private String iname;
   private String username;
   private String password;
   
  @ColumnDefault("INSTRUCTOR")
   private String role;
   public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}
@OneToOne
   @JoinColumn(name="course_id",unique=true)
   private Course course;

public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}

@Override
public String toString() {
	return "Instructor [id=" + id + ", iname=" + iname + ", username=" + username + ", password=" + password + ", role="
			+ role + ", course=" + course + "]";
}


public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getIname() {
	return iname;
}
public void setIname(String iname) {
	this.iname = iname;
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
	UserRole userRole=UserRole.INSTRUCTOR;
	if(role.equals(userRole.ADMIN.name()))
		userRole=UserRole.ADMIN;
	if(role.equals(userRole.STUDENT.name()))
		userRole=UserRole.STUDENT;
	Set<SimpleGrantedAuthority> permission=userRole.getPermission().stream().map(permissions->new SimpleGrantedAuthority(permissions.getPermission())).collect(Collectors.toSet());
	permission.add(new SimpleGrantedAuthority("ROLE_"+role));
	return permission;
}
}
