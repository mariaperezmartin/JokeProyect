package com.alvarogm.apisremotas.data
/*data class JokeClass(
    val amount: Int,
    val error: Boolean,
    val jokes: List<Joke>
)

data class Joke(
    val category: String,
    val delivery: String,
    val flags: Flags,
    val id: Int,
    val joke: String,
    val lang: String,
    val safe: Boolean,
    val setup: String,
    val type: String
)

data class Flags(
    val explicit: Boolean,
    val nsfw: Boolean,
    val political: Boolean,
    val racist: Boolean,
    val religious: Boolean,
    val sexist: Boolean
)*/

data class JokeClass(
    val category: String,
    val delivery: String,//twopart
    val flags: Flags,
    val id: Int,
    val joke: String,//simple
    val jokes: List<JokeClass>,
    val lang: String,
    val safe: Boolean,
    val setup: String,
    val type: String,
    val isLocal: Boolean
)

data class Joke(
    val category: String,
    val delivery: String,
    val flags: Flags,
    val id: Int,
    val joke: String,
    val lang: String,
    val safe: Boolean,
    val setup: String,
    val type: String
)

data class Flags(
    val explicit: Boolean,
    val nsfw: Boolean,
    val political: Boolean,
    val racist: Boolean,
    val religious: Boolean,
    val sexist: Boolean
)



