(ns log-levels
  (:require [clojure.string :as str]))

(def regex #"\[(WARNING|ERROR|INFO)\]:[ \t\r\n]{0,}(.*)")

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (get (re-find regex (str/trim s)) 2))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (str/lower-case (get (re-find regex (str/trim s)) 1)))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (let [level (log-level s)
        msg (message s)]
    (str msg " (" level ")")))
