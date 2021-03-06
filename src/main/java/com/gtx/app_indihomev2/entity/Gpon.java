package com.gtx.app_indihomev2.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "gpon")
public class Gpon implements Serializable {
    @Id
    @Column(name = "gpon_id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID gponId;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    @Size(max = 30)
    private String hostname;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 7,max = 15)
    private String ip;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    @Size(min = 2,max = 6)
    private String vendor;

    @Column(nullable = false)
    private Integer vlan;

    @OneToMany(mappedBy = "gpon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pelanggan> pelanggan;
}
