package me.dgahn.adapter

import com.expediagroup.graphql.annotations.GraphQLDescription
import com.expediagroup.graphql.spring.operations.Query
import kotlinx.coroutines.coroutineScope
import me.dgahn.domain.handler.CloudinessAnalysisHandler
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

private val logger = KotlinLogging.logger { }

@Component
open class CloudinessAnalysisQuery(
    @Autowired private val handler: CloudinessAnalysisHandler
) : Query {

    @GraphQLDescription("운량 분석량을 조회할 수 있다.")
    suspend fun cloudinessAnalysis(arg: CloudinessAnalysisArg?): List<CloudinessAnalysis> = coroutineScope {
        handler.findByCloudinessAnalysisHandler(arg)
    }

}