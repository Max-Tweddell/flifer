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
  (map future-maker
       (str/split (:out (shell/sh "ls" :dir "images")) #"\n")))

(defn multi-thread []
    (for [x [(range 0 5)]]
      (future-call get-images)
      )) wd
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (multi-thread))
(defn doot []
  (println "egg"))
