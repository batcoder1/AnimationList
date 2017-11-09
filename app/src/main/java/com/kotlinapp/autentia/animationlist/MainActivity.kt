package com.kotlinapp.autentia.animationlist

 import android.content.Context
 import android.os.Bundle
 import android.support.v7.app.AppCompatActivity
 import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
 import android.view.LayoutInflater
 import android.view.View
 import android.view.ViewGroup
 import android.widget.Button
 import android.widget.Toast
 import com.kotlinapp.autentia.animationlist.adapter.MyAdapter
 import org.jetbrains.anko.toast


class MainActivity : AppCompatActivity() {
    lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: MyAdapter
    lateinit var btdelete :Button
    private var mLayoutManager = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setUpRecyclerView()

    }

    fun setUpRecyclerView() {
        mRecyclerView = findViewById(R.id.myrecyclerView)
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<Item>()
        for (i in (0 until 10)){
            val item = Item(i, "item"+i)
            data.add(item)
        }


        mAdapter = MyAdapter(data){
            mAdapter.deleteItem(it)
            toast("${it.decripcion} borrado")//A toast that displays the name of OS which you clicked on

        }
        mRecyclerView.adapter = mAdapter



    }
}
