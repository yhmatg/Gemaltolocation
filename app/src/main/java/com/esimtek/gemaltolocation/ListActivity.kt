package com.esimtek.gemaltolocation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.esimtek.gemaltolocation.adapter.OrderBoxAdapter
import com.esimtek.gemaltolocation.model.LocationOrder
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_list.*
import com.google.gson.reflect.TypeToken


class ListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val data = intent.getStringExtra("data")
        val list = Gson().fromJson<List<LocationOrder.DataBean.TableBean>>(data, object : TypeToken<List<LocationOrder.DataBean.TableBean>>() {}.type)
        recyclerView.adapter = OrderBoxAdapter(list)
    }
}
