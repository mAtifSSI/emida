package com.emdia.employee.model

import javax.persistence.*

@Entity
@Table
data class Employee (@Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
                     @Column(name="name") val name: String,
                     @Column(name="age") val age: Int) {
    constructor() : this(0,"",0) {

    }
}