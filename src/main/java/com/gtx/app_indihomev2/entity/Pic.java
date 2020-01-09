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
@Table
public class Pic {

    @Id
    @Column(name = "pic_id")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private UUID picId;

    @Column(nullable = false)
    @NotNull
    @NotEmpty
    @Size(max = 50)
    private String nama;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "picId"
    )
    private List<Pelanggan> pelangganId = new ArrayList<>();
}
