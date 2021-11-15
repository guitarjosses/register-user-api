package com.jossessoft.user.register.data.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name = "USER")
@Data
public class User {
    
    @Id
    @Type(type="uuid-char")
    @Column(name = "USER_UUID",updatable = false,nullable = false)
    private UUID userUUID = UUID.randomUUID();

    @Column(name = "CREATED")
    private Date created = new Date();

    @Column(name = "MODIFIED")
    private Date modified = new Date();

    @Column(name = "LAST_LOGIN")
    private Date lastLogin = new Date();

    @Type(type="uuid-char")
    @Column(name = "TOKEN")
    private UUID token;

    @Column(name = "ISACTIVE")
    private boolean isActive = true;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USER_PASSWORD")
    private String password;

    @OneToMany(targetEntity = Phone.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_UUID")
    private List<Phone> phones;

}