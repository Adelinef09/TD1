package fr.net.estia.feurte.a.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ComputeActivity : AppCompatActivity(), View.OnClickListener, TextWatcher {
    private lateinit var clickButton: Button
    private lateinit var textView: TextView
    private lateinit var nb1: EditText
    private lateinit var nb2: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.compute_activity)
        clickButton = findViewById(R.id.btn_calculer)
        textView = findViewById(R.id.resultat)
        nb1 = findViewById(R.id.field_1)
        nb2 = findViewById(R.id.field_2)
        nb1.addTextChangedListener(this)
        nb2.addTextChangedListener(this)
        clickButton.setOnClickListener(this)
        clickButton.isEnabled = false
    }

    override fun onClick(v: View?) {
        if (nb1.text.isNotBlank() && nb2.text.isNotBlank()) {
            textView.text = (nb1.text.toString().toDouble() + nb2.text.toString().toDouble()).toString()
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }

    override fun afterTextChanged(s: Editable?) {
        clickButton.isEnabled = nb1.text.isNotBlank() && nb2.text.isNotBlank()
    }
}
