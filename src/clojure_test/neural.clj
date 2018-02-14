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

(defn paired-reduce
  [first-seq second-seq result apply-fx]
  (if (or (empty? first-seq) (empty? second-seq))
    result
    (let [x 1]
      (println result)
      (recur (rest first-seq) (rest second-seq) (apply-fx (first first-seq) (first second-seq) result) apply-fx)
      )
    ))

(defn generate-pairs-of2vecs
  [vector-first vector-last]
  (paired-reduce vector-first vector-last []
                 (fn [elem-first elem-second result]
                   (into result (vector (vector elem-first elem-second))))))

(defn change-weights
  [inputs weights change-fx]
  (let [new-weights (paired-reduce inputs weights '()
                                   (fn [elem-first elem-second result]
                                     (conj result (if (= elem-first 1) (change-fx elem-second) elem-second))))]
    (reverse new-weights)))

(defn decrease-weights
  [inputs weights]
  (change-weights inputs weights #(- % 1)))

(defn increase-weights
  [inputs weights]
  (change-weights inputs weights #(+ % 1)))

(defn proceed
  [inputs weights bias]
  (let [result (reduce + (map #(* (first %) (last %)) (generate-pairs-of2vecs inputs weights)))]
    (> result bias)))

(defn change-weights-after-classify
  [generated-number inputs weights]
  (if (not (= generated-number 5))
    (if (proceed inputs weights 7)
      (decrease-weights inputs weights)
      weights)
    (if (not (proceed inputs weights 7))
      (increase-weights inputs weights)
      weights)
    )
  )

(defn learn-neural
  ([learn-iterations]
   (let [train-data
         (prepareData cseq->intseq
                      "111101101101111"
                      "001001001001001"
                      "111001111100111"
                      "111001111001111"
                      "101101111001001"
                      "111100111001111"
                      "111100111101111"
                      "111001001001001"
                      "111101111101111"
                      "111101111001111")
         test-data
         (prepareData cseq->intseq
                      "111100111000111"
                      "111100010001111"
                      "111100011001111"
                      "110100111001111"
                      "110100111001011"
                      "111100101001111"
                      )
         weights
         (generate-weights 0 15)]
     ))
  ([train-data weights learn-iterations]
   (if (= learn-iterations 0)
     weights
     (let [generated-number (rand-int 10)]
       (recur train-data (change-weights-after-classify generated-number (nth train-data generated-number) learn-iterations)))))
  )