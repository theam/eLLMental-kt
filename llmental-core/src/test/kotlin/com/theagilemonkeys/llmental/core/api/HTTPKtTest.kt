package com.theagilemonkeys.llmental.core.api

import com.theagilemonkeys.llmental.core.handler.handler
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import kotlinx.serialization.Serializable
import org.http4k.client.JavaHttpClient
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Status.Companion.OK

class HTTPKtTest : BehaviorSpec({

    Given("an API converted to an HTTP app ") {
        When("it is called with primitive types") {
            Then("it should run write operations on POST") {

                val greet = handler("greet") { input: Int ->
                    "Hello ${input}"
                }

                val greetApi = api("GreetingService") {
                    write(greet)
                }

                val server = greetApi.toHttpApp().start()

                val client = JavaHttpClient()

                val request = Request(
                    Method.POST, "http://localhost:${server.port()}/greet"
                )
                    .body("1")

                val response = client(request)

                response.status shouldBe OK
                response.bodyString() shouldBe "\"Hello 1\""

                server.stop()

            }

            Then("it should run read operations on GET") {

                val greet = handler("greet") { input: Int ->
                    "Hello ${input}"
                }

                val greetApi = api("GreetingService") {
                    read(greet)
                }

                val server = greetApi.toHttpApp().start()

                val client = JavaHttpClient()

                val request = Request(
                    Method.GET, "http://localhost:${server.port()}/greet?Int=1"
                )

                val response = client(request)

                response.status shouldBe OK
                response.bodyString() shouldBe "\"Hello 1\""

                server.stop()
            }
        }
        When("it is called with data classes") {
            Then("it should work with write operations") {

                @Serializable
                data class GreetInput(val name: String)

                val greet = handler("greet") { input: GreetInput ->
                    "Hello ${input.name}"
                }

                val greetApi = api("GreetingService") {
                    write(greet)
                }

                val server = greetApi.toHttpApp().start()

                val client = JavaHttpClient()

                val request = Request(
                    Method.POST, "http://localhost:${server.port()}/greet"
                )
                    .body("{\"name\":\"John\"}")

                val response = client(request)

                response.status shouldBe OK
                response.bodyString() shouldBe "\"Hello John\""

                server.stop()

            }

            Then("it should work with read operations") {

                @Serializable
                data class GreetInput(val name: String)

                val greet = handler("greet") { input: GreetInput ->
                    "Hello ${input.name}"
                }

                val greetApi = api("GreetingService") {
                    read(greet)
                }

                val server = greetApi.toHttpApp().start()

                val client = JavaHttpClient()

                val request = Request(
                    Method.GET, "http://localhost:${server.port()}/greet?name=John"
                )

                val response = client(request)

                response.status shouldBe OK
                response.bodyString() shouldBe "\"Hello John\""

                server.stop()
            }
        }
    }

})
