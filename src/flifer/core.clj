(ns flifer.core
  (:require [clojure.java.shell :as shell ])
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (shell/sh "" "-aul"))

(defn convert [image]
(shell/sh flif -e image )
  )
