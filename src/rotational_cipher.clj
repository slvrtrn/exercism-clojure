(ns rotational-cipher)

(defn is-ascii-lowercase
  [code]
  (and (>= (int code) 97) (<= (int code) 122)))

(defn is-ascii-uppercase
  [code]
  (and (>= (int code) 65) (<= (int code) 90)))

(defn rotate-char [code x upper] ; 
  (char (if (> (+ (int code) x) upper)
          (+ x (- (int code) 26))
          (+ x (int code)))))

(defn normalize-rotation
  [rotation]
  (let [remainder (rem rotation 26)]
    (cond
      (pos? remainder) remainder
      (neg? remainder) (+ remainder 26)
      :else 0)))

(defn rotate [input rotation]
  (if-let
   [rotation (normalize-rotation rotation)]
    (apply str
           (map
            (fn [c]
              (cond
                (is-ascii-uppercase c) (rotate-char c rotation 90)
                (is-ascii-lowercase c) (rotate-char c rotation 122)
                :else c))
            input))
    input))
