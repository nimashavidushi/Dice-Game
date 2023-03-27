// https://drive.google.com/drive/folders/18BKssFtakJxRZajBfgWEA1BqtAIuKlEW?usp=sharing
package com.example.dicegame

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.Button
import android.widget.PopupWindow
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aboutButton = findViewById<Button>(R.id.button2)
        val newGameButton = findViewById<Button>(R.id.button)
        aboutButton.setOnClickListener {
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.activity_about, null)

            val authorName = popupView.findViewById<TextView>(R.id.textView7)
            val authorId = popupView.findViewById<TextView>(R.id.textView8)
            val authorMessage = popupView.findViewById<TextView>(R.id.textView)

            authorName.text = "Name : Nimasha Kosgoda"
            authorId.text = "Student ID : 20210360"
            authorMessage.text = "I confirm that I understand what plagiarism is and have read and\n" +
                    "understood the section on Assessment Offences in the Essential\n" +
                    "Information for Students. The work that I have submitted is\n" +
                    "entirely my own. Any work from other authors is duly referenced\n" +
                    "and acknowledged.\n"

            val backgroundDrawable = ContextCompat.getDrawable(this, R.drawable.white)
            popupView.background = backgroundDrawable

            val popupWindow = PopupWindow(popupView, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true)
            popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)
        }
        newGameButton.setOnClickListener {
            val newGameIntent = Intent(this, NewGame::class.java)
            startActivity(newGameIntent)
        }
    }
}
