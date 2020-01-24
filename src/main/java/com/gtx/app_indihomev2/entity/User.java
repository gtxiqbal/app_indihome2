package com.gtx.app_indihomev2.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "users")
public class User extends BaseEntity {

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String username;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Role> roles;

    @Column(nullable = false)
    private boolean active;
}
