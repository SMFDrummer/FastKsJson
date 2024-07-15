import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonBuilder
import kotlinx.serialization.json.JsonObject
import java.util.concurrent.ConcurrentHashMap

enum class JsonFeature {
    PrettyPrint,
    ExplicitNulls,
    IgnoreUnknownKeys,
    AllowTrailingComma,
    AllowSpecialFloatingPointValues
}

@OptIn(ExperimentalSerializationApi::class)
private fun JsonBuilder.config(vararg features: JsonFeature): JsonBuilder {
    features.forEach {
        when (it) {
            JsonFeature.PrettyPrint -> this.prettyPrint = true
            JsonFeature.ExplicitNulls -> this.explicitNulls = true
            JsonFeature.IgnoreUnknownKeys -> this.ignoreUnknownKeys = true
            JsonFeature.AllowTrailingComma -> this.allowTrailingComma = true
            JsonFeature.AllowSpecialFloatingPointValues -> this.allowSpecialFloatingPointValues = true
        }
    }
    return this
}

class JsonCache {
    private val cache = ConcurrentHashMap<Set<JsonFeature>, Json>()

    fun getJson(vararg features: JsonFeature): Json {
        val featureSet = features.toSet()
        return cache.getOrPut(featureSet) {
            Json { config(*features) }
        }
    }
}

private val jsonCache = JsonCache()

fun Json.by(vararg features: JsonFeature): Json {
    return jsonCache.getJson(*features)
}
