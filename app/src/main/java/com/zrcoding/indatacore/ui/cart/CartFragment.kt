package com.zrcoding.indatacore.ui.cart

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import com.zrcoding.indatacore.R
import com.zrcoding.indatacore.databinding.FragmentCartBinding
import com.zrcoding.indatacore.ui.MainActivity
import com.zrcoding.indatacore.ui.shared.Product


class CartFragment : Fragment(), CartProductAdapterListener {

    companion object {
        fun newInstance() = CartFragment()
    }

    private var _binding: FragmentCartBinding? = null
    private val binding: FragmentCartBinding get() = _binding!!

    private val cartProductAdapter = CartProductAdapter(listener = this)

    private val viewModel: CartViewModel by viewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (requireActivity() as MainActivity).changeTitle(R.string.title_cart)
        (requireActivity() as MainActivity).changeStep(5)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_cart,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.initUi()
    }

    private fun FragmentCartBinding.initUi() {
        PagerSnapHelper().attachToRecyclerView(productListRv)
        productListRv.adapter = cartProductAdapter
        cartProductAdapter.refreshList(viewModel.getCartProductList())

        footer.setNavigationOnClickListener { findNavController().popBackStack() }
    }

    override fun onDetailsClicked(product: Product) {
        findNavController().navigate(
            R.id.action_cartFragment_to_productDetailsFragment,
            Bundle().apply {
                putString("id", "id")
            }
        )
    }

    override fun onRemoveClicked(product: Product) {
        TODO("Not yet implemented")
    }
}