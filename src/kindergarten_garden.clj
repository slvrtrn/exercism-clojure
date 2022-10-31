(ns kindergarten-garden
  (:require [clojure.string :as str]))

(defn ->plant
  [char]
  (case char
    \V :violets
    \R :radishes
    \G :grass
    \C :clover))

(def default-students
  ["Alice" "Bob" "Charlie"
   "David" "Eve" "Fred"
   "Ginny" "Harriet" "Ileana"
   "Joseph" "Kincaid" "Larry"])

(defn garden
  ([input]
   (garden input default-students))
  ([input students]
   (let [students (into [] (sort students))]
     (into {}
           (map-indexed
            (fn [idx [row1 row2]]
              (let [student (keyword (str/lower-case (students idx)))
                    plants (into [] (map #(->plant %) (concat row1 row2)))]
                [student plants]))
            (apply map vector
                   (map #(partition 2 2 %)
                        (str/split input #"\n"))))))))
