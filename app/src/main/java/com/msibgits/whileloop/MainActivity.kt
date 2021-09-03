package com.msibgits.whileloop

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.msibgits.whileloop.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var view: View

    // Diberikan angka : 2, 4, 7, 9, 12, 20, 44, 68, 90
    private val givenNumberList = listOf(2, 4, 7, 9, 12, 20, 44, 68, 90)

    // Diberikan nama : Refi, Alpin, Haries, Imam, Aldi, Memot
    private val givenNameList = listOf("Refi", "Alpin", "Haries", "Imam", "Aldi", "Memot")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        view = binding.root
        setContentView(view)
        initView()
    }

    private fun initView() {
        binding.btnFilter.setOnClickListener {
            val result = filterNumberMod()
            binding.tvResultNumber.text = result
        }

        binding.btnSearch.setOnClickListener {
            val result = findImam()
            binding.tvResultName.text = result
        }
    }

    private fun filterNumberMod(): String {
        val result = StringBuilder()
        result.append("Hasilnya:")
        val listIterator = givenNumberList.iterator()
        while (listIterator.hasNext()) {
            val value = listIterator.next()
            if (value % 2 == 0) {
                result.append("\n$value")
                continue
            }
        }
        return result.toString()
    }

    private fun findImam(): String {
        val query = "Imam"
        val result = StringBuilder()
        result.append("Hasilnya:")
        val listIterator = givenNameList.iterator()
        while (listIterator.hasNext()) {
            val name = listIterator.next()
            if (name == query) {
                result.append(name)
                break
            } else {
                continue
            }
        }
        return result.toString()
    }

}