package com.example.assignment_3

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editExpense = findViewById<EditText>(R.id.editExpense)
        val buttonAddExpense = findViewById<Button>(R.id.buttonAddExpense)

        // Set up the toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        buttonAddExpense.setOnClickListener {
            val expense = editExpense.text.toString()
            if (expense.isNotEmpty()) {
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra("EXTRA_EXPENSE", expense)
                }
                startActivityForResult(intent, REQUEST_CODE)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // Handle settings action
                // Add your code here
                true
            }
            R.id.action_about -> {
                // Handle about action
                // Add your code here
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}






