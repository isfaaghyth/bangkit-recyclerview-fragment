package app.isfaaghyth.animallist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.isfaaghyth.animallist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

}