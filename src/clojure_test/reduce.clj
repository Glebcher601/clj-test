(ns clojure-test.reduce)

(defn _reduce
  [f initial coll]
  (loop [result initial
         remaining coll]
    (if (empty? remaining)
      result
      (recur (f result (first remaining)) (rest remaining))))
  ([f [head & tail]]
    (_reduce f head tail)))