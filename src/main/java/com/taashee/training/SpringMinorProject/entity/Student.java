package com.taashee.training.SpringMinorProject.entity;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.taashee.training.SpringMinorProject.entity.Course;
import com.taashee.training.SpringMinorProject.security.UserRole;

@Entity
@Component
public class Student implements UserDetails{
	@Id
	@Column(name="student_id")
	private int id;
	private String sname;
	private String username;
	private String password;
	@ColumnDefault("STUDENT")
	private String role;
	@ManyToMany()
	@JoinTable(
			name="student_course_rel",
			joinColumns=@JoinColumn(name="student_id"),
			inverseJoinColumns=@JoinColumn(name="course_id")
			)
	private Set<Course> courses;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
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
	
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		
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
		UserRole userRole=UserRole.STUDENT;
		if(role.equals(userRole.ADMIN.name()))
			userRole=UserRole.ADMIN;
		if(role.equals(userRole.INSTRUCTOR.name()))
			userRole=UserRole.INSTRUCTOR;
		Set<SimpleGrantedAuthority> permission=userRole.getPermission().stream().map(permissions->new SimpleGrantedAuthority(permissions.getPermission())).collect(Collectors.toSet());
		permission.add(new SimpleGrantedAuthority("ROLE_"+role));
		return permission;
	}
}
