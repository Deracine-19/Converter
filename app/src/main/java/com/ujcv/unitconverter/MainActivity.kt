package com.ujcv.unitconverter

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.Window
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ujcv.unitconverter.R.layout.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var units_spnr_input: Spinner
    lateinit var units_spnr_output: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(activity_main);

        //Categories Spinner Styling
        val category_spnr: Spinner = findViewById(R.id.spnr_categorias);
        val category_spnr_adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this,
            R.array.categories,
            categories_spnr_selected_item);
        //category_spnr_adapter.setDropDownViewResource(R.layout.categories_spnr_selected_item)
        category_spnr.adapter = category_spnr_adapter;



        //Units Spinner A Styling
        units_spnr_input = findViewById(com.ujcv.unitconverter.R.id.input_unit_spnr);

        val units_spnr_input_adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this,
            R.array.longitud_unidades,
            units_spnr_input_selected_item);

        units_spnr_input_adapter.setDropDownViewResource(R.layout.categories_spnr_selected_item);

        units_spnr_input.adapter = units_spnr_input_adapter;


        //Units Spinner B Styling
        units_spnr_output = findViewById(R.id.output_units_spnr);
        val units_spnr_output_adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this,
            R.array.longitud_unidades,
            units_spnr_output_selected_item);

        units_spnr_output_adapter.setDropDownViewResource(output_dropdown);

        units_spnr_output.adapter = units_spnr_output_adapter;


        // Input Box Change Listener
        editTxt_input.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                inputValidation()

            }
        })

        // Category Spinner Change Listener
        spnr_categorias.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                checkCategory()
            }
        }
    }

    private fun inputValidation() {
        if (editTxt_input.text.toString().isEmpty()) {
            Toast.makeText(this@MainActivity, "Please enter a value :)", Toast.LENGTH_LONG).show()
            txt_output.setText("")
        } else {
            evaluateConversion()
        }
    }

    private fun evaluateConversion() {
        if (input_unit_spnr.selectedItem.toString() == "km" && output_units_spnr.selectedItem.toString() == "m") {
            val result = (editTxt_input.text.toString().toFloat() * 1000)
            txt_output.text = String.format("%.2f", result)

        }
    }

    private fun checkCategory() {

        val units_spnr_input_adapter: ArrayAdapter<*>
        val units_spnr_output_adapter: ArrayAdapter<*>
        
        if (spnr_categorias.selectedItem.toString() == "Densidad")
        {

            val units_spnr_input_adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
                this,
                R.array.densidad_unidades,
                units_spnr_input_selected_item)

            val units_spnr_output_adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
                this,
                R.array.densidad_unidades,
                units_spnr_output_selected_item)

            units_spnr_input.setAdapter(units_spnr_input_adapter)
            units_spnr_output.setAdapter(units_spnr_output_adapter)
        }
        else
        {
            if (spnr_categorias.selectedItem.toString() == "Masa")
            {

                units_spnr_input_adapter = ArrayAdapter.createFromResource(
                    this,
                    R.array.masa_unidades,
                    units_spnr_input_selected_item)

                units_spnr_output_adapter = ArrayAdapter.createFromResource(
                    this,
                    R.array.masa_unidades,
                    units_spnr_output_selected_item)

                units_spnr_input.setAdapter(units_spnr_input_adapter)
                units_spnr_output.setAdapter(units_spnr_output_adapter)
            }
            else
            {
                if (spnr_categorias.selectedItem.toString() == "Longitud")
                {

                    units_spnr_input_adapter = ArrayAdapter.createFromResource(
                            this,
                            R.array.longitud_unidades,
                            units_spnr_input_selected_item)

                    units_spnr_output_adapter = ArrayAdapter.createFromResource(
                            this,
                            R.array.longitud_unidades,
                            units_spnr_output_selected_item)

                    units_spnr_input.setAdapter(units_spnr_input_adapter)
                    units_spnr_output.setAdapter(units_spnr_output_adapter)
                }
                else
                {
                    if (spnr_categorias.selectedItem.toString() == "Superficie")
                    {

                        units_spnr_input_adapter = ArrayAdapter.createFromResource(
                                this,
                                R.array.superifcie_unidades,
                                units_spnr_input_selected_item)

                        units_spnr_output_adapter = ArrayAdapter.createFromResource(
                                this,
                                R.array.superifcie_unidades,
                                units_spnr_output_selected_item)

                        units_spnr_input.setAdapter(units_spnr_input_adapter)
                        units_spnr_output.setAdapter(units_spnr_output_adapter)
                    }
                    else
                    {
                        if (spnr_categorias.selectedItem.toString() == "Volumen")
                        {

                            units_spnr_input_adapter = ArrayAdapter.createFromResource(
                                    this,
                                    R.array.volumen_unidades,
                                    units_spnr_input_selected_item)

                            units_spnr_output_adapter = ArrayAdapter.createFromResource(
                                    this,
                                    R.array.volumen_unidades,
                                    units_spnr_output_selected_item)

                            units_spnr_input.setAdapter(units_spnr_input_adapter)
                            units_spnr_output.setAdapter(units_spnr_output_adapter)
                        }
                    }
                }
            }
        }
    }
}