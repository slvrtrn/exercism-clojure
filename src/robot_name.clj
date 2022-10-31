(ns robot-name)

(defn range-A-Z
  [] (map char (range 65 91)))

;; Generate all robot names AA000 to ZZ999 in advance and then shuffle
(defn gen-robot-names
  []
  (shuffle
   (flatten (map (fn [[ch1 ch2]]
                   (map (fn [n]
                          (str ch1 ch2 (format "%03d" n)))
                        (range 0 1000)))
                 (zipmap (range-A-Z) (range-A-Z))))))

(def robot-names (gen-robot-names))
(def current-robot-id (atom 0))

(defn get-random-name
  []
  (when (> @current-robot-id (count robot-names))
    (reset! current-robot-id 0)) ;; reset if we used all the names
  (let [robot-name (get robot-names @current-robot-id)
        _ (swap! current-robot-id inc)]
    robot-name))

(defn robot
  []
  (atom {:name (get-random-name)}))

(defn robot-name
  [robot]
  (get @robot :name))

(defn reset-name
  [r]
  (swap! r assoc :name (get-random-name)))
