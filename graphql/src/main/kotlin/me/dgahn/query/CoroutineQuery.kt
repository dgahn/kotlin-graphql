package me.dgahn.query

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Query
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import mu.KotlinLogging
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger { }

@Component
class CoroutineQuery : Query {

    @GraphQLDescription("Example query that uses coroutines")
    suspend fun sample(): Sample = coroutineScope {
        delay(1_000L)
        Sample(name = "sample")
    }

}

data class Sample(val name: String)