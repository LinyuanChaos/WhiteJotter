package com.example.wj.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "admin_role")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class AdminRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    String name;
    @Column(name = "name_zh")
    private String nameZh;
    boolean enabled;
    @Transient
    private List<AdminPermission> perms;
    @Transient
    private List<AdminMenu> menus;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<AdminPermission> getPerms() {
        return perms;
    }

    public void setPerms(List<AdminPermission> perms) {
        this.perms = perms;
    }

    public List<AdminMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<AdminMenu> menus) {
        this.menus = menus;
    }
}
