(ns pangram
  (:require [clojure.string :as str]))

(defn is-ascii-lowercase
  [code]
  (and (>= (int code) 97) (<= (int code) 122)))

(defn filter-lowercase-ascii
  [s]
  (filter is-ascii-lowercase (str/lower-case s)))

(defn pangram?
  [s]
  (= (count (into #{} (char-array (filter-lowercase-ascii s)))) 26))
