package me.dgahn.entity

import java.time.ZonedDateTime
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(name = "account")
data class Account(
    @Id
    val id: String,
    val name: String,
    val password: String,
    val email: String,
    val createdTime: ZonedDateTime
)
