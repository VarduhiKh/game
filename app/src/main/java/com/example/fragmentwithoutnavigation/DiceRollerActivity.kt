package com.example.fragmentwithoutnavigation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class DiceRollerActivity : AppCompatActivity() {

    val FIRST_PLAYER = "FIRST_PLAYER"
    val SECOND_PLAYER = "SECOND_PLAYER"

    var firstDicer: ImageView? = null
    var secondDicer: ImageView? = null
    var firstPlayerScore = 0
    var secondPlayerScore = 0

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice_roller)

        val endButton = findViewById<Button>(R.id.end_botton)

        val rollButton = findViewById<Button>(R.id.roll_botton)
        rollButton.tag = FIRST_PLAYER

        firstDicer = findViewById(R.id.first_dicer)
        secondDicer = findViewById(R.id.second_dicer)
        val dicerPlayer = findViewById<TextView>(R.id.dicer_player)

        fun playGame() {
            val player = rollButton.tag.toString()
            if (player.equals(FIRST_PLAYER)) {
                dicerPlayer.text = "Player 1"
                firstPlayerScore = sumOfDicer()
                rollButton.tag = SECOND_PLAYER
                endButton.visibility = View.GONE
            } else {
                dicerPlayer.text = "Player 2"
                secondPlayerScore = sumOfDicer()

                if (firstPlayerScore > secondPlayerScore) {
                    dicerPlayer.text = "~~~Wins first player~~~"
                } else if (firstPlayerScore < secondPlayerScore) {
                    dicerPlayer.text = "~~~Wins second player~~~"
                } else {
                    dicerPlayer.text = "No one wins!"
                }
                endButton.visibility = View.VISIBLE
                rollButton.tag = FIRST_PLAYER
            }
        }

        rollButton.setOnClickListener {
            playGame()
        }

        endButton.setOnClickListener {
            if (firstPlayerScore > secondPlayerScore) {
                PlayerScore.firstPlayer += 1
            } else if (firstPlayerScore < secondPlayerScore) {
                PlayerScore.secondPlayer += 1
            }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun sumOfDicer(): Int {
        val firstPlayerFirstRoll = Random.nextInt(1, 7)
        when (firstPlayerFirstRoll) {
            1 -> firstDicer?.setImageResource(R.drawable.dice_1)
            3 -> firstDicer?.setImageResource(R.drawable.dice_3)
            2 -> firstDicer?.setImageResource(R.drawable.dice_2)
            4 -> firstDicer?.setImageResource(R.drawable.dice_4)
            5 -> firstDicer?.setImageResource(R.drawable.dice_5)
            6 -> firstDicer?.setImageResource(R.drawable.dice_6)
        }
        val firstPlayerSecondRoll = Random.nextInt(1, 7)
        when (firstPlayerSecondRoll) {
            1 -> secondDicer?.setImageResource(R.drawable.dice_1)
            3 -> secondDicer?.setImageResource(R.drawable.dice_3)
            2 -> secondDicer?.setImageResource(R.drawable.dice_2)
            4 -> secondDicer?.setImageResource(R.drawable.dice_4)
            5 -> secondDicer?.setImageResource(R.drawable.dice_5)
            6 -> secondDicer?.setImageResource(R.drawable.dice_6)
        }

        return firstPlayerFirstRoll + firstPlayerSecondRoll
    }
}
