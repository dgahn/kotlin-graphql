package me.dgahn.ports

import me.dgahn.domain.model.Scene

interface SceneRepository {

    fun save(scene: Scene): Scene?

    fun findById(id: String?): Scene?

    fun findAll(): List<Scene>

}