package ruby.moduleapi

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = [
    "ruby.modulerds",                   // Repository 계층
    "ruby.moduledomainvendor",          // Service 계층
    "ruby.modulevendorlookup",          // Service 계층
    "ruby.moduleapi"                    // Controller 계층
])
class ModuleApiApplication

fun main(args: Array<String>) {
    runApplication<ModuleApiApplication>(*args)
}

fun <T : Any> T.logger(): Logger {
    return LoggerFactory.getLogger(this::class.java)
}