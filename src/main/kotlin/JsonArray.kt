/**
 * As extended function with [JsonArray],
 * any getSomething function will return the value or a null,
 * but if you use the getSomethingValue function, it will return the value or an exception
 */

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.*

fun JsonArray.getInt(index: Int): Int? = this[index].jsonPrimitive.intOrNull

fun JsonArray.getIntValue(index: Int): Int = this[index].jsonPrimitive.int

fun JsonArray.getLong(index: Int): Long? = this[index].jsonPrimitive.longOrNull

fun JsonArray.getLongValue(index: Int): Long = this[index].jsonPrimitive.long

fun JsonArray.getBoolean(index: Int): Boolean? = this[index].jsonPrimitive.booleanOrNull

fun JsonArray.getBooleanValue(index: Int): Boolean = this[index].jsonPrimitive.boolean

fun JsonArray.getFloat(index: Int): Float? = this[index].jsonPrimitive.floatOrNull

fun JsonArray.getFloatValue(index: Int): Float = this[index].jsonPrimitive.float

fun JsonArray.getDouble(index: Int): Double? = this[index].jsonPrimitive.doubleOrNull

fun JsonArray.getDoubleValue(index: Int): Double = this[index].jsonPrimitive.double

fun JsonArray.getString(index: Int): String? = this[index].jsonPrimitive.contentOrNull

fun JsonArray.toJsonString(vararg features: JsonFeature): String = Json.by(*features).encodeToString(this)

fun JsonArray.getJsonObject(index: Int): JsonObject = this[index].jsonObject

fun JsonArray.getJsonPrimitive(index: Int): JsonPrimitive = this[index].jsonPrimitive

fun JsonArray.modify(vararg modifications: Pair<Int, JsonElement>): JsonArray {
    val mutableList = this.toMutableList()
    for ((index, value) in modifications) {
        mutableList[index] = value
    }
    return JsonArray(mutableList)
}

fun JsonArray.addFirst(vararg elements: JsonElement): JsonArray {
    val mutableList = mutableListOf<JsonElement>()
    mutableList.addAll(elements)
    mutableList.addAll(this)
    return JsonArray(mutableList)
}

fun JsonArray.addLast(vararg elements: JsonElement): JsonArray {
    val mutableList = mutableListOf<JsonElement>()
    mutableList.addAll(this)
    mutableList.addAll(elements)
    return JsonArray(mutableList)
}