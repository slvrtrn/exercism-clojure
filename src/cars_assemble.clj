(ns cars-assemble)

(def cars-per-hour 221)
(defn success-rate-percent [speed]
  (/ (cond
       (= speed 10) 77
       (= speed 9) 80
       (and (>= speed 5) (<= speed 8)) 90
       (and (>= speed 1) (<= speed 4)) 100
       :else 0) 100.))

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (* speed cars-per-hour (success-rate-percent speed)))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60)))
