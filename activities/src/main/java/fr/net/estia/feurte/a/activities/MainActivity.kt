package fr.net.estia.feurte.a.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var clickButton: Button
    private lateinit var textView: TextView
    private lateinit var computeButton: Button
    private var nbClick = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickButton = findViewById(R.id.btn_click_me)
        textView = findViewById(R.id.text_view)
        computeButton = findViewById(R.id.btn_compute)
        computeButton.setOnClickListener {
            val intent = Intent(baseContext, ComputeActivity::class.java)
            startActivity(intent)
        }
        clickButton.setOnClickListener {
            nbClick++
            val newText = "Vous avez cliquez $nbClick fois"
            textView.text = newText

            if (nbClick == 0) {
                textView.text = ""
            }

            if (nbClick > 5) {
                clickButton.isEnabled = false
            }
        }
    }
}
