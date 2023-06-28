package com.theagilemonkeys.llmental.semanticsearch

import com.theagilemonkeys.llmental.core.handler.handler

val learn = handler("learn") { entry: SemanticEntry ->
    /*
      Figure out how to declare "abstract" handlers that are implemented later on
      and can be configured later on, at the top level execution of the service.

      Ideally, one could declare a handler like this:

        val store = abstractHandler("store")

      And then in the code one would use it directly like

        val learn = handler("learn") { entry: SemanticEntry ->
            store(entry.text)
            entry.text
        }

      Then, at the top level, one would use the appropriate implementation:

        val actualStore = handler("store") { text: String ->
            // store the text
        }

        val initializedLearn = learn.with(actualStore)
        initializedLearn(entry)

      Maybe we could setup a pattern that makes handlers to be returned by functions
      that have to be initialized with some context, we can copy React on that.
      With that approach we could use Context Receivers to pass the concrete implementation like:

        interface EmbeddingStore {
          val store: Handler<String, Unit>
        }

        context(EmbeddingStore)
        fun useLearn() = handler("learn") { entry: SemanticEntry ->
            store(entry.text)    // now store is available in the context of `learn`
            entry.text
        }

      And at the top level we provide the interface implementation like this:

        class EmbStoreImpl : EmbeddingStore {
            override val store = handler("store") { text: String ->
                // store the text
            }
        }

      Now when the user writes their top level app, they can have the dependencies
      explicitly stated like this:

        context(SemanticSearch, EmbeddingStore)
        fun useMyAppMain() = handler("MyAppMain") { input: String ->
            val learn = useLearn()
            learn(entry)
        }

      And then, the main function would look like this:

        fun main() =
            with(EmbStoreImpl, SemanticSearchImpl) {
                val myAppMain = useMyAppMain()
                myAppMain.run()
            }
        }

     */
    entry.text
}

val search = handler("search") { entry: SemanticEntry ->
    entry.text
}

