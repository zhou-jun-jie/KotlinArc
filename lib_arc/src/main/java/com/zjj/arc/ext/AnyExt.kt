package com.zjj.arc.ext

/**
 * user: zjj
 * date: 2023/6/2
 * desc: 扩展
 */
inline fun <reified T> Any.saveAs() :T {
    return this as T
}

@Suppress("UNCHECKED_CAST")
fun <T> Any.saveAsUnChecked() : T {
    return this as T
}