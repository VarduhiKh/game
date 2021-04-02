package com.example.fragmentwithoutnavigation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var firstPlayerScore: TextView? = null
    var secondPlayerScore: TextView? = null

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonTicTacToe = findViewById<Button>(R.id.tic_tac_toe)
        val buttonDiceRoller = findViewById<Button>(R.id.dice_roller)
        val buttonAddPlayer = findViewById<Button>(R.id.add_player)
        firstPlayerScore = findViewById(R.id.first_player_score)
        secondPlayerScore = findViewById(R.id.second_player_score)

        buttonTicTacToe.setOnClickListener {
            val intent = Intent(this, TicTacToeActivity::class.java)
            startActivity(intent)
        }

        buttonDiceRoller.setOnClickListener {
            val intent = Intent(this, DiceRollerActivity::class.java)
            startActivity(intent)
        }

       setScores()
    }

    fun setScores() {
        firstPlayerScore?.setText(PlayerScore.firstPlayer.toString())
        secondPlayerScore?.setText(PlayerScore.secondPlayer.toString())
    }
}


