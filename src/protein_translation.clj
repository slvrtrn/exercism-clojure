(ns protein-translation)

(def codon-to-protein
  {"AUG" "Methionine"
   "UUU" "Phenylalanine"
   "UUC" "Phenylalanine"
   "UUA" "Leucine"
   "UUG" "Leucine"
   "UCU" "Serine"
   "UCC" "Serine"
   "UCA" "Serine"
   "UCG" "Serine"
   "UAU" "Tyrosine"
   "UAC" "Tyrosine"
   "UGU" "Cysteine"
   "UGC" "Cysteine"
   "UGG" "Tryptophan"
   "UAA" "STOP"
   "UAG" "STOP"
   "UGA" "STOP"})

(defn translate-codon
  [codon]
  (get codon-to-protein codon))

(defn translate-rna
  [rna]
  (reduce
   (fn [acc codon]
     (let [codon (codon-to-protein (apply str codon))]
       (if (= codon "STOP")
         (reduced acc)
         (conj acc codon))))
   []
   (partition 3 3 rna)))
