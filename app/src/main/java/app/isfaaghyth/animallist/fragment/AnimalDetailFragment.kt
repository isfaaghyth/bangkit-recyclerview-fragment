package app.isfaaghyth.animallist.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import app.isfaaghyth.animallist.databinding.FragmentAnimalDetailBinding

class AnimalDetailFragment : Fragment() {

    private var _binding: FragmentAnimalDetailBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimalDetailBinding.inflate(inflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            // the key of `animal_name` is must be same as the bundle in MainActivity
            val animalName = it.getString("animal_name")?: ""
            binding?.tvName?.text = animalName
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}