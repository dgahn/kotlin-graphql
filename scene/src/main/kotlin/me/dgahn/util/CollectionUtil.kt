package me.dgahn.util

inline fun <K, V, C> Map<K, V>.filterNotNull(condition: C?, predicate: (Map.Entry<K, V>) -> Boolean)
        : Map<K, V> = if (condition != null) {
    filterTo(LinkedHashMap(), predicate)
} else {
    this
}