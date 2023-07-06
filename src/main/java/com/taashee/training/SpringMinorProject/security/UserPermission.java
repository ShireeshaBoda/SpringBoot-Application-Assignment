package com.taashee.training.SpringMinorProject.security;

public enum UserPermission {
	READ("read"),
	WRITE("write");
	
	private  String permission;

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	private UserPermission(String permission) {
		this.permission = permission;
	}
	

}
