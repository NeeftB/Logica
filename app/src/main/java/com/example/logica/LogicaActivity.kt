package com.example.logica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_logica.*

class LogicaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logica)

        btnSubmit.setOnClickListener { checkAnswers() }
    }


    private fun checkAnswers() {
        val answerOne = etAnswerCaseOne.text.toString().trim()
        val answerTwo = etAnswerCaseTwo.text.toString().trim()
        val answerThree = etAnswerCaseThree.text.toString().trim()
        val answerFour= etAnswerCaseFour.text.toString().trim()
        val answerTotal = "$answerOne$answerTwo$answerThree$answerFour"

        if(Regex("[^tfTF]").containsMatchIn(answerTotal)){
            onAnswerWrongInput()
            return
        }

        if (answerTotal.equals(getString(R.string.answer), true))
        {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.correct),
            Toast.LENGTH_LONG).show()
    }

    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrect),
            Toast.LENGTH_LONG).show()
    }

    private fun onAnswerWrongInput() {
        Toast.makeText(this, getString(R.string.wrong_input),
            Toast.LENGTH_LONG).show()
    }


}
