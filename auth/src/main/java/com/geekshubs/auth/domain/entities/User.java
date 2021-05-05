package com.geekshubs.auth.domain.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data
@Entity(name="USERS")
public class User {

    @Id
    private String uuid = UUID.randomUUID().toString();

    @Column
    private String name;

    @Column
    private String last_name;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_created = new Date();





}
