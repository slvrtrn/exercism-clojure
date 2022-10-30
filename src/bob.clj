(ns bob
  (:require [clojure.string :as str]))

(defn is-ascii-lowercase
  [code]
  (and (>= code 97) (<= code 122)))

(defn is-ascii-uppercase
  [code]
  (and (>= code 65) (<= code 90)))

(defn is-alphabetic
  [char]
  (let [code (int char)]
    (or (is-ascii-lowercase code) (is-ascii-uppercase code))))
;;
(defn response-for [s]
  (let [trimmed (str/trim s)]
    (if (empty? trimmed)
      "Fine. Be that way!"
      (let [alpha-count (count (filter is-alphabetic trimmed))
            upper-count (count (filter #(is-ascii-uppercase (int %)) trimmed))]
        (if (str/ends-with? trimmed "?")
          (if (and (= upper-count alpha-count) (> alpha-count 0))
            "Calm down, I know what I'm doing!"
            "Sure.")
          (if (and (= upper-count alpha-count) (> alpha-count 0))
            "Whoa, chill out!"
            "Whatever."))))))