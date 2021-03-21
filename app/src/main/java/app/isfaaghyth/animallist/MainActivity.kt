package app.isfaaghyth.animallist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.isfaaghyth.animallist.adapter.AnimalAdapter
import app.isfaaghyth.animallist.databinding.ActivityMainBinding
import app.isfaaghyth.animallist.datasource.Animal
import app.isfaaghyth.animallist.fragment.AnimalDetailFragment
import app.isfaaghyth.animallist.fragment.AnimalFragment

class MainActivity : AppCompatActivity(), AnimalCallback {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // for the default view
        openFragment(AnimalFragment())

        binding?.btnAnimal?.setOnClickListener {
            openFragment(AnimalFragment())
        }

        binding?.btnAnimalDetail?.setOnClickListener {
            openFragment(AnimalDetailFragment())
        }
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
    }

    override fun sendAnimal(animal: Animal) {
        val animalDetailFragment = AnimalDetailFragment()

        // preparing the data to ready to send into the AnimalDetailFragment
        val bundle = Bundle()
        bundle.putString("animal_name", animal.animalName)
        bundle.putString("animal_habitat", animal.habitat)

        // send to the fragment
        animalDetailFragment.arguments = bundle

        openFragment(animalDetailFragment)
    }

}