package fr.net.estia.feurte.a.tp1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var imageView: ImageView
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView = findViewById(R.id.image_view)
        button = findViewById(R.id.my_button)
        button.setOnClickListener(this)
        loadImage("https://img-19.ccm2.net/cI8qqj-finfDcmx6jMK6Vr-krEw=/1500x/smart/b829396acc244fd484c5ddcdcb2b08f3/ccmcms-commentcamarche/20494859.jpg")
    }

    override fun onClick(view: View?) {
        val link = mutableListOf(
            "https://www.editions-equinoxe.com/editeur-livre-provence/uploads/2018/08/La-cigogne-voyageuse-du-levant-aux-editions-Equinoxe_photo-maurice-schalker.jpg",
            "https://cdn.futura-sciences.com/buildsv6/images/wide1920/4/f/0/4f0a7b509c_50154019_oeufs-moustique-tigre-diapause.jpg",
            "https://www.anmp-plongee.com/wp-content/uploads/2016/06/N2.png",
            "https://cdn.futura-sciences.com/buildsv6/images/largeoriginal/a/0/f/a0fc73919d_50166390_chaton.jpg"
        )
        loadImage(link.random())
        Toast.makeText(this, "You click me", Toast.LENGTH_LONG).show()
    }

    private fun loadImage(url: String) {
        Picasso.get()
            .load(url)
            .resize(500, 500)
            .centerCrop()
            .into(imageView)
    }
}
