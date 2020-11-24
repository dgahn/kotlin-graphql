package me.dgahn.repo

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.future.asDeferred
import me.dgahn.entity.Account
import me.dgahn.fixture.getAccount
import me.dgahn.fixture.getManager

class AccountHibernateRepositoryTest : FunSpec({
    val accountRepo = AccountHibernateRepository(getManager())

    afterTest {
        accountRepo.deleteAll()
    }

    test("account을 저장할 수 있다.") {
        val account = getAccount()
        accountRepo.save(account)

        val findDeferred = accountRepo.findById(account.id)
        val actual = findDeferred.asDeferred().await()

        actual shouldBe account
    }

    test("account 목록을 불러올 수 있다") {
        val account = getAccount()
        val accounts = (1..10).fold(listOf<Account>()) { acc, num -> acc.plus(account.copy(id = "${account.id}_$num")) }
        accounts.forEach { accountRepo.save(it) }

        val findDeferred = accountRepo.findAll()
        val actual = findDeferred.asDeferred().await()

        actual shouldBe accounts
    }

    test("account 목록을 불러오면서 변환할 수 있다") {
        val account = getAccount()
        val accounts = (1..10).fold(listOf<Account>()) { acc, num -> acc.plus(account.copy(id = "${account.id}_$num")) }
        accounts.forEach { accountRepo.save(it) }

        val findDeferred = accountRepo.findAll()
        val actual = findDeferred.asDeferred().await()

        actual shouldBe accounts
    }

    test("account 목록을 불러오면서 proto로 변경할 수 있다.") {
        val account = getAccount()
        val accounts = (1..10).fold(listOf<Account>()) { acc, num -> acc.plus(account.copy(id = "${account.id}_$num")) }
        accounts.forEach { accountRepo.save(it) }

        val findDeferred = accountRepo.findAll()
        val actual = findDeferred.asDeferred().await()

        actual shouldBe accounts
    }

})