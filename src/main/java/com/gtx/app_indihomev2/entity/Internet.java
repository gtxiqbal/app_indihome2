package com.gtx.app_indihomev2.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "internet")
public class Internet {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID id;

    @OneToOne
    @JoinColumn(name = "pelanggan_id", nullable = false, unique = true)
    @MapsId
    private Pelanggan pelanggan;

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
