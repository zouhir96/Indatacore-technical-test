package com.zrcoding.indatacore.ui.product.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.zrcoding.indatacore.R
import com.zrcoding.indatacore.databinding.FragmentProductListBinding
import com.zrcoding.indatacore.databinding.LayoutProductChooserBinding
import com.zrcoding.indatacore.ui.MainActivity
import com.zrcoding.indatacore.ui.shared.CenterZoomLinearLayoutManager
import com.zrcoding.indatacore.ui.shared.ItemClick
import com.zrcoding.indatacore.ui.shared.Product

class ProductListFragment : Fragment(), ItemClick<Product> {

    companion object {
        fun newInstance() = ProductListFragment()
    }

    private var _binding: FragmentProductListBinding? = null
    private val binding: FragmentProductListBinding get() = _binding!!

    private val productListAdapter = ProductListAdapter(itemClickListener = this)
    private val snapHelper: SnapHelper = PagerSnapHelper()

    private val viewModel by viewModels<ProductListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (requireActivity() as MainActivity).changeTitle(R.string.title_home)
        (requireActivity() as MainActivity).changeStep(4)

        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_product_list,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.initUi()
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun FragmentProductListBinding.initUi() {
        productListRv.layoutManager = CenterZoomLinearLayoutManager(
            requireContext()
        )
        snapHelper.attachToRecyclerView(productListRv)
        productListRv.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    getCurrentItemPosition()?.let {
                        binding.productChooser.product = productListAdapter.getItemAt(it)
                    }
                }
            }
        )

        productListRv.adapter = productListAdapter
        productListAdapter.refreshList(viewModel.getProductList())

        chosenProduct = viewModel.getProductList()[0]

        productCountBtn.text = getString(R.string.product_count, 0)

        continueBtn.setOnClickListener {
            findNavController().navigate(
                R.id.action_productListFragment_to_cartFragment
            )
        }
        binding.productChooser.initUi()
    }

    private fun LayoutProductChooserBinding.initUi() {
        nextBtn.setOnClickListener {
            getCurrentItemPosition()?.let {
                binding.productListRv.scrollToPosition(it + 1)
            }
        }
        previousBtn.setOnClickListener {
            getCurrentItemPosition()?.let {
                binding.productListRv.scrollToPosition(it - 1)
            }
        }
        detailsBtn.setOnClickListener {
            findNavController().navigate(
                R.id.action_productListFragment_to_productDetailsFragment,
                Bundle().apply {
                    putString("id", "id")
                }
            )
        }
        addToCartBtn.setOnClickListener {

        }
    }

    override fun onItemClick(item: Product) {
        binding.productChooser.product = item
    }

    private fun getCurrentItemPosition(): Int? =
        snapHelper.findSnapView(binding.productListRv.layoutManager)?.let {
            binding.productListRv.getChildAdapterPosition(
                it
            )
        }

}