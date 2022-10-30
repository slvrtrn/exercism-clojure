(ns anagram
  (:require [clojure.string :as str]))

(defn sort-by-chars
  [word]
  (sort (str/lower-case word)))

(defn anagrams-for
  [word prospect-list]
  (let [sorted (sort-by-chars word)]
    (filter
     #(and (not (.equalsIgnoreCase word %)) (= sorted (sort-by-chars %)))
     prospect-list)))