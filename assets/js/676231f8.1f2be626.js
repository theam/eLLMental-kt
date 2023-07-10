"use strict";(self.webpackChunkellmental=self.webpackChunkellmental||[]).push([[817],{3905:(e,t,n)=>{n.d(t,{Zo:()=>p,kt:()=>h});var r=n(7294);function a(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function o(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter((function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable}))),n.push.apply(n,r)}return n}function i(e){for(var t=1;t<arguments.length;t++){var n=null!=arguments[t]?arguments[t]:{};t%2?o(Object(n),!0).forEach((function(t){a(e,t,n[t])})):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(n)):o(Object(n)).forEach((function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(n,t))}))}return e}function s(e,t){if(null==e)return{};var n,r,a=function(e,t){if(null==e)return{};var n,r,a={},o=Object.keys(e);for(r=0;r<o.length;r++)n=o[r],t.indexOf(n)>=0||(a[n]=e[n]);return a}(e,t);if(Object.getOwnPropertySymbols){var o=Object.getOwnPropertySymbols(e);for(r=0;r<o.length;r++)n=o[r],t.indexOf(n)>=0||Object.prototype.propertyIsEnumerable.call(e,n)&&(a[n]=e[n])}return a}var l=r.createContext({}),u=function(e){var t=r.useContext(l),n=t;return e&&(n="function"==typeof e?e(t):i(i({},t),e)),n},p=function(e){var t=u(e.components);return r.createElement(l.Provider,{value:t},e.children)},c="mdxType",m={inlineCode:"code",wrapper:function(e){var t=e.children;return r.createElement(r.Fragment,{},t)}},d=r.forwardRef((function(e,t){var n=e.components,a=e.mdxType,o=e.originalType,l=e.parentName,p=s(e,["components","mdxType","originalType","parentName"]),c=u(n),d=a,h=c["".concat(l,".").concat(d)]||c[d]||m[d]||o;return n?r.createElement(h,i(i({ref:t},p),{},{components:n})):r.createElement(h,i({ref:t},p))}));function h(e,t){var n=arguments,a=t&&t.mdxType;if("string"==typeof e||a){var o=n.length,i=new Array(o);i[0]=d;var s={};for(var l in t)hasOwnProperty.call(t,l)&&(s[l]=t[l]);s.originalType=e,s[c]="string"==typeof e?e:a,i[1]=s;for(var u=2;u<o;u++)i[u]=n[u];return r.createElement.apply(null,i)}return r.createElement.apply(null,n)}d.displayName="MDXCreateElement"},8701:(e,t,n)=>{n.r(t),n.d(t,{assets:()=>l,contentTitle:()=>i,default:()=>m,frontMatter:()=>o,metadata:()=>s,toc:()=>u});var r=n(7462),a=(n(7294),n(3905));const o={},i="Contributing",s={unversionedId:"contributing",id:"contributing",title:"Contributing",description:"We're happy to see that you're interested in contributing, that's great! In the sections below, you can see how to report",source:"@site/docs/04_contributing.md",sourceDirName:".",slug:"/contributing",permalink:"/contributing",draft:!1,editUrl:"https://github.com/facebook/docusaurus/tree/main/packages/create-docusaurus/templates/shared/docs/04_contributing.md",tags:[],version:"current",lastUpdatedBy:"Juan Jos\xe9 Rodr\xedguez L\xf3pez",lastUpdatedAt:1688997753,formattedLastUpdatedAt:"Jul 10, 2023",sidebarPosition:4,frontMatter:{},sidebar:"docs",previous:{title:"Deployments",permalink:"/deployments"}},l={},u=[{value:"\ud83d\udc1b Reporting bugs",id:"-reporting-bugs",level:2},{value:"\ud83d\udca1 Suggesting Enhancements",id:"-suggesting-enhancements",level:2}],p={toc:u},c="wrapper";function m(e){let{components:t,...n}=e;return(0,a.kt)(c,(0,r.Z)({},p,n,{components:t,mdxType:"MDXLayout"}),(0,a.kt)("h1",{id:"contributing"},"Contributing"),(0,a.kt)("p",null,"We're happy to see that you're interested in contributing, that's great! In the sections below, you can see how to report\nbugs or suggest enhancements \ud83d\ude80."),(0,a.kt)("h2",{id:"-reporting-bugs"},"\ud83d\udc1b Reporting bugs"),(0,a.kt)("p",null,"Before creating a bug report, please ",(0,a.kt)("strong",{parentName:"p"},"search for similar issues to make sure that they're not already reported. If you\ndon't find any, go ahead and create an issue including as many details as possible.")),(0,a.kt)("blockquote",null,(0,a.kt)("p",{parentName:"blockquote"},"If you find a Closed issue that seems related to the issues that you're experiencing, make sure to reference it in the\nbody of your new one by writing its number like this => #42 (Github will auto-link it for you).")),(0,a.kt)("p",null,"Bugs are tracked as GitHub issues. Explain the problem and include additional details to help maintainers reproduce the\nproblem:"),(0,a.kt)("ul",null,(0,a.kt)("li",{parentName:"ul"},(0,a.kt)("strong",{parentName:"li"},"Use a clear and descriptive title")," for the issue to identify the problem."),(0,a.kt)("li",{parentName:"ul"},(0,a.kt)("strong",{parentName:"li"},"Describe the exact steps")," which reproduce the problem in as many details as possible."),(0,a.kt)("li",{parentName:"ul"},(0,a.kt)("strong",{parentName:"li"},"Provide specific examples")," to demonstrate the steps. Include links to files or GitHub projects, or copy/pasteable\nsnippets, which you use in those examples. If you're providing snippets in the issue, use Markdown code blocks."),(0,a.kt)("li",{parentName:"ul"},(0,a.kt)("strong",{parentName:"li"},"Describe the behavior you observed after following the steps")," and point out what exactly is the problem with that\nbehavior."),(0,a.kt)("li",{parentName:"ul"},(0,a.kt)("strong",{parentName:"li"},"Explain which behavior you expected to see")," instead and why."),(0,a.kt)("li",{parentName:"ul"},"If the problem is related to performance or memory, ",(0,a.kt)("strong",{parentName:"li"},"include a CPU profile capture with your report."))),(0,a.kt)("blockquote",null,(0,a.kt)("p",{parentName:"blockquote"},'Remember to label the issue with a "',(0,a.kt)("strong",{parentName:"p"},"bug"),'" tag')),(0,a.kt)("h2",{id:"-suggesting-enhancements"},"\ud83d\udca1 Suggesting Enhancements"),(0,a.kt)("p",null,"Enhancement suggestions are tracked as GitHub issues. Make sure you provide the following information:"),(0,a.kt)("ul",null,(0,a.kt)("li",{parentName:"ul"},(0,a.kt)("strong",{parentName:"li"},"Use a clear and descriptive title")," for the issue to identify the suggestion."),(0,a.kt)("li",{parentName:"ul"},(0,a.kt)("strong",{parentName:"li"},"Provide a step-by-step description")," of the suggested enhancement in as many details as possible."),(0,a.kt)("li",{parentName:"ul"},(0,a.kt)("strong",{parentName:"li"},"Provide specific examples to demonstrate the steps"),". Include copy/pasteable snippets which you use in those examples,\nas Markdown code blocks."),(0,a.kt)("li",{parentName:"ul"},(0,a.kt)("strong",{parentName:"li"},"Describe the current behavior")," and explain which behavior you expected to see instead and why."),(0,a.kt)("li",{parentName:"ul"},(0,a.kt)("strong",{parentName:"li"},"Explain why this enhancement would be useful")," to most eLLMental users and isn't something that can or should be\nimplemented as a community package."),(0,a.kt)("li",{parentName:"ul"},(0,a.kt)("strong",{parentName:"li"},"List some other libraries or frameworks where this enhancement exists."))),(0,a.kt)("blockquote",null,(0,a.kt)("p",{parentName:"blockquote"},'Remember to label the issue with an "',(0,a.kt)("strong",{parentName:"p"},"enhancement"),'" tag')),(0,a.kt)("h1",{id:"license"},"License"),(0,a.kt)("p",null,"This eLLMental project is licensed under the Business source license. You can take a look at the details\nin ",(0,a.kt)("a",{parentName:"p",href:"https://timreview.ca/article/691"},"this article"),"."),(0,a.kt)("p",null,"eLLMental is a project by ",(0,a.kt)("a",{parentName:"p",href:"https://www.theagilemonkeys.com/"},"The Agile Monkeys"),"."))}m.isMDXComponent=!0}}]);