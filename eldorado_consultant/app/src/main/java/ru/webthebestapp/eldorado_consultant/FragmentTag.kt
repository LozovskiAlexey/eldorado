package ru.webthebestapp.eldorado_consultant

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class FragmentTag: Fragment() {
    private val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)

    private val consultationApi = NetworkModule().consultationApi

    private var fragmentClickListener: FragmentClickListener? = null

    private var gamerTag: TextView? = null
    private var studyTag: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.tag_fragment, container, false)

        gamerTag = view.findViewById(R.id.tv_tag_play)
        studyTag = view.findViewById(R.id.tv_tag_study)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<TextView>(R.id.tv_sentTags).setOnClickListener {
            setClientTags(clientTags())
        }

        view.findViewById<ImageView>(R.id.iv_backToBasket).setOnClickListener {
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

    private fun setClientTags(tags: List<String>) {
        coroutineScope.launch {
            consultationApi.setClientTags(tags)
        }
    }

    private fun clientTags() : List<String> = listOf(gamerTag?.text.toString(), studyTag?.text.toString())

    companion object {
        fun newInstance(): FragmentTag = FragmentTag()
    }
}