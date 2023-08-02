"use strict";
(self["webpackChunkellmental"] = self["webpackChunkellmental"] || []).push([[5888],{

/***/ 3905:
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   Zo: () => (/* binding */ MDXProvider),
/* harmony export */   kt: () => (/* binding */ createElement)
/* harmony export */ });
/* unused harmony exports MDXContext, useMDXComponents, withMDXComponents */
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(7294);


function _defineProperty(obj, key, value) {
  if (key in obj) {
    Object.defineProperty(obj, key, {
      value: value,
      enumerable: true,
      configurable: true,
      writable: true
    });
  } else {
    obj[key] = value;
  }

  return obj;
}

function _extends() {
  _extends = Object.assign || function (target) {
    for (var i = 1; i < arguments.length; i++) {
      var source = arguments[i];

      for (var key in source) {
        if (Object.prototype.hasOwnProperty.call(source, key)) {
          target[key] = source[key];
        }
      }
    }

    return target;
  };

  return _extends.apply(this, arguments);
}

function ownKeys(object, enumerableOnly) {
  var keys = Object.keys(object);

  if (Object.getOwnPropertySymbols) {
    var symbols = Object.getOwnPropertySymbols(object);
    if (enumerableOnly) symbols = symbols.filter(function (sym) {
      return Object.getOwnPropertyDescriptor(object, sym).enumerable;
    });
    keys.push.apply(keys, symbols);
  }

  return keys;
}

function _objectSpread2(target) {
  for (var i = 1; i < arguments.length; i++) {
    var source = arguments[i] != null ? arguments[i] : {};

    if (i % 2) {
      ownKeys(Object(source), true).forEach(function (key) {
        _defineProperty(target, key, source[key]);
      });
    } else if (Object.getOwnPropertyDescriptors) {
      Object.defineProperties(target, Object.getOwnPropertyDescriptors(source));
    } else {
      ownKeys(Object(source)).forEach(function (key) {
        Object.defineProperty(target, key, Object.getOwnPropertyDescriptor(source, key));
      });
    }
  }

  return target;
}

function _objectWithoutPropertiesLoose(source, excluded) {
  if (source == null) return {};
  var target = {};
  var sourceKeys = Object.keys(source);
  var key, i;

  for (i = 0; i < sourceKeys.length; i++) {
    key = sourceKeys[i];
    if (excluded.indexOf(key) >= 0) continue;
    target[key] = source[key];
  }

  return target;
}

function _objectWithoutProperties(source, excluded) {
  if (source == null) return {};

  var target = _objectWithoutPropertiesLoose(source, excluded);

  var key, i;

  if (Object.getOwnPropertySymbols) {
    var sourceSymbolKeys = Object.getOwnPropertySymbols(source);

    for (i = 0; i < sourceSymbolKeys.length; i++) {
      key = sourceSymbolKeys[i];
      if (excluded.indexOf(key) >= 0) continue;
      if (!Object.prototype.propertyIsEnumerable.call(source, key)) continue;
      target[key] = source[key];
    }
  }

  return target;
}

var isFunction = function isFunction(obj) {
  return typeof obj === 'function';
};

var MDXContext = /*#__PURE__*/react__WEBPACK_IMPORTED_MODULE_0__.createContext({});
var withMDXComponents = function withMDXComponents(Component) {
  return function (props) {
    var allComponents = useMDXComponents(props.components);
    return /*#__PURE__*/React.createElement(Component, _extends({}, props, {
      components: allComponents
    }));
  };
};
var useMDXComponents = function useMDXComponents(components) {
  var contextComponents = react__WEBPACK_IMPORTED_MODULE_0__.useContext(MDXContext);
  var allComponents = contextComponents;

  if (components) {
    allComponents = isFunction(components) ? components(contextComponents) : _objectSpread2(_objectSpread2({}, contextComponents), components);
  }

  return allComponents;
};
var MDXProvider = function MDXProvider(props) {
  var allComponents = useMDXComponents(props.components);
  return /*#__PURE__*/react__WEBPACK_IMPORTED_MODULE_0__.createElement(MDXContext.Provider, {
    value: allComponents
  }, props.children);
};

var TYPE_PROP_NAME = 'mdxType';
var DEFAULTS = {
  inlineCode: 'code',
  wrapper: function wrapper(_ref) {
    var children = _ref.children;
    return /*#__PURE__*/react__WEBPACK_IMPORTED_MODULE_0__.createElement(react__WEBPACK_IMPORTED_MODULE_0__.Fragment, {}, children);
  }
};
var MDXCreateElement = /*#__PURE__*/react__WEBPACK_IMPORTED_MODULE_0__.forwardRef(function (props, ref) {
  var propComponents = props.components,
      mdxType = props.mdxType,
      originalType = props.originalType,
      parentName = props.parentName,
      etc = _objectWithoutProperties(props, ["components", "mdxType", "originalType", "parentName"]);

  var components = useMDXComponents(propComponents);
  var type = mdxType;
  var Component = components["".concat(parentName, ".").concat(type)] || components[type] || DEFAULTS[type] || originalType;

  if (propComponents) {
    return /*#__PURE__*/react__WEBPACK_IMPORTED_MODULE_0__.createElement(Component, _objectSpread2(_objectSpread2({
      ref: ref
    }, etc), {}, {
      components: propComponents
    }));
  }

  return /*#__PURE__*/react__WEBPACK_IMPORTED_MODULE_0__.createElement(Component, _objectSpread2({
    ref: ref
  }, etc));
});
MDXCreateElement.displayName = 'MDXCreateElement';
function createElement (type, props) {
  var args = arguments;
  var mdxType = props && props.mdxType;

  if (typeof type === 'string' || mdxType) {
    var argsLength = args.length;
    var createElementArgArray = new Array(argsLength);
    createElementArgArray[0] = MDXCreateElement;
    var newProps = {};

    for (var key in props) {
      if (hasOwnProperty.call(props, key)) {
        newProps[key] = props[key];
      }
    }

    newProps.originalType = type;
    newProps[TYPE_PROP_NAME] = typeof type === 'string' ? type : mdxType;
    createElementArgArray[1] = newProps;

    for (var i = 2; i < argsLength; i++) {
      createElementArgArray[i] = args[i];
    }

    return react__WEBPACK_IMPORTED_MODULE_0__.createElement.apply(null, createElementArgArray);
  }

  return react__WEBPACK_IMPORTED_MODULE_0__.createElement.apply(null, args);
}




/***/ }),

/***/ 9966:
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

__webpack_require__.r(__webpack_exports__);
/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   assets: () => (/* binding */ assets),
/* harmony export */   contentTitle: () => (/* binding */ contentTitle),
/* harmony export */   "default": () => (/* binding */ MDXContent),
/* harmony export */   frontMatter: () => (/* binding */ frontMatter),
/* harmony export */   metadata: () => (/* binding */ metadata),
/* harmony export */   toc: () => (/* binding */ toc)
/* harmony export */ });
/* harmony import */ var _home_runner_work_eLLMental_eLLMental_website_node_modules_babel_runtime_helpers_esm_extends_js__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(7462);
/* harmony import */ var react__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(7294);
/* harmony import */ var _mdx_js_react__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(3905);
/* @jsxRuntime classic */ /* @jsx mdx */ /* @jsxFrag React.Fragment */const frontMatter={};const contentTitle='Getting started';const metadata={"unversionedId":"getting_started","id":"getting_started","title":"Getting started","description":"eLLMental is a toolset for building AI-powered applications written in Kotlin, and it offers a variety of components","source":"@site/docs/02_getting_started.md","sourceDirName":".","slug":"/getting_started","permalink":"/getting_started","draft":false,"tags":[],"version":"current","lastUpdatedBy":"Adrián Lorenzo","lastUpdatedAt":1690966526,"formattedLastUpdatedAt":"Aug 2, 2023","sidebarPosition":2,"frontMatter":{},"sidebar":"docs","previous":{"title":"Introduction","permalink":"/"},"next":{"title":"Components","permalink":"/Components"}};const assets={};const toc=[{value:'Step 0: Create a new Kotlin application project',id:'step-0-create-a-new-kotlin-application-project',level:2},{value:'Step 1: Add the eLLMental dependencies using JitPack',id:'step-1-add-the-ellmental-dependencies-using-jitpack',level:2},{value:'Step 2: Creating the Note class',id:'step-2-creating-the-note-class',level:2},{value:'Step 3: Initializing the SemanticSearch component',id:'step-3-initializing-the-semanticsearch-component',level:2},{value:'Step 4: Implementing the <code>learn</code> and <code>search</code> features',id:'step-4-implementing-the-learn-and-search-features',level:2},{value:'Step 5: Creating a main function',id:'step-5-creating-a-main-function',level:2},{value:'Step 6: Running the application',id:'step-6-running-the-application',level:2},{value:'Additional sample code',id:'additional-sample-code',level:2}];const layoutProps={toc};const MDXLayout="wrapper";function MDXContent(_ref){let{components,...props}=_ref;return (0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)(MDXLayout,(0,_home_runner_work_eLLMental_eLLMental_website_node_modules_babel_runtime_helpers_esm_extends_js__WEBPACK_IMPORTED_MODULE_2__/* ["default"] */ .Z)({},layoutProps,props,{components:components,mdxType:"MDXLayout"}),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("h1",{"id":"getting-started"},`Getting started`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("p",null,`eLLMental is a toolset for building AI-powered applications written in Kotlin, and it offers a variety of components
that you can use right away. In this guide, we will guide you through an example of how to use
the `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("a",{parentName:"p","href":"/api_docs/ellmental/com.theagilemonkeys.ellmental.semanticsearch/"},`SemanticSearch component`),` to build an
intelligent note taking application for the terminal that learns from your notes and is able to find
relevant notes based on a query.`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("h2",{"id":"step-0-create-a-new-kotlin-application-project"},`Step 0: Create a new Kotlin application project`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("p",null,`This can be done using your preferred way of Kotlin project initialization. If you're using IntelliJ IDEA,
you can follow the steps below:`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("ol",null,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("li",{parentName:"ol"},`Open IntelliJ IDEA and click on `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"li"},`Create New Project`),`.`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("li",{parentName:"ol"},`Select `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"li"},`New Project`),` in the left panel and then select `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"li"},`Kotlin`),` and `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"li"},`Gradle`),` in the right panel. Choose `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"li"},`Kotlin`),` as
the Build DSL.`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("li",{parentName:"ol"},`Click `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"li"},`Create`),` and then enter the project name and location.`)),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("h2",{"id":"step-1-add-the-ellmental-dependencies-using-jitpack"},`Step 1: Add the eLLMental dependencies using `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("a",{parentName:"h2","href":"https://jitpack.io"},`JitPack`)),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("p",null,`Import the eLLMental dependencies in your `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`build.gradle.kts`),` file.`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("p",null,`You can use this one as a starting point:`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("pre",null,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("code",{parentName:"pre","className":"language-kotlin"},`import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm") version "1.9.0"
  application
}

group = "com.theagilemonkeys"

version = "1.0-SNAPSHOT"

allprojects { repositories { maven { url = uri("https://jitpack.io") } } }

repositories { mavenCentral() }

dependencies {
  implementation("com.github.theam.ellmental:core:main-SNAPSHOT")
  implementation("com.github.theam.ellmental:semanticsearch:main-SNAPSHOT")
  implementation("com.github.theam.ellmental:vectorstore:main-SNAPSHOT")
  implementation("com.github.theam.ellmental:embeddingsmodel:main-SNAPSHOT")
  implementation("com.aallam.openai:openai-client:3.3.0")
  testImplementation(kotlin("test"))
}

tasks.test { useJUnitPlatform() }

tasks.withType<KotlinCompile> { kotlinOptions.jvmTarget = "17" }

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions { freeCompilerArgs = freeCompilerArgs + "-Xcontext-receivers" }
}

tasks.named<JavaExec>("run") { standardInput = System.\`in\` }

application { mainClass.set("MainKt") }
`)),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("h2",{"id":"step-2-creating-the-note-class"},`Step 2: Creating the Note class`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("p",null,`Let's create a `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`Note`),` class. This class will have two
properties: `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`id`),` type `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`Int`),` for the note identifier and `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`content`),` type `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`String`),` for the note content.`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("pre",null,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("code",{parentName:"pre","className":"language-kotlin"},`data class Note(
    val id: Int,
    val content: String
)
`)),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("h2",{"id":"step-3-initializing-the-semanticsearch-component"},`Step 3: Initializing the SemanticSearch component`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("p",null,`Before initializing the `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`SemanticSearch`),` component, we need to set up the `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`OpenAIEmbeddingsModel`),`
and `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`PineconeVectorStore`),`, which are two key components required by `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`SemanticSearch`),`.`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("p",null,`You can initialize these components in their own function, so you can do stuff like loading the
tokens from your environment variables.`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("p",null,`You can follow both the `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("a",{parentName:"p","href":"https://docs.pinecone.io/docs/quickstart"},`PineCone quickstart guide`),` as well
as the `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("a",{parentName:"p","href":"https://platform.openai.com/docs/guides/production-best-practices/api-keys"},`OpenAI API keys guide`),` to get the required tokens.`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("pre",null,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("code",{parentName:"pre","className":"language-kotlin"},`import com.aallam.openai.client.OpenAI
import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIEmbeddingsModel
import com.theagilemonkeys.ellmental.vectorstore.pinecone.PineconeVectorStore

fun embeddingsModel(): OpenAIEmbeddingsModel {
    val openaiToken = System.getenv("OPEN_AI_API_KEY")
    check(openaiToken != null) { "OPEN_AI_API_KEY environment variable is not set" }
    with(OpenAI(token = openaiToken)) {
        return OpenAIEmbeddingsModel()
    }
}

fun vectorStore(): PineconeVectorStore {
    val pineconeToken = System.getenv("PINECONE_API_KEY")
    check (pineconeToken != null) { "PINECONE_API_KEY environment variable is not set" }
    val pineconeUrl = System.getenv("PINECONE_URL")
    check (pineconeUrl != null) { "PINECONE_URL environment variable is not set" }
    return PineconeVectorStore(apiKey = pineconeToken, url = pineconeUrl)
}
`)),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("p",null,`Next, we will do the same for initializing the `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`SemanticSearch`),` instance. Import the `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`SemanticSearch`),` component
from eLLMental and create an instance using the functions you created above.`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("pre",null,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("code",{parentName:"pre","className":"language-kotlin"},`import com.theagilemonkeys.ellmental.embeddingsmodel.openai.OpenAIEmbeddingsModel
import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch
import com.theagilemonkeys.ellmental.vectorstore.pinecone.PineconeVectorStore


fun semanticSearch(): SemanticSearch {
    val embeddingsModel = embeddingsModel()
    val vectorStore = vectorStore()
    with(embeddingsModel) {
        with(vectorStore) {
            return SemanticSearch()
        }
    }
}
`)),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("h2",{"id":"step-4-implementing-the-learn-and-search-features"},`Step 4: Implementing the `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"h2"},`learn`),` and `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"h2"},`search`),` features`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("p",null,`Let's implement the `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`learn`),` and `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`search`),` features to add new notes into the `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`SemanticSearch`),` index and find them
later.`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("pre",null,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("code",{parentName:"pre","className":"language-kotlin"},`import com.theagilemonkeys.ellmental.semanticsearch.SemanticSearch

suspend fun learn(semanticSearch: SemanticSearch, note: Note) {
    semanticSearch.learn(SearchInput(listOf(note.content)))
}

suspend fun search(semanticSearch: SemanticSearch, query: String): List<String> {
    semanticSearch.search(query).entries.map {
        // Here entries can be mapped to your corresponding data models based on the returned \`SemanticEntry\` object
        // we just gonna return the id
        it.id.value
    }
}
`)),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("h2",{"id":"step-5-creating-a-main-function"},`Step 5: Creating a main function`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("p",null,`The only thing that's missing now is an application loop. Let's implement so in the `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`main`),` function.`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("pre",null,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("code",{parentName:"pre","className":"language-kotlin"},`fun main() = runBlocking {
    val semanticSearch = semanticSearch()
    println("Available commands: learn, search, quit\\n")
    var shouldQuit = false
    while (!shouldQuit) {
        print("> ")
        when (readln()) {
            "help" -> {
                println("Available commands: learn, search, quit")
            }
            "learn" -> {
                println("Enter note content:")
                val txt = readln()
                val note = Note(
                  id = 1,
                  content = txt
                )
                learn(semanticSearch, note)
            }
            "search" -> {
                println("Enter query:")
                val query = readln()
                val results = search(semanticSearch, query)
                println(results)
            }
            "quit" -> {
                println("Bye!")
                shouldQuit = true
            }
            else -> {
                println("Invalid command")
            }
        }
    }
}
`)),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("h2",{"id":"step-6-running-the-application"},`Step 6: Running the application`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("p",null,`Now you can run your application either from the IDE run button or from the command line using `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`./gradlew run`),`.`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("pre",null,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("code",{parentName:"pre","className":"language-text"},`Available commands: learn, search, quit
> learn

Enter note content:
This is a note about eLLMental, an open source library for building intelligent applications.

> search

Enter query:
eLLMental
[This is a note about eLLMental, an open source library for building intelligent applications.]

> quit
Bye!
`)),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("p",null,`This is how you can use the `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`SemanticSearch`),` component from eLLMental to build an intelligent note taking application
backend that learns from your notes and is able to find relevant notes based on a query.`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("p",null,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("a",{parentName:"p","href":"https://github.com/theam/ellmental-cli-notes-example"},`Here is a link to the repository`),` that contains this entire example.`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("p",null,`Wanna learn more? Read the `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("a",{parentName:"p","href":"/Components"},`Components`),`
page to discover the different components available in eLLMental, together with their thorough usage, and if you have
any question,
you are very welcome at the `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("a",{parentName:"p","href":"https://discord.gg/34cBbvjjAx"},`community Discord server`),`!`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("h2",{"id":"additional-sample-code"},`Additional sample code`),(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("p",null,`In addition to this guide, you can find a simpler sample application that exposes the `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("inlineCode",{parentName:"p"},`SemanticSearch`),` component from
eLLMental as a REST API in
the `,(0,_mdx_js_react__WEBPACK_IMPORTED_MODULE_1__/* .mdx */ .kt)("a",{parentName:"p","href":"https://github.com/theam/eLLMental/tree/main/examples/semanticsearchservicedemo"},`eLLMental Examples repository`),`.`));};MDXContent.isMDXComponent=true;

/***/ })

}]);