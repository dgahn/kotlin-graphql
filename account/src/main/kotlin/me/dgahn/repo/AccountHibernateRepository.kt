package me.dgahn.repo

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.future.asDeferred
import me.dgahn.config.HibernateReactiveSessionManager
import me.dgahn.entity.Account
import java.io.Closeable
import java.util.concurrent.CompletionStage

class AccountHibernateRepository(
    sessionManager: HibernateReactiveSessionManager
) : AccountRepository, Closeable {
    private val session = sessionManager.getSession()

    fun save(account: Account): Void =
        session.withTransaction {
            session.persist(account)
        }
            .toCompletableFuture().join()

    fun findById(id: String): CompletionStage<Account> {
        return session.withTransaction {
            session.find(Account::class.java, id)
        }
    }

    fun <T> findById(id: String, action: (account: Account) -> CompletionStage<T>) {
        session.withTransaction {
            session.find(Account::class.java, id)
                .thenCompose { account -> action(account) }
        }
    }

    fun findAll(): CompletionStage<MutableList<Account>> {
        return session.createNativeQuery("SELECT * FROM ${Account::class.simpleName}", Account::class.java)
            .resultList
    }

    fun <T> findAll(action: (account: Account) -> T): CompletionStage<MutableList<Account>> {
        return session.createNativeQuery("SELECT * FROM ${Account::class.simpleName}", Account::class.java)
            .resultList
    }

    fun deleteAll() {
        session.createNativeQuery("DELETE FROM ${Account::class.simpleName}", Account::class.java)
            .executeUpdate()
    }

    override fun close() {
        session.close()
    }

}