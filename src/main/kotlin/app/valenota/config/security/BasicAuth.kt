package app.valenota.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
@EnableWebSecurity
class BasicAuth {
    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain? {
        http.authorizeHttpRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic()
            .and()
            .csrf()
            .ignoringRequestMatchers("/**")
        return http.build()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.allowedOrigins = listOf("*")
        corsConfiguration.allowedMethods = listOf("GET", "POST", "PATCH", "PUT", "DELETE", "OPTIONS", "HEAD")
        corsConfiguration.allowCredentials = true
        corsConfiguration.maxAge = 3600L
        corsConfiguration.exposedHeaders = listOf("X-Get-Header")
        corsConfiguration.allowedHeaders = listOf("Authorization", "Requestor-Type")
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", corsConfiguration)
        return source
    }
}