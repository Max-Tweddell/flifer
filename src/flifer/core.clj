(ns flifer.core
  (:require
   [clojure.java.shell :as shell ]
   [clojure.string :as str ]
            )
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (multi-thread))

(defn convert [image]
  (shell/sh "flif"  "-e"  "-E 100" (str  image ".png") (str image ".flif") :dir "images" )
  )
(defn image-split [image]
  (convert (first (str/split (first  (str/split image #"\.")) #"\n"))))

(defn get-images []
  (map image-split
       (str/split (:out (shell/sh "ls" :dir "images")) #"\n")))

(defn multi-thread []
  (do
    (get-images)
    (get-images)
    (get-images)
    (get-images)
    (get-images)
    (get-images)
    (get-images))
  )
