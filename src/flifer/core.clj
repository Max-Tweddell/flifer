(ns flifer.core
  (:require
   [clojure.java.shell :as shell ]
   [clojure.string :as str ]
            )
  (:gen-class))


(defn convert [image-name]
  (let [image (first (str/split (first  (str/split image-name #"\.")) #"\n"))]
    (shell/sh "flif"  "-e"  "-E 100" (str  image ".png") (str image ".flif") :dir "images" ))
  )
(defn future-maker [x] (future (convert x)))
(defn get-images []
  (map future-maker (take 8
                          (str/split (:out (shell/sh "ls" :dir "images")) #"\n"))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (multi-thread))
(defn blerg [] (+ 2 2))
