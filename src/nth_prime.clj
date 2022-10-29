(ns nth-prime)

(defn is-prime
  [n]
  (if (<= n 1)
    false
    ;; don't need to traverse the entire range,
    ;; so we get O(sqrt(N)) complexity instead of O(N)
    (let [upper-bound (inc (int (Math/sqrt n)))]
      boolean (not (some #(== (rem n %) 0) (range 2 upper-bound))))))

(defn nth-prime
  "Returns the prime number in the nth position."
  [n]
  (if (<= n 0)
    (throw (IllegalArgumentException. "N should be at least 1"))
    (nth (filter #(is-prime %) (range)) (dec n))))
