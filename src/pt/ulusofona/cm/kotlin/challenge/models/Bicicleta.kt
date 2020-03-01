package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel

class Bicicleta(indetificador: String) : Veiculo(indetificador), Movimentavel {
    override fun requerCarta(): Boolean {
        return false
    }

    override fun moverPara(x: Int, y: Int) {
        posicao.alterarPosicaoPara(x, y)
    }


    override fun toString(): String =
        "Bicicleta | $identificador | $dataDeAquisicao | Posicao | x:${posicao.x} | y:${posicao.y}"
}