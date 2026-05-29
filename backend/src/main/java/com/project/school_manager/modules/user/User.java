package com.project.school_manager.modules.user;

import com.project.school_manager.modules.user.entity.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter
@Getter
@Entity(name = "users")
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String login;

    private String password;

    private String cpf;

    public User(String login, String password, String name, UserRole role, String cpf){
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
        this.cpf = cpf;

    }

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_SECRETARY"),
                    new SimpleGrantedAuthority("ROLE_TEACHER"),
                    new SimpleGrantedAuthority("ROLE_USER"));

        else if (this.role == UserRole.SECRETARY)
            return List.of(new SimpleGrantedAuthority("ROLE_SECRETARY"),
                    new SimpleGrantedAuthority("ROLE_USER"));

        else if (this.role == UserRole.TEACHER)
            return List.of(new SimpleGrantedAuthority("ROLE_TEACHER"),
                    new SimpleGrantedAuthority("ROLE_USER"));

        else if (this.role == UserRole.STUDENT)
            return List.of(new SimpleGrantedAuthority("ROLE_STUDENT"));

        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return login;
    }
}