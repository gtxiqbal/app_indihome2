package com.gtx.app_indihomev2.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "internet")
public class Internet {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @OneToOne
    @JoinColumn(name = "pelanggan_id", nullable = false, unique = true)
    @MapsId
    private Pelanggan pelangganId;

    @Column(nullable = false, unique = true)
    @NotNull
    @NotEmpty
    @Size(min = 12,max = 12)
    private String nomor;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 7, max = 7)
    private String password;
}
