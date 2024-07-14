package com.example.englishwordsapp

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.englishwordsapp.databinding.ActivityLearnWordBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityLearnWordBinding? = null
    private val binding
        get() = _binding
            ?: throw IllegalStateException("Binding for ActivityLearnWordBinding must not be null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLearnWordBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val trainer = LearnWordsTrainer()
        showNextQuestion(trainer)
        with(binding) {
//            btnContinue.setOnClickListener {
//                layoutResult.isVisible = false
//                markAnswerNeutral()
//
//                showNextQuestion(trainer)
//            }
            btnSkip.setOnClickListener {
                showNextQuestion(trainer)
            }
        }
    }


    private fun showNextQuestion(trainer: LearnWordsTrainer) {
        with(binding) {
            val firstQuestion: Question? = trainer.getNextQuestion()
            if (firstQuestion == null || firstQuestion.variants.size < NUMBER_OF_ANSWERS) {
                layoutVariants.isVisible = false
                tvQuestionWord.isVisible = false
                btnSkip.text = "Complite!"
            } else {
                btnSkip.isVisible = true
                tvQuestionWord.text = firstQuestion.correctAnswer.original

                val answerList = firstQuestion.variants
                val recyclerView: RecyclerView = findViewById(R.id.rvAnswer)
                val customAdapter = AnswerAdapter(answerList)
                recyclerView.adapter = customAdapter


//                layoutAnswer1.setOnClickListener {
//                    if (trainer.checkAnswer(0)) {
//                        markAnswerCurrent(layoutAnswer1, tvVariantNumber1, tvVariantValue1)
//                        showResultMessage(true)
//                    } else {
//                        markAnswerWrong(layoutAnswer1, tvVariantNumber1, tvVariantValue1)
//                        showResultMessage(false)
//                    }
//                }
//                layoutAnswer2.setOnClickListener {
//                    if (trainer.checkAnswer(1)) {
//                        markAnswerCurrent(layoutAnswer2, tvVariantNumber2, tvVariantValue2)
//                        showResultMessage(true)
//                    } else {
//                        markAnswerWrong(layoutAnswer2, tvVariantNumber2, tvVariantValue2)
//                        showResultMessage(false)
//                    }
//                }
//                layoutAnswer3.setOnClickListener {
//                    if (trainer.checkAnswer(2)) {
//                        markAnswerCurrent(layoutAnswer3, tvVariantNumber3, tvVariantValue3)
//                        showResultMessage(true)
//                    } else {
//                        markAnswerWrong(layoutAnswer3, tvVariantNumber3, tvVariantValue3)
//                        showResultMessage(false)
//                    }
//                }
//                layoutAnswer4.setOnClickListener {
//                    if (trainer.checkAnswer(3)) {
//                        markAnswerCurrent(layoutAnswer4, tvVariantNumber4, tvVariantValue4)
//                        showResultMessage(true)
//                    } else {
//                        markAnswerWrong(layoutAnswer4, tvVariantNumber4, tvVariantValue4)
//                        showResultMessage(false)
//                    }
            }
        }
    }
}

//    private fun markAnswerNeutral(
//        layoutAnswer: LinearLayout,
//        tvVariantNumber: TextView,
//        tvVariantValue: TextView,
//    ) {
//        with(binding) {
//            layoutAnswer.background = ContextCompat.getDrawable(
//                this@MainActivity,
//                R.drawable.shape_rounded_containers
//            )
//            tvVariantValue.setTextColor(
//                ContextCompat.getColor(
//                    this@MainActivity,
//                    R.color.textVariantsColor
//                )
//            )
//            tvVariantNumber.apply {
//                setTextColor(
//                    ContextCompat.getColor(
//                        this@MainActivity,
//                        R.color.textVariantsColor
//                    )
//                )
//                background = ContextCompat.getDrawable(
//                    this@MainActivity,
//                    R.drawable.shape_rounded_variants
//                )
//            }
//            layoutResult.isVisible = false
//            btnSkip.isVisible = true
//        }
//    }
//
//
//    private fun markAnswerWrong(
//        layoutAnswer: LinearLayout,
//        tvVariantNumber: TextView,
//        tvVariantValue: TextView,
//
//        ) {
//        layoutAnswer.background = ContextCompat.getDrawable(
//            this@MainActivity,
//            R.drawable.shape_rounded_containers_wrong
//        )
//        tvVariantNumber.background = ContextCompat.getDrawable(
//            this@MainActivity,
//            R.drawable.shape_rounded_variants_wrong
//        )
//        tvVariantNumber.setTextColor(
//            ContextCompat.getColor(
//                this@MainActivity,
//                R.color.white
//            )
//        )
//        tvVariantValue.setTextColor(
//            ContextCompat.getColor(
//                this@MainActivity,
//                R.color.wrongAnswerColor
//            )
//        )
//    }
//
//    private fun markAnswerCurrent(
//        layoutAnswer: LinearLayout,
//        tvVariantNumber: TextView,
//        tvVariantValue: TextView,
//    ) {
//        layoutAnswer.background = ContextCompat.getDrawable(
//            this@MainActivity,
//            R.drawable.shape_rounded_containers_correct
//        )
//        tvVariantNumber.background = ContextCompat.getDrawable(
//            this@MainActivity,
//            R.drawable.shape_rounded_variants_correct
//        )
//        tvVariantNumber.setTextColor(
//            ContextCompat.getColor(
//                this@MainActivity,
//                R.color.white
//            )
//        )
//        tvVariantValue.setTextColor(
//            ContextCompat.getColor(
//                this@MainActivity,
//                R.color.correctAnswerColor
//            )
//        )
//    }
//
//    private fun showResultMessage(isCorrect: Boolean) {
//        val color: Int
//        val messageText: String
//        val resultIconResource: Int
//        if (isCorrect) {
//            color = ContextCompat.getColor(this, R.color.correctAnswerColor)
//            messageText = "Correct!"
//            resultIconResource = R.drawable.ic_correct
//        } else {
//            color = ContextCompat.getColor(this, R.color.wrongAnswerColor)
//            messageText = "InCorrect!!"
//            resultIconResource = R.drawable.ic_wrong
//        }
//        with(binding) {
//            btnSkip.isVisible = false
//            layoutResult.isVisible = true
//            btnContinue.setTextColor(color)
//            layoutResult.setBackgroundColor(color)
//            tvResultMessage.text = messageText
//            ivResultIcon.setImageResource(resultIconResource)
//        }
//    }





