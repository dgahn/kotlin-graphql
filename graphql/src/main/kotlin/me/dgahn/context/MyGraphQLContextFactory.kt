package me.dgahn.context

import com.expediagroup.graphql.spring.execution.GraphQLContextFactory
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.http.server.reactive.ServerHttpResponse
import org.springframework.stereotype.Component

/**
 * [MyGraphQLContextFactory] GraphQL 요청을 처리 할 때 사용할 수있는 [MyGraphQLContext]를 생성합니다.
 */

@Component
class MyGraphQLContextFactory : GraphQLContextFactory<MyGraphQLContext> {

    override suspend fun generateContext(request: ServerHttpRequest, response: ServerHttpResponse): MyGraphQLContext =
        MyGraphQLContext(
            myCustomValue = request.headers.getFirst("MyHeader") ?: "defaultContext",
            request = request,
            response = response,
            subscriptionValue = null
        )
}