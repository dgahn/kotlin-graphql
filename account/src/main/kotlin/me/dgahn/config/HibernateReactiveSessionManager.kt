package me.dgahn.config

import org.hibernate.reactive.stage.Stage
import javax.persistence.Persistence


class HibernateReactiveSessionManager {

    private val emf = Persistence.createEntityManagerFactory("account")
    private val sessionFactory = emf.unwrap(Stage.SessionFactory::class.java)

    fun getSession(): Stage.Session = sessionFactory.openSession()

}