package app.valenota

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ValenotaApplication {
	fun main(args: Array<String>) {
		runApplication<ValenotaApplication>(*args)
	}
}