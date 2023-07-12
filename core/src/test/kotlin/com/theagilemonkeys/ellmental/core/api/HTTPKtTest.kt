package com.theagilemonkeys.ellmental.core.api

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import kotlinx.serialization.Serializable
import org.http4k.client.JavaHttpClient
import org.http4k.core.Method
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK

class HTTPKtTest : BehaviorSpec({

    @Serializable
    data class Input(val value: String)

    /**
     * Class under test
     */
    class MockService {
        fun writeOp(name: String): String {
            return "Hello $name"
        }

        fun readOp(name: String): String {
            return "Goodbye $name"
        }

        fun writeOp2(input: Input): String {
            return "Hello ${input.value}"
        }

        fun readOp2(input: Input): String {
            return "Goodbye ${input.value}"
        }

        val api = MockService::class.apiDefinition {
            write("writeOp") { input: String ->
                writeOp(input)
            }

            read("readOp") { input: String ->
                readOp(input)
            }

            write("writeOp2") { input: Input ->
                writeOp2(input)
            }

            read("readOp2") { input: Input ->
                readOp2(input)
            }
        }

    }

    /**
     * Helper function to run a server perform a request, and assert on the response
     */
    fun withServiceCall(method: Method, route: String, body: String, block: (Response) -> Unit) {
        val server = MockService().api.toHttpApp().start()

        val client = JavaHttpClient()

        val uri = "http://localhost:${server.port()}/MockService/${route}".replace(
            "\"", "%22"
        )

        val request = Request(
            method, uri
        )
            .body(body)

        val response = client(request)

        try {
            block(response)
        } finally {
            server.stop()
        }

    }

    /**
     * Helper function over withServiceCall to run a write operation
     */
    fun withWriteOp(operation: String, body: String, block: (Response) -> Unit) {
        withServiceCall(Method.POST, operation, body, block)
    }

    /**
     * Helper function over withServiceCall to run a read operation
     */
    fun withReadOp(operation: String, body: String, block: (Response) -> Unit) {
        withServiceCall(Method.GET, "$operation?$body", "", block)
    }


    /**
     * The Actual Tests
     */
    Given("an API converted to an HTTP app ") {
        When("it is called with primitive types") {
            Then("it should run write operations on POST") {
                withWriteOp("writeOp", "\"1\"") { response ->
                    response.bodyString() shouldBe "\"Hello 1\""
                    response.status shouldBe OK
                }
            }

            Then("it should run read operations on GET") {
                withReadOp("readOp", "String=\"1\"") { response ->
                    response.bodyString() shouldBe "\"Goodbye 1\""
                    response.status shouldBe OK
                }
            }
        }

        When("it is called with data classes") {
            Then("it should work with write operations") {
                withWriteOp("writeOp2", "{\"value\":\"John\"}") { response ->
                    response.bodyString() shouldBe "\"Hello John\""
                    response.status shouldBe OK
                }
            }

            Then("it should work with read operations") {
                withReadOp("readOp2", "value=John") { response ->
                    response.bodyString() shouldBe "\"Goodbye John\""
                    response.status shouldBe OK
                }
            }
        }
    }


})

