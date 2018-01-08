package com.example.backend.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Problem constructor(
        var name: String = "",
        var description: String = "",
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0
) {
}