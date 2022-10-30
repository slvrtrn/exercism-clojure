(ns rna-transcription)

(def dna-to-rna
  {\G \C
   \C \G
   \T \A
   \A \U})

(defn get-dna-to-rna
  [dna]
  (let [rna (get dna-to-rna dna)
        _ (assert rna)]
    rna))

(defn to-rna
  [dna]
  (apply str (map get-dna-to-rna dna)))
