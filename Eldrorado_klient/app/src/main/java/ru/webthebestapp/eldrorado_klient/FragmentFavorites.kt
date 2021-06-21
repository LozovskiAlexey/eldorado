package ru.webthebestapp.eldrorado_klient

import android.content.Context
import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentFavorites : Fragment() {
    private var fragmentClickListener: FragmentClickListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.basket_fragment, container, false)

//        view?.findViewById<ImageView>(R.id.imageView6)?.apply {
//            setOnClickListener {
//                fragmentClickListener?.onReplaceFragmentFavoritesClicked()
//            }
//        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentClickListener) {
            fragmentClickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        fragmentClickListener = null
    }


    companion object {
        fun newInstance(): FragmentFavorites = FragmentFavorites()
    }
}