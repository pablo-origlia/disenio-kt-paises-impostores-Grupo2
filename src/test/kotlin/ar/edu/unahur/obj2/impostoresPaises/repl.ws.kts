import ar.edu.unahur.obj2.impostoresPaises.Pais
import ar.edu.unahur.obj2.impostoresPaises.*
import ar.edu.unahur.obj2.impostoresPaises.api.CurrencyConverterAPI
import ar.edu.unahur.obj2.impostoresPaises.api.RestCountriesAPI
import io.kotest.core.spec.style.DescribeSpec

// Algunos ejemplos para que jueguen un poco
// con lo que devuelve la API

//val api = RestCountriesAPI()
//api.buscarPaisesPorNombre("guay")
//api.paisConCodigo("CHL")

//val currencyApi = CurrencyConverterAPI("poné acá la API key")
//// PEN es el código del sol peruano
//currencyApi.convertirDolarA("PEN")



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


Observatorio.paises.map { p->p.densidadPoblacional() }.sorted().take(2)
Observatorio.paises.filter { p->p.densidadPoblacional() == 24}.map{p->p.codigoIso3}
