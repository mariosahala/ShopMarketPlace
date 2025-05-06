package id.mario.storemarketplace.ui.activity

import id.mario.core.base.BaseActivity
import id.mario.storemarketplace.databinding.ActivitySplashScreenShopBinding

class SplashScreenShopActivity : BaseActivity<ActivitySplashScreenShopBinding>() {
    override fun setViewBinding(): ActivitySplashScreenShopBinding =
        ActivitySplashScreenShopBinding.inflate(layoutInflater)

    override fun setUpVariable() {
        binding.apply {

        }
    }
}