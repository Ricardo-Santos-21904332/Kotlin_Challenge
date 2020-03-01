package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoDesligadoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoLigadoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Ligavel
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel

class Carro(indetificador: String, motor: Motor) : Veiculo(indetificador), Movimentavel, Ligavel {
    var motor = motor
    var carroLigado = false
    override fun requerCarta(): Boolean {
        return true
    }

    override fun moverPara(x: Int, y: Int) {
        if (!carroLigado) {
            ligar()
        }
        posicao.alterarPosicaoPara(x, y)
        desligar()
    }

    override fun ligar() {
        if (!carroLigado) {
            carroLigado = true
            motor.ligar()
            return
        }
        throw VeiculoLigadoException("O veículo já se encontra ligado!")
    }

    override fun desligar() {
        if (carroLigado) {
            carroLigado = false
            motor.desligar()
            return
        }
        throw VeiculoDesligadoException("O veículo já se encontra desligado!")
    }

    override fun estaLigado(): Boolean {
        return carroLigado
    }


    override fun toString(): String =
        "Carro | $identificador | $dataDeAquisicaoToString | Posicao | x:${posicao.x} | y:${posicao.y}"


}