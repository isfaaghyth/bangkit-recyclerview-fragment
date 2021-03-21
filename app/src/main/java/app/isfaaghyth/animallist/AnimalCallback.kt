package app.isfaaghyth.animallist

import app.isfaaghyth.animallist.datasource.Animal

// interface is the abstract class
interface AnimalCallback {
    fun sendAnimal(animal: Animal)
}