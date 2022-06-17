package com.arslan.pillapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.arslan.pillapp.entities.Pill
import kotlinx.android.synthetic.main.activity_add_pill.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class AddPillActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_pill)

        val dao = AppDatabase.getInstance(this).appDao

        val pills= mutableListOf(
            Pill("vermidon","Aspirin","1"),
            Pill("deneme2","denem2","2"),
            Pill("deneme3","deneme3","3"),
        )

        addButtonPill.setOnClickListener{
            pills.add(Pill(textPillName.text.toString(),textDescription.text.toString(),textPillCount.text.toString()))

            lifecycleScope.launch {
                pills.forEach { dao.insertPill(it) }
            }
        }
    }
}