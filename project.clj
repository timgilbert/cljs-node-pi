(defproject cljs-node-pi "0.1.0-SNAPSHOT"
  :description "Small project for running a cljs compiler and uploading the results to a rpi"
  :url "https://github.com/timgilbert/cljs-node-pi"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2665"]]

  :node-dependencies [[source-map-support "0.2.8"]]

  :plugins [[lein-cljsbuild "1.0.4"]
            [lein-npm "0.4.0"]]

  :source-paths ["src"]

  :clean-targets ["out"]

  :cljsbuild {
    :builds [{:id "cljs-node-pi"
              :source-paths ["src"]
              :notify-command ["./rsync.sh"]
              :compiler {
                :output-to "out/cljs_node_pi.js"
                :output-dir "out"
                :target :nodejs
                :optimizations :none
                :source-map true}}]})
