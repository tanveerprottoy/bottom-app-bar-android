package com.tanveershafeeprottoy.bottomappbardemo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.parkkori.bottomappbardemo.ActivityUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ListViewHolder.OnListItemClickListener {
    private var currentFabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(bar)
        fab.setOnClickListener(fabOcl)
        ActivityUtil.addFragmentOnActivity(
            supportFragmentManager,
            ListFragment.newInstance(),
            R.id.mainFrame
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.bottom_bar_nav_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.app_bar_fav -> {
                Toast.makeText(this, "favorite clicked", Toast.LENGTH_SHORT).show()
                return true
            }
            android.R.id.home -> {
                BottomMenuDialogFragment.newInstance()
                    .show(supportFragmentManager, "BottomMenuDialogFragment")
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onItemClick(adapterPosition: Int) {
        ActivityUtil.replaceFragmentOnActivity(
            supportFragmentManager,
            DetailFragment.newInstance("jjd"),
            R.id.mainFrame
        )
        fab.hide(onVisibilityChangedListener)
        invalidateOptionsMenu()
        bar.navigationIcon = if(bar.navigationIcon != null) {
            null
        }
        else {
            ContextCompat.getDrawable(this, R.drawable.ic_menu_white_24dp)
        }
    }

    private fun BottomAppBar.toggleFabAlignment() {
        currentFabAlignmentMode = fabAlignmentMode
        fabAlignmentMode = currentFabAlignmentMode.xor(1)
    }

    val fabOcl = View.OnClickListener {
        Toast.makeText(this, "Fab clicked", Toast.LENGTH_LONG).show()
        //Snackbar.make(parentCoordinatorLayout, "Fab clicked", Snackbar.LENGTH_LONG).show()
    }

    val onVisibilityChangedListener: FloatingActionButton.OnVisibilityChangedListener =
        object : FloatingActionButton.OnVisibilityChangedListener() {

            override fun onHidden(fab: FloatingActionButton?) {
                super.onHidden(fab)
                bar.toggleFabAlignment()
                bar.replaceMenu(
                    if(currentFabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER) {
                        R.menu.bottom_bar_nav_menu
                    }
                    else {
                        R.menu.bottom_bar_nav_detail_menu
                    }
                )
                fab?.setImageDrawable(
                    if(currentFabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER) {
                        ContextCompat.getDrawable(
                            this@MainActivity,
                            R.drawable.ic_search_white_24dp
                        )
                    }
                    else {
                        ContextCompat.getDrawable(this@MainActivity, R.drawable.ic_edit_black_24dp)
                    }
                )
                fab?.show()
            }
        }
}
