package org.theagilemonkeys.llmental.api

import io.ktor.http.*
import io.ktor.serialization.jackson.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::semanticSearchApp).start(wait = true)
}

fun Application.semanticSearchApp() {
    install(ContentNegotiation) {
        jackson { }
    }
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respond(HttpStatusCode.InternalServerError, cause.message ?: "Unknown error")
        }
    }
    routing {
        route("/api") {
            post("/learn") {
                val entry = call.receive<SemanticEntry>()
                call.respond(HttpStatusCode.OK, "Learn called with ${entry.text}")
            }
            get("/search") {
                val text = call.parameters["text"]
                call.respond(HttpStatusCode.OK, "Search called with $text")
            }
        }
    }
}
