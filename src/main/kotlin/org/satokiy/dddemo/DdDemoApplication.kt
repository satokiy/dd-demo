package org.satokiy.dddemo


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

@SpringBootApplication
@RestController
class DdDemoApplication {
    private val logger = LoggerFactory.getLogger(DdDemoApplication::class.java)

    data class HelloResponse(val message: String)

    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/hello/info"],
    )
    fun getHello(): ResponseEntity<HelloResponse> {
        logger.info("Hello Datadog Log!")
        return ResponseEntity(HelloResponse("Hello Datadog!"), HttpStatus.OK)
    }

    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/hello/error"],
    )
    fun getHelloError(): ResponseEntity<HelloResponse> {
        logger.error("Hello Datadog Error!")
        return ResponseEntity(HelloResponse("Hello Datadog Error!"), HttpStatus.OK)
    }

    @RequestMapping(
        method = [RequestMethod.GET],
        value = ["/hello/crash"],
    )
    fun getHelloCrash() {
        try {
            throw Exception("Something wrong happened.");
        } catch (e: Exception) {
            logger.error("an exception occurred", e)
            throw e
        }
    }

    @RequestMapping(
        method = [RequestMethod.POST],
        value = ["/hello"],
    )
    fun sayHello(): String {
        return "Hello World!"
    }
}

fun main(args: Array<String>) {
    runApplication<DdDemoApplication>(*args)
}
