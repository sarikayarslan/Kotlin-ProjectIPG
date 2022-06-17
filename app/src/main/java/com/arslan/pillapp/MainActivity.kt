package com.arslan.pillapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.arslan.pillapp.entities.Pill
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pillPageButton.setOnClickListener{
            Toast.makeText(this,"İlaç butonuna basıldı",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,AddPillActivity::class.java))
        }
        alarmPageButton.setOnClickListener{
            Toast.makeText(this,"Alarm butonuna basıldı",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,AlarmActivity::class.java))

        }
        val dao = AppDatabase.getInstance(this).appDao
     //   lifecycleScope.launch {
     //       alarms.forEach { dao.insertAlarm(it) }
     //      pills.forEach { dao.insertPill(it) }
     //       pillAlarmRelations.forEach { dao.insertPillAlarmCrossRef(it) }
     //   }


        val listView = findViewById<ListView>(R.id.main_listview)

        val pills = mutableListOf<Pill>(
            Pill("Amazon","alışveriş sitesi","2"),
            Pill("Google","Arama Motoru","3"),
            Pill("Huawei","Telefoncu","2"),
            Pill("Huawe23i","Telefoncu","2"),

            )

        listView.adapter = MyCustomAdapter(this,pills)



    }





    private class MyCustomAdapter(context: Context,_pills:MutableList<Pill>): BaseAdapter(){

        private val mContext: Context

        val pills = _pills

        init{
            this.mContext = context
        }

        //responsible for how many rows in my list
        override fun getCount(): Int {
            return pills.size
        }

        //you can also ignore class
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        //you can ignore this for now
        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        //responsible for rendering out each row
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.row_main,null,false)
            val nameTextView = rowMain.findViewById<TextView>(R.id.name_textview)
            nameTextView.text = pills.get(position).pillName.toString()

            var positionTextView =rowMain.findViewById<TextView>(R.id.position_textview)
            positionTextView.text = "Count: ${pills.get(position).Count}"
            return rowMain



        }
    }




}