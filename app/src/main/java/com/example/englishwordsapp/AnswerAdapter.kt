package com.example.englishwordsapp
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnswerAdapter(private val dataSet: List<Word>) : RecyclerView.Adapter<AnswerAdapter.AnswerHolder>() {

    class AnswerHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvNumber: TextView = view.findViewById(R.id.tvVariantNumber)
        val tvValue: TextView = view.findViewById(R.id.tvVariantValue)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AnswerHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.answer_item, viewGroup, false)
        return AnswerHolder(view)
    }

    override fun onBindViewHolder(viewHolder: AnswerHolder, position: Int) {
        val answer = dataSet[position]
        viewHolder.tvNumber.text = position.plus(1).toString()
        viewHolder.tvValue.text = answer.translate
    }

    override fun getItemCount() = dataSet.size
}