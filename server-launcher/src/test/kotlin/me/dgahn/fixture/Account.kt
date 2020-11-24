package me.dgahn.fixture

import me.dgahn.entity.Account
import java.time.ZonedDateTime

fun getAccount() = Account(
    id = "test",
    password = "1234",
    name = "테스트",
    email = "email@email.com",
    createdTime = ZonedDateTime.now()
)