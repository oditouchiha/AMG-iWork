package com.example.amgiwork

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvEmployees: RecyclerView
    private var list: ArrayList<Employee> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvEmployees = findViewById(R.id.rv_employees)
        rvEmployees.setHasFixedSize(true)

        list.addAll(EmployeeData.listData)

        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvEmployees.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListEmployeeAdapter(list)
        rvEmployees.adapter = listHeroAdapter
    }

    private fun showAboutActivity() {
        val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(moveIntent)
        finish()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_employee_list -> {
            }
            R.id.action_about -> {
                showAboutActivity()
            }
        }
    }
}
