package ru.webthebestapp.eldorado_consultant

import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment

class FragmentConsultation: Fragment() {
    private var fragmentClickListener: FragmentClickListener? = null
    private var isImageScaled = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.consultation_fragment, container, false)

        view?.findViewById<ImageView>(R.id.iv_basket)?.apply {
            setOnClickListener {
                fragmentClickListener?.onReplaceFragmentBasketClicked()
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
        fun newInstance(): FragmentConsultation = FragmentConsultation()
    }
}