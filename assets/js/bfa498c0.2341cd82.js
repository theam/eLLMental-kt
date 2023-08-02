"use strict";
(self["webpackChunkellmental"] = self["webpackChunkellmental"] || []).push([[2493],{

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

/***/ 5740:
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

// ESM COMPAT FLAG
__webpack_require__.r(__webpack_exports__);

// EXPORTS
__webpack_require__.d(__webpack_exports__, {
  CONTEXT_STYLE_LABEL: () => (/* binding */ CONTEXT_STYLE_LABEL),
  CONTEXT_STYLE_VALUE: () => (/* binding */ CONTEXT_STYLE_VALUE),
  PARAMETER_STYLE_LABEL: () => (/* binding */ PARAMETER_STYLE_LABEL),
  PARAMETER_STYLE_VALUE: () => (/* binding */ PARAMETER_STYLE_VALUE),
  TAB_GROUP_ID: () => (/* binding */ TAB_GROUP_ID),
  assets: () => (/* binding */ assets),
  contentTitle: () => (/* binding */ contentTitle),
  "default": () => (/* binding */ MDXContent),
  frontMatter: () => (/* binding */ frontMatter),
  metadata: () => (/* binding */ metadata),
  toc: () => (/* binding */ toc)
});

// EXTERNAL MODULE: ./node_modules/@babel/runtime/helpers/esm/extends.js
var esm_extends = __webpack_require__(7462);
// EXTERNAL MODULE: ./node_modules/react/index.js
var react = __webpack_require__(7294);
// EXTERNAL MODULE: ./node_modules/@mdx-js/react/dist/esm.js
var esm = __webpack_require__(3905);
// EXTERNAL MODULE: ./node_modules/clsx/dist/clsx.m.js
var clsx_m = __webpack_require__(6010);
// EXTERNAL MODULE: ./node_modules/@docusaurus/theme-common/lib/utils/scrollUtils.js
var scrollUtils = __webpack_require__(2466);
// EXTERNAL MODULE: ./node_modules/react-router/esm/react-router.js
var react_router = __webpack_require__(6550);
// EXTERNAL MODULE: ./node_modules/@docusaurus/theme-common/lib/utils/historyUtils.js
var historyUtils = __webpack_require__(1980);
// EXTERNAL MODULE: ./node_modules/@docusaurus/theme-common/lib/utils/jsUtils.js
var jsUtils = __webpack_require__(7392);
// EXTERNAL MODULE: ./node_modules/@docusaurus/theme-common/lib/utils/storageUtils.js
var storageUtils = __webpack_require__(12);
;// CONCATENATED MODULE: ./node_modules/@docusaurus/theme-common/lib/utils/tabsUtils.js
/**
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */// A very rough duck type, but good enough to guard against mistakes while
// allowing customization
function isTabItem(comp){const{props}=comp;return!!props&&typeof props==='object'&&'value'in props;}function ensureValidChildren(children){return react.Children.map(children,child=>{// Pass falsy values through: allow conditionally not rendering a tab
if(!child||/*#__PURE__*/(0,react.isValidElement)(child)&&isTabItem(child)){return child;}// child.type.name will give non-sensical values in prod because of
// minification, but we assume it won't throw in prod.
throw new Error(`Docusaurus error: Bad <Tabs> child <${// @ts-expect-error: guarding against unexpected cases
typeof child.type==='string'?child.type:child.type.name}>: all children of the <Tabs> component should be <TabItem>, and every <TabItem> should have a unique "value" prop.`);})?.filter(Boolean)??[];}function extractChildrenTabValues(children){return ensureValidChildren(children).map(_ref=>{let{props:{value,label,attributes,default:isDefault}}=_ref;return{value,label,attributes,default:isDefault};});}function ensureNoDuplicateValue(values){const dup=(0,jsUtils/* duplicates */.l)(values,(a,b)=>a.value===b.value);if(dup.length>0){throw new Error(`Docusaurus error: Duplicate values "${dup.map(a=>a.value).join(', ')}" found in <Tabs>. Every value needs to be unique.`);}}function useTabValues(props){const{values:valuesProp,children}=props;return (0,react.useMemo)(()=>{const values=valuesProp??extractChildrenTabValues(children);ensureNoDuplicateValue(values);return values;},[valuesProp,children]);}function isValidValue(_ref2){let{value,tabValues}=_ref2;return tabValues.some(a=>a.value===value);}function getInitialStateValue(_ref3){let{defaultValue,tabValues}=_ref3;if(tabValues.length===0){throw new Error('Docusaurus error: the <Tabs> component requires at least one <TabItem> children component');}if(defaultValue){// Warn user about passing incorrect defaultValue as prop.
if(!isValidValue({value:defaultValue,tabValues})){throw new Error(`Docusaurus error: The <Tabs> has a defaultValue "${defaultValue}" but none of its children has the corresponding value. Available values are: ${tabValues.map(a=>a.value).join(', ')}. If you intend to show no default tab, use defaultValue={null} instead.`);}return defaultValue;}const defaultTabValue=tabValues.find(tabValue=>tabValue.default)??tabValues[0];if(!defaultTabValue){throw new Error('Unexpected error: 0 tabValues');}return defaultTabValue.value;}function getStorageKey(groupId){if(!groupId){return null;}return`docusaurus.tab.${groupId}`;}function getQueryStringKey(_ref4){let{queryString=false,groupId}=_ref4;if(typeof queryString==='string'){return queryString;}if(queryString===false){return null;}if(queryString===true&&!groupId){throw new Error(`Docusaurus error: The <Tabs> component groupId prop is required if queryString=true, because this value is used as the search param name. You can also provide an explicit value such as queryString="my-search-param".`);}return groupId??null;}function useTabQueryString(_ref5){let{queryString=false,groupId}=_ref5;const history=(0,react_router/* useHistory */.k6)();const key=getQueryStringKey({queryString,groupId});const value=(0,historyUtils/* useQueryStringValue */._X)(key);const setValue=(0,react.useCallback)(newValue=>{if(!key){return;// no-op
}const searchParams=new URLSearchParams(history.location.search);searchParams.set(key,newValue);history.replace({...history.location,search:searchParams.toString()});},[key,history]);return[value,setValue];}function useTabStorage(_ref6){let{groupId}=_ref6;const key=getStorageKey(groupId);const[value,storageSlot]=(0,storageUtils/* useStorageSlot */.Nk)(key);const setValue=(0,react.useCallback)(newValue=>{if(!key){return;// no-op
}storageSlot.set(newValue);},[key,storageSlot]);return[value,setValue];}function useTabs(props){const{defaultValue,queryString=false,groupId}=props;const tabValues=useTabValues(props);const[selectedValue,setSelectedValue]=(0,react.useState)(()=>getInitialStateValue({defaultValue,tabValues}));const[queryStringValue,setQueryString]=useTabQueryString({queryString,groupId});const[storageValue,setStorageValue]=useTabStorage({groupId});// We sync valid querystring/storage value to state on change + hydration
const valueToSync=(()=>{const value=queryStringValue??storageValue;if(!isValidValue({value,tabValues})){return null;}return value;})();// Sync in a layout/sync effect is important, for useScrollPositionBlocker
// See https://github.com/facebook/docusaurus/issues/8625
(0,react.useLayoutEffect)(()=>{if(valueToSync){setSelectedValue(valueToSync);}},[valueToSync]);const selectValue=(0,react.useCallback)(newValue=>{if(!isValidValue({value:newValue,tabValues})){throw new Error(`Can't select invalid tab value=${newValue}`);}setSelectedValue(newValue);setQueryString(newValue);setStorageValue(newValue);},[setQueryString,setStorageValue,tabValues]);return{selectedValue,selectValue,tabValues};}
// EXTERNAL MODULE: ./node_modules/@docusaurus/core/lib/client/exports/useIsBrowser.js
var useIsBrowser = __webpack_require__(2389);
;// CONCATENATED MODULE: ./node_modules/@docusaurus/theme-classic/lib/theme/Tabs/styles.module.css
// extracted by mini-css-extract-plugin
/* harmony default export */ const styles_module = ({"tabList":"tabList__CuJ","tabItem":"tabItem_LNqP"});
;// CONCATENATED MODULE: ./node_modules/@docusaurus/theme-classic/lib/theme/Tabs/index.js
/**
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */function TabList(_ref){let{className,block,selectedValue,selectValue,tabValues}=_ref;const tabRefs=[];const{blockElementScrollPositionUntilNextRender}=(0,scrollUtils/* useScrollPositionBlocker */.o5)();const handleTabChange=event=>{const newTab=event.currentTarget;const newTabIndex=tabRefs.indexOf(newTab);const newTabValue=tabValues[newTabIndex].value;if(newTabValue!==selectedValue){blockElementScrollPositionUntilNextRender(newTab);selectValue(newTabValue);}};const handleKeydown=event=>{let focusElement=null;switch(event.key){case'Enter':{handleTabChange(event);break;}case'ArrowRight':{const nextTab=tabRefs.indexOf(event.currentTarget)+1;focusElement=tabRefs[nextTab]??tabRefs[0];break;}case'ArrowLeft':{const prevTab=tabRefs.indexOf(event.currentTarget)-1;focusElement=tabRefs[prevTab]??tabRefs[tabRefs.length-1];break;}default:break;}focusElement?.focus();};return/*#__PURE__*/react.createElement("ul",{role:"tablist","aria-orientation":"horizontal",className:(0,clsx_m/* default */.Z)('tabs',{'tabs--block':block},className)},tabValues.map(_ref2=>{let{value,label,attributes}=_ref2;return/*#__PURE__*/react.createElement("li",(0,esm_extends/* default */.Z)({// TODO extract TabListItem
role:"tab",tabIndex:selectedValue===value?0:-1,"aria-selected":selectedValue===value,key:value,ref:tabControl=>tabRefs.push(tabControl),onKeyDown:handleKeydown,onClick:handleTabChange},attributes,{className:(0,clsx_m/* default */.Z)('tabs__item',styles_module.tabItem,attributes?.className,{'tabs__item--active':selectedValue===value})}),label??value);}));}function TabContent(_ref3){let{lazy,children,selectedValue}=_ref3;const childTabs=(Array.isArray(children)?children:[children]).filter(Boolean);if(lazy){const selectedTabItem=childTabs.find(tabItem=>tabItem.props.value===selectedValue);if(!selectedTabItem){// fail-safe or fail-fast? not sure what's best here
return null;}return/*#__PURE__*/(0,react.cloneElement)(selectedTabItem,{className:'margin-top--md'});}return/*#__PURE__*/react.createElement("div",{className:"margin-top--md"},childTabs.map((tabItem,i)=>/*#__PURE__*/(0,react.cloneElement)(tabItem,{key:i,hidden:tabItem.props.value!==selectedValue})));}function TabsComponent(props){const tabs=useTabs(props);return/*#__PURE__*/react.createElement("div",{className:(0,clsx_m/* default */.Z)('tabs-container',styles_module.tabList)},/*#__PURE__*/react.createElement(TabList,(0,esm_extends/* default */.Z)({},props,tabs)),/*#__PURE__*/react.createElement(TabContent,(0,esm_extends/* default */.Z)({},props,tabs)));}function Tabs(props){const isBrowser=(0,useIsBrowser/* default */.Z)();return/*#__PURE__*/react.createElement(TabsComponent// Remount tabs after hydration
// Temporary fix for https://github.com/facebook/docusaurus/issues/5653
,(0,esm_extends/* default */.Z)({key:String(isBrowser)},props));}
;// CONCATENATED MODULE: ./node_modules/@docusaurus/theme-classic/lib/theme/TabItem/styles.module.css
// extracted by mini-css-extract-plugin
/* harmony default export */ const TabItem_styles_module = ({"tabItem":"tabItem_Ymn6"});
;// CONCATENATED MODULE: ./node_modules/@docusaurus/theme-classic/lib/theme/TabItem/index.js
/**
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */function TabItem(_ref){let{children,hidden,className}=_ref;return/*#__PURE__*/react.createElement("div",{role:"tabpanel",className:(0,clsx_m/* default */.Z)(TabItem_styles_module.tabItem,className),hidden},children);}
;// CONCATENATED MODULE: ./docs/Components.mdx
/* @jsxRuntime classic */ /* @jsx mdx */ /* @jsxFrag React.Fragment */const frontMatter={};const contentTitle=undefined;const metadata={"unversionedId":"Components","id":"Components","title":"Components","description":"Welcome to the Components section of the eLLMental library! eLLMental is like a master chef's kitchen, but","source":"@site/docs/Components.mdx","sourceDirName":".","slug":"/Components","permalink":"/Components","draft":false,"tags":[],"version":"current","lastUpdatedBy":"Javier Toledo","lastUpdatedAt":1690967709,"formattedLastUpdatedAt":"Aug 2, 2023","frontMatter":{},"sidebar":"docs","previous":{"title":"Getting started","permalink":"/getting_started"},"next":{"title":"Community","permalink":"/community/"}};const assets={};const toc=[{value:'EmbeddingsModel',id:'embeddingsmodel',level:2},{value:'VectorStore',id:'vectorstore',level:2},{value:'SemanticSearch',id:'semanticsearch',level:2}];const TAB_GROUP_ID="style";const PARAMETER_STYLE_VALUE="kotlin-parameter";const CONTEXT_STYLE_VALUE="kotlin-context";const PARAMETER_STYLE_LABEL="Kotlin (Parameter Passing)";const CONTEXT_STYLE_LABEL="Kotlin (Context Receivers)";const layoutProps={toc,TAB_GROUP_ID};const MDXLayout="wrapper";function MDXContent(_ref){let{components,...props}=_ref;return (0,esm/* mdx */.kt)(MDXLayout,(0,esm_extends/* default */.Z)({},layoutProps,props,{components:components,mdxType:"MDXLayout"}),(0,esm/* mdx */.kt)("h1",{"id":"introduction-to-the-usage-of-components"},`Introduction to the usage of components`),(0,esm/* mdx */.kt)("p",null,`Welcome to the Components section of the eLLMental library! eLLMental is like a master chef's kitchen, but
instead of preparing food with ingredients, it helps you whip up AI applications with ease through the usage of
well-defined components that work extremely well together.`),(0,esm/* mdx */.kt)("p",null,`In eLLMental, components are defined through interfaces. This means that you can easily swap out components for your
own implementations, or even use multiple implementations of the same component in the same application. This allows
you to easily experiment with different components and see which ones work best for your use case.`),(0,esm/* mdx */.kt)("p",null,`You write your functions and classes in terms of these components, and then you pass concrete implementations of the
components when you call the functions or instantiate the classes.`),(0,esm/* mdx */.kt)(Tabs,{groupId:TAB_GROUP_ID,mdxType:"Tabs"},(0,esm/* mdx */.kt)(TabItem,{value:PARAMETER_STYLE_VALUE,label:PARAMETER_STYLE_LABEL,mdxType:"TabItem"},(0,esm/* mdx */.kt)("pre",null,(0,esm/* mdx */.kt)("code",{parentName:"pre","className":"language-kotlin"},`import com.theagilemonkeys.ellmental.embeddingmodel.*

// Passing it as a parameter to the function
suspend fun doSomething(embeddingModel: EmbeddingModel<Any>): Embedding {
  return embeddingModel.embed("Hello world!")
}

// Passing it as a parameter to the constructor
class MyService(val embeddingModel: EmbeddingModel<Any>) {
  suspend fun doSomething(): Embedding {
    return embeddingModel.embed("Hello world!")
  }
}
`))),(0,esm/* mdx */.kt)(TabItem,{value:CONTEXT_STYLE_VALUE,label:CONTEXT_STYLE_LABEL,mdxType:"TabItem"},(0,esm/* mdx */.kt)("p",null,`  `,(0,esm/* mdx */.kt)("a",{parentName:"p","href":"https://blog.rockthejvm.com/kotlin-context-receivers/"},`Context Receivers`),` are a Kotlin feature that allows you to express the required dependencies of a function or a class
through the use of the `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`context`),` keyword. This way you can avoid passing the dependencies as parameters, and instead
let the compiler inject the dependencies for you. This is like dependency injection, but without the need for a
dependency injection framework.`),(0,esm/* mdx */.kt)("pre",null,(0,esm/* mdx */.kt)("code",{parentName:"pre","className":"language-kotlin"},`import com.theagilemonkeys.ellmental.embeddingmodel.*

// Using Context Receivers in a function
context(EmbeddingModel<Any>)
suspend fun doSomething(): Embedding {
  return embed("Hello world!")
}


// Using Context Receivers in a class
context(EmbeddingModel<Any>)
  class MyService {
    suspend fun doSomething(): Embedding {
    return embed("Hello world!")
  }
}
`)))),(0,esm/* mdx */.kt)("p",null,`Now you can pass your concrete implementations of the components when you call the functions or instantiate the
classes:`),(0,esm/* mdx */.kt)(Tabs,{groupId:TAB_GROUP_ID,mdxType:"Tabs"},(0,esm/* mdx */.kt)(TabItem,{value:PARAMETER_STYLE_VALUE,label:PARAMETER_STYLE_LABEL,mdxType:"TabItem"},(0,esm/* mdx */.kt)("pre",null,(0,esm/* mdx */.kt)("code",{parentName:"pre","className":"language-kotlin"},`fun main() = runBlocking {
  // Instantiate the concrete implementation of the EmbeddingModel interface
  val embeddingModel = OpenAIEmbeddingsModel("API KEY")

  // Passing it as a parameter to the function
  doSomething(embeddingModel)

  // Passing it as a parameter to the constructor
  val myService = MyService(embeddingModel)
  myService.doSomething()
}
`))),(0,esm/* mdx */.kt)(TabItem,{value:CONTEXT_STYLE_VALUE,label:CONTEXT_STYLE_LABEL,mdxType:"TabItem"},(0,esm/* mdx */.kt)("pre",null,(0,esm/* mdx */.kt)("code",{parentName:"pre","className":"language-kotlin"},`fun main() = runBlocking {
  with(OpenAIEmbeddingsModel("API KEY")) {
    // Calling a function
    doSomething()

    // Calling a class method
    val myService = MyService()
    myService.doSomething()
  }
}
`)),(0,esm/* mdx */.kt)("p",null,`  Note the difference between the two styles: in the parameter passing style, you pass the concrete implementation as
a parameter to the function or constructor `,(0,esm/* mdx */.kt)("strong",{parentName:"p"},`manually`),`. While with the context receivers style, you use the `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`with`),`
once, and then you can call the methods of the component as if they were there in the rest of the application.`))),(0,esm/* mdx */.kt)("h1",{"id":"available-components"},`Available components`),(0,esm/* mdx */.kt)("p",null,`In this section you will find a list of all the available components in eLLMental, along with a brief description of
what they do and how to use them.`),(0,esm/* mdx */.kt)("p",null,`If you want to go to the API documentation of a component, simply click on its name.`),(0,esm/* mdx */.kt)("h2",{"id":"embeddingsmodel"},(0,esm/* mdx */.kt)("a",{parentName:"h2","href":"/api_docs/ellmental/com.theagilemonkeys.ellmental.embeddingsmodel/-embeddings-model/"},`EmbeddingsModel`)),(0,esm/* mdx */.kt)("p",null,`The embeddings model is the component that is responsible for generating embeddings from text.`),(0,esm/* mdx */.kt)("p",null,`An embedding is a semantic representation of a text in the "semantics space", an imaginary high-dimensional mathematical representation of all the possible semantics. In this space, each concept is associated with a specific point in a way
that words or phrases that are similar from a meaning point of view are placed closer than those with different meanings.
In short, an embedding is an array of numbers representing the text's meaning in the semantics space.`),(0,esm/* mdx */.kt)("p",null,`For example, If we were to represent the embeddings of the words `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`swimming`),`, `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`swam`),`, `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`walking`),`, `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`walked`),` in a very
simplified visualization, we could see them like this:`),(0,esm/* mdx */.kt)("img",{alt:"Visualization of word embeddings",src:(__webpack_require__(7889)/* ["default"] */ .Z),style:{width:"300px"}}),(0,esm/* mdx */.kt)("p",null,`Embeddings are useful because they allow you to compare
pieces of text by their `,(0,esm/* mdx */.kt)("em",{parentName:"p"},`meaning`),` rather than by their characters or other properties. For example, the embeddings of
the sentences "I like apples" and "I like oranges" will be very similar, because the vector representation of the
sentences is similar.`),(0,esm/* mdx */.kt)("p",null,`The `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`EmbeddingsModel`),` interface is defined by the following interface:`),(0,esm/* mdx */.kt)("pre",null,(0,esm/* mdx */.kt)("code",{parentName:"pre","className":"language-kotlin"},`interface EmbeddingsModel<Params> {
  suspend fun embed(text: String, params: Params? = null): Embedding
}
`)),(0,esm/* mdx */.kt)("p",null,`As you may have noticed, the interface declares a generic parameter that represents possible configuration options for the concrete implementation of the `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`EmbeddingsModel`),`. If you're unsure about what to use, you can use `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`Any`),` as the generic parameter and then specify it later once you decide on a concrete implementation.`),(0,esm/* mdx */.kt)("p",null,`The `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`EmbeddingsModel`),` component declares a single `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`embed`),` method. This method receives a string that can be a single word, a sentence, a paragraph, or even a whole book, as long as the implementation of the `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`EmbeddingsModel`),` that you are using supports processing the length of text that you are passing.`),(0,esm/* mdx */.kt)(Tabs,{groupId:TAB_GROUP_ID,mdxType:"Tabs"},(0,esm/* mdx */.kt)(TabItem,{value:PARAMETER_STYLE_VALUE,label:PARAMETER_STYLE_LABEL,mdxType:"TabItem"},(0,esm/* mdx */.kt)("pre",null,(0,esm/* mdx */.kt)("code",{parentName:"pre","className":"language-kotlin"},`import com.theagilemonkeys.ellmental.embeddingmodel.*

suspend fun doSomething(embeddingModel: EmbeddingModel<Any>) {
  val swimmingEmbedding = embeddingModel.embed("swimming")
  println(swimmingEmbedding)
}
`))),(0,esm/* mdx */.kt)(TabItem,{value:CONTEXT_STYLE_VALUE,label:CONTEXT_STYLE_LABEL,mdxType:"TabItem"},(0,esm/* mdx */.kt)("pre",null,(0,esm/* mdx */.kt)("code",{parentName:"pre","className":"language-kotlin"},`import com.theagilemonkeys.ellmental.embeddingmodel.*

context(EmbeddingModel<Any>)
suspend fun doSomething() {
    val swimmingEmbedding = embed("swimming")
    println(swimmingEmbedding)
}
`)))),(0,esm/* mdx */.kt)("h2",{"id":"vectorstore"},(0,esm/* mdx */.kt)("a",{parentName:"h2","href":"/api_docs/ellmental/com.theagilemonkeys.ellmental.vectorstore/-vector-store/"},`VectorStore`)),(0,esm/* mdx */.kt)("p",null,`The `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`VectorStore`),` component is responsible for storing the embeddings generated by the `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`EmbeddingsModel`),` and is defined by the following interface:`),(0,esm/* mdx */.kt)("pre",null,(0,esm/* mdx */.kt)("code",{parentName:"pre","className":"language-kotlin"},`interface VectorStore {
  suspend fun upsert(semanticEntry: SemanticEntry)
  suspend fun query(semanticEntry: SemanticEntry): QueryOutput
}
`)),(0,esm/* mdx */.kt)("p",null,`It is important to note that the VectorStore component is not responsible for generating the embeddings. It only stores
and retrieves them.`),(0,esm/* mdx */.kt)("p",null,`The `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`VectorStore`),` component declares two methods: `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`upsert`),` and `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`query`),`. The `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`upsert`),` method is used to store embeddings in the `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`VectorStore`),`, and the `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`query`),` method is used to retrieve semantically similar embeddings from the `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`VectorStore`),`.`),(0,esm/* mdx */.kt)(Tabs,{groupId:TAB_GROUP_ID,mdxType:"Tabs"},(0,esm/* mdx */.kt)(TabItem,{value:PARAMETER_STYLE_VALUE,label:PARAMETER_STYLE_LABEL,mdxType:"TabItem"},(0,esm/* mdx */.kt)("pre",null,(0,esm/* mdx */.kt)("code",{parentName:"pre","className":"language-kotlin"},`import com.theagilemonkeys.ellmental.vectorstore.*

suspend fun doSomething(vectorStore: VectorStore<Any>) {
  val embedding = // some embedding generated by an EmbeddingModel

  vectorStore.upsert(embedding)
  val similarEmbeddings = vectorStore.query(embedding)
  println(similarEmbeddings)
}
`))),(0,esm/* mdx */.kt)(TabItem,{value:CONTEXT_STYLE_VALUE,label:CONTEXT_STYLE_LABEL,mdxType:"TabItem"},(0,esm/* mdx */.kt)("pre",null,(0,esm/* mdx */.kt)("code",{parentName:"pre","className":"language-kotlin"},`import com.theagilemonkeys.ellmental.vectorstore.*

context(VectorStore)
suspend fun doSomething() {
    val embedding = // some embedding generated by an EmbeddingModel

    upsert(embedding)
    val similarEmbeddings = query(embedding)
    println(similarEmbeddings)
}
`)))),(0,esm/* mdx */.kt)("h2",{"id":"semanticsearch"},(0,esm/* mdx */.kt)("a",{parentName:"h2","href":"/api_docs/ellmental/com.theagilemonkeys.ellmental.semanticsearch/-semantic-search/"},`SemanticSearch`)),(0,esm/* mdx */.kt)("p",null,`The `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`SemanticSearch`),` component combines the functionality of the `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`EmbeddingsModel`),` and the `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`VectorStore`),`, abstracting the process of generating embeddings from text and storing them in a VectorStore
to provide a higher-level interface for implementing semantic search use cases. It is defined by the `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`SemanticSearch`),` class, which has the following interface:`),(0,esm/* mdx */.kt)("pre",null,(0,esm/* mdx */.kt)("code",{parentName:"pre","className":"language-kotlin"},`context(EmbeddingsModel<Any>, VectorStore)
class SemanticSearch {
  suspend fun learn(input: SearchInput)
  suspend fun search(text: String): SearchOutput
}
`)),(0,esm/* mdx */.kt)("p",null,`The `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`SemanticSearch`),` component declares two methods: `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`learn`),` and `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`search`),`. The `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`learn`),` method is used to store the semantic meaning of a piece of text, and the `,(0,esm/* mdx */.kt)("inlineCode",{parentName:"p"},`search`),` method is used to retrieve semantically similar pieces of text.`),(0,esm/* mdx */.kt)(Tabs,{groupId:TAB_GROUP_ID,mdxType:"Tabs"},(0,esm/* mdx */.kt)(TabItem,{value:PARAMETER_STYLE_VALUE,label:PARAMETER_STYLE_LABEL,mdxType:"TabItem"},(0,esm/* mdx */.kt)("pre",null,(0,esm/* mdx */.kt)("code",{parentName:"pre","className":"language-kotlin"},`import com.theagilemonkeys.ellmental.semanticsearch.*

suspend fun doSomething(semanticSearch: SemanticSearch<Any>) {
  semanticSearch.learn("Hello world!")
  val similarEmbeddings = semanticSearch.search("Hello world!")
  println(similarEmbeddings)
}
`))),(0,esm/* mdx */.kt)(TabItem,{value:CONTEXT_STYLE_VALUE,label:CONTEXT_STYLE_LABEL,mdxType:"TabItem"},(0,esm/* mdx */.kt)("pre",null,(0,esm/* mdx */.kt)("code",{parentName:"pre","className":"language-kotlin"},`import com.theagilemonkeys.ellmental.semanticsearch.*

context(SemanticSearch)
suspend fun doSomething() {
    learn("Hello world!", embedding)
    val similarEmbeddings = search("Hello world!")
    println(similarEmbeddings)
}
`)))));};MDXContent.isMDXComponent=true;

/***/ }),

/***/ 7889:
/***/ ((__unused_webpack_module, __webpack_exports__, __webpack_require__) => {

/* harmony export */ __webpack_require__.d(__webpack_exports__, {
/* harmony export */   Z: () => (__WEBPACK_DEFAULT_EXPORT__)
/* harmony export */ });
/* harmony default export */ const __WEBPACK_DEFAULT_EXPORT__ = (__webpack_require__.p + "assets/images/word2vec-b26ea4145dcd33eb10ce992de8199693.png");

/***/ })

}]);