(ns etl
  (:require [clojure.string :as str]))

(defn to-pair
  [key value]
  [(str/lower-case value) key])

(defn transform
  [source]
  (apply hash-map
         (flatten
          (map
           (fn [[key values]]
             (map (partial to-pair key) values))
           source))))