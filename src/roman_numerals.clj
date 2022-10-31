(ns roman-numerals)

(defn repeat-char
  [times char]
  (apply str (repeat (int times) char)))

(defn numerals
  [x]
  (cond
    (and (>= x 1000) (<= x 3000))
    (str (repeat-char (/ x 1000) "M") (numerals (rem x 1000)))
    (and (>= x 900) (<= x 999))
    (str "CM" (numerals (- x 900)))
    (and (>= x 500) (<= x 899))
    (let [d-and-c (str "D" (repeat-char (/ (- x 500) 100) "C"))]
      (str d-and-c (numerals (rem (- x 500) 100))))
    (and (>= x 400) (<= x 499))
    (str "CD" (numerals (- x 400)))
    (and (>= x 100) (<= x 499))
    (str (repeat-char (/ x 100) "C") (numerals (rem x 100)))
    (and (>= x 90) (<= x 99))
    (str "XC" (numerals (- x 90)))
    (and (>= x 50) (<= x 89))
    (let [l-and-x (str "L" (repeat-char (/ (- x 50) 10) "X"))]
      (str l-and-x (numerals (rem (- x 50) 10))))
    (and (>= x 40) (<= x 49))
    (str "XL" (numerals (- x 40)))
    (and (>= x 10) (<= x 39))
    (str (repeat-char (/ x 10) "X") (numerals (rem x 10)))
    (= x 9)
    "IX"
    (and (>= x 6) (<= x 8))
    (str "V" (repeat-char (- x 5) "I"))
    (= x 5)
    "V"
    (= x 4)
    "IV"
    (>= x 0)
    (repeat-char x "I")
    :else nil))

