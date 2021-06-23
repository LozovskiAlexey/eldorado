package ru.webthebestapp.eldorado_consultant

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import coil.load
import kotlinx.coroutines.*
import ru.webthebestapp.eldorado_consultant.data.Basket
import ru.webthebestapp.eldorado_consultant.data.ConsultationClient
import ru.webthebestapp.eldorado_consultant.data.Product

class FragmentBasket : Fragment() {
    private val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)

    private val consultationApi = NetworkModule().consultationApi

    private var fragmentClickListener: FragmentClickListener? = null

    private val clientId = 1
    private val consultantId = 1
    private val productId = 1
    private var amount: Int = 0


    private var tvClient: TextView? = null
    private var tvTag: TextView? = null
    private var tvTag1: TextView? = null
    private var consultationId: Int? = null

    private var tvName: TextView? = null
    private var ivProduct: ImageView? = null
    private var tvPrice: TextView? = null
    private var tvAmount: TextView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.basket_fragment, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvClient = view.findViewById(R.id.tv_client_name)
        tvTag = view.findViewById(R.id.tv_tag)
        tvTag1 = view.findViewById(R.id.tv_tag1)

        tvName = view.findViewById(R.id.tv_name)
        ivProduct = view.findViewById(R.id.iv_product)
        tvPrice = view.findViewById(R.id.tv_price)
        tvAmount = view.findViewById(R.id.tv_amount)

        view.findViewById<ImageView>(R.id.iv_back)?.apply {
            setOnClickListener {
                fragmentClickListener?.onReplaceFragmentConsultationClicked()
            }
        }

        getClient(consultantId,clientId)

        view.findViewById<TextView>(R.id.tv_payment)?.apply {
            setOnClickListener {
                sendBasket(mapOf(productId to amount))
                fragmentClickListener?.onReplaceFragmentTagClicked()
            }
        }

        view.findViewById<ImageView>(R.id.iv_scan).setOnClickListener {
            getProduct(consultationId!!, productId)

        }
    }

    private fun getClient(consultantId: Int, clientId: Int) {
        coroutineScope.launch {
            val consultationClient = consultationApi.getConsultation(consultantId, clientId)
            showClient(consultationClient)
            consultationId = consultationClient.id
        }
    }

    private fun getProduct(consultationId: Int, productId: Int) {
        coroutineScope.launch {
            val product = consultationApi.getProduct(consultationId, productId)
            showProduct(product)
            amount = product.amount
        }
    }

    private fun sendBasket(products: Map<Int, Int>) {
        coroutineScope.launch {
            consultationApi.sendBasket(products)
        }
    }

    private suspend fun showProduct(product: Product) = Dispatchers.Main {
        tvName?.text = product.name
        tvPrice?.text = product.price.toString()
        tvAmount?.text = product.amount.toString()
        ivProduct?.load(product.image)
    }

    private fun showClient(client: ConsultationClient) {
        tvClient?.text = client.name
        tvTag?.text = client.tags[0]
        tvTag1?.text = client.tags[1]
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