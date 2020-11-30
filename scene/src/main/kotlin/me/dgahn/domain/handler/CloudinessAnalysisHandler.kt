package me.dgahn.domain.handler

import me.dgahn.adapter.CloudinessAnalysis
import me.dgahn.adapter.CloudinessAnalysisArg
import me.dgahn.adapter.toCloudinessAnalysis
import me.dgahn.domain.model.Scene
import me.dgahn.ports.CloudRepository
import me.dgahn.ports.SceneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CloudinessAnalysisHandler(
    @Autowired private val sceneRepository: SceneRepository,
    @Autowired private val cloudRepository: CloudRepository
) {
    fun findByCloudinessAnalysisHandler(arg: CloudinessAnalysisArg?): List<CloudinessAnalysis> {
        val sceneList: List<Scene> = if (!arg?.sceneId.isNullOrBlank()) {
            val scene = sceneRepository.findById(arg?.sceneId)
            if (scene == null) emptyList() else listOf(scene)
        } else {
            sceneRepository.findAll()
        }

        val map = sceneList.associate { it.id to cloudRepository.findBy(it.id) }
        return sceneList.toCloudinessAnalysis(map)
    }
}