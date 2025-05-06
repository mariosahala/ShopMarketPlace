package id.mario.storemarketplace.ui.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import id.mario.core.base.BaseFragment
import id.mario.storemarketplace.databinding.FragmentDetailProductBinding

@AndroidEntryPoint
class DetailProductFragment : BaseFragment<FragmentDetailProductBinding>() {
    override fun setViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDetailProductBinding =
        FragmentDetailProductBinding.inflate(layoutInflater, container, false)


    override fun setUpVariable() {
    }

}