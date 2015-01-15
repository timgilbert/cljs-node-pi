try {
    require("source-map-support").install();
} catch(err) {
}
require("./out/goog/bootstrap/nodejs.js");
require("./out/cljs_node_pi.js");
goog.require("cljs_node_pi.core");
goog.require("cljs.nodejscli");
