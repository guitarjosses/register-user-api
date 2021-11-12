package com.jossessoft.user.register.data.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name = "PHONE")
@Data
public class Phone {

    @Id
    @Type(type="uuid-char")
    @Column(name = "PHONE_UUID",updatable = false,nullable = false)
    private UUID phoneUUID = UUID.randomUUID();

    @Type(type="uuid-char")
    @Column(name = "USER_UUID")
    private UUID userUUID;

    @Column(name = "PHONE_NUMBER")
    private String number;

    @Column(name = "CITY_CODE")
    private String citycode;

    @Column(name = "COUNTRY_CODE")
    private String countrycode;
    
}