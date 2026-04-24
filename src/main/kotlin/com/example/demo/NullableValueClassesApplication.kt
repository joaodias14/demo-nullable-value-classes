package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class NullableValueClassesApplication

fun main(args: Array<String>) {
    runApplication<NullableValueClassesApplication>(*args)
}

@RestController
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class ExampleController {
    @GetMapping("/nullable-value-classes")
    @ResponseStatus(HttpStatus.OK)
    fun testValueClasses(
        @RequestParam(required = true) nonNullableValueClass: ValueClass,
        @RequestParam(required = false) nullableValueClass: ValueClass? = null,
    ) = "$nonNullableValueClass / $nullableValueClass"
}

@JvmInline
value class ValueClass(
    val value: String,
)
