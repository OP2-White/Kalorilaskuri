package Kalorilaskuri.Domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String passwordHash;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<FoodEaten> foodsEaten;


    public AppUser() {
    }

    public AppUser( String username, String passwordHash) {
        super();
        this.username = username;
        this.passwordHash = passwordHash;
    
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        return "AppUser [id=" + userId + ", username=" + username + ", passwordHash=" + passwordHash +  "]";
    }

    
}

