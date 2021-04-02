package com.example.fragmentwithoutnavigation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TicTacToeActivity : AppCompatActivity() {

    var resetButton: Button? = null
    var endButton: Button? = null

    var isFirstPlayerWin = 0
    var isSecondPlayerWin = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe)

        resetButton = findViewById(R.id.reset_game)
        endButton = findViewById(R.id.end_game)

        resetButton?.setOnClickListener {
            val intent = Intent(this, TicTacToeActivity::class.java)
            startActivity(intent)
        }

        endButton?.setOnClickListener {
            if (isFirstPlayerWin == 1) {
                PlayerScore.firstPlayer += 1
            } else if (isSecondPlayerWin == 1) {
                PlayerScore.secondPlayer += 1
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun cubeClick(view: View) {
        val cubeSelected = view as Button
        var cubeID = 0
        when (cubeSelected.id) {
            R.id.first_cube -> cubeID = 1
            R.id.second_cube -> cubeID = 2
            R.id.third_cube -> cubeID = 3
            R.id.fourth_cube -> cubeID = 4
            R.id.fifth_cube -> cubeID = 5
            R.id.sixth_cube -> cubeID = 6
            R.id.seventh_cube -> cubeID = 7
            R.id.eighth_cube -> cubeID = 8
            R.id.ninth_cube -> cubeID = 9
        }
        playGame(cubeID, cubeSelected)
    }

    var firstPlayer = ArrayList<Int>()
    var secondPlayer = ArrayList<Int>()

    var activePlayer = 1

    private fun playGame(cubeID: Int, cubeSeleced: Button) {
        val player = findViewById<TextView>(R.id.player_id)

        if (activePlayer == 1) {
            player.setText("Player 1")
            cubeSeleced.setText("X")
            firstPlayer.add(cubeID)
            activePlayer = 2
        } else {
            player.setText("Player 2")
            cubeSeleced.setText("O")
            secondPlayer.add(cubeID)
            activePlayer = 1
        }

        cubeSeleced.isEnabled = false
        checkWinner()

    }

    private fun checkWinner() {
        val player = findViewById<TextView>(R.id.player_id)

        var winner = -1
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winner = 1
        }

        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winner = 2
        }

        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winner = 1
        }

        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winner = 2
        }

        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winner = 1
        }

        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winner = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winner = 1
        }

        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winner = 2
        }

        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winner = 1
        }

        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winner = 2
        }

        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winner = 1
        }

        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winner = 2
        }

        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winner = 1
        }

        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winner = 2
        }

        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winner = 1
        }

        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                player.setText("~~~The first player won the game~~~")
                isFirstPlayerWin = 1
            } else {
                player.setText("~~~The second player won the game~~~")
                isSecondPlayerWin = 1
            }
            resetButton?.visibility = View.VISIBLE
            endButton?.visibility = View.VISIBLE
        } else if (firstPlayer.size + secondPlayer.size == 9) {
            resetButton?.visibility = View.VISIBLE
            endButton?.visibility = View.VISIBLE
        }


    }


}
