package fr.net.estia.feurte.a.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import fr.net.estia.feurte.a.activities.databinding.ComputeActivityBinding

class ComputeActivity : AppCompatActivity(), View.OnClickListener, TextWatcher {
    private lateinit var binding: ComputeActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ComputeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.field1.addTextChangedListener(this)
        binding.field2.addTextChangedListener(this)
        binding.btnCalculer.setOnClickListener(this)
        binding.btnCalculer.isEnabled = false
    }

    override fun onClick(v: View?) {
        if (binding.field1.text.isNotBlank() && binding.field2.text.isNotBlank()) {
            binding.resultat.text = (binding.field1.text.toString().toDouble() + binding.field2.text.toString().toDouble()).toString()
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        binding.btnCalculer.isEnabled = binding.field1.text.isNotBlank() && binding.field2.text.isNotBlank()
    }
}
