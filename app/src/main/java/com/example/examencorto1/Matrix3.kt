package com.example.examencorto1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Matrix3 : AppCompatActivity() {

    private lateinit var matrixButtons: Array<Array<Button>>
    private lateinit var matrix: Array<Array<Char>>
    private val isLocked: Array<BooleanArray> = Array(3) { BooleanArray(3) { false } }
    var i : Int = 1
    var e : Int = 1
    var st : String? = null
    var st2 : String? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.matrix3)

        val player1Name: TextView = findViewById(R.id.txvPlayer1)
        val player2Name: TextView = findViewById(R.id.txvPlayer2)

        st= getIntent().getExtras()?.getString("Player1")
        st2 = getIntent().getExtras()?.getString("Player2")


        player1Name.setText(st)
        player2Name.setText(st2)

        val gridLayout: GridLayout = findViewById(R.id.matrixGridLayout3)

        // Initialize the 3x3 matrix of buttons and matrix values
        matrixButtons = Array(3) { i ->
            Array(3) { j ->
                createMatrixButton(i, j)
            }
        }
        matrix = Array(3) { Array(3) { 'A' } }

        // Add buttons to the GridLayout
        for (i in matrixButtons.indices) {
            for (j in matrixButtons[i].indices) {
                gridLayout.addView(matrixButtons[i][j])
            }
        }
    }

    private fun createMatrixButton(row: Int, col: Int): Button {
        val button = Button(this)
        val params = GridLayout.LayoutParams()

        val turnPlayer : TextView = findViewById(R.id.txvTurnPlayer)

        st= getIntent().getExtras()?.getString("Player1")
        st2 = getIntent().getExtras()?.getString("Player2")

        turnPlayer.setText(st)

        params.rowSpec = GridLayout.spec(row, 1f)
        params.columnSpec = GridLayout.spec(col, 1f)
        button.layoutParams = params
        button.text = " " // Default value for the button
        button.setOnClickListener {
            if (i > 1){
                if (win(matrix,st,st2) != ""){
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("Winner", win(matrix,st,st2))
                    startActivity(intent)

                }
            }
            // Open a dialog or use any other input method to get the user input for the cell value
            // For simplicity, we will increment the cell value by 1 on each click
            if (!isLocked[row][col]){
                if (matrix[row][col].toString() != "x" && matrix[row][col].toString() != "o") {
                    matrix[row][col] = turn(i)
                    i++
                    button.text = matrix[row][col].toString()

                    if (i%2 == 0)
                        turnPlayer.setText(st2)
                    else
                        turnPlayer.setText(st)
                }
            }
        }
        return button
    }
}

private fun turn(i : Int) : Char {
    return if (i%2 != 0){
        'x'
    } else {
        'o'
    }
}

private fun win(array : Array<Array<Char>>, name1 : String?, name2 : String?) : String{
    var numbers : List<Int> = listOf<Int>(0,1,2)
    var i : Int = 0
    for (e in numbers){
        //Horizontally
        if (array[e][0] == array[e][1] && array[e][0] == array[e][2] && array[e][1] == array[e][2]) {
            if (array[e][1].toString() != "A"){
                return if (i%2 != 0)
                    "$name2 wins"
                else
                    "$name1 wins"
            }
        //vertically
        } else if (array[0][e] == array[1][e] && array[0][e] == array[2][e] && array[1][e] == array[2][e]) {
            if (array[1][e].toString() != "A"){
                return if (i%2 != 0)
                    "$name2 wins"
                else
                    "$name1 wins"
            }
        //diagonal
        } else if ((array[0][0] == array[1][1] && array[1][1] == array[2][2]) || (array[0][2] == array[1][1] && array[1][1] == array[2][0])) {
            if (array[1][1].toString() != "A"){
                return if (i%2 != 0)
                    "$name2 wins"
                else
                    "$name1 wins"
            }
        }
    }
    return ""
}

