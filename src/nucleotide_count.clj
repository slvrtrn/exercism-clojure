(ns nucleotide-count
  (:require [clojure.string :refer [includes?]]))

(def valid-nucleotides "ATCG")

(defn validate
  [strand]
  (if (includes? valid-nucleotides (str strand))
    strand
    (throw (IllegalArgumentException. "Invalid strand"))))

(defn count-of-nucleotide-in-strand
  [nucleotide strand]
  (let [_ (validate nucleotide)
        count (get (frequencies strand) nucleotide)]
    (or count 0)))

(defn nucleotide-counts
  [strand]
  (into {\A 0 \T 0 \C 0 \G 0} (frequencies strand)))
