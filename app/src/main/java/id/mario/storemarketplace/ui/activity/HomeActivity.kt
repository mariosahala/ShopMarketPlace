package id.mario.storemarketplace.ui.activity

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import id.mario.core.base.BaseActivity
import androidx.navigation.ui.setupWithNavController
import id.mario.core.util.gone
import id.mario.core.util.visible
import id.mario.storemarketplace.R
import id.mario.storemarketplace.databinding.ActivityHomeBinding

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding>() {
    private lateinit var navController: NavController

    override fun setViewBinding(): ActivityHomeBinding {
        return ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun setUpVariable() {
        binding.apply {
            val navHostFragment =
                supportFragmentManager.findFragmentById(R.id.frag_content) as NavHostFragment
            navController = navHostFragment.findNavController()

            bnvContent.apply {
                setupWithNavController(navController)
            }
            navController.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.homeFragment, R.id.cartFragment -> {
                        bnvContent.visible()
                    }

                    else -> {
                        bnvContent.gone()
                    }
                }
            }
        }
    }
}