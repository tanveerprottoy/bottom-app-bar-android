package com.tanveershafeeprottoy.bottomappbardemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fragment_bottom_menu_dialog.view.*

class BottomMenuDialogFragment : BottomSheetDialogFragment(),
                                 NavigationView.OnNavigationItemSelectedListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_bottom_menu_dialog, container, false)
        root.navView.setNavigationItemSelectedListener(this)
        return root
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when(menuItem.itemId) {
            R.id.nav0 -> Toast.makeText(
                activity,
                getString(R.string.nav_0),
                Toast.LENGTH_SHORT
            ).show()
            R.id.nav1 -> Toast.makeText(
                activity,
                getString(R.string.nav_1),
                Toast.LENGTH_SHORT
            ).show()
            R.id.nav2 -> Toast.makeText(
                activity,
                getString(R.string.nav_2),
                Toast.LENGTH_SHORT
            ).show()
        }
        return true
    }

    companion object {

        @JvmStatic
        fun newInstance() = BottomMenuDialogFragment()
    }
}
