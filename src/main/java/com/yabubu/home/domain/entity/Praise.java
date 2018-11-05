package com.yabubu.home.domain.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Praise {

    @Id
    private int id;

    @Column
    private String contents;

    @Column(name = "created_at", insertable = false)
    private Date createdAt;
}
