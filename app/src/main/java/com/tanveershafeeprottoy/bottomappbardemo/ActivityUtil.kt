package com.parkkori.bottomappbardemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

object ActivityUtil {
    private var fragmentTransaction: FragmentTransaction? = null

    fun addFragmentOnActivity(fragmentManager: FragmentManager?,
                              fragment: Fragment, frameId: Int) {
        fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.add(frameId, fragment)
        fragmentTransaction?.commit()
    }

    fun replaceFragmentOnActivity(fragmentManager: FragmentManager?,
                                  fragment: Fragment, frameId: Int) {
        fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(frameId, fragment)
        fragmentTransaction?.commit()
    }
}