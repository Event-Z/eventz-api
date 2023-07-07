package app.valenota

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ValenotaApplication {
	companion object {
		@JvmStatic
		fun main(args: Array<String>) {
			print("Teste caralhooo")
			//runApplication<ValenotaApplication>(*args)
		}
	}
}