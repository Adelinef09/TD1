package fr.net.estia.feurte.a.neighbors.adapters

import fr.net.estia.feurte.a.neighbors.models.Neighbor

interface ListNeighborHandler {
    fun onDeleteNeibor(neighbor: Neighbor)
}
