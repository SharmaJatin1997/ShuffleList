package com.app.shufflelist

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.shufflelist.base.BaseActivity
import com.app.shufflelist.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class MainActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var adapter: NameAdapter
    val data = ArrayList<ItemsViewModel>()
    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerview = findViewById<RecyclerView>(R.id.rv_users)
        val refresh = findViewById<ImageView>(R.id.refresh)
        recyclerview.layoutManager = LinearLayoutManager(this)
        data.add(ItemsViewModel("Jatin"))
        data.add(ItemsViewModel("Anushka"))
        data.add(ItemsViewModel("Karan"))
        data.add(ItemsViewModel("Nitish"))
        data.add(ItemsViewModel("Aman"))
        data.add(ItemsViewModel("Rajat"))
        data.add(ItemsViewModel("Mamo"))
        val adapter = NameAdapter(this, data)
        recyclerview.adapter = adapter
        refresh.setOnClickListener {
            data.shuffle()
//            shuffle(data)
            adapter.notifyDataSetChanged()
        }
    }

    //Custom methods
    fun <T> shuffle(list: MutableList<T>)
    {
        for (i in list.size - 1 downTo 1)
        {
            val j = Random.nextInt(i + 1)
            val temp = list[i]
            list[i] = list[j]
            list[j] = temp
        }
    }



}