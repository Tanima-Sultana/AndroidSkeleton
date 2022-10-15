package com.example.androidskeleton.ui

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.example.androidskeleton.R
import com.example.androidskeleton.utils.AlertButtonData
import com.example.androidskeleton.utils.Constants
import com.example.androidskeleton.utils.NetworkUtil
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private val navController by lazy {
        findNavController(R.id.nav_host_fragment)
    }


    private val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
        if(destination.id == R.id.fragmentLogin
            || destination.id == R.id.fragmentSplash
        //|| destination.id == R.id.messagingFragment
        ){
            toggleMenu(false)
        } else {
            toggleMenu(true)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)


        appBarConfiguration = AppBarConfiguration(
            setOf(
               R.id.fragmentLogin, R.id.fragmentSplash, R.id.fragmentHome,

            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navView.setNavigationItemSelectedListener {
            if (it.itemId == R.id.nav_logout) {

                //TODO logout function will be added later
                //logOut()
            } else {
                NavigationUI.onNavDestinationSelected(it, navController)
                drawerLayout.closeDrawer(GravityCompat.START)
            }
            return@setNavigationItemSelectedListener true
        }

    }

        fun navigateToHome(){
            navController.popBackStack(R.id.fragmentHome, true)
            navController.navigate(R.id.action_fragmentLogin_to_fragmentHome)
        }

    private fun navigateToLogin(){
        navController.popBackStack(R.id.fragmentHome, true)
        navController.navigate(R.id.action_global_loginFragment)
    }



    fun showAlert(
        title: String? = null, message: String? = null,
        positiveButtonData: AlertButtonData? = null,
        negativeButtonData: AlertButtonData? = null,
        neutralButtonData: AlertButtonData? = null
    ) {
        val builder = AlertDialog.Builder(this)

        if(!title.isNullOrBlank()) builder.setTitle(title)
        if (!message.isNullOrBlank()) builder.setMessage(message)

        if (positiveButtonData != null) {
            builder.setPositiveButton(positiveButtonData.title ?: "") { _, _ ->
                positiveButtonData.action?.let { it() }
            }
        }

        if (negativeButtonData != null) {
            builder.setNegativeButton(negativeButtonData.title ?: "") { _, _ ->
                negativeButtonData.action?.let { it() }
            }
        }

        if(neutralButtonData != null) {
            builder.setNeutralButton(neutralButtonData.title ?: "") { _, _ ->
                neutralButtonData.action?.let { it() }
            }
        }

        builder.show()
    }
    fun showSimpleAlert(title: String? = null, message: String? = null) {
        MainScope().launch {
            showAlert(
                title = title, message = message, neutralButtonData = AlertButtonData(
                    "OK",
                    {
                        print("test")
                    })
            )
        }
    }
    fun login(userId: String, password: String) {
        if(userId.isBlank() && password.isBlank()){
            showSimpleAlert(message = "UserId and Password is required")
        }else if(userId.isBlank()){
            showSimpleAlert(message = "UserId is Required")
        }
//        else if(!Constants.PHONE_REGEX.matcher(userId).matches())
//        {
//            showSimpleAlert(message = "Valid UserId is Required")
//        }
        else if(password.isBlank()){
            showSimpleAlert(message = "Password is Required")
        }
        else{
            if(!NetworkUtil.isNetworkAvailable(this)){
                Toast.makeText(
                    this,
                    "Please make sure you are connected to internet.",
                    Toast.LENGTH_SHORT
                ).show()
            }else{
               // mainViewModel.authenticateUser(userId, password)
                navigateToHome()

            }
        }
    }


    private fun isTopLevelDestination() =
        appBarConfiguration.topLevelDestinations.contains(navController.currentDestination?.id)
    fun toggleMenu(enabled: Boolean) {

        //TODO toolbar needed if customization on toolbar is required
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)

        if (enabled){
            toolbar.visibility = View.VISIBLE
        }
        else {
            toolbar.visibility = View.GONE
        }

        if (isTopLevelDestination()) {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        } else {
            drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listener)
    }

    override fun onPause() {
        navController.removeOnDestinationChangedListener(listener)
        super.onPause()
    }
}