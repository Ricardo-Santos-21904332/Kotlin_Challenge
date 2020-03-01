package pt.ulusofona.cm.kotlin.challenge.models

import pt.ulusofona.cm.kotlin.challenge.exceptions.AlterarPosicaoException
import pt.ulusofona.cm.kotlin.challenge.exceptions.MenorDeIdadeException
import pt.ulusofona.cm.kotlin.challenge.exceptions.PessoaSemCartaException
import pt.ulusofona.cm.kotlin.challenge.exceptions.VeiculoNaoEncontradoException
import pt.ulusofona.cm.kotlin.challenge.interfaces.Movimentavel
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


class Pessoa(val nome: String, val dataDeNascimento: Date) : Movimentavel {
    var veiculos = mutableListOf<Veiculo>()
    var carta: Carta? = null
    var posicao: Posicao =
        Posicao(0, 0)
    val dataDeNascimentoToString = formatarData(dataDeNascimento)

    fun comprarVeiculo(veiculo: Veiculo) {
        veiculo.dataDeAquisicao = Date()
        veiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador: String): Veiculo {
        for (i in veiculos) {
            if (identificador.equals(i.indetificador)) {
                return i
            }
        }
        throw VeiculoNaoEncontradoException("Veículo não encontrado!")
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        val iterator = veiculos.iterator()
        while (iterator.hasNext()) {
            val veiculo = iterator.next()
            if (identificador.equals(veiculo.indetificador)) {
                comprador.veiculos.add(veiculo)
                //veiculo.dataDeAquisicao = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
                val data = Date()
                veiculo.dataDeAquisicao = data
                iterator.remove()
                return
            }
        }
    }

    fun moverVeiculoPara(identificador: String, x: Int, y: Int) {
        val posicaoAMover = Posicao(x, y)
        val iterator = veiculos.iterator()
        while (iterator.hasNext()) {
            val veiculo = iterator.next()
            if (carta == null && veiculo.requerCarta()) {
                throw PessoaSemCartaException("$nome não tem carta para conduzir o veículo indicado")
            } else if (identificador.equals(veiculo.indetificador)) {
                if (posicaoAMover.equals(veiculo.posicao)) {
                    throw AlterarPosicaoException("Posição Ocupada")
                }
                veiculo.moverPara(x, y)
            }
        }
    }

    fun temCarta(): Boolean {
        if (carta != null) {
            return true
        }
        return false
    }

    fun tirarCarta() {
        if (calculaIdade() > 18) {
            carta = Carta()
            return
        }
        throw MenorDeIdadeException("$nome é menor de idade, não é possível tirar a carta!")
    }

    override fun moverPara(x: Int, y: Int) {
        val posicaoAMover = Posicao(x, y)
        if (posicaoAMover.equals(posicao)) {
            throw AlterarPosicaoException("Posição Ocupada")
        }
        posicao.alterarPosicaoPara(x, y)
    }

    fun formatarData(dataDeNascimento: Date): String {
        val formatter: DateFormat = SimpleDateFormat("dd-MM-yyyy")
        val dataFormatada = formatter.format(dataDeNascimento)
        return dataFormatada
    }

    fun calculaIdade(): Int {
        val formatter: DateFormat = SimpleDateFormat("dd-MM-yyyy")
        val aux5 = formatter.format(dataDeNascimento)
        val aux = aux5.split("-").toTypedArray()
        val dia = aux[0]
        val mes = aux[1]
        val ano = aux[2]
        val aux2: String = LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")).toString()
        val aux3 = aux2.split("-")
        val dia1 = aux3[0]
        val mes1 = aux3[1]
        val ano1 = aux3[2]
        val idade = (Integer.parseInt(ano1) - Integer.parseInt(ano))
        return idade

    }

    override fun toString(): String =
        "Pessoa | $nome | $dataDeNascimentoToString | Posicao | x:${posicao.x} | y:${posicao.y}"

}
