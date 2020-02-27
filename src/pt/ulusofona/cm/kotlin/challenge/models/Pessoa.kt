package pt.ulusofona.cm.kotlin.challenge.models

import java.util.*

class Pessoa(val nome: String, val dataNascimento: Date) {
    val listaVeiculos = mutableListOf<Veiculo>()
    val carta: Carta =
        Carta()
    var posicao: Posicao =
        Posicao(0, 0)


    fun comprarVeiculo(veiculo: Veiculo) {
        listaVeiculos.add(veiculo)
    }

    fun pesquisarVeiculo(identificador: String): Veiculo? {
        for (i in listaVeiculos) {
            if (identificador.equals(i.indetificador)) {
                return i
            }
        }
        return null
    }

    fun venderVeiculo(identificador: String, comprador: Pessoa) {
        for (i in listaVeiculos) {
            if (identificador.equals(i.indetificador)) {
                listaVeiculos.remove(i)
                comprador.listaVeiculos.add(i)
            }
        }
    }
    

    fun temCarta(): Boolean {
        return true
    }

    fun tirarCarta() {

    }
}
