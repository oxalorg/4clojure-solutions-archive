#!/usr/bin/env bb

(ns dedupe
  (:require [cheshire.core :as json]
            [clojure.java.io :as io]))

(println "Deduping files: " *command-line-args*)

(defn dedupe-solutions [m]
  (let [m* (group-by :code m)]
    (for [[k v] m*]
      (first v))))

(doseq [f *command-line-args*]
  (let [deduped-data
        (dedupe-solutions (json/parse-string (slurp f) true))]
    (spit (str "deduped/" f)
          (json/generate-string deduped-data))
    (println f " ... Done ")))
