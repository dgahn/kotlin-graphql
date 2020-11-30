package me.dgahn.adapter

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Query
import kotlinx.coroutines.coroutineScope
import me.dgahn.domain.handler.CloudinessAnalysisHandler
import me.dgahn.domain.handler.SceneHandler
import me.dgahn.domain.model.Cloud
import me.dgahn.domain.model.Scene
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger { }

@Component
open class SceneQuery(
    @Autowired private val handler: SceneHandler
) : Query {

    @GraphQLDescription("운량 분석량을 조회할 수 있다.")
    suspend fun scene(id: String): Scene = coroutineScope {
        handler.findById(id)
    }

}