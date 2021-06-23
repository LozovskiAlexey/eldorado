package ru.webthebestapp.eldorado_consultant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), FragmentClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .add(R.id.container, FragmentConsultation())
                .commit()
        }

    }

    override fun onReplaceFragmentConsultationClicked() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, FragmentConsultation())
            .commit()
    }


    override fun onReplaceFragmentBasketClicked() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, FragmentBasket())
            .commit()
    }

    override fun onReplaceFragmentTagClicked() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container, FragmentTag())
            .commit()
    }
}

interface FragmentClickListener {
    fun onReplaceFragmentConsultationClicked()
    fun onReplaceFragmentBasketClicked()
    fun onReplaceFragmentTagClicked()

}