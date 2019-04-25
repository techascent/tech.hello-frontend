(defproject tech.hello-frontend "0.1.0-SNAPSHOT"
  :description "A component built on the TechAscent stack which can be embedded into a larger React app."
  :url "https://github.com/techascent/tech.hello-frontend"
  :license {:name "Copyright 2019, TechAscent, LLC."
            :url "http://techascent.com"}

  :min-lein-version "2.7.1"

  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [reagent "0.8.1"]]

  :plugins [[lein-figwheel "0.5.16"]
            [lein-cljsbuild "1.1.7" :exclusions [[org.clojure/clojure]]]]

  :source-paths ["src"]

  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src"]
                :figwheel {:on-jsload "tech.hello-frontend.core/on-js-reload"}
                ;; The presence of a :figwheel configuration here
                ;; will cause figwheel to inject the figwheel client
                ;; into your build
                :compiler {:main tech.hello-frontend.core
                           :asset-path "js/out"
                           :output-to "resources/public/js/tech/hello_frontend.js"
                           :output-dir "resources/public/js/out"
                           :source-map-timestamp true
                           :preloads [devtools.preload]}}
               {:id "min"
                :source-paths ["src"]
                :compiler {:output-to "resources/public/js/tech/hello_frontend.js"
                           :main tech.hello-frontend.core
                           :optimizations :advanced
                           :pretty-print false}}]}

  :figwheel {:css-dirs ["resources/public/css"]}

  :profiles {:dev {:dependencies [[binaryage/devtools "0.9.9"]
                                  [figwheel-sidecar "0.5.16"]
                                  [cider/piggieback "0.3.1"]]
                   :source-paths ["src" "dev"]
                   :repl-options {:nrepl-middleware [cider.piggieback/wrap-cljs-repl]}
                   :clean-targets ^{:protect false} ["resources/public/js"
                                                     "figwheel_server.log"
                                                     :target-path]}})
