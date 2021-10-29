package fr.net.estia.feurte.a.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.net.estia.feurte.a.activities.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var nbClick = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCompute.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }
        binding.btnClickMe.setOnClickListener {
            nbClick++
            binding.textView.text = getString(R.string.you_click, nbClick)

            if (nbClick == 0) {
                binding.textView.text = ""
            }

            if (nbClick > 5) {
                binding.btnClickMe.isEnabled = false
            }
        }
    }
}
