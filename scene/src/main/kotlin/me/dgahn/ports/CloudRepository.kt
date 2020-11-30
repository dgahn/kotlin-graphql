package me.dgahn.ports

import me.dgahn.domain.model.Cloud

interface CloudRepository {

    fun findBy(sceneId: String? = null, volumeRange: ClosedRange<Double>? = null): List<Cloud>

}