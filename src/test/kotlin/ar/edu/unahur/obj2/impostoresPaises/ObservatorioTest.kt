import ar.edu.unahur.obj2.impostoresPaises.Observatorio
import ar.edu.unahur.obj2.impostoresPaises.Pais
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.engine.toTestResult
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder


class ObservatorioTest : DescribeSpec ({

  val argentina = Pais( "Argentina", "ARG",47000000, 2780400.0, "America",
    "ARS", 135.6, listOf("UNASUR", "MERCOSUR"), listOf("español","guarani","qom")
  )

  val brasil = Pais("Brasil","BRA",208388000,8515770.00,"America",
    "REA",5.41, listOf("UNASUR", "MERCOSUR"),
    listOf("portugues")
  )
  val chile = Pais("Chile","CHI",18430408,756950.00,"America",
    "CHI",0.00095, listOf("UNASUR"),
    listOf("español","rapanui")
  )

  describe("Test de Observatorio") {
    it("Comprobacion de atributos") {
      Observatorio.agregarPais(argentina)
      Observatorio.agregarPais(brasil)
      Observatorio.agregarPais(chile)

      brasil.agregarPaisLimitrofe(argentina)
      argentina.agregarPaisLimitrofe(brasil)
      argentina.agregarPaisLimitrofe(chile)
      chile.agregarPaisLimitrofe(argentina)

      //Observatorio.paises.size.shouldBe(3)

      Observatorio.sonLimitrofes("Argentina","Brasil").shouldBe(true)
      Observatorio.sonLimitrofes("Chile","Brasil").shouldBe(false)
      shouldThrow<Exception> { Observatorio.sonLimitrofes("Argentina","Disneyland") }

      Observatorio.necesitanTraduccion("Argentina","Brasil").shouldBe(true)
      Observatorio.necesitanTraduccion("Argentina","Chile").shouldBe(false)
      shouldThrow<Exception> { Observatorio.necesitanTraduccion("Argentina", "Disneyland") }

      Observatorio.sonPotencialesAliados("Argentina", "Brasil").shouldBe(false)
      Observatorio.sonPotencialesAliados("Argentina", "Chile").shouldBe(true)

      Observatorio.convieneIrDeComprasDesdeA("Argentina", "Brasil").shouldBe(false)
      Observatorio.convieneIrDeComprasDesdeA("Brasil", "Argentina").shouldBe(true)
      shouldThrow<Exception> { Observatorio.convieneIrDeComprasDesdeA("Brasil","Disneyland") }

      Observatorio.aCuantoEquivaleEn(20000.00, "Argentina","Brasil").shouldBe(797.93 plusOrMinus 0.01)
      shouldThrow<Exception> { Observatorio.aCuantoEquivaleEn(20000.00, "Argentina","Disneyland") }

      Observatorio.codigosPaisesMasDensamentePoblados().shouldContainExactlyInAnyOrder("CHI","ARG","BRA")

    }
  }
  describe("Test de Promedio Densidad Poblacional") {
    it("Paises Insulares") {

      val australia = Pais(
        "Australia","AUS",25900570,7741220.0,"Oceania",
        "AUD", 1.23, listOf("OTAN"), listOf("ingles")
      )
      val groenlandia = Pais(
        "Groenlandia","GRL",9876600,2166086.0,"America",
        "DKK", 1.23, listOf("OTAN"), listOf("ingles", "danes")
      )
      val islandia = Pais(
        "Islandia","ISL",457050,103000.0,"Europa",
        "ISK", 1.23, listOf("OTAN"), listOf("ingles","islandes")
      )

      shouldThrow<Exception> { Observatorio.promedioDensidadPoblacionalPaisesInsulares() }

      Observatorio.agregarPais(australia)     // densidad 3
      Observatorio.agregarPais(groenlandia)   // densidad 5
      Observatorio.agregarPais(islandia)      // densidad 4

      Observatorio.promedioDensidadPoblacionalPaisesInsulares().shouldBe(4.0)

      Observatorio.continenteConMasPaisesPlurinacionales().shouldBe("America")
    }
  }
})