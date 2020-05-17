package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it)
        }

        findViewById<TextView>(R.id.nickname_text).setOnClickListener {
            editNickname(it)
        }
    }

    private fun addNickname (view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameText = findViewById<TextView>(R.id.nickname_text)

        nicknameText.text = editText.text
        editText.visibility = View.GONE
        view.visibility = View.GONE
        nicknameText.visibility = View.VISIBLE

        val InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        InputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun editNickname (view: View) {
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)

        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        editText.requestFocus()
        val InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        InputMethodManager.showSoftInput(editText, 0)
    }
}
