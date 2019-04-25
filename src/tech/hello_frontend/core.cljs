(ns tech.hello-frontend.core
  (:require [reagent.core :as r]))

(enable-console-print!)

(defn component
  [props]
  (fn [props]
    [:div.component
     [:div "Hello, " (:name props) "."]
     [:div (:number props) " x " (:number props) " = " (* (:number props) (:number props))]]))

(aset js/window "HelloComponent" (r/reactify-component component))

(defn on-js-reload
  []
  (r/render [component {:name "Figwheel" :number 32}] (js/document.getElementById "root")))
