package ru.myitschool.lab23

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder

data class Person(val name: String)
class ResultActivity : AppCompatActivity() {

    private lateinit var persons: List<Person>
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val fileResult = application.assets.open("test.json").bufferedReader().use{ it.readText() }
        persons = GsonBuilder().create().fromJson(fileResult, Array<Person>::class.java).toList()
        recyclerView = findViewById(R.id.generated_list)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(persons)
    }
}