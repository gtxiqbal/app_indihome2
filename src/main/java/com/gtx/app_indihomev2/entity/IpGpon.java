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
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "ip_gpon")
public class IpGpon {

    @Id
    @Column(name = "ip_gpon_id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID ipGponId;

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
    @NotNull
    @NotEmpty
    @Size(min = 4,max = 4)
    private Integer vlan;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "ipGponId"
    )
    private List<Pelanggan> pelangganId = new ArrayList<>();
}
