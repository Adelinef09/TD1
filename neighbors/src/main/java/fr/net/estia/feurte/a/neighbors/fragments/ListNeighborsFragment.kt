package fr.net.estia.feurte.a.neighbors.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.neighbors.fragments.AddNeighbourFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import fr.net.estia.feurte.a.neighbors.NavigationListener
import fr.net.estia.feurte.a.neighbors.R
import fr.net.estia.feurte.a.neighbors.adapters.ListNeighborHandler
import fr.net.estia.feurte.a.neighbors.adapters.ListNeighborsAdapter
import fr.net.estia.feurte.a.neighbors.data.NeighborRepository
import fr.net.estia.feurte.a.neighbors.models.Neighbor

class ListNeighborsFragment : Fragment(), ListNeighborHandler {
    /**
     * Fonction permettant de définir une vue à attacher à un fragment
     */
    private lateinit var recyclerView: RecyclerView
    private lateinit var addNeighbor: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_neighbors_fragment, container, false)
        recyclerView = view.findViewById(R.id.neighbors_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        addNeighbor = view.findViewById(R.id.add_button)

        (activity as? NavigationListener)?.updateTitle(R.string.list_neighbor)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter
        addNeighbor.setOnClickListener {
            (activity as? NavigationListener)?.showFragment(AddNeighbourFragment())
        }
    }

    override fun onDeleteNeibor(neighbor: Neighbor) {

        val builder = AlertDialog.Builder(this.requireContext())
        builder.setTitle("Confirmation")
        builder.setMessage("Voulez-vous supprimer ce voisin ?")
        builder.setNegativeButton("non") { _, _ -> }
        builder.setPositiveButton(
            "oui"
        ) { _, _ ->
            NeighborRepository.getInstance().deleteNeighbours(neighbor)
            val neighbors = NeighborRepository.getInstance().getNeighbours()
            val adapter = ListNeighborsAdapter(neighbors, this)
            recyclerView.adapter = adapter
        }
        builder.show()
    }
}
