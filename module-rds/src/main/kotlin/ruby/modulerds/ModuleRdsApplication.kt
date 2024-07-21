package ruby.modulerds

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ModuleRdsApplication

fun main(args: Array<String>) {
    runApplication<ModuleRdsApplication>(*args)
}
