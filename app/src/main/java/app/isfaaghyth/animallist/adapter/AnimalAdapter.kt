package app.isfaaghyth.animallist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import app.isfaaghyth.animallist.R
import app.isfaaghyth.animallist.databinding.ItemAnimalBinding
import app.isfaaghyth.animallist.datasource.Animal
import com.bumptech.glide.Glide

class AnimalAdapter(
    private val onItemClicked: (Animal) -> Unit,
    private val animals: List<Animal> = mutableListOf()
) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    // the viewHolder it will be handling the view component
    // of the item_animal.xml, to showing the data based on
    // the view component.
    inner class AnimalViewHolder(
        private val onItemClicked: (Animal) -> Unit,
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        // binding the view component with view binding
        private val binding = ItemAnimalBinding.bind(itemView)

        // bind the data of Animal into view component
        fun bind(animal: Animal) {
            binding.tvName.text = animal.animalName
            binding.tvHabitat.text = animal.habitat

            Glide.with(itemView.context)
                .asBitmap() // it will be convert from image resource into bitmap type
                .circleCrop() // convert image from square into circle
                .load(animal.imageUrl) // the image url
                .into(binding.ivAnimal) // set into imageView

            // adding the item view action (of click on listener)
            itemView.setOnClickListener {
                onItemClicked(animal)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        // it will be inflate your item layout into the viewHolder trough the adapter
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_animal, parent, false)

        return AnimalViewHolder(onItemClicked, view)
    }

    // it will be getting the size of the data
    override fun getItemCount(): Int {
        return animals.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        // set the data into the viewHolder
        holder.bind(animals[position])
    }

}