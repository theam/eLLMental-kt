"use strict";(self.webpackChunkellmental=self.webpackChunkellmental||[]).push([[941],{3905:(e,t,n)=>{n.d(t,{Zo:()=>u,kt:()=>h});var a=n(7294);function i(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function o(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var a=Object.getOwnPropertySymbols(e);t&&(a=a.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,a)}return n}function r(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?o(Object(n),!0).forEach((function(t){i(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):o(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function l(e,t){if(null==e)return{};var n,a,i=function(e,t){if(null==e)return{};var n,a,i={},o=Object.keys(e);for(a=0;a<o.length;a++)n=o[a],t.indexOf(n)>=0||(i[n]=e[n]);return i}(e,t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(e);for(a=0;a<o.length;a++)n=o[a],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(i[n]=e[n])}return i}var s=a.createContext({}),p=function(e){var t=a.useContext(s),n=t;return e&&(n="function"==typeof e?e(t):r(r({},t),e)),n},u=function(e){var t=p(e.components);return a.createElement(s.Provider,{value:t},e.children)},c="mdxType",d={inlineCode:"code",wrapper:function(e){var t=e.children;return a.createElement(a.Fragment,{},t)}},m=a.forwardRef((function(e,t){var n=e.components,i=e.mdxType,o=e.originalType,s=e.parentName,u=l(e,["components","mdxType","originalType","parentName"]),c=p(n),m=i,h=c["".concat(s,".").concat(m)]||c[m]||d[m]||o;return n?a.createElement(h,r(r({ref:t},u),{},{components:n})):a.createElement(h,r({ref:t},u))}));function h(e,t){var n=arguments,i=t&&t.mdxType;if("string"==typeof e||i){var o=n.length,r=new Array(o);r[0]=m;var l={};for(var s in t)hasOwnProperty.call(t,s)&&(l[s]=t[s]);l.originalType=e,l[c]="string"==typeof e?e:i,r[1]=l;for(var p=2;p<o;p++)r[p]=n[p];return a.createElement.apply(null,r)}return a.createElement.apply(null,n)}m.displayName="MDXCreateElement"},7050:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>s,contentTitle:()=>r,default:()=>d,frontMatter:()=>o,metadata:()=>l,toc:()=>p});var a=n(7462),i=(n(7294),n(3905));const o={slug:"/"},r="Introduction",l={unversionedId:"introduction",id:"introduction",title:"Introduction",description:"The eLLMental project raises from the necessity of developer's to have a single framework that joins flexibility,",source:"@site/docs/01_introduction.md",sourceDirName:".",slug:"/",permalink:"/",draft:!1,editUrl:"https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/docs/01_introduction.md",tags:[],version:"current",lastUpdatedBy:"Juan Jos\xe9 Rodr\xedguez L\xf3pez",lastUpdatedAt:1688742979,formattedLastUpdatedAt:"Jul 7, 2023",sidebarPosition:1,frontMatter:{slug:"/"},sidebar:"docs",next:{title:"Getting started",permalink:"/getting_started"}},s={},p=[{value:"Modules",id:"modules",level:2},{value:"The YOLO tool",id:"the-yolo-tool",level:2},{value:"Reporting bugs",id:"reporting-bugs",level:2},{value:"Suggesting Enhancements",id:"suggesting-enhancements",level:2}],u={toc:p},c="wrapper";function d(e){let{components:t,...n}=e;return(0,i.kt)(c,(0,a.Z)({},u,n,{components:t,mdxType:"MDXLayout"}),(0,i.kt)("h1",{id:"introduction"},"Introduction"),(0,i.kt)("p",null,"The eLLMental project raises from the necessity of developer's to have a single framework that joins flexibility,\nefficiency and productivity while building the different block an AI application. During this time, we've seen different\nchallenges that motivated us to start building this project:"),(0,i.kt)("ol",null,(0,i.kt)("li",{parentName:"ol"},(0,i.kt)("strong",{parentName:"li"},"Lack of Robust Tools and Libraries:")," The field being fairly new means there's a lack of effective tools\ncustom-made for LLMs, making it more difficult for developers to understand how LLMs work nowadays."),(0,i.kt)("li",{parentName:"ol"},(0,i.kt)("strong",{parentName:"li"},"MLOps management:")," There's no one-size-fits-all solution in MLOps and particularly with LLMs, resulting in\nheterogeneity in the tools, platforms, and workflow processes. This means more time is needed to find the right\nstack. Also, evaluating LLMs performance is not straightforward."),(0,i.kt)("li",{parentName:"ol"},(0,i.kt)("strong",{parentName:"li"},"Security"),": Ensuring the security of the underlying infrastructure, including network security, firewall\nconfigurations, and container security, is a major challenge. Setting up appropriate monitoring and alerts can be\nboth technically challenging and resource-intensive."),(0,i.kt)("li",{parentName:"ol"},(0,i.kt)("strong",{parentName:"li"},"Privacy:")," LLMs often require large amounts of data, raising potential data privacy issues, which may not be\nadequately addressed by existing MLOps platforms."),(0,i.kt)("li",{parentName:"ol"},(0,i.kt)("strong",{parentName:"li"},"Flexibility:")," Application's needs grow constantly, and so does AI applications. That's why we are adopting a\nflexible philosophy, by building separate software blocks that con compose themselves into bigger customizable AI\napplications.")),(0,i.kt)("p",null,"Overall, eLLMental is designed to help software engineers build AI-driven applications in an efficient manner by\nremoving all common headaches while integrating AI in your development environment."),(0,i.kt)("h1",{id:"getting-started"},"Getting started"),(0,i.kt)("p",null,"The main package eLLMental offers is called ",(0,i.kt)("inlineCode",{parentName:"p"},"ellmental-core"),". In this package, we provide an API implementation for your\nAI applications. This API currently support two kind of operations: write (HTTP POST), and read (HTTP GET). You can provide\nyour own implementation for these two operations, as you can see in the ",(0,i.kt)("inlineCode",{parentName:"p"},"SemanticSearch.kt")," file."),(0,i.kt)("p",null,"Technical-wise, ",(0,i.kt)("inlineCode",{parentName:"p"},"ellmental-core")," is built under the following stack:"),(0,i.kt)("table",null,(0,i.kt)("thead",{parentName:"table"},(0,i.kt)("tr",{parentName:"thead"},(0,i.kt)("th",{parentName:"tr",align:null}),(0,i.kt)("th",{parentName:"tr",align:null}))),(0,i.kt)("tbody",{parentName:"table"},(0,i.kt)("tr",{parentName:"tbody"},(0,i.kt)("td",{parentName:"tr",align:null},"Package Manager"),(0,i.kt)("td",{parentName:"tr",align:null},"Gradle")),(0,i.kt)("tr",{parentName:"tbody"},(0,i.kt)("td",{parentName:"tr",align:null},"Programming Language"),(0,i.kt)("td",{parentName:"tr",align:null},"Kotlin")),(0,i.kt)("tr",{parentName:"tbody"},(0,i.kt)("td",{parentName:"tr",align:null},"JVM Version"),(0,i.kt)("td",{parentName:"tr",align:null},"17")))),(0,i.kt)("h2",{id:"modules"},"Modules"),(0,i.kt)("p",null,"The eLLMental project also implements three different AI modules:"),(0,i.kt)("ol",null,(0,i.kt)("li",{parentName:"ol"},(0,i.kt)("strong",{parentName:"li"},"A vector store:")," Database or repository used to house and handle vector representations of words or phrases, known\nas embeddings. eLLMental implements different databases that support vector columns, like Pinecone or Supabase."),(0,i.kt)("li",{parentName:"ol"},(0,i.kt)("strong",{parentName:"li"},"Embedding generator:")," The service that is responsible for converting raw text data into representative numerical\nvectors, also known as embeddings."),(0,i.kt)("li",{parentName:"ol"},(0,i.kt)("strong",{parentName:"li"},"Semantic search module:")," To search similarities in the vector store.\nUsing ",(0,i.kt)("a",{parentName:"li",href:"https://en.wikipedia.org/wiki/Cosine_similarity"},"cosine similarity"),", which measures the cosine of the angle\nbetween two vectors. The vectors close to each other (having a smaller angle between them)\nindicate more similar content.")),(0,i.kt)("blockquote",null,(0,i.kt)("p",{parentName:"blockquote"},"An example of how these modules are use can be found in the ",(0,i.kt)("inlineCode",{parentName:"p"},"semantic-search-service-demo")," project.")),(0,i.kt)("p",null,"These modules work on their own, but we can manage them in an easier way, by using the ",(0,i.kt)("inlineCode",{parentName:"p"},"YOLO")," CLI tool, which will help\nyou set up these different modules."),(0,i.kt)("h2",{id:"the-yolo-tool"},"The YOLO tool"),(0,i.kt)("p",null,"The ",(0,i.kt)("a",{parentName:"p",href:"https://github.com/theam/yolo"},"YOLO")," tool is the way we configure our applications to import different AI\nmodules. To start using it you just need to run the following command:"),(0,i.kt)("p",null,(0,i.kt)("inlineCode",{parentName:"p"},"yolo init")),(0,i.kt)("p",null,"This command will create a ",(0,i.kt)("inlineCode",{parentName:"p"},"yolo.json")," file, in which you will configure your different scripts. Here's an example:"),(0,i.kt)("pre",null,(0,i.kt)("code",{parentName:"pre",className:"language-json"},'{\n  "name": "SemanticSearch",\n  "description": "Description of the app",\n  "commands": [\n    {\n      "name": "deploy",\n      "description": "command description",\n      "script": "npm run deploy",\n      "args": [{ ... }]\n    }\n  ],\n  "modules": {\n    "vector-store": "Pinecone",\n    "embedding-generator": {\n      "llm": "openAI",\n      "api-url": "url",\n      "api-token": "token"\n    }\n  }\n}\n')),(0,i.kt)("p",null,"This ",(0,i.kt)("inlineCode",{parentName:"p"},"yolo.json")," file, will allow you to run ",(0,i.kt)("inlineCode",{parentName:"p"},"yolo run deploy"),", that will execute the code inside the ",(0,i.kt)("inlineCode",{parentName:"p"},"script")," key. The final\nobjective for this CLI tool is that it will help us composing different modules too, so we can abstract the boiler-plate code\nas much as possible."),(0,i.kt)("h1",{id:"contributing"},"Contributing"),(0,i.kt)("p",null,"We're happy to see that you're interested in contributing, that's great! In the sections below, you can see how to report\nbugs or suggest enhancements."),(0,i.kt)("p",null,"If your plan is to create a different package or module using Kotlin (like ",(0,i.kt)("inlineCode",{parentName:"p"},"llmental-core"),"), you can duplicate the ",(0,i.kt)("inlineCode",{parentName:"p"},".kotlin-template"),"\nfolder and rename it to your package name. After that, you'll have to add the package name to the ",(0,i.kt)("inlineCode",{parentName:"p"},"settings.gradle.kts"),"\nfile, in the ",(0,i.kt)("inlineCode",{parentName:"p"},"includes")," list. This way we will keep the same structure for all of them."),(0,i.kt)("h2",{id:"reporting-bugs"},"Reporting bugs"),(0,i.kt)("p",null,"Before creating a bug report, please search for similar issues to make sure that they're not already reported. If you\ndon't find any, go ahead and create an issue including as many details as possible."),(0,i.kt)("blockquote",null,(0,i.kt)("p",{parentName:"blockquote"},"If you find a Closed issue that seems related to the issues that you're experiencing, make sure to reference it in the\nbody of your new one by writing its number like this => #42 (Github will autolink it for you).")),(0,i.kt)("p",null,"Bugs are tracked as GitHub issues. Explain the problem and include additional details to help maintainers reproduce the\nproblem:"),(0,i.kt)("ul",null,(0,i.kt)("li",{parentName:"ul"},"Use a clear and descriptive title for the issue to identify the problem."),(0,i.kt)("li",{parentName:"ul"},"Describe the exact steps which reproduce the problem in as many details as possible."),(0,i.kt)("li",{parentName:"ul"},"Provide specific examples to demonstrate the steps. Include links to files or GitHub projects, or copy/pasteable\nsnippets, which you use in those examples. If you're providing snippets in the issue, use Markdown code blocks."),(0,i.kt)("li",{parentName:"ul"},"Describe the behavior you observed after following the steps and point out what exactly is the problem with that\nbehavior."),(0,i.kt)("li",{parentName:"ul"},"Explain which behavior you expected to see instead and why."),(0,i.kt)("li",{parentName:"ul"},"If the problem is related to performance or memory, include a CPU profile capture with your report.")),(0,i.kt)("blockquote",null,(0,i.kt)("p",{parentName:"blockquote"},'Remember to label the issue with a "bug" tag')),(0,i.kt)("h2",{id:"suggesting-enhancements"},"Suggesting Enhancements"),(0,i.kt)("p",null,"Enhancement suggestions are tracked as GitHub issues. Make sure you provide the following information:"),(0,i.kt)("ul",null,(0,i.kt)("li",{parentName:"ul"},"Use a clear and descriptive title for the issue to identify the suggestion."),(0,i.kt)("li",{parentName:"ul"},"Provide a step-by-step description of the suggested enhancement in as many details as possible."),(0,i.kt)("li",{parentName:"ul"},"Provide specific examples to demonstrate the steps. Include copy/pasteable snippets which you use in those examples,\nas Markdown code blocks."),(0,i.kt)("li",{parentName:"ul"},"Describe the current behavior and explain which behavior you expected to see instead and why."),(0,i.kt)("li",{parentName:"ul"},"Explain why this enhancement would be useful to most Booster users and isn't something that can or should be\nimplemented as a community package."),(0,i.kt)("li",{parentName:"ul"},"List some other libraries or frameworks where this enhancement exists.")),(0,i.kt)("blockquote",null,(0,i.kt)("p",{parentName:"blockquote"},'Remember to label the issue wit an "enhancement" tag')),(0,i.kt)("h1",{id:"license"},"License"),(0,i.kt)("p",null,"This eLLMental project is licensed under the Business source license. You can take a look at the details\nin ",(0,i.kt)("a",{parentName:"p",href:"https://timreview.ca/article/691"},"this article"),"."),(0,i.kt)("p",null,"eLLMental is a project by ",(0,i.kt)("a",{parentName:"p",href:"https://www.theagilemonkeys.com/"},"The Agile Monkeys"),"."))}d.isMDXComponent=!0}}]);