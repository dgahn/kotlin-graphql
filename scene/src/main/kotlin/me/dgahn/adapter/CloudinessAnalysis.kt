package me.dgahn.adapter

import me.dgahn.domain.model.Cloud
import me.dgahn.domain.model.Scene

data class CloudinessAnalysis(
    val scene: Scene,
    val cloudList: List<Cloud> = emptyList()
)

data class CloudinessAnalysisArg(
    val sceneId: String?,
    val minValue: Double?,
    val maxValue: Double?
)

fun List<Scene>.toCloudinessAnalysis(cloudMap: Map<String, List<Cloud>>): List<CloudinessAnalysis> =
    this.map { it.toCloudinessAnalysis(cloudMap) }

fun Scene.toCloudinessAnalysis(cloudList: Map<String, List<Cloud>>): CloudinessAnalysis =
    CloudinessAnalysis(scene = this, cloudList = cloudList.getValue(this.id))
