package ru.webthebestapp.eldrorado_klient

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity(), FragmentClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .add(R.id.container, FragmentQR())
                .commit()
        }

        onSetButtonColor()

    }

    override fun onReplaceFragmentFavoritesClicked() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, FragmentFavorites())
            .commit()
    }


    override fun onReplaceFragmentQRClicked() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, FragmentQR())
            .commit()
    }

    fun onSetButtonColor() {

        val basketImageView = findViewById<ImageView>(R.id.iv_basket)
        val qrImageView = findViewById<ImageView>(R.id.iv_home)
        val basketTextView = findViewById<TextView>(R.id.tv_basket)
        val qrTextView = findViewById<TextView>(R.id.tv_home)

        qrImageView.setColorFilter(Color.GREEN)
        qrTextView.setTextColor(Color.GREEN)

        basketImageView?.apply {
            setOnClickListener {
                basketImageView.setColorFilter(Color.GREEN)
                basketTextView.setTextColor(Color.GREEN)
                qrImageView.setColorFilter(Color.BLACK)
                qrTextView.setTextColor(Color.BLACK)
                onReplaceFragmentFavoritesClicked()
            }
        }

        basketTextView?.apply {
            setOnClickListener {
                basketImageView.setColorFilter(Color.GREEN)
                basketTextView.setTextColor(Color.GREEN)
                qrImageView.setColorFilter(Color.BLACK)
                qrTextView.setTextColor(Color.BLACK)
                onReplaceFragmentFavoritesClicked()
            }
        }

        qrImageView?.apply {
            setOnClickListener {
                basketImageView?.setColorFilter(Color.BLACK)
                basketTextView.setTextColor(Color.BLACK)
                qrImageView.setColorFilter(Color.GREEN)
                qrTextView.setTextColor(Color.GREEN)
                onReplaceFragmentQRClicked()
            }
        }

        basketTextView?.apply {
            setOnClickListener {
                basketImageView.setColorFilter(Color.GREEN)
                basketTextView.setTextColor(Color.GREEN)
                qrImageView.setColorFilter(Color.BLACK)
                qrTextView.setTextColor(Color.BLACK)
                onReplaceFragmentFavoritesClicked()
            }
        }
    }
}

interface FragmentClickListener {
    fun onReplaceFragmentFavoritesClicked()
    fun onReplaceFragmentQRClicked()
    
}