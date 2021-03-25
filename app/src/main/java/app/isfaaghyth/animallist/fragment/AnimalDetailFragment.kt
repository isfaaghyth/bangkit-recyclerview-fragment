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

        val bundle = AnimalDetailFragmentArgs.fromBundle(arguments as Bundle)

        binding?.tvName?.text = "${bundle.name} is from ${bundle.habitat}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}