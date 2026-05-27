package com.project.school_manager.modules.user.entity;

public enum UserRole {
    ADMIN("admin"),
    TEACHER("teacher"),
    SECRETARY("secretary"),
    STUDENT("student"),
    USER("user");


    private String role;

    UserRole(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

}
