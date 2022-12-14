package com.example.appalcoolougasolina

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //função calcular onClick
    fun calcularPreco(view: View){

        //capturanto string dos editText
        val precoAlcool =edtPrecoAlcool.text.toString()
        val precoGasolina =edtPrecoGasolina.text.toString()

        // varialvel booleana que amazena informação captura do edtText esta vazia ou preenchida
        val validaCampos = validarCampos(precoAlcool,precoGasolina)

        if (validaCampos){
            //
            calcularMelhorPreco(precoAlcool,precoGasolina)
        }else{
            txtResultado.text = getString(R.string.edt_result)
        }

    }

    private fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String) {
        //Converter de string para Double
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        // resultado ad formula
        val resultadoPreco = valorAlcool/valorGasolina

        //laço da formula
        if(resultadoPreco>=0.7){
            txtResultado.text = getString(R.string.gasolina)
        }else{
            txtResultado.text = getString(R.string.alcool)

        }
    }

    // Metodo Booleano para verificar se os campos estão vazios"false" ou preenchidos "true"
    private fun validarCampos(precoAlcool: String, precoGasolina: String):Boolean {

        // varialvel onde armazena  true ou false
        var camposValidados = true

        //veirificando se campo do preco alcool esta vazio
        if(precoAlcool==null||precoAlcool.equals("")){

            //se o campo do edtText esta vazio determina-se false
            camposValidados=false
        }

        //veirificando se campo do preco gasolina esta vazio
        else if(precoGasolina==null||precoGasolina.equals("")) {

            //se o campo do edtText esta vazio determina-se false
            camposValidados = false
        }

        // Essa função tem como objetivo retornar um booleano para a
        //  função calcularPreco que verifica a condição  e que chama a função calcularMelhorPreco
        //  para calcular sem erros relacionado a captura dos edtTexts
        return camposValidados
    }


}
