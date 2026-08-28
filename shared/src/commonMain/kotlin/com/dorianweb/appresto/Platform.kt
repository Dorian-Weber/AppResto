package com.dorianweb.appresto

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform