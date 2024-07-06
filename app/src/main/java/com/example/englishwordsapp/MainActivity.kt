package com.example.englishwordsapp

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
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

        binding.layoutAnswer3.setOnClickListener {
            markAnswerCurrent()
        }
    }

    private fun markAnswerCurrent() {
        binding.layoutAnswer3.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_containers_correct
        )
        binding.tvVariantNumber3.background = ContextCompat.getDrawable(
            this@MainActivity,
            R.drawable.shape_rounded_variants_correct
        )
        binding.tvVariantNumber3.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.white
            )
        )
        binding.tvVariantValue3.setTextColor(
            ContextCompat.getColor(
                this@MainActivity,
                R.color.correctAnswerColor
            )
        )
        binding.btnSkip.isVisible = false

//        binding.layoutResult.setBackgroundColor(
//            ContextCompat.getColor(
//                this@MainActivity,
//                R.color.correctAnswerColor
//            )
//        )
//        binding.ivResultIcon.setImageDrawable(
//            ContextCompat.getDrawable(
//                this@MainActivity,
//                R.drawable.ic_correct
//            )
//        )
//        binding.tvResultMessage.text = resources.getString(R.string.title_correct)
//
//        binding.btnContinue.setTextColor(
//            ContextCompat.getColor(
//                this@MainActivity,
//                R.color.correctAnswerColor
//            )
//        )
        binding.layoutResult.isVisible = true
    }
}