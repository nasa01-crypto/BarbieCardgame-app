package com.example.barbiegamepink

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity2 : AppCompatActivity() {
    lateinit var card1ImageView: ImageView
    lateinit var card2ImageView: ImageView

    lateinit var player1ScoreTextView: TextView
    lateinit var player2ScoreTextView: TextView

    lateinit var warTextView: TextView

    lateinit var dealButton: Button

    var playerScores = intArrayOf(0, 0)

    var cardsArray = intArrayOf(
        R.drawable.card10,
        R.drawable.card10h,
        R.drawable.card10k,
        R.drawable.card10r,
        R.drawable.card11,
        R.drawable.card11h,
        R.drawable.card11k,
        R.drawable.card11r,
        R.drawable.card12,
        R.drawable.card12h,
        R.drawable.card12k,
        R.drawable.card12r,
        R.drawable.card13,
        R.drawable.card13h,
        R.drawable.card13r,
        R.drawable.card1h,
        R.drawable.card1k,
        R.drawable.card1r,
        R.drawable.card1s,
        R.drawable.card2,
        R.drawable.card2h,
        R.drawable.card2k,
        R.drawable.card2r,
        R.drawable.card3,
        R.drawable.card3h,
        R.drawable.card3k,
        R.drawable.card3r,
        R.drawable.card4,
        R.drawable.card4h,
        R.drawable.card4k,
        R.drawable.card4r,
        R.drawable.card5,
        R.drawable.card5h,
        R.drawable.card5k,
        R.drawable.card5r,
        R.drawable.card6,
        R.drawable.card6h,
        R.drawable.card6k,
        R.drawable.card6r,
        R.drawable.card7,
        R.drawable.card7h,
        R.drawable.card7k,
        R.drawable.card7r,
        R.drawable.card8,
        R.drawable.card8h,
        R.drawable.card8k,
        R.drawable.card8r,
        R.drawable.card9h,
        R.drawable.card9k,
        R.drawable.card9r,


        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val random = Random

        card1ImageView = findViewById(R.id.iv_card1)
        card2ImageView = findViewById(R.id.iv_card2)


        player1ScoreTextView = findViewById(R.id.tv_score_right)
        player2ScoreTextView = findViewById(R.id.tv_score_left)

        warTextView = findViewById(R.id.tv_war)
        warTextView.visibility = View.VISIBLE

        dealButton = findViewById(R.id.b_deal)
        dealButton.setOnClickListener {
            warTextView.visibility = View.VISIBLE

            val card1 = random.nextInt(cardsArray.size)
            val card2 = random.nextInt(cardsArray.size)

            setCardImage(card1, card1ImageView)
            setCardImage(card2, card2ImageView)


            when {
                card1 > card2 -> playerScores[0]++
                card1 < card2 -> playerScores[1]++
                else -> warTextView.visibility = View.VISIBLE


            }

            updateScoreUI()

        }
    }

    private fun setCardImage(cardIndex: Int, imageView: ImageView) {
        imageView.setImageResource(cardsArray[cardIndex])
    }

    private fun updateScoreUI() {
        player1ScoreTextView.text = "Player 2: ${playerScores[0]}"
        player2ScoreTextView.text = "Player 1: ${playerScores[1]}"


    }
}