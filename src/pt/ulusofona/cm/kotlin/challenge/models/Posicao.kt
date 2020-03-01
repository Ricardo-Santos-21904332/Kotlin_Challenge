package pt.ulusofona.cm.kotlin.challenge.models


data class Posicao(var x: Int, var y: Int) {
    fun alterarPosicaoPara(x1: Int, y1: Int) {
        x = x1
        y = y1
    }

    override fun toString(): String = "Posicao | x:$x | y:$y"

}