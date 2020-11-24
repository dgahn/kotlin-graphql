package me.dgahn.converter

import me.dgahn.account.AccountResponse
import me.dgahn.entity.Account

fun Account.toProto(): AccountResponse = AccountResponse.newBuilder()
    .setId(id)
    .setName(name)
    .setEmail(email)
    .setCreatedTime(createdTime.toProto())
    .build()