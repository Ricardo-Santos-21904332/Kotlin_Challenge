package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel

class Motor(val cavalos: Int, val cilindrada: Int) : Ligavel {
    var ligado: Boolean = false

    override fun ligar() {
        if (!ligado) {
            ligado = true
            return
        }
        throw VeiculoLigadoException("O veículo já se encontra ligado!")
    }

    override fun desligar() {
        if (ligado) {
            ligado = false
            return
        }
        throw VeiculoDesligadoException("O veículo já se encontra desligado!")
    }

    override fun estaLigado(): Boolean {
        return ligado
    }

    override fun toString(): String = "Motor | $cavalos | $cilindrada"
}