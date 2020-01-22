package com.gtx.app_indihomev2.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "iptv")
public class Iptv implements Serializable {

    @Id
    @Column(name = "iptv_id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID iptvId;

    @Column(nullable = false, unique = true)
    @NotNull
    @NotEmpty
    @Size(min=12, max = 14)
    private String nomor;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    @Size(max = 7)
    private String password;

    @ManyToOne
    @JoinColumn(name = "pelanggan_id", nullable = false)
    private Pelanggan pelanggan;

    public Iptv() {

    }

    public Iptv(String nomor, String password) {
        this.nomor = nomor;
        this.password = password;
    }

    public Iptv(String nomor, String password, Pelanggan pelanggan) {
        this.nomor = nomor;
        this.password = password;
        this.pelanggan = pelanggan;
    }

    @Override
    public String toString() {
        return "Iptv{" +
                "iptvId=" + iptvId +
                ", nomor='" + nomor + '\'' +
                ", password='" + password + '\'' +
                ", pelanggan=" + pelanggan +
                '}';
    }
}
