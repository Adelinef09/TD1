package fr.net.estia.feurte.a.neighbors.data

import fr.net.estia.feurte.a.neighbors.data.service.DummyNeighborApiService
import fr.net.estia.feurte.a.neighbors.data.service.NeighborApiService
import fr.net.estia.feurte.a.neighbors.models.Neighbor

class NeighborRepository {
    private val apiService: NeighborApiService

    init {
        apiService = DummyNeighborApiService()
    }

    fun getNeighbours(): List<Neighbor> = apiService.neighbours

    fun deleteNeighbours(neighbor: Neighbor) = apiService.deleteNeighbour(neighbor)

    fun createNeighbours(neighbor: Neighbor) = apiService.createNeighbour(neighbor)

    companion object {
        private var instance: NeighborRepository? = null
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance!!
        }
    }
}
