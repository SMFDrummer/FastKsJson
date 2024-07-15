import kotlinx.serialization.json.*

/**
 *  parse any text to [JsonElement], such value to [JsonPrimitive], object to [JsonObject], array to [JsonArray]
 */
fun Json.parse(text: String): JsonElement = Json.parseToJsonElement(text)

/**
 *  parse any text to [JsonObject], the text must be a [LinkedHashMap] start with '{' and end with '}'
 */
fun Json.parseObject(text: String): JsonObject = this.parse(text) as JsonObject

fun String.parseObject(): JsonObject = Json.parseObject(this)

/**
 *  parse any text to [JsonArray], the text must be a [LinkedHashSet] start with '[' and end with ']'
 */
fun Json.parseArray(text: String): JsonArray = this.parse(text) as JsonArray

fun String.parseArray(): JsonArray = Json.parseArray(this)

/**
 * if text is a [JsonObject], return true, else return false
 */
fun Json.isObject(text: String): Boolean {
    return try {
        Json.parse(text) is JsonObject
    } catch (_: Exception) {
        false
    }
}

fun String.isJsonObject(): Boolean = Json.isObject(this)

/**
 * if text is a [JsonArray], return true, else return false
 */
fun Json.isArray(text: String): Boolean {
    return try {
        Json.parse(text) is JsonArray
    } catch (_: Exception) {
        false
    }
}

fun String.isJsonArray(): Boolean = Json.isArray(this)

/**
 * deserialize any text to target class
 */
inline fun<reified T> Json.to(text: String): T = Json.decodeFromString<T>(text)

inline fun<reified T> String.to(): T = Json.to<T>(this)
