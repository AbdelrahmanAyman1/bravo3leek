package com.example.bravo3leek

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class HomeActivity : AppCompatActivity() {
    lateinit var textInputLayout: TextInputLayout
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        textInputLayout = findViewById(R.id.textinput)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            if (valdate() == true) {
                startBravo3leekActivity()
            }
        }
    }

    private fun startBravo3leekActivity() {
        Handler(Looper.getMainLooper()).postDelayed({
            start()
        }, 0)
    }

    private fun start() {
        val intent = Intent(this, Bravo3leekActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun valdate(): Boolean {
        var isValid = true
        if (textInputLayout.editText?.text.toString().isBlank()) {
            textInputLayout.error = "اكتب حاجه يسطا متخمش"
            isValid = false
        } else {
            textInputLayout.error = null
        }
        return isValid
    }
}