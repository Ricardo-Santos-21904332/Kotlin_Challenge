package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

abstract class Veiculo(val indetificador: String) : Movimentavel {
    val identificador = this.indetificador
    var posicao: Posicao = Posicao(0, 0)
    var dataDeAquisicao: Date = Date()
    val dataDeAquisicaoToString = formatarData(dataDeAquisicao)

    abstract fun requerCarta(): Boolean

    fun formatarData(dataDeNascimento: Date): String {
        val formatter: DateFormat = SimpleDateFormat("dd-MM-yyyy")
        val dataFormatada = formatter.format(dataDeNascimento)
        return dataFormatada
    }

    override fun moverPara(x: Int, y: Int) {
    }

    override fun toString(): String = "$identificador | $dataDeAquisicaoToString | Posicao | x:${posicao.x} | y:${posicao.y}"
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Veiculo

        if (indetificador != other.indetificador) return false
        if (identificador != other.identificador) return false
        if (posicao != other.posicao) return false
        if (dataDeAquisicao != other.dataDeAquisicao) return false

        return true
    }

    override fun hashCode(): Int {
        var result = indetificador.hashCode()
        result = 31 * result + identificador.hashCode()
        result = 31 * result + posicao.hashCode()
        result = 31 * result + dataDeAquisicao.hashCode()
        return result
    }
}