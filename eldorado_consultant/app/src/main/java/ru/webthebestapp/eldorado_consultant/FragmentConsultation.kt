package ru.webthebestapp.eldorado_consultant

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import ru.webthebestapp.eldorado_consultant.data.ConsultationClient

class FragmentConsultation: Fragment() {
    private var fragmentClickListener: FragmentClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.consultation_fragment, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<ImageView>(R.id.iv_qr_scan).setOnClickListener {
            fragmentClickListener?.onReplaceFragmentBasketClicked()
        }
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