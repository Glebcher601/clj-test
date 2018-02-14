(ns clojure-test.neural)
(require '[clojure.string :as str])

(defn cseq->intseq
  [str]
  (map #(Integer/parseInt %) (str/split str #"")))

(defn prepareData
  [prepFn & data]
  (map prepFn data))

(defn generate-weights
  "generate {number} of {value} list"
  ([value number]
   (generate-weights '() value number))
  ([list value number]
   (if (not (= number 0))
     (recur (conj list value) value (- number 1))
     list)))

(defn generate-pairs-of2vecs
  "Taskes pairs of two vector and makes vector of pairs of two corresponding elements,
  vectors must be equal length, otherwise only full pairs will be included"
  ([vector-first vector-last]
    (generate-pairs-of2vecs vector-first vector-last []))
  ([vector-first vector-last result]
   (if (or (empty? vector-first) (empty? vector-last))
     result
     (recur (rest vector-first) (rest vector-last) (concat (vector (vector (first vector-first) (first vector-last))) result))
     )))

(defn proceed
  [inputs weights bias]
  (let [result (reduce +  (map #(* (first %) (last %)) (generate-pairs-of2vecs inputs weights)))]
    (> result bias)))

(defn decrease-weights-if-errors
  "If our network commited error, decrease energized inputs' weight"
  ([input-weights-pairs]
    (map #((if (= % 1))) input-weights-pairs)
    )
  )