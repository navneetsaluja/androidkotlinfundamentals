package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Navneet Saluja")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.myName = myName
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }

        binding.nicknameText.setOnClickListener {
            editNickname(it)
        }
    }

    private fun addNickname (view: View) {
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

        val InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        InputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun editNickname (view: View) {
        binding.nicknameEdit.visibility = View.VISIBLE
        binding.doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        binding.nicknameEdit.requestFocus()
        val InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        InputMethodManager.showSoftInput(binding.nicknameEdit, 0)
    }
}
