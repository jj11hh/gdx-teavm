
var Bullet = (() => {
  var _scriptDir = typeof document !== 'undefined' && document.currentScript ? document.currentScript.src : undefined;
  if (typeof __filename !== 'undefined') _scriptDir = _scriptDir || __filename;
  return (
function(moduleArg = {}) {

var b=moduleArg,f,g;b.ready=new Promise((a,c)=>{f=a;g=c});var k=Object.assign({},b),aa="object"==typeof window,l="function"==typeof importScripts,m="object"==typeof process&&"object"==typeof process.versions&&"string"==typeof process.versions.node,n="",p,q;
if(m){var fs=require("fs"),r=require("path");n=l?r.dirname(n)+"/":__dirname+"/";p=(a,c)=>{a=a.startsWith("file://")?new URL(a):r.normalize(a);return fs.readFileSync(a,c?void 0:"utf8")};q=a=>{a=p(a,!0);a.buffer||(a=new Uint8Array(a));return a};process.argv.slice(2);b.inspect=()=>"[Emscripten Module object]"}else if(aa||l)l?n=self.location.href:"undefined"!=typeof document&&document.currentScript&&(n=document.currentScript.src),_scriptDir&&(n=_scriptDir),0!==n.indexOf("blob:")?n=n.substr(0,n.replace(/[?#].*/,
"").lastIndexOf("/")+1):n="",p=a=>{var c=new XMLHttpRequest;c.open("GET",a,!1);c.send(null);return c.responseText},l&&(q=a=>{var c=new XMLHttpRequest;c.open("GET",a,!1);c.responseType="arraybuffer";c.send(null);return new Uint8Array(c.response)});b.print||console.log.bind(console);var t=b.printErr||console.error.bind(console);Object.assign(b,k);k=null;var u;b.wasmBinary&&(u=b.wasmBinary);var noExitRuntime=b.noExitRuntime||!0;"object"!=typeof WebAssembly&&w("no native wasm support detected");
var x,y,z=!1,A,B=[],C=[],D=[];function ba(){var a=b.preRun.shift();B.unshift(a)}var E=0,F=null,G=null;function w(a){if(b.onAbort)b.onAbort(a);a="Aborted("+a+")";t(a);z=!0;a=new WebAssembly.RuntimeError(a+". Build with -sASSERTIONS for more info.");g(a);throw a;}function H(a){return a.startsWith("data:application/octet-stream;base64,")}var I;I="data:application/octet-stream;base64,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";if(!H(I)){var J=I;I=b.locateFile?b.locateFile(J,n):n+J}
function ca(){var a=I;return Promise.resolve().then(()=>{if(a==I&&u)var c=new Uint8Array(u);else{if(H(a)){var d=a.slice(37);if("undefined"!=typeof m&&m)c=Buffer.from(d,"base64"),c=new Uint8Array(c.buffer,c.byteOffset,c.byteLength);else try{var e=atob(d),h=new Uint8Array(e.length);for(d=0;d<e.length;++d)h[d]=e.charCodeAt(d);c=h}catch(v){throw Error("Converting base64 string to bytes failed.");}}else c=void 0;if(!c)if(q)c=q(a);else throw"both async and sync fetching of the wasm failed";}return c})}
function da(a,c){return ca().then(d=>WebAssembly.instantiate(d,a)).then(d=>d).then(c,d=>{t("failed to asynchronously prepare wasm: "+d);w(d)})}function fa(a,c){return da(a,c)}var K=a=>{for(;0<a.length;)a.shift()(b)},L="undefined"!=typeof TextDecoder?new TextDecoder("utf8"):void 0,ha={a:()=>{w("OOM")}};
(function(){function a(d){y=d=d.exports;x=y.b;var e=x.buffer;b.HEAP8=new Int8Array(e);b.HEAP16=new Int16Array(e);b.HEAP32=new Int32Array(e);b.HEAPU8=A=new Uint8Array(e);b.HEAPU16=new Uint16Array(e);b.HEAPU32=new Uint32Array(e);b.HEAPF32=new Float32Array(e);b.HEAPF64=new Float64Array(e);C.unshift(y.c);E--;b.monitorRunDependencies&&b.monitorRunDependencies(E);0==E&&(null!==F&&(clearInterval(F),F=null),G&&(e=G,G=null,e()));return d}var c={a:ha};E++;b.monitorRunDependencies&&b.monitorRunDependencies(E);
if(b.instantiateWasm)try{return b.instantiateWasm(c,a)}catch(d){t("Module.instantiateWasm callback failed with error: "+d),g(d)}fa(c,function(d){a(d.instance)}).catch(g);return{}})();
var M=b._emscripten_bind_VoidPtr___destroy___0=a=>(M=b._emscripten_bind_VoidPtr___destroy___0=y.d)(a),N=b._emscripten_bind_btVector3_btVector3_0=()=>(N=b._emscripten_bind_btVector3_btVector3_0=y.e)(),O=b._emscripten_bind_btVector3_btVector3_3=(a,c,d)=>(O=b._emscripten_bind_btVector3_btVector3_3=y.f)(a,c,d),P=b._emscripten_bind_btVector3_length_0=a=>(P=b._emscripten_bind_btVector3_length_0=y.g)(a),Q=b._emscripten_bind_btVector3_getX_0=a=>(Q=b._emscripten_bind_btVector3_getX_0=y.h)(a),R=b._emscripten_bind_btVector3_getY_0=
a=>(R=b._emscripten_bind_btVector3_getY_0=y.i)(a),S=b._emscripten_bind_btVector3_getZ_0=a=>(S=b._emscripten_bind_btVector3_getZ_0=y.j)(a),T=b._emscripten_bind_btVector3_setX_1=(a,c)=>(T=b._emscripten_bind_btVector3_setX_1=y.k)(a,c),ia=b._emscripten_bind_btVector3_setY_1=(a,c)=>(ia=b._emscripten_bind_btVector3_setY_1=y.l)(a,c),ja=b._emscripten_bind_btVector3_setZ_1=(a,c)=>(ja=b._emscripten_bind_btVector3_setZ_1=y.m)(a,c),ka=b._emscripten_bind_btVector3_setValue_3=(a,c,d,e)=>(ka=b._emscripten_bind_btVector3_setValue_3=
y.n)(a,c,d,e),la=b._emscripten_bind_btVector3___destroy___0=a=>(la=b._emscripten_bind_btVector3___destroy___0=y.o)(a);b._free=a=>(b._free=y.q)(a);b._malloc=a=>(b._malloc=y.r)(a);b.___start_em_js=1078;b.___stop_em_js=1176;
b.UTF8ToString=(a,c)=>{if(a){var d=A,e=a+c;for(c=a;d[c]&&!(c>=e);)++c;if(16<c-a&&d.buffer&&L)a=L.decode(d.subarray(a,c));else{for(e="";a<c;){var h=d[a++];if(h&128){var v=d[a++]&63;if(192==(h&224))e+=String.fromCharCode((h&31)<<6|v);else{var ea=d[a++]&63;h=224==(h&240)?(h&15)<<12|v<<6|ea:(h&7)<<18|v<<12|ea<<6|d[a++]&63;65536>h?e+=String.fromCharCode(h):(h-=65536,e+=String.fromCharCode(55296|h>>10,56320|h&1023))}}else e+=String.fromCharCode(h)}a=e}}else a="";return a};var U;
G=function ma(){U||na();U||(G=ma)};
function na(){function a(){if(!U&&(U=!0,b.calledRun=!0,!z)){K(C);f(b);if(b.onRuntimeInitialized)b.onRuntimeInitialized();if(b.postRun)for("function"==typeof b.postRun&&(b.postRun=[b.postRun]);b.postRun.length;){var c=b.postRun.shift();D.unshift(c)}K(D)}}if(!(0<E)){if(b.preRun)for("function"==typeof b.preRun&&(b.preRun=[b.preRun]);b.preRun.length;)ba();K(B);0<E||(b.setStatus?(b.setStatus("Running..."),setTimeout(function(){setTimeout(function(){b.setStatus("")},1);a()},1)):a())}}
if(b.preInit)for("function"==typeof b.preInit&&(b.preInit=[b.preInit]);0<b.preInit.length;)b.preInit.pop()();na();function V(){}V.prototype=Object.create(V.prototype);V.prototype.constructor=V;V.prototype.u=V;V.v={};b.WrapperObject=V;function W(a){return(a||V).v}b.getCache=W;function X(a,c){var d=W(c),e=d[a];if(e)return e;e=Object.create((c||V).prototype);e.s=a;return d[a]=e}b.wrapPointer=X;b.castObject=function(a,c){return X(a.s,c)};b.NULL=X(0);
b.destroy=function(a){if(!a.__destroy__)throw"Error: Cannot destroy object. (Did you create it yourself?)";a.__destroy__();delete W(a.u)[a.s]};b.compare=function(a,c){return a.s===c.s};b.getPointer=function(a){return a.s};b.getClass=function(a){return a.u};function Y(){throw"cannot construct a VoidPtr, no constructor in IDL";}Y.prototype=Object.create(V.prototype);Y.prototype.constructor=Y;Y.prototype.u=Y;Y.v={};b.VoidPtr=Y;Y.prototype.__destroy__=function(){M(this.s)};
function Z(a,c,d){a&&"object"===typeof a&&(a=a.s);c&&"object"===typeof c&&(c=c.s);d&&"object"===typeof d&&(d=d.s);this.s=void 0===a?N():void 0===c?_emscripten_bind_btVector3_btVector3_1(a):void 0===d?_emscripten_bind_btVector3_btVector3_2(a,c):O(a,c,d);W(Z)[this.s]=this}Z.prototype=Object.create(V.prototype);Z.prototype.constructor=Z;Z.prototype.u=Z;Z.v={};b.btVector3=Z;Z.prototype.length=Z.prototype.length=function(){return P(this.s)};Z.prototype.getX=function(){return Q(this.s)};
Z.prototype.getY=function(){return R(this.s)};Z.prototype.getZ=function(){return S(this.s)};Z.prototype.setX=function(a){var c=this.s;a&&"object"===typeof a&&(a=a.s);T(c,a)};Z.prototype.setY=function(a){var c=this.s;a&&"object"===typeof a&&(a=a.s);ia(c,a)};Z.prototype.setZ=function(a){var c=this.s;a&&"object"===typeof a&&(a=a.s);ja(c,a)};Z.prototype.setValue=function(a,c,d){var e=this.s;a&&"object"===typeof a&&(a=a.s);c&&"object"===typeof c&&(c=c.s);d&&"object"===typeof d&&(d=d.s);ka(e,a,c,d)};
Z.prototype.__destroy__=function(){la(this.s)};


  return moduleArg.ready
}

);
})();
if (typeof exports === 'object' && typeof module === 'object')
  module.exports = Bullet;
else if (typeof define === 'function' && define['amd'])
  define([], () => Bullet);
Bullet().then(function(r){
    window.bullet = r;
    window.BulletOnInit();
});