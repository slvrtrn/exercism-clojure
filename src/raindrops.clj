(ns raindrops)

(defn convert
  [num]
  (let [result
        (reduce (fn [acc [factor sound]]
                  (if (= (mod num factor) 0)
                    (str acc sound)
                    acc))
                ""
                [[3 "Pling"] [5 "Plang"] [7 "Plong"]])]
    (if (empty? result)
      (str num)
      result)))
