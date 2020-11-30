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
class SceneHandler(
    @Autowired private val sceneRepository: SceneRepository,
) {
    fun findById(id: String): Scene = sceneRepository.findById(id) ?: throw NoSuchElementException()
}