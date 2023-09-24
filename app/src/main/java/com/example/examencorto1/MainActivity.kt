package com.example.examencorto1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {

    var st: String? = null
    var st2: String? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val player1N: EditText = findViewById(R.id.editTextPlayer1)
        val player2N: EditText = findViewById(R.id.editTextPlayer2)

        val buttonClick = findViewById<Button>(R.id.Mbutton)

        val choices = arrayOf("3x3", "4x4", "5x5")
        val spinner = findViewById<Spinner>(R.id.spinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, choices)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                buttonClick.setOnClickListener {
                    val selectedActivity = choices[position]
                    st = player1N.getText().toString()
                    st2 = player2N.getText().toString()
                    navigateToActivity(selectedActivity)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val winner: TextView = findViewById(R.id.txvWinner)

        val message = getIntent().getExtras()?.getString("Winner")
        winner.text = message

        /*buttonClick.setOnClickListener {
            val selectedText = spinner.selectedItem as String

            if (selectedText == "3x3"){
                st = player1N.getText().toString()
                st2 = player2N.getText().toString()

                val intent = Intent(this, Matrix3::class.java)
                intent.putExtra("Player1", st)
                intent.putExtra("Player2", st2)
                startActivity(intent)
            } else if (selectedText == "4x4") {
                st = player1N.getText().toString()
                st2 = player2N.getText().toString()

                val intent = Intent(this, Matrix4::class.java)
                intent.putExtra("Player1", st)
                intent.putExtra("Player2", st2)
                startActivity(intent)
            } else if (selectedText == "5x5"){
                st = player1N.getText().toString()
                st2 = player2N.getText().toString()

                val intent = Intent(this, Matrix5::class.java)
                intent.putExtra("Player1", st)
                intent.putExtra("Player2", st2)
                startActivity(intent)
            }*/
    }

    private fun navigateToActivity(selectedActivity: String) {
        when (selectedActivity) {
            "3x3" -> {
                val intent = Intent(this, Matrix3::class.java)
                intent.putExtra("Player1", st)
                intent.putExtra("Player2", st2)
                startActivity(intent)
            }

            "4x4" -> {
                val intent = Intent(this, Matrix4::class.java)
                intent.putExtra("Player1", st)
                intent.putExtra("Player2", st2)
                startActivity(intent)
            }

            /*"5x5" -> {
                val intent = Intent(this, Matrix5::class.java)
                intent.putExtra("Player1", st)
                intent.putExtra("Player2", st2)
                startActivity(intent)
            }*/
        }
    }
}

