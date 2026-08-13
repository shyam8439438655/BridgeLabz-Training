package com.contactApp.contactApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="ContactApp")
public class ContactApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name" ,nullable = false,unique = false)
    private String name;

    @Column(name="mobNo",nullable = false,unique = true)
    private String mobNo;

    @Column(name="email", nullable = false ,unique = true)
    private String email;

}