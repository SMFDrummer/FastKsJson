/**
 * As extended function with [JsonObject],
 * any getSomething function will return the value or a null,
 * but if you use the getSomethingValue function, it will return the value or an exception
 */

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*
import org.noear.snack.ONode
import org.noear.snack.core.JsonPath

fun JsonObject.getInt(key: String): Int? = this[key]?.jsonPrimitive?.intOrNull

fun JsonObject.getIntValue(key: String): Int = this[key]?.jsonPrimitive?.int!!

fun JsonObject.getLong(key: String): Long? = this[key]?.jsonPrimitive?.longOrNull

fun JsonObject.getLongValue(key: String): Long = this[key]?.jsonPrimitive?.long!!

fun JsonObject.getBoolean(key: String): Boolean? = this[key]?.jsonPrimitive?.booleanOrNull

fun JsonObject.getBooleanValue(key: String): Boolean = this[key]?.jsonPrimitive?.boolean!!

fun JsonObject.getFloat(key: String): Float? = this[key]?.jsonPrimitive?.floatOrNull

fun JsonObject.getFloatValue(key: String): Float = this[key]?.jsonPrimitive?.float!!

fun JsonObject.getDouble(key: String): Double? = this[key]?.jsonPrimitive?.doubleOrNull

fun JsonObject.getDoubleValue(key: String): Double = this[key]?.jsonPrimitive?.double!!

fun JsonObject.getString(key: String): String? = this[key]?.jsonPrimitive?.contentOrNull

fun JsonObject.getByPath(jsonPath: JsonPath): JsonElement = Json.parseToJsonElement(ONode.load(this).select(jsonPath.toString()).toJson())

fun JsonObject.getByPath(jsonPath: String): JsonElement = Json.parseToJsonElement(ONode.load(this).select(jsonPath).toJson())

fun JsonObject.toJsonString(vararg features: JsonFeature): String = Json.by(*features).encodeToString(this)

fun JsonObject.getJsonObject(key: String): JsonObject? = this[key]?.jsonObject

fun JsonObject.getJsonArray(key: String): JsonArray? = this[key]?.jsonArray

fun JsonObject.getJsonPrimitive(key: String): JsonPrimitive? = this[key]?.jsonPrimitive

fun JsonObject.modify(vararg modifications: Pair<String, JsonElement>): JsonObject {
    val mutableMap = this.toMutableMap()
    for ((key, value) in modifications) {
        mutableMap[key] = value
    }
    return JsonObject(mutableMap)
}

operator fun JsonObject.set(jsonPath: String, value: JsonElement): JsonObject =
    Json.parseToJsonElement(ONode.load(this).select(jsonPath).forEach { n -> n.`val`(value) }.toJson()).jsonObject

fun JsonObject.setOrNew(jsonPath: String, value: JsonElement): JsonObject =
    Json.parseToJsonElement(ONode.load(this).selectOrNew(jsonPath).`val`(value).toJson()).jsonObject

