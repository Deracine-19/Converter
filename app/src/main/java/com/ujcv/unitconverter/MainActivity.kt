package com.ujcv.unitconverter

import android.os.Bundle
import android.view.Window
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.ujcv.unitconverter.R.layout.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        //this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)


        setContentView(R.layout.activity_main);

        //Categories Spinner Styling
        val category_spnr: Spinner = findViewById(R.id.spnr_categorias)
        val category_spnr_adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this,
            R.array.categories,
            selected_item)
        //adapter.setDropDownViewResource(R.layout.selected_item)
        category_spnr.setAdapter(category_spnr_adapter)

        //Units Spinner A Styling
        val units_spnr_input: Spinner = findViewById(R.id.spnr_units)
        val units_spnr_input_adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this,
            R.array.longitud_unidades,
            units_spnr_input_selected_item)
        //adapter.setDropDownViewResource(R.layout.selected_item)
        units_spnr_input.setAdapter(units_spnr_input_adapter)


        //Units Spinner B Styling
        val units_spnr_output: Spinner = findViewById(R.id.spnr_units2)
        val units_spnr_output_adapter: ArrayAdapter<*> = ArrayAdapter.createFromResource(
            this,
            R.array.longitud_unidades,
            units_spnr_output_selected_item)
        //adapter.setDropDownViewResource(R.layout.selected_item)
        units_spnr_output.setAdapter(units_spnr_output_adapter)

    }
}