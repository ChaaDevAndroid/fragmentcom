package com.example.fragmentCom

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.fragmentcom.R
import com.example.fragmentcom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: ItemViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val listFragment = ListFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerFragment, listFragment)
            .commit()

        viewModel.selectedItem.observe(this, Observer { item ->
            Toast.makeText(this, item.item, Toast.LENGTH_SHORT).show()
        })
    }


}

