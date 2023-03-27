package com.example.dicegame

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlin.random.Random


class NewGame : AppCompatActivity() {
    private var defaultTarget = 101
    private var humanWins = 0
    private var compWins = 0
    private var humanRolls = 0
    private var compReRolls = 0
    private var compReTake = 0
    private var humanRe1Sum = 0
    private var humanRe2Sum = 0
    private var compRe1Sum = 0
    private var compRe2Sum = 0
    private var keepCompDice1 = 0
    private var keepCompDice2 = 0
    private var keepCompDice3 = 0
    private var keepCompDice4 = 0
    private var keepCompDice5 = 0
    private var compSum = 0
    private var humanSum = 0
    private var random1 = 0
    private var random2 = 0
    private var random3 = 0
    private var random4 = 0
    private var random5 = 0
    private var isDice1Clicked = false
    private var isDice2Clicked = false
    private var isDice3Clicked = false
    private var isDice4Clicked = false
    private var isDice5Clicked = false
    private var compRandom1 = 0
    private var compRandom2 = 0
    private var compRandom3 = 0
    private var compRandom4 = 0
    private var compRandom5 = 0
    private var humanScore = 0
    private var compScore = 0
    private lateinit var wonText: TextView
    private lateinit var diceImage6: ImageView
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        humanWins = 0
        compWins = 0
        setContentView(R.layout.activity_game)
        val scoreButton = findViewById<Button>(R.id.button4)
        val throwButton = findViewById<Button>(R.id.button3)
        val scoresView = findViewById<TextView>(R.id.textView2)
        val dice1Button = findViewById<Button>(R.id.button5)
        val dice2Button = findViewById<Button>(R.id.button6)
        val dice3Button = findViewById<Button>(R.id.button7)
        val dice4Button = findViewById<Button>(R.id.button8)
        val dice5Button = findViewById<Button>(R.id.button9)
        val setTargetButton = findViewById<Button>(R.id.button10)
        val setTarget = findViewById<EditText>(R.id.editTextNumber)
        val diceImage1 = findViewById<ImageView>(R.id.imageView)
        val diceImage2 = findViewById<ImageView>(R.id.imageView2)
        val diceImage3 = findViewById<ImageView>(R.id.imageView3)
        val diceImage4 = findViewById<ImageView>(R.id.imageView4)
        val diceImage5 = findViewById<ImageView>(R.id.imageView5)
        val diceImage6 = findViewById<ImageView>(R.id.imageView6)
        val diceImage7 = findViewById<ImageView>(R.id.imageView7)
        val diceImage8 = findViewById<ImageView>(R.id.imageView8)
        val diceImage9 = findViewById<ImageView>(R.id.imageView9)
        val diceImage10 = findViewById<ImageView>(R.id.imageView10)
        var imageView: Int
        var imageView2: Int
        var imageView3: Int
        var imageView4: Int
        var imageView5: Int
        var imageView6: Int
        var imageView7: Int
        var imageView8: Int
        var imageView9: Int
        var imageView10: Int
        wonText = findViewById<TextView>(R.id.textView6)
        sharedPreferences = getSharedPreferences("GamePrefs", Context.MODE_PRIVATE)
        dice1Button.isEnabled = false
        dice2Button.isEnabled = false
        dice3Button.isEnabled = false
        dice4Button.isEnabled = false
        dice5Button.isEnabled = false

        setTargetButton.setOnClickListener {
            //editable text field will be disable after the target is set
            setTarget.isEnabled = false
            // access the text in the editable text field
            try {
                var number = setTarget.text.toString().toInt()
                defaultTarget = number
            }catch (e: java.lang.NumberFormatException){
                //this message will be displayed if the user enters an invalid format
                Toast.makeText(this, "Please enter a valid number", Toast.LENGTH_SHORT).show()
                setTarget.isEnabled = true
            }
        }


        throwButton.setOnClickListener {
            humanRolls += 1
            val testText = "$humanRolls"
            scoresView.text = testText
            // first roll of the human
            if (humanRolls==1){
                // generates five random numbers for five dice in the range of 1-6
                random1 = (1..6).random()
                random2 = (1..6).random()
                random3 = (1..6).random()
                random4 = (1..6).random()
                random5 = (1..6).random()
                // generates five random numbers for computer in the range of 1-6
                compRandom1 = (1..6).random()
                compRandom2 = (1..6).random()
                compRandom3 = (1..6).random()
                compRandom4 = (1..6).random()
                compRandom5 = (1..6).random()
                // sets the 5 image views of the human player with the die face images according to the random number
                imageView = when(random1){
                    1 -> {
                        R.drawable.die_face_1
                    }
                    2 -> {
                        R.drawable.die_face_2
                    }
                    3 -> {
                        R.drawable.die_face_3
                    }
                    4 -> {
                        R.drawable.die_face_4
                    }
                    5 -> {
                        R.drawable.die_face_5
                    }
                    else -> {
                        R.drawable.die_face_6
                    }
                }
                imageView2 = when(random2){
                    1 -> {
                        R.drawable.die_face_1
                    }
                    2 -> {
                        R.drawable.die_face_2
                    }
                    3 -> {
                        R.drawable.die_face_3
                    }
                    4 -> {
                        R.drawable.die_face_4
                    }
                    5 -> {
                        R.drawable.die_face_5
                    }
                    else -> {
                        R.drawable.die_face_6
                    }
                }
                imageView3 = when(random3){
                    1 -> {
                        R.drawable.die_face_1
                    }
                    2 -> {
                        R.drawable.die_face_2
                    }
                    3 -> {
                        R.drawable.die_face_3
                    }
                    4 -> {
                        R.drawable.die_face_4
                    }
                    5 -> {
                        R.drawable.die_face_5
                    }
                    else -> {
                        R.drawable.die_face_6
                    }
                }
                imageView4 = when(random4){
                    1 -> {
                        R.drawable.die_face_1
                    }
                    2 -> {
                        R.drawable.die_face_2
                    }
                    3 -> {
                        R.drawable.die_face_3
                    }
                    4 -> {
                        R.drawable.die_face_4
                    }
                    5 -> {
                        R.drawable.die_face_5
                    }
                    else -> {
                        R.drawable.die_face_6
                    }
                }
                imageView5 = when(random5){
                    1 -> {
                        R.drawable.die_face_1
                    }
                    2 -> {
                        R.drawable.die_face_2
                    }
                    3 -> {
                        R.drawable.die_face_3
                    }
                    4 -> {
                        R.drawable.die_face_4
                    }
                    5 -> {
                        R.drawable.die_face_5
                    }
                    else -> {
                        R.drawable.die_face_6
                    }
                }
                // sets the 5 image views of the computer player with the die face images according to the random number
                imageView6 = when(compRandom1){
                    1 -> {
                        R.drawable.die_face_1
                    }
                    2 -> {
                        R.drawable.die_face_2
                    }
                    3 -> {
                        R.drawable.die_face_3
                    }
                    4 -> {
                        R.drawable.die_face_4
                    }
                    5 -> {
                        R.drawable.die_face_5
                    }
                    else -> {
                        R.drawable.die_face_6
                    }
                }
                imageView7 = when(compRandom2){
                    1 -> {
                        R.drawable.die_face_1
                    }
                    2 -> {
                        R.drawable.die_face_2
                    }
                    3 -> {
                        R.drawable.die_face_3
                    }
                    4 -> {
                        R.drawable.die_face_4
                    }
                    5 -> {
                        R.drawable.die_face_5
                    }
                    else -> {
                        R.drawable.die_face_6
                    }
                }
                imageView8 = when(compRandom3){
                    1 -> {
                        R.drawable.die_face_1
                    }
                    2 -> {
                        R.drawable.die_face_2
                    }
                    3 -> {
                        R.drawable.die_face_3
                    }
                    4 -> {
                        R.drawable.die_face_4
                    }
                    5 -> {
                        R.drawable.die_face_5
                    }
                    else -> {
                        R.drawable.die_face_6
                    }
                }
                imageView9 = when(compRandom4){
                    1 -> {
                        R.drawable.die_face_1
                    }
                    2 -> {
                        R.drawable.die_face_2
                    }
                    3 -> {
                        R.drawable.die_face_3
                    }
                    4 -> {
                        R.drawable.die_face_4
                    }
                    5 -> {
                        R.drawable.die_face_5
                    }
                    else -> {
                        R.drawable.die_face_6
                    }
                }
                imageView10 = when(compRandom5){
                    1 -> {
                        R.drawable.die_face_1
                    }
                    2 -> {
                        R.drawable.die_face_2
                    }
                    3 -> {
                        R.drawable.die_face_3
                    }
                    4 -> {
                        R.drawable.die_face_4
                    }
                    5 -> {
                        R.drawable.die_face_5
                    }
                    else -> {
                        R.drawable.die_face_6
                    }
                }
                diceImage1.setImageResource(imageView)
                diceImage2.setImageResource(imageView2)
                diceImage3.setImageResource(imageView3)
                diceImage4.setImageResource(imageView4)
                diceImage5.setImageResource(imageView5)
                diceImage6.setImageResource(imageView6)
                diceImage7.setImageResource(imageView7)
                diceImage8.setImageResource(imageView8)
                diceImage9.setImageResource(imageView9)
                diceImage10.setImageResource(imageView10)
                // calculates the score for the first roll of the human player
                humanSum = random1 + random2 + random3 + random4 + random5
                humanScore += humanSum
                // calculate the score for the first roll of the computer player
                compSum = compRandom1 + compRandom2 + compRandom3 + compRandom4 + compRandom5
                compScore += compSum
                compReTake = (0..1).random() // generates random number 0 or 1
                //if compReTake equals to 1 then choose to take the first reroll for the computer
                if (compReTake == 1){
                    // score of the first roll of the computer will be deducted from the compScore
                    compScore -= compSum
                    compReRolls+=1
                    val testText = "computer reroll: $compReRolls"
                    scoresView.text = testText
                    //random strategy to choose which dice to roll
                    keepCompDice1 = (0..1).random()
                    keepCompDice2 = (0..1).random()
                    keepCompDice3 = (0..1).random()
                    keepCompDice4 = (0..1).random()
                    keepCompDice5 = (0..1).random()
                    /* if keepCompDice1=0 dice will be kept without rolling
                    and the value of that dice will be equal to the previous roll value
                    if keepCompDice1=1 dice will be reroll and the value of the die face
                    will be randomly generated
                    same steps will be repeated for all the five dice of the computer
                     */
                    if (keepCompDice1==0){
                        compRandom1 = compRandom1
                    }
                    else{
                        compRandom1 = (1..6).random()
                        imageView6 = when(compRandom1){
                            1 -> {
                                R.drawable.die_face_1
                            }
                            2 -> {
                                R.drawable.die_face_2
                            }
                            3 -> {
                                R.drawable.die_face_3
                            }
                            4 -> {
                                R.drawable.die_face_4
                            }
                            5 -> {
                                R.drawable.die_face_5
                            }
                            else -> {
                                R.drawable.die_face_6
                            }
                        }
                        diceImage6.setImageResource(imageView6)
                    }
                    if (keepCompDice2==0){
                        compRandom2 = compRandom2
                    }
                    else{
                        compRandom2 = (1..6).random()
                        imageView7 = when(compRandom2){
                            1 -> {
                                R.drawable.die_face_1
                            }
                            2 -> {
                                R.drawable.die_face_2
                            }
                            3 -> {
                                R.drawable.die_face_3
                            }
                            4 -> {
                                R.drawable.die_face_4
                            }
                            5 -> {
                                R.drawable.die_face_5
                            }
                            else -> {
                                R.drawable.die_face_6
                            }
                        }
                        diceImage7.setImageResource(imageView7)
                    }
                    if (keepCompDice3==0){
                        compRandom3 = compRandom3
                    }
                    else{
                        compRandom3 = (1..6).random()
                        imageView8 = when(compRandom3){
                            1 -> {
                                R.drawable.die_face_1
                            }
                            2 -> {
                                R.drawable.die_face_2
                            }
                            3 -> {
                                R.drawable.die_face_3
                            }
                            4 -> {
                                R.drawable.die_face_4
                            }
                            5 -> {
                                R.drawable.die_face_5
                            }
                            else -> {
                                R.drawable.die_face_6
                            }
                        }
                        diceImage8.setImageResource(imageView8)
                    }
                    if (keepCompDice4==0){
                        compRandom4 = compRandom4
                    }
                    else{
                        compRandom4 = (1..6).random()
                        imageView9 = when(compRandom4){
                            1 -> {
                                R.drawable.die_face_1
                            }
                            2 -> {
                                R.drawable.die_face_2
                            }
                            3 -> {
                                R.drawable.die_face_3
                            }
                            4 -> {
                                R.drawable.die_face_4
                            }
                            5 -> {
                                R.drawable.die_face_5
                            }
                            else -> {
                                R.drawable.die_face_6
                            }
                        }
                        diceImage9.setImageResource(imageView9)
                    }
                    if (keepCompDice5==0){
                        compRandom5 = compRandom5
                    }
                    else{
                        compRandom5 = (1..6).random()
                        imageView10 = when(compRandom5){
                            1 -> {
                                R.drawable.die_face_1
                            }
                            2 -> {
                                R.drawable.die_face_2
                            }
                            3 -> {
                                R.drawable.die_face_3
                            }
                            4 -> {
                                R.drawable.die_face_4
                            }
                            5 -> {
                                R.drawable.die_face_5
                            }
                            else -> {
                                R.drawable.die_face_6
                            }
                        }
                        diceImage10.setImageResource(imageView10)
                    }
                    //score for the first reroll will be calculated and added to the compScore
                    compRe1Sum = compRandom1+compRandom2+compRandom3+compRandom4+compRandom5
                    compScore += compRe1Sum
                    //choose to take the second reroll for the computer
                    compReTake = (0..1).random()
                    if (compReTake==0){
                        //if second reroll is not taking compReRolls will set to 0
                        compReRolls = 0
                    }
                    else{
                        //same strategy for the first reroll will be done here
                        compScore -= compRe1Sum
                        compReRolls+=1
                        val testText = "Computer reroll: $compReRolls"
                        scoresView.text = testText
                        keepCompDice1 = (0..1).random()
                        keepCompDice2 = (0..1).random()
                        keepCompDice3 = (0..1).random()
                        keepCompDice4 = (0..1).random()
                        keepCompDice5 = (0..1).random()
                        if (keepCompDice1==0){
                            compRandom1 = compRandom1
                        }
                        else{
                            compRandom1 = (1..6).random()
                            imageView6 = when(compRandom1){
                                1 -> {
                                    R.drawable.die_face_1
                                }
                                2 -> {
                                    R.drawable.die_face_2
                                }
                                3 -> {
                                    R.drawable.die_face_3
                                }
                                4 -> {
                                    R.drawable.die_face_4
                                }
                                5 -> {
                                    R.drawable.die_face_5
                                }
                                else -> {
                                    R.drawable.die_face_6
                                }
                            }
                            diceImage6.setImageResource(imageView6)
                        }
                        if (keepCompDice2==0){
                            compRandom2 = compRandom2
                        }
                        else{
                            compRandom2 = (1..6).random()
                            imageView7 = when(compRandom2){
                                1 -> {
                                    R.drawable.die_face_1
                                }
                                2 -> {
                                    R.drawable.die_face_2
                                }
                                3 -> {
                                    R.drawable.die_face_3
                                }
                                4 -> {
                                    R.drawable.die_face_4
                                }
                                5 -> {
                                    R.drawable.die_face_5
                                }
                                else -> {
                                    R.drawable.die_face_6
                                }
                            }
                            diceImage7.setImageResource(imageView7)
                        }
                        if (keepCompDice3==0){
                            compRandom3 = compRandom3
                        }
                        else{
                            compRandom3 = (1..6).random()
                            imageView8 = when(compRandom3){
                                1 -> {
                                    R.drawable.die_face_1
                                }
                                2 -> {
                                    R.drawable.die_face_2
                                }
                                3 -> {
                                    R.drawable.die_face_3
                                }
                                4 -> {
                                    R.drawable.die_face_4
                                }
                                5 -> {
                                    R.drawable.die_face_5
                                }
                                else -> {
                                    R.drawable.die_face_6
                                }
                            }
                            diceImage8.setImageResource(imageView8)
                        }
                        if (keepCompDice4==0){
                            compRandom4 = compRandom4
                        }
                        else{
                            compRandom4 = (1..6).random()
                            imageView9 = when(compRandom4){
                                1 -> {
                                    R.drawable.die_face_1
                                }
                                2 -> {
                                    R.drawable.die_face_2
                                }
                                3 -> {
                                    R.drawable.die_face_3
                                }
                                4 -> {
                                    R.drawable.die_face_4
                                }
                                5 -> {
                                    R.drawable.die_face_5
                                }
                                else -> {
                                    R.drawable.die_face_6
                                }
                            }
                            diceImage9.setImageResource(imageView9)
                        }
                        if (keepCompDice5==0){
                            compRandom5 = compRandom5
                        }
                        else{
                            compRandom5 = (1..6).random()
                            imageView10 = when(compRandom5){
                                1 -> {
                                    R.drawable.die_face_1
                                }
                                2 -> {
                                    R.drawable.die_face_2
                                }
                                3 -> {
                                    R.drawable.die_face_3
                                }
                                4 -> {
                                    R.drawable.die_face_4
                                }
                                5 -> {
                                    R.drawable.die_face_5
                                }
                                else -> {
                                    R.drawable.die_face_6
                                }
                            }
                            diceImage10.setImageResource(imageView10)
                        }
                        //updates the computer score with the second reroll score and set compReRolls to 0
                        compRe2Sum = compRandom1+compRandom2+compRandom3+compRandom4+compRandom5
                        compScore += compRe2Sum
                        compReRolls = 0
                    }
                }
                //rerolls for the human player starts here enable all the disable buttons
                dice1Button.isEnabled = true
                dice2Button.isEnabled = true
                dice3Button.isEnabled = true
                dice4Button.isEnabled = true
                dice5Button.isEnabled = true
                dice1Button.setOnClickListener {
                    //isDiceClicked is set to true when the button is clicked
                    isDice1Clicked = true
                    random1 = random1
                    // dice 1 will not roll and the value will be the previous roll value
                    val testText = "Keep Dice 1"
                    scoresView.text = testText
                }
                dice2Button.setOnClickListener {
                    isDice2Clicked = true
                    random2 = random2
                    // dice 2 will not roll and the value will be the previous roll value
                    val testText = "Keep Dice 2"
                    scoresView.text = testText
                }
                dice3Button.setOnClickListener {
                    isDice3Clicked = true
                    random3 = random3
                    // dice 3 will not roll and the value will be the previous roll value
                    val testText = "Keep Dice 3"
                    scoresView.text = testText
                }
                dice4Button.setOnClickListener {
                    isDice4Clicked = true
                    random4 = random4
                    // dice 4 will not roll and the value will be the previous roll value
                    val testText = "Keep Dice 4"
                    scoresView.text = testText
                }
                dice5Button.setOnClickListener {
                    isDice5Clicked = true
                    random5 = random5
                    // dice 5 will not roll and the value will be the previous roll value
                    val testText = "Keep Dice 5"
                    scoresView.text = testText
                }
            }
            if (humanRolls==2){
                dice1Button.isEnabled = true
                dice2Button.isEnabled = true
                dice3Button.isEnabled = true
                dice4Button.isEnabled = true
                dice5Button.isEnabled = true
                val testText = "Human roll2"
                scoresView.text = testText
                //deduct the score of the first roll from the humanScore
                humanScore -= humanSum
                // roll all the dice which are not kept
                if (!isDice1Clicked){
                    random1 = (1..6).random()
                    imageView = when(random1){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    diceImage1.setImageResource(imageView)
                }
                if (!isDice2Clicked){
                    random2 = (1..6).random()
                    imageView2 = when(random2){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    diceImage2.setImageResource(imageView2)
                }
                if (!isDice3Clicked){
                    random3 = (1..6).random()
                    imageView3 = when(random3){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    diceImage3.setImageResource(imageView3)
                }
                if (!isDice4Clicked){
                    random4 = (1..6).random()
                    imageView4 = when(random4){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    diceImage4.setImageResource(imageView4)
                }
                if (!isDice5Clicked){
                    random5 = (1..6).random()
                    imageView5 = when(random5){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    diceImage5.setImageResource(imageView5)
                }
                //sets all the diceClicked variables to false
                isDice1Clicked = false
                isDice2Clicked = false
                isDice3Clicked = false
                isDice4Clicked = false
                isDice5Clicked = false
                //calculate the score of the human reroll 1 and add it to humanScore
                humanRe1Sum = random1 + random2 + random3 + random4 + random5
                humanScore += humanRe1Sum

                //strategy repeats to keep the dice to the second reroll of the human
                dice1Button.isEnabled = true
                dice1Button.setOnClickListener {
                    isDice1Clicked = true
                    random1 = random1
                    val testText = "Keep dice 1"
                    scoresView.text = testText
                }
                dice2Button.setOnClickListener {
                    isDice2Clicked = true
                    random2 = random2
                    val testText = "Keep Dice 2"
                    scoresView.text = testText
                }
                dice3Button.setOnClickListener {
                    isDice3Clicked = true
                    random3 = random3
                    val testText = "Keep Dice 3"
                    scoresView.text = testText
                }
                dice4Button.setOnClickListener {
                    isDice4Clicked = true
                    random4 = random4
                    val testText = "Keep Dice 4"
                    scoresView.text = testText
                }
                dice5Button.setOnClickListener {
                    isDice5Clicked = true
                    random5 = random5
                    val testText = "Keep Dice 5"
                    scoresView.text = testText
                }
            }
            //last roll for the human player
            if (humanRolls==3){
                val testText = "Last roll $humanRolls"
                scoresView.text = testText
                dice1Button.isEnabled = true
                dice2Button.isEnabled = true
                dice3Button.isEnabled = true
                dice4Button.isEnabled = true
                dice5Button.isEnabled = true
                //deduct the score of the reroll 1 from the total scores
                humanScore -= humanRe1Sum

                //roll the dice which are not kept
                if (!isDice1Clicked){
                    random1 = (1..6).random()
                    imageView = when(random1){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    diceImage1.setImageResource(imageView)
                }
                if (!isDice2Clicked){
                    random2 = (1..6).random()
                    imageView2 = when(random2){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    diceImage2.setImageResource(imageView2)
                }
                if (!isDice3Clicked){
                    random3 = (1..6).random()
                    imageView3 = when(random3){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    diceImage3.setImageResource(imageView3)
                }
                if (!isDice4Clicked){
                    random4 = (1..6).random()
                    imageView4 = when(random4){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    diceImage4.setImageResource(imageView4)
                }
                if (!isDice5Clicked){
                    random5 = (1..6).random()
                    imageView5 = when(random5){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    diceImage5.setImageResource(imageView5)
                }
                isDice1Clicked = false
                isDice2Clicked = false
                isDice3Clicked = false
                isDice4Clicked = false
                isDice5Clicked = false
                //calculate the score for the human reroll 2 and add to the total score
                humanRe2Sum = random1 + random2 + random3 + random4 + random5
                humanScore += humanRe2Sum
                val hText = "H:$humanScore C: $compScore"
                scoresView.text = hText
                //sets humanRolls to 0 because maximum 3 rolls are allowed
                humanRolls=0
            }
        }

        scoreButton.setOnClickListener {
            humanRolls = 1
            val hText = "H:$humanScore C: $compScore"
            scoresView.text = hText
            humanRolls = 0
            //executes if both scores are greater than the target
            if (humanScore>=defaultTarget && compScore>=defaultTarget){
                //if humanScore is greater than the compScore human wins
                if (humanScore>compScore){
                    val winDialog = AlertDialog.Builder(this)
                        .setTitle("You win!")
                        .setMessage("Congratulations! You have won the game.")
                        .setPositiveButton("OK", null)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .show()
                    //sets the background color to green
                    val window = winDialog.window
                    window?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, android.R.color.holo_green_light)))

                    // set the dialog's text color to green
                    winDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(
                        ContextCompat.getColor(this, android.R.color.holo_green_dark)
                    )
                    humanWins++
                    updateScoreTextView()
                    //disable buttons so the user cant play again
                    throwButton.isEnabled = false
                    scoreButton.isEnabled = false
                }
                if (compScore>humanScore){
                    //human lose
                    val loseDialog = AlertDialog.Builder(this)
                        .setTitle("You lose")
                        .setMessage("Sorry, the computer has won the game.")
                        .setPositiveButton("OK", null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show()
                    // set the dialog background color into red
                    val window = loseDialog.window
                    window?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, android.R.color.holo_red_light)))

                    // set the dialog's text color to red
                    loseDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(
                        ContextCompat.getColor(this, android.R.color.holo_red_dark)
                    )
                    compWins++
                    updateScoreTextView()
                    //disable buttons so user cant play again
                    throwButton.isEnabled = false
                    scoreButton.isEnabled = false
                }
                //if tie roll again without rerolls
                if (compScore==humanScore){
                    random1 = (1..6).random()
                    random2 = (1..6).random()
                    random3 = (1..6).random()
                    random4 = (1..6).random()
                    random5 = (1..6).random()
                    compRandom1 = (1..6).random()
                    compRandom2 = (1..6).random()
                    compRandom3 = (1..6).random()
                    compRandom4 = (1..6).random()
                    compRandom5 = (1..6).random()
                    imageView = when(random1){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    imageView2 = when(random2){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    imageView3 = when(random3){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    imageView4 = when(random4){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    imageView5 = when(random5){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    imageView6 = when(compRandom1){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    imageView7 = when(compRandom2){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    imageView8 = when(compRandom3){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    imageView9 = when(compRandom4){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    imageView10 = when(compRandom5){
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                    diceImage1.setImageResource(imageView)
                    diceImage2.setImageResource(imageView2)
                    diceImage3.setImageResource(imageView3)
                    diceImage4.setImageResource(imageView4)
                    diceImage5.setImageResource(imageView5)
                    diceImage6.setImageResource(imageView6)
                    diceImage7.setImageResource(imageView7)
                    diceImage8.setImageResource(imageView8)
                    diceImage9.setImageResource(imageView9)
                    diceImage10.setImageResource(imageView10)

                    humanSum = random1 + random2 + random3 + random4 + random5
                    humanScore += humanSum
                    compSum = compRandom1 + compRandom2 + compRandom3 + compRandom4 + compRandom5
                    compScore += compSum
                }
            }
            //executes atleast if one score is greater than or equal to the target
            else if (humanScore>=defaultTarget||compScore>=defaultTarget){
                //human wins
                if (humanScore >= defaultTarget) {
                    val winDialog = AlertDialog.Builder(this)
                        .setTitle("You win!")
                        .setMessage("Congratulations! You have won the game.")
                        .setPositiveButton("OK", null)
                        .setIcon(android.R.drawable.ic_dialog_info)
                        .show()
                    //sets the background color to green
                    val window = winDialog.window
                    window?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, android.R.color.holo_green_light)))

                    // set the dialog's text color to green
                    winDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(
                        ContextCompat.getColor(this, android.R.color.holo_green_dark)
                    )
                    humanWins++
                    updateScoreTextView()
                    //disable buttons so user cant play again
                    throwButton.isEnabled = false
                    scoreButton.isEnabled = false
                }else{
                    val loseDialog = AlertDialog.Builder(this)
                        .setTitle("You lose")
                        .setMessage("Sorry, the computer has won the game.")
                        .setPositiveButton("OK", null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show()
                    //set the dialog background color to red
                    val window = loseDialog.window
                    window?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, android.R.color.holo_red_light)))

                    // set the dialog's text color to red
                    loseDialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(
                        ContextCompat.getColor(this, android.R.color.holo_red_dark)
                    )
                    compWins++
                    updateScoreTextView()
                    //disable buttons so user cant play again
                    throwButton.isEnabled=false
                    scoreButton.isEnabled = false
                }
            }
        }
    }
    override fun onResume() {
        super.onResume()
        // Retrieve the score values from the shared preferences
        humanWins = sharedPreferences.getInt("humanGames", 0)
        compWins = sharedPreferences.getInt("compGames", 0)
        updateScoreTextView()
    }
    private fun updateScoreTextView() {
        wonText.text = "H/$humanWins C/$compWins"
    }
    override fun onPause() {
        super.onPause()
        // Save the score values to the shared preferences
        sharedPreferences.edit().apply {
            putInt("humanGames", humanWins)
            putInt("compGames", compWins)
            apply()
        }
    }

    override fun onStop() {
        super.onStop()
        // Reset the score values to 0 when the app is exited
        humanWins = 0
        compWins = 0
    }
    /* this compStrategy() function is regarding the 12th sub question of the cw
    in this the computer will choose to reroll if only the compScore is less than the humanScore
    and during the reroll computer will keep the dices if the number in the dice face (compRandom1,compRandom2... variables)
     is greater than or equal to 4. And reroll the rest (this will be done randomly).
     same strategy will repeat for the second reroll as well.
     Advantages of using this method is it only rerolls if the compScore is less than the human and this will not
     reduce the computer score than the human score.
     Since this only rolls the dice which are less than 4 during a reroll the computer score will not be reduced.
     So this will be more efficient than randomly choosing to reroll.
     */
    fun compStrategy(){
        if (compScore<humanScore){
            // increases by 1
            compReRolls+=1
            while (compReRolls<2){
                if (compRandom1>=4){
                    //don't reroll
                    compRandom1 = compRandom1
                }else{
                    // reroll
                    compRandom1=(1..6).random()
                    var imageView6 = when (compRandom1) {
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                }
                if (compRandom2>=4){
                    // dice 2 will not be rolled
                    compRandom2 = compRandom2
                }else{
                    //dice 2 will be rolled
                    compRandom2=(1..6).random()
                    var imageView7 = when (compRandom2) {
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                }
                if (compRandom3>=4){
                    //dice 3 will not be rolled
                    compRandom3 = compRandom3
                }else{
                    //will be rolled
                    compRandom3=(1..6).random()
                    var imageView8 = when (compRandom3) {
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                }
                if (compRandom4>=4){
                    //will not be rolled
                    compRandom4 = compRandom4
                }else{
                    //will roll
                    compRandom4=(1..6).random()
                    var imageView9 = when (compRandom4) {
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                }
                if (compRandom5>=4){
                    //will not be rolled
                    compRandom5 = compRandom5
                }else {
                    //will be rolled
                    compRandom5 = (1..6).random()
                    var imageView10 = when (compRandom5) {
                        1 -> {
                            R.drawable.die_face_1
                        }
                        2 -> {
                            R.drawable.die_face_2
                        }
                        3 -> {
                            R.drawable.die_face_3
                        }
                        4 -> {
                            R.drawable.die_face_4
                        }
                        5 -> {
                            R.drawable.die_face_5
                        }
                        else -> {
                            R.drawable.die_face_6
                        }
                    }
                }
                if (compReRolls==1){
                    //reduce the score of roll1
                    compScore-=compSum
                    //calculate the score for reroll 1
                    compRe1Sum= compRandom1+compRandom2+compRandom3+compRandom4+compRandom5
                    compScore+=compRe1Sum
                }
                if (compReRolls==2){
                    //reduce the score of roll 2
                    compScore-=compRe1Sum
                    //calculate the score for reroll 2
                    compRe2Sum=compRandom1+compRandom2+compRandom3+compRandom4+compRandom5
                    compScore+=compRe2Sum
                    //sets compReRolls to 0
                    compReRolls=0
                }
            }
        }
    }

}