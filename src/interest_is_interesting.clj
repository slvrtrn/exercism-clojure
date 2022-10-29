(ns interest-is-interesting)

(def balance 550.5M)
(def tax-free-percentage 2.5)

(defn interest-rate
  "Calculate the interest rate based on the specified balance.
   Returns Double"
  [balance]
  (cond
    (< balance 0) -3.213
    (and (>= balance 0) (< balance 1000)) 0.5
    (and (>= balance 1000) (< balance 5000)) 1.621
    (>= balance 5000) 2.475))

(defn annual-balance-update
  "Calculate the annual balance update, taking into account the interest rate.
   Returns BigDecimal"
  [balance]
  ;; take `abs` so it will subtract in case of negative balance update
  (let [abs-interest-rate (abs (interest-rate balance))
        interest-rate-coeff (/ (bigdec abs-interest-rate) 100M)
        update (* balance interest-rate-coeff)]
    (+ balance update)))

(defn amount-to-donate
  "Calculate how much money to donate to charities based on 
   the balance and the tax-free percentage that the government allows.
   Because you're a nice person, if your balance is positive 
   at the end of the year, you donate twice this amount to charities, 
   rounded down to the nearest whole dollar.
   Cannot donate anything if your balance is negative.
   Returns Integer"
  [balance tax-free-percentage]
  (if (> balance 0)
    (let [tax-free-coeff (/ tax-free-percentage 100M)]
      (int (* tax-free-coeff 2 balance)))
    0))