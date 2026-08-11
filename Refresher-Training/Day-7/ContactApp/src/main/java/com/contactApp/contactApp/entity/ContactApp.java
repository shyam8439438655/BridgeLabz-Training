package com.contactApp.contactApp.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ContactApp")
public class ContactApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "mobNo", unique = true , nullable = false)
    private String mobNo;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "email", unique = true,nullable = false)
    private String email;

}
