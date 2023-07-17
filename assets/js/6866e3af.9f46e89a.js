"use strict";(self.webpackChunkellmental=self.webpackChunkellmental||[]).push([[888],{3905:(e,t,n)=>{n.d(t,{Zo:()=>c,kt:()=>h});var a=n(7294);function r(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function o(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);t&&(a=a.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,a)}return n}function i(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?o(Object(n),!0).forEach((function(t){r(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):o(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function l(e,t){if(null==e)return{};var n,a,r=function(e,t){if(null==e)return{};var n,a,r={},o=Object.keys(e);for(a=0;a<o.length;a++)n=o[a],t.indexOf(n)>=0||(r[n]=e[n]);return r}(e,t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(e);for(a=0;a<o.length;a++)n=o[a],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(r[n]=e[n])}return r}var s=a.createContext({}),p=function(e){var t=a.useContext(s),n=t;return e&&(n="function"==typeof e?e(t):i(i({},t),e)),n},c=function(e){var t=p(e.components);return a.createElement(s.Provider,{value:t},e.children)},m="mdxType",d={inlineCode:"code",wrapper:function(e){var t=e.children;return a.createElement(a.Fragment,{},t)}},u=a.forwardRef((function(e,t){var n=e.components,r=e.mdxType,o=e.originalType,s=e.parentName,c=l(e,["components","mdxType","originalType","parentName"]),m=p(n),u=r,h=m["".concat(s,".").concat(u)]||m[u]||d[u]||o;return n?a.createElement(h,i(i({ref:t},c),{},{components:n})):a.createElement(h,i({ref:t},c))}));function h(e,t){var n=arguments,r=t&&t.mdxType;if("string"==typeof e||r){var o=n.length,i=new Array(o);i[0]=u;var l={};for(var s in t)hasOwnProperty.call(t,s)&&(l[s]=t[s]);l.originalType=e,l[m]="string"==typeof e?e:r,i[1]=l;for(var p=2;p<o;p++)i[p]=n[p];return a.createElement.apply(null,i)}return a.createElement.apply(null,n)}u.displayName="MDXCreateElement"},9966:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>s,contentTitle:()=>i,default:()=>d,frontMatter:()=>o,metadata:()=>l,toc:()=>p});var a=n(7462),r=(n(7294),n(3905));const o={},i="Getting started",l={unversionedId:"getting_started",id:"getting_started",title:"Getting started",description:"The main package eLLMental offers is called ellmental-core. In this package, we provide an API implementation for your",source:"@site/docs/02_getting_started.md",sourceDirName:".",slug:"/getting_started",permalink:"/getting_started",draft:!1,tags:[],version:"current",lastUpdatedBy:"Nick Tchayka",lastUpdatedAt:1689610458,formattedLastUpdatedAt:"Jul 17, 2023",sidebarPosition:2,frontMatter:{},sidebar:"docs",previous:{title:"Introduction",permalink:"/"},next:{title:"AWS Elastic Beanstalk",permalink:"/deployments/aws"}},s={},p=[{value:"\ud83e\udde9 Modules",id:"-modules",level:2},{value:"Creating a semantic index",id:"creating-a-semantic-index",level:2},{value:"Creating your own module",id:"creating-your-own-module",level:2}],c={toc:p},m="wrapper";function d(e){let{components:t,...n}=e;return(0,r.kt)(m,(0,a.Z)({},c,n,{components:t,mdxType:"MDXLayout"}),(0,r.kt)("h1",{id:"getting-started"},"Getting started"),(0,r.kt)("p",null,"The main package eLLMental offers is called ",(0,r.kt)("inlineCode",{parentName:"p"},"ellmental-core"),". In this package, we provide an API implementation for your\nAI applications. This API currently supports two kinds of operations: write, and read. These two kinds of operations\ncan be easily mapped to any kind of API protocol. By default, we offer a REST-style HTTP mapping, but you can easily\nmap it to GraphQL or gRPC."),(0,r.kt)("blockquote",null,(0,r.kt)("p",{parentName:"blockquote"},(0,r.kt)("inlineCode",{parentName:"p"},"ellmental-core")," is built using Kotlin with JVM 17 and using gradle as our package manager.")),(0,r.kt)("h2",{id:"-modules"},"\ud83e\udde9 Modules"),(0,r.kt)("p",null,"The eLLMental project also implements three different AI modules:"),(0,r.kt)("ol",null,(0,r.kt)("li",{parentName:"ol"},(0,r.kt)("strong",{parentName:"li"},"A vector store:")," Database or repository used to house and handle vector representations of words or phrases, known\nas embeddings. eLLMental implements different databases that support vector columns, like Pinecone or Supabase."),(0,r.kt)("li",{parentName:"ol"},(0,r.kt)("strong",{parentName:"li"},"Embedding generator:")," The service that is responsible for converting raw text data into representative numerical\nvectors, also known as embeddings."),(0,r.kt)("li",{parentName:"ol"},(0,r.kt)("strong",{parentName:"li"},"Semantic search module:")," To search similarities in the vector store.\nUsing ",(0,r.kt)("a",{parentName:"li",href:"https://en.wikipedia.org/wiki/Cosine_similarity"},"cosine similarity"),", which measures the cosine of the angle\nbetween two vectors. The vectors that are close to each other (having a smaller angle between them)\nindicate more similar content.")),(0,r.kt)("blockquote",null,(0,r.kt)("p",{parentName:"blockquote"},"An example of how these modules are used can be found in the ",(0,r.kt)("inlineCode",{parentName:"p"},"semantic-search-service-demo")," project.")),(0,r.kt)("h2",{id:"creating-a-semantic-index"},"Creating a semantic index"),(0,r.kt)("p",null,"In the case that you want to create your own semantic index, we recommend you to follow the guidelines below. Anyways\nyou can always see an example app in the ",(0,r.kt)("a",{parentName:"p",href:"https://github.com/theam/eLLMental/tree/main/semantic-search-service-demo"},"semantic search demo")," from\nthe repo."),(0,r.kt)("p",null,"First, you'll need to implement the ",(0,r.kt)("inlineCode",{parentName:"p"},"API.kt")," module from ",(0,r.kt)("inlineCode",{parentName:"p"},"ellmental-core"),". This includes two main operations: ",(0,r.kt)("inlineCode",{parentName:"p"},"read")," and ",(0,r.kt)("inlineCode",{parentName:"p"},"write"),"."),(0,r.kt)("p",null,"Second, you'll have to select the embedding's model you want to use. If you want to use the implementations we provide, you\ncan use the ones in the ",(0,r.kt)("inlineCode",{parentName:"p"},"embeddings-model")," module."),(0,r.kt)("p",null,"Third, you'll need your implementation to call the Vector store you'd want to use. Existing vector stores implementation are present in\nthe ",(0,r.kt)("inlineCode",{parentName:"p"},"vector-store")," module."),(0,r.kt)("p",null,"Finally, you'll need to put everything together in the Semantic Search module. Here's an example with also the ",(0,r.kt)("inlineCode",{parentName:"p"},"Main.kt")," file:"),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-kotlin"},'// Semantic search module\nfun default(): SemanticSearch =\n            with(OpenAIEmbeddingsModel("API KEY")) {\n                with(PineconeVectorStore()) {\n                    with(SemanticSearch()) {\n                        this\n                    }\n                }\n            }\n\n')),(0,r.kt)("pre",null,(0,r.kt)("code",{parentName:"pre",className:"language-Main.kt"},"SemanticSearch.default().api.runHttp(port = 8080)\n")),(0,r.kt)("p",null,"After that, you can run ",(0,r.kt)("inlineCode",{parentName:"p"},"./gradlew :<your_service>:run")," to serve your API."),(0,r.kt)("h2",{id:"creating-your-own-module"},"Creating your own module"),(0,r.kt)("p",null,"If you plan to create a different package or module using Kotlin (like ",(0,r.kt)("inlineCode",{parentName:"p"},"llmental-core"),"), you can duplicate the ",(0,r.kt)("inlineCode",{parentName:"p"},".kotlin-template"),"\nfolder and rename it to your package name. After that, you'll have to add the package name to the ",(0,r.kt)("inlineCode",{parentName:"p"},"settings.gradle.kts"),"\nfile, in the ",(0,r.kt)("inlineCode",{parentName:"p"},"includes")," list. This way we will keep the same structure for all of them."))}d.isMDXComponent=!0}}]);