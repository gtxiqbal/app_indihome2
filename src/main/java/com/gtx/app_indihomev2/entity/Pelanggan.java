package com.gtx.app_indihomev2.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
public class Pelanggan {

    @Id
    @Column(name = "pelanggan_id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String pelangganId;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String nama;

    @Column(name = "ip_gpon_id", nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 7,max = 15)
    private String ipGponId;

    @Column(name = "slot_port", nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 3,max = 5)
    private String slotPort;

    @Column(name = "onu_id", nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 1,max = 2)
    private String onuId;

    @Column(name = "sn_ont", nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 12,max = 16)
    private String snOnt;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    private Float harga;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 5, max = 11)
    private String status;

    @ManyToOne
    @JoinColumn(name = "pic_id", nullable = false)
    private Pic picId;
}
