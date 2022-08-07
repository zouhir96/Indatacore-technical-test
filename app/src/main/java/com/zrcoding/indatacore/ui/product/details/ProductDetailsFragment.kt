package com.zrcoding.indatacore.ui.product.details

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import com.zrcoding.indatacore.R
import com.zrcoding.indatacore.databinding.FragmentProductDetailsBinding

const val KEY_ID = "com.zrcoding.indatacore.ui.product.details.ID"

class ProductDetailsFragment : DialogFragment() {

    companion object {
        fun newInstance(id: String): ProductDetailsFragment {
            return ProductDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(KEY_ID, "")
                }
            }
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
        arguments?.let {
            it.getString(KEY_ID)?.let { id ->
                binding.product = viewModel.getProduct(id)
            }
        }

        binding.initUi()
    }

    private fun FragmentProductDetailsBinding.initUi() {
        cancelBtn.setOnClickListener { dismiss() }
    }
}