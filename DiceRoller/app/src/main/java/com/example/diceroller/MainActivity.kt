/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.diceroller

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.R.id.scoreA
import org.w3c.dom.Text

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    /**
     * This method is called when the Activity is created.
     */

    var score1 = 0;
    var score2 = 0;
    var count = 0;
    var score = 0;




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.button)
         val turn: TextView = findViewById(R.id.turn)


        val scoreA: TextView = findViewById(R.id.scoreA)
        val scoreB: TextView  = findViewById(R.id.scoreB)
        score = 0;



        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener { rollDice();
            count++;
            if(count%2==0) {

                score2+=score

                turn.setText("Team B")
                scoreB.setText("Score:"+score2.toString())

//                scoreB.setText(score2.toString())

            }
            else{


                turn.setText("Team A")
                score1+=score
                scoreA.setText("Score:"+score1.toString())

            }

            if(score1 >=100){


            }




            }








        // Do a dice roll when the app starts
        rollDice()
    }

    /**
     * Roll the dice and update the screen with the result.
     */


    open fun rollDice() {

        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        score = diceRoll



        // Find the ImageView in the layout
        val diceImage: ImageView = findViewById(R.id.imageView)


        // Determine which drawable resource ID to use based on the dice roll
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        // Update the ImageView with the correct drawable resource ID
        diceImage.setImageResource(drawableResource)

        // Update the content description
        diceImage.contentDescription = diceRoll.toString()

    }
}

/**
 * Dice with a fixed number of sides.
 */
class Dice(private val numSides: Int) {

    /**
     * Do a random dice roll and return the result.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}