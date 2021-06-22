package ru.webthebestapp.eldorado_consultant

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment

class FragmentBasket : Fragment() {
    private var fragmentClickListener: FragmentClickListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.basket_fragment, container, false)

        view?.findViewById<ImageView>(R.id.iv_back)?.apply {
            setOnClickListener {
                fragmentClickListener?.onReplaceFragmentConsultationClicked()
            }
        }

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
        fun newInstance(): FragmentBasket = FragmentBasket()
    }
}