(ns all-your-base)

;; [[6 5 4 3] 7] = (6 × 7^3) + (5 × 7^2) + (4 × 7^1) + (3 × 7^0) = [[2 3 3 4] 10]
(defn to-decimal
  [digits base]
  (let [[result _]
        (reduce
         (fn
           [[sum digit-num] x]
           (if (or (> x (dec base)) (neg? x))
             (reduced [-1])
             (let [part (* x (Math/pow base digit-num))]
               [(+ part sum) (dec digit-num)])))
         [0 (dec (count digits))]
         digits)]
    (int result)))

(defn to-base
  ([num base]
   (if (= num -1)
     nil
     (if (= num 0)
       [0]
       (to-base num base ()))))
  ([num base acc]
   (if (= num 0)
     acc
     (to-base (int (/ num base)) base (cons (rem num base) acc)))))

(defn convert
  [src-base digits target-base]
  (if (and (> src-base 1) (> target-base 1))
    (if (seq digits)
      (to-base (to-decimal digits src-base) target-base)
      [])
    nil))
