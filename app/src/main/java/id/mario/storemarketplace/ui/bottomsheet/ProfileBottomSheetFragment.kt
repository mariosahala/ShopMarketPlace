package id.mario.storemarketplace.ui.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import id.mario.storemarketplace.R
import id.mario.storemarketplace.databinding.FragmentProfileBottomSheetBinding
import id.mario.storemarketplace.ui.adapter.ProfileAccountAdapter
import id.mario.storemarketplace.viewmodel.model.AccountProfileModel

class ProfileBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var accountProfileAdapter: ProfileAccountAdapter

    private var _binding: FragmentProfileBottomSheetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBottomSheetBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.CustomBottomSheetDialogThemeInput)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        val data: ArrayList<AccountProfileModel> = arrayListOf(
            AccountProfileModel("My Account", R.drawable.ic_account_profile),
            AccountProfileModel("Purchase History", R.drawable.ic_purchase_history),
            AccountProfileModel("Payment Methods", R.drawable.ic_material_payment),
            AccountProfileModel("Help Center", R.drawable.ic_question)
        )

        accountProfileAdapter = ProfileAccountAdapter()
        accountProfileAdapter.differ.submitList(data)
        binding.rvAccountProfile.adapter = accountProfileAdapter
        binding.rvAccountProfile.layoutManager = LinearLayoutManager(requireContext())
    }
}
