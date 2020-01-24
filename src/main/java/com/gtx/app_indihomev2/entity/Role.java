package com.gtx.app_indihomev2.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Role extends BaseEntity {

    private String name;
}
