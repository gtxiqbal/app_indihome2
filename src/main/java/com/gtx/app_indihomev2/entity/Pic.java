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
@Table
public class Pic implements Serializable {
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

    @OneToMany(mappedBy = "pic", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pelanggan> pelanggan;
}
