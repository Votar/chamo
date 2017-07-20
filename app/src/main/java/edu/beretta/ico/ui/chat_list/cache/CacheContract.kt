package edu.beretta.ico.ui.chat_list.cache


interface CacheContract<T : Any> {
    fun isCached(): Boolean
    fun isExpired(): Boolean
    fun get(): T
    fun put(dataset: T)
}