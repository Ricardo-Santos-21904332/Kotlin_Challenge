package pt.ulusofona.cm.kotlin.challenge.pt.ulusofona.cm.kotlin.challenge

import pt.ulusofona.cm.kotlin.challenge.models.Bicicleta
import pt.ulusofona.cm.kotlin.challenge.models.Carro
import pt.ulusofona.cm.kotlin.challenge.models.Motor
import pt.ulusofona.cm.kotlin.challenge.models.Pessoa
import java.time.LocalDate
import java.time.ZoneId
import java.util.*


fun main() {
    // aqui escreves o código do programa
    val data = LocalDate.of(1999, 7, 11)
    val data1 = LocalDate.of(2000, 7, 11)
    val carro = Carro("29", Motor(250, 2000))
    val carro1 = Carro("2000", Motor(250, 2000))
    val carro2 = Carro("3000", Motor(250, 2000))
    println(carro.dataDeAquisicao)
    println(carro)
    val pessoa = Pessoa("Ricardo", Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant()))
    pessoa.veiculos.add(carro)
    pessoa.veiculos.add(carro1)
    println(pessoa)
    println(carro)
    println(pessoa)
    carro.moverPara(30, 40)
    println(carro)
    val pessoa2 = Pessoa("Zé", Date.from(data1.atStartOfDay(ZoneId.systemDefault()).toInstant()))
    pessoa2.comprarVeiculo(carro2)
    pessoa2.tirarCarta()
    pessoa2.moverVeiculoPara("29", 60, 70)
    println(carro)
    println(carro.motor.estaLigado())
    pessoa.comprarVeiculo(Bicicleta("30"))
    println(pessoa.veiculos)
    //pessoa2.moverVeiculoPara("29", 60, 70)
    println(pessoa.veiculos)
    println(pessoa.calculaIdade())
    println(pessoa2.calculaIdade())
    pessoa2.moverVeiculoPara("29", 30, 10)
    println(pessoa2.veiculos)


    println("Antes Venda do veiculo 29")
    println("Lista Ricardo ${pessoa.veiculos} ")
    println("Lista Zé ${pessoa2.veiculos} ")
    println("Venda")
    pessoa.venderVeiculo("29", pessoa2)
    println("Apos Venda do veiculo 29")
    println("Lista Ricardo ${pessoa.veiculos} ")
    println("Lista Zé ${pessoa2.veiculos} ")
}