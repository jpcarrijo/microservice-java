package com.microservice.hruser.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  private String email;

  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "tb_user_role",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roleSet = new HashSet<>();


  public User() {
  }

  public User(Long id, String name, String email, String password) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoleSet() {
    return roleSet;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return getId().equals(user.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  public static final class UserBuilder {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Set<Role> roleSet;

    private UserBuilder() {
    }

    public static UserBuilder anUser() {
      return new UserBuilder();
    }

    public UserBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public UserBuilder name(String name) {
      this.name = name;
      return this;
    }

    public UserBuilder email(String email) {
      this.email = email;
      return this;
    }

    public UserBuilder password(String password) {
      this.password = password;
      return this;
    }

    public UserBuilder roleSet(Set<Role> roleSet) {
      this.roleSet = roleSet;
      return this;
    }

    public User build() {
      User user = new User(id, name, email, password);
      user.roleSet = this.roleSet;
      return user;
    }
  }
}
