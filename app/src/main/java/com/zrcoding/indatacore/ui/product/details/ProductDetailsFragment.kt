package com.zrcoding.indatacore.ui.product.details

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.zrcoding.indatacore.R
import com.zrcoding.indatacore.databinding.FragmentProductDetailsBinding
import kotlinx.coroutines.flow.collectLatest

const val KEY_ID = "com.zrcoding.indatacore.ui.product.details.ID"

class ProductDetailsFragment : DialogFragment() {

    companion object {
        fun newInstance(): ProductDetailsFragment {
            return ProductDetailsFragment()
        }
    }

    private var _binding: FragmentProductDetailsBinding? = null
    private val binding: FragmentProductDetailsBinding get() = _binding!!

    private val viewModel by viewModels<ProductDetailsViewModel>()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getString(KEY_ID)?.let { id ->
                viewModel.getProduct(id)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_product_details,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.initUi()
        observeData()
    }

    private fun FragmentProductDetailsBinding.initUi() {
        cancelBtn.setOnClickListener { dismiss() }
    }

    private fun observeData() {
        lifecycleScope.launchWhenStarted {
            viewModel.product.collectLatest {
                binding.product = it
            }
        }
    }
}