object AndroidConfig {
    const val namespace = "com.stanleymesa.pokedex"
    const val applicationId = "com.stanleymesa.pokedex"
    const val compileSdk = 34
    const val targetSdk = 34
    const val minSdk = 23
    const val versionCode = 1
    const val versionName = "1.0.0"

    const val baseURLStaging = "\"https://pokeapi.co/api/v2/\""
    const val baseURLProduction = "\"https://pokeapi.co/api/v2/\""
    const val koltinCompilerVersion = "1.4.2"

    var moduleNameSpace: String? = ""
    fun moduleNameSpace(nameSpace: String) {
        moduleNameSpace = nameSpace
    }
}