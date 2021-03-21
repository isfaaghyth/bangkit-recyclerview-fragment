package app.isfaaghyth.animallist.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import app.isfaaghyth.animallist.AnimalCallback
import app.isfaaghyth.animallist.MainActivity
import app.isfaaghyth.animallist.adapter.AnimalAdapter
import app.isfaaghyth.animallist.databinding.FragmentAnimalBinding
import app.isfaaghyth.animallist.datasource.Animal

class AnimalFragment : Fragment() {

    private var _binding: FragmentAnimalBinding? = null
    private val binding get() = _binding

    private var callback: AnimalCallback? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimalBinding.inflate(inflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // set the layout manager
        binding?.rvAnimal?.layoutManager = LinearLayoutManager(
            requireContext()
        )

        // set the adapter
        binding?.rvAnimal?.adapter = AnimalAdapter(
            ::onAnimalItemClicked,
            animalsMock()
        )
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // assign the callback object above
        // to getting the object from the MainActivity
        if (context is AnimalCallback) {
            callback = context
        }
    }

    private fun onAnimalItemClicked(animal: Animal) {
        // trigger the sendAnimal from the MainActivity
        callback?.sendAnimal(animal)

        Toast.makeText(
            requireContext(),
            "You select the ${animal.animalName} from ${animal.habitat}",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun animalsMock(): List<Animal> {
        return mutableListOf(
            Animal("https://www.biologicaldiversity.org/publications/earthonline/eeo_images/809-825/811/NorthAtlanticRightWhale_Wikimedia_NOAA_300.jpg", "Whale", "Oceans"),
            Animal("https://cdn.britannica.com/64/169964-004-9B802CA8.jpg", "Snake", "Desserts"),
            Animal("https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/65415823-1069-4dd1-940f-8c91660cb4a1/dasl6nh-50a15d1e-8b8e-4a5b-99a1-ece61f41a45e.jpg?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvNjU0MTU4MjMtMTA2OS00ZGQxLTk0MGYtOGM5MTY2MGNiNGExXC9kYXNsNm5oLTUwYTE1ZDFlLThiOGUtNGE1Yi05OWExLWVjZTYxZjQxYTQ1ZS5qcGcifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.7s9NAOP4YY5BJjYkI9xcRhidB-VHWc1zO5qf3SDyZ5U", "Wolf", "Polar")
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}