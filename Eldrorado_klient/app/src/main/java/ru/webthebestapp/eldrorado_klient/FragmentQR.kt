package ru.webthebestapp.eldrorado_klient

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment

class FragmentQR: Fragment() {
    private var fragmentClickListener: FragmentClickListener? = null
    private var isImageScaled = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.qr_kod_fragment, container, false)

        view?.findViewById<ImageView>(R.id.iv_home1)?.apply {
            setOnClickListener {
                AlertDialog.Builder(context).setView(R.layout.qr).show()
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
        fun newInstance(): FragmentQR = FragmentQR()
    }
}