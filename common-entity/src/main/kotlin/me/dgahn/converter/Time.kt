package me.dgahn.converter

import com.google.protobuf.Timestamp
import java.time.ZonedDateTime

fun ZonedDateTime.toProto(): Timestamp = Timestamp.newBuilder()
    .setSeconds(this.toEpochSecond())
    .setNanos(this.nano)
    .build()
