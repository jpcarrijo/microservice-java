package com.microservice.hruser.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_role")
public class Role implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String roleName;


  public Role() {
  }

  public Role(Long id, String roleName) {
    this.id = id;
    this.roleName = roleName;
  }

  public Long getId() {
    return id;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Role)) return false;
    Role role = (Role) o;
    return getRoleName().equals(role.getRoleName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getRoleName());
  }

  public void setId(Long id) {
    this.id = id;
  }


  public static final class RoleBuilder {
    private Long id;
    private String roleName;

    private RoleBuilder() {
    }

    public static RoleBuilder builder() {
      return new RoleBuilder();
    }

    public RoleBuilder id(Long id) {
      this.id = id;
      return this;
    }

    public RoleBuilder roleName(String roleName) {
      this.roleName = roleName;
      return this;
    }

    public Role build() {
      return new Role(id, roleName);
    }
  }
}
