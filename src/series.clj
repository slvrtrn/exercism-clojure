(ns series)

(defn slices
  [string length]
  (if (> length (count string))
    []
    (if (== length 0)
      [""]
      (let [upper-bound (inc (- (count string) length))]
        (map
         #(subs string % (+ % length))
         (range 0 upper-bound))))))
