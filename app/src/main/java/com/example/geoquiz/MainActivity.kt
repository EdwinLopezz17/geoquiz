package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var position = 0
    var points:Float = 0.00f

    private lateinit var btYes: Button
    private lateinit var btNo: Button
    private lateinit var btNext: Button
    private lateinit var tvSentence: TextView
    private lateinit var tvPoints:TextView
    private lateinit var tvQuestionNumber: TextView

    private lateinit var progressBar:ProgressBar

    private lateinit var questions:ArrayList<Question>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btYes = findViewById(R.id.btYes)
        btNo = findViewById(R.id.btNo)
        btNext = findViewById(R.id.btNext)
        tvSentence = findViewById(R.id.tvSentence)
        tvPoints = findViewById(R.id.tvPoints)
        tvQuestionNumber = findViewById(R.id.tvQuestionNumber)
        progressBar = findViewById(R.id.progressBar)


        loadQuestions()
        showSentence()
        setupViews()
        updateInfo()


    }

    fun setupViews(){

        btYes.setOnClickListener{
            if(questions[position].isAnswer){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
                points += 3
            }else{
                Toast.makeText(this, "In Correcto", Toast.LENGTH_LONG).show()
                points-=0.2f
            }
            nextQuestion()

            updateInfo()

            progressBar.setProgress(position+1,true)
        }

        btNo.setOnClickListener{

            if(!questions[position].isAnswer){
                Toast.makeText(this, "Correcto", Toast.LENGTH_LONG).show()
                points+=3
            }else{
                Toast.makeText(this, "In Correcto", Toast.LENGTH_LONG).show()
                points -= 0.2f

            }
            nextQuestion()

            updateInfo()

            progressBar.setProgress(position+1,true)
        }

        btNext.setOnClickListener{
           nextQuestion()
        }
    }

    fun updateInfo(){
        tvPoints.text = points.toString()
        tvQuestionNumber.text = (1+position).toString()
    }

    fun showSentence(){
        tvSentence.text = questions[position].sentence
    }
    fun nextQuestion(){
        position++
        if(questions.size <= position ){
            tvSentence.text="Fin del juego"

            btYes.visibility = View.GONE
            btNo.visibility = View.GONE
            btNext.visibility = View.GONE

            position=0
        }else{
            showSentence()
        }
    }


    fun loadQuestions(){
        questions = ArrayList()

        questions.add(Question("¿Lima es la capital de peru?", true))
        questions.add(Question("¿La Gran Muralla China es visible desde el espacio?", false))
        questions.add(Question("¿La Mona Lisa fue pintada por Leonardo da Vinci?", true))
        questions.add(Question("¿El Taj Mahal se encuentra en India?", true))
        questions.add(Question("¿El sistema solar tiene más de ocho planetas?", false))
        questions.add(Question("¿La Gran Barrera de Coral está en Australia?", true))
        questions.add(Question("¿La Torre Eiffel está ubicada en París?", true))
        questions.add(Question("¿El Everest es la montaña más alta del mundo?", true))
        questions.add(Question("¿El árabe es el idioma oficial de Rusia?", false))
        questions.add(Question("¿El agua hierve a 200 grados Celsius a nivel del mar?", false))
        questions.add(Question("¿La ópera es un género musical?", true))
        questions.add(Question("¿La pizza es originaria de españa?", false))
        questions.add(Question("¿El ajedrez es un juego de estrategia?", true))
        questions.add(Question("¿El Monte Rushmore tiene esculturas de presidentes de EE. UU.?", true))
        questions.add(Question("¿El Amazonas es el río más largo del mundo?", true))
        questions.add(Question("¿La Mona Lisa está expuesta en el Louvre?", true))
        questions.add(Question("¿El inglés es el idioma oficial de Canadá?", false))
        questions.add(Question("¿La Capilla Sixtina se encuentra en el Vaticano?", true))
        questions.add(Question("¿El diamante es la piedra preciosa mas valioza?", false))
        questions.add(Question("¿La Torre de Pisa está inclinada?", true))
    }
}