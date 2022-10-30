(ns acronym
  (:require [clojure.string :as str]))

(defn capitalize
  [s]
  (str (Character/toUpperCase (get s 0)) (subs s 1)))

(defn acronym
  "Converts phrase to its acronym."
  [phrase]
  (if (empty? phrase)
    ""
    (let [before-colon (apply str (take-while #(not= % \:) phrase))
          splitted (str/split before-colon #"( |-)")]
      (str/join
       (map
        (fn [word]
          (apply str (filter #(Character/isUpperCase %) (capitalize word))))
        splitted)))))
