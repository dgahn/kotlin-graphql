package me.dgahn.adapter

import me.dgahn.domain.model.Scene
import me.dgahn.ports.SceneRepository
import org.springframework.stereotype.Repository
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap

@Repository
class SceneMemoryRepository : SceneRepository {

    private val map: MutableMap<String, Scene> = ConcurrentHashMap()

    init {
        val sceneList = listOf(
            Scene(UUID.randomUUID().toString(), "1번 영상"),
            Scene(UUID.randomUUID().toString(), "2번 영상"),
            Scene(UUID.randomUUID().toString(), "3번 영상")
        )
        sceneList.forEach { map[it.id] = it }
    }

    override fun save(scene: Scene): Scene? = map.putIfAbsent(scene.id, scene)

    override fun findById(id: String?): Scene? = map[id]

    override fun findAll(): List<Scene> = map.values.toList()

}