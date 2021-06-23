package ru.webthebestapp.eldrorado_klient

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import coil.load
import kotlinx.coroutines.*
import ru.webthebestapp.eldrorado_klient.data.Product

class FragmentBasket : Fragment() {
    private val coroutineScope = CoroutineScope(Job() + Dispatchers.IO)

    private val basketApi = NetworkModule().consultationApi
    private val clientId = 1

    private var tvName: TextView? = null
    private var ivProduct: ImageView? = null
    private var tvPrice: TextView? = null
    private var tvAmount: TextView? = null
    private var fragmentClickListener: FragmentClickListener? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.basket_fragment, container, false)

        tvName = view.findViewById(R.id.tv_name)
        ivProduct = view.findViewById(R.id.iv_product)
        tvPrice = view.findViewById(R.id.tv_price_cons)
        tvAmount = view.findViewById(R.id.tv_amount)

        val basketConsCircle = view.findViewById<ImageView>(R.id.iv_cons_circle)
        val basketClientCircle = view.findViewById<ImageView>(R.id.iv_client_circle)

        val tvConsBasket = view.findViewById<TextView>(R.id.tv_cons_basket)
        val tvClientBasket = view.findViewById<TextView>(R.id.tv_basket_client)

        val priceCons = view.findViewById<TextView>(R.id.tv_price_cons)
        val priceClient = view.findViewById<TextView>(R.id.tv_price_client)
        val price = view.findViewById<TextView>(R.id.tv_price)

        basketClientCircle.setOnClickListener {
            tvClientBasket.setTextColor(Color.GREEN)
            basketClientCircle.setImageResource(R.drawable.eclipse)
            price.text = priceClient.text


            tvConsBasket.setTextColor(Color.BLACK)
            basketConsCircle.setImageResource(R.drawable.eclipse_black)
        }

        basketConsCircle.setOnClickListener {
            tvConsBasket.setTextColor(Color.GREEN)
            basketConsCircle.setImageResource(R.drawable.eclipse)
            price.text = priceCons.text

            tvClientBasket.setTextColor(Color.BLACK)
            basketClientCircle.setImageResource(R.drawable.eclipse_black)

        }

        //getProduct(clientId)

        return view
    }
    private fun getProduct(clientId: Int) {
        coroutineScope.launch {
            val products = basketApi.getBasket(clientId)
            showProduct(products)
        }
    }
    private suspend fun showProduct(products: List<Product>) = Dispatchers.Main {
        tvName?.text = products[0].name
        tvPrice?.text = products[0].price.toString()
        tvAmount?.text = products[0].amount.toString()
        ivProduct?.load(products[0].image)
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