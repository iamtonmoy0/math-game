package com.example.mathfungame

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
    var correctans=0
    var userScore=0
    var userLife=100
    lateinit var question: TextView
    lateinit var answer: EditText
    lateinit var okbtn: Button
    lateinit var nextbtn: Button
    lateinit var score: TextView
    lateinit var life: TextView
    lateinit var time: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)

        question=findViewById(R.id.question)
        answer=findViewById(R.id.answer)
        okbtn=findViewById(R.id.okbtn)
        nextbtn=findViewById(R.id.nextbtn)
        score=findViewById(R.id.score)
        life=findViewById(R.id.life)
        time=findViewById(R.id.time)


//event listener
        okbtn.setOnClickListener {
val userAnswer=answer.text.toString()
            if(userAnswer.isEmpty()){
                Toast.makeText(applicationContext,"please enter your answer",Toast.LENGTH_SHORT).show()
            }
            else{
             val answ=userAnswer.toInt()
                if (answ==correctans){
                    userScore+=1
                    Toast.makeText(applicationContext,"correct",Toast.LENGTH_SHORT).show()
                    score.text=userScore.toString()

                }
                else{
                    userLife--
                    Toast.makeText(applicationContext,"wrong",Toast.LENGTH_SHORT).show()
                    life.text=userLife.toString()
                }
            }
        }

        nextbtn.setOnClickListener {

        }


        fun gameContinue() {
            val num1 = Random.nextInt(0, 100)
            val num2 = Random.nextInt(0, 100)
            question.text = "$num1 + $num2"
            correctans = num1 + num2
        }

        gameContinue()

        nextbtn.setOnClickListener {
            gameContinue()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}