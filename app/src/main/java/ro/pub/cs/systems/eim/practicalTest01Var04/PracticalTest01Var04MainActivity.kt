package ro.pub.cs.systems.eim.practicalTest01Var04

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class PracticalTest01Var04MainActivity : AppCompatActivity() {
    public lateinit var btn1 : Button
    public lateinit var btn2 : Button

    public lateinit var edit1 : EditText
    public lateinit var edit2 : EditText

    public lateinit var check1 : CheckBox
    public lateinit var check2 : CheckBox

    public var checked1 : Boolean = false
    public var checked2 : Boolean = false
    public lateinit var text1 : TextView

    companion object {
        private const val OK = 1
        private const val ERR = 0
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var04_main)

        btn1 = findViewById<Button>(R.id.btn1)
        btn2 = findViewById<Button>(R.id.btn2)

        edit1 = findViewById<EditText>(R.id.edit1)
        edit2 = findViewById<EditText>(R.id.edit2)

        check1 = findViewById<CheckBox>(R.id.check1)
        check2 = findViewById<CheckBox>(R.id.check2)

        text1 = findViewById<TextView>(R.id.text1)

        check1.setOnCheckedChangeListener({ buttonView, isChecked ->
            checked1 = check1.isChecked
        })
        check2.setOnCheckedChangeListener({ buttonView, isChecked ->
            checked2 = check2.isChecked
        })


        btn1.setOnClickListener {
            //val intent1 : Intent = Intent(this@PracticalTest01Var04MainActivity, PracticalTest01Var04SecondaryActivity::class.java)
            startActivity(Intent(this@PracticalTest01Var04MainActivity, PracticalTest01Var04SecondaryActivity::class.java))
//            intent.putExtra("TEXT1", edit1.text)
//            intent.putExtra("TEXT2", edit2.text)

        }

        btn2.setOnClickListener {
            if (checked1 && edit1.getText().toString().isEmpty()
                || checked2 && edit2.getText().toString().isEmpty() || !checked1 && !checked2) {
                Toast.makeText(applicationContext,"Unchecked boxes error", Toast.LENGTH_SHORT).show()
            } else {
                text1.text = edit1.text.toString() + " - " + edit2.text.toString()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putString("TEXT1", text1.text.toString())
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        savedInstanceState.getString("TEXT1")?.let { username ->
            text1.setText(username)
        }
    }

}