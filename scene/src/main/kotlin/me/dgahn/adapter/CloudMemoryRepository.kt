package me.dgahn.adapter

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.dgahn.domain.model.Cloud
import me.dgahn.ports.CloudRepository
import me.dgahn.ports.SceneRepository
import me.dgahn.util.filterNotNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.util.UUID
import java.util.concurrent.ConcurrentHashMap
import kotlin.random.Random

@Repository
class CloudMemoryRepository(@Autowired sceneRepository: SceneRepository) : CloudRepository {

    private val map: MutableMap<String, Cloud> = ConcurrentHashMap()

    init {
        val sceneList = sceneRepository.findAll()
        CoroutineScope(Dispatchers.Default).launch {
            sceneList.forEach {
                val id = UUID.randomUUID().toString()
                map[id] = Cloud(id = id, sceneId = it.id, volume = Random.nextDouble(1.0))
                delay(1L)
                map[id] = Cloud(id = id, sceneId = it.id, volume = Random.nextDouble(1.0))
                delay(1L)
                map[id] = Cloud(id = id, sceneId = it.id, volume = Random.nextDouble(1.0))
                delay(1L)
            }
        }
    }

    override fun findBy(sceneId: String?, volumeRange: ClosedRange<Double>?)
            : List<Cloud> = map.filterNotNull(sceneId) { it.value.sceneId == sceneId }
        .filterNotNull(volumeRange) { volumeRange!!.contains(it.value.volume) }
        .map { it.value }

}
