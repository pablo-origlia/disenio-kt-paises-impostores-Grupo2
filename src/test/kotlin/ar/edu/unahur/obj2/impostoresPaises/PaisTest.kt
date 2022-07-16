package ar.edu.unahur.obj2.impostoresPaises

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.engine.toTestResult
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.internal.artificialFrame

class PaisTest : DescribeSpec ({
  val argentina = Pais( "Argentina", "ARG",47000000, 2780400.0, "America",
    "ARS", 135.6, listOf("UNASUR", "MERCOSUR"), listOf("español","guarani","qom")
  )

  val brasil = Pais("Brasil","BRA",208388000,8515770.00,"America",
    "REA",5.41, listOf("UNASUR", "MERCOSUR"),
    listOf("portugues","español")
  )

  describe("Test de Pais") {
    it("Comprobación de atributos") {
      argentina.esPlurinacional().shouldBe(true)
      argentina.agregarPaisLimitrofe(brasil)
      argentina.esUnaIsla().shouldBe(false)
      argentina.densidadPoblacional().shouldBe(17)
      argentina.vecinoMasPoblado().shouldBe(brasil)
      argentina.esLimitrofeDe(brasil).shouldBe(true)
      argentina.necesitaTraduccionCon(brasil).shouldBe(false)
      argentina.esPotencialAliadoDe(brasil).shouldBe(true)
      argentina.convieneIrDeComprasA(brasil).shouldBe(false)
      brasil.convieneIrDeComprasA(argentina).shouldBe(true)
      argentina.aCuantoEquivaleEn(20000.00, brasil).shouldBe(797.93 plusOrMinus 0.01)
    }
  }
})