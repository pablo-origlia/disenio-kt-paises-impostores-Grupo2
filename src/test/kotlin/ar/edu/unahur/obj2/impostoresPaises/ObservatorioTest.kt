import ar.edu.unahur.obj2.impostoresPaises.Observatorio
import ar.edu.unahur.obj2.impostoresPaises.Pais
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
    listOf("portugues","español")
  )

  val chile = Pais("Chile","CHI",18430408,756950.00,"America",
    "CHI",0.00095, listOf("UNASUR"),
    listOf("español","rapanui")
  )

  Observatorio.agregarPais(argentina)
  Observatorio.agregarPais(brasil)
  Observatorio.agregarPais(chile)

  brasil.agregarPaisLimitrofe(argentina)
  argentina.agregarPaisLimitrofe(brasil)
  argentina.agregarPaisLimitrofe(chile)
  chile.agregarPaisLimitrofe(argentina)

  describe("Test de Observatorio") {
    it("Comprobación de atributos") {
      Observatorio.sonLimitrofes("Argentina","Brasil").shouldBe(true)
      Observatorio.necesitanTraduccion("Argentina","Brasil").shouldBe(false)
      Observatorio.necesitanTraduccion("Argentina","Brasil").shouldBe(true)
      Observatorio.convieneIrDeComprasDesdeA("Argentina","Brasil").shouldBe(false)
      Observatorio.convieneIrDeComprasDesdeA("Brasil","Argentina").shouldBe(true)
      Observatorio.aCuantoEquivaleEn(20000.00, "Argentina","Brasil").shouldBe(797.93 plusOrMinus 0.01)
      Observatorio.codigosPaisesMasDensamentePoblados().shouldContainExactlyInAnyOrder("CHI","ARG","BRA")
    }
  }
})