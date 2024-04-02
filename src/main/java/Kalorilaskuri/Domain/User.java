package Kalorilaskuri.Domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false, updatable = false)
    private Long id;

   @Column(name = "username", nullable = false, unique = true)
    private String username;
    
    @Column(name = "password", nullable = false)
    private String passwordHash;


    public User() {
    }

    public User( String username, String passwordHash) {
        super();
        this.username = username;
        this.passwordHash = passwordHash;
    
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }


    @Override
    public String toString() {
        return "AppUser [id=" + id + ", username=" + username + ", passwordHash=" + passwordHash +  "]";
    }

    
}
