package com.example.googleplaystore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val horizontalModels = createFakeData()
        val horizontalAdapter = HorizontalItemAdapter(horizontalModels)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = horizontalAdapter
    }

    private fun createFakeData(): ArrayList<HorizontalModel> {
        val horizontalModels = ArrayList<HorizontalModel>()
        for (i in 1..5) { // Tạo 5 danh mục ngang
            val appList = ArrayList<AppModel>()
            for (j in 1..5) { // Mỗi danh mục có 5 ứng dụng giả
                val imageId = resources.getIdentifier("thumb$j", "drawable", packageName)
                val appName = "App $j in $i"
                val app = AppModel(appName, 4.0, imageId)
                appList.add(app)
            }
            val category = "Category $i"
            val horizontalModel = HorizontalModel(category, appList)
            horizontalModels.add(horizontalModel)
        }
        return horizontalModels
    }
}
