(ns clojure-test.excs)

;(println (= "HELLO WORLD" (.toUpperCase "hello world")))

;(println (map #(+ % 5) '(1 2 3)))

;(print (apply str (re-seq #"[A-Z]+" "bA1B3Ce ")))


;(defn titleize [title] (str title "=__="))

;(println (map titleize #{"a" "b"}))

;(def sum #(reduce + %))

;(def avg #(/ (sum %) (count %)))

;(defn stats
;  [numbers]
; (map #(% numbers) [sum count avg])
; )

;(println (reduce (fn [new-map [key val]] (assoc new-map key (+ val 2)))
;      {}
;                {:a 1, :b 2, :c 3, :d 4, :e 5}
;         ))

;(defn null-key [key_ map_] (and (contains? map_ key_) (nil? (get map_ key_))))
;(println (null-key :a {:b 2, :c 3, :d nil, :e 5}))
;(println (null-key :b {:b 2, :c 3, :d nil, :e 5}))
;(println (null-key :d {:b 2, :c 3, :d nil, :e 5}))

;(defn infix [args]
;  []
;  (infix )
;  [expr rest]
;  ())

;(print
;   (loop [x 5
;          result []]
;     (if (> x 0)
;       (recur (dec x) (conj result (+ 2 x)))
;       result)))


;(= (reduce + (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))
;   (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (reduce +)) 11)

;(def keys_ [:a :b :c :d])
;(def map_ {:a 1 :b 2 :c 3})
;(def res (map #(% map_) keys_))
;
;(println res)

;(def locations [{:lat 12 :lng 45}, {:lat 32 :lng 98}, {:lat 65 :lng 43}, {:lat 23 :lng 21}])
;(def min-location {:lat 12 :lng 21})

;(def merged-locs (map #(merge-with - % min-location) locations))
;(println merged-locs)


;(defmacro code-critic
;  "Sample macro"
;  [bad good]
;  `(do
;        (println
;              "Too bad:"
;              (quote ~bad))
;        (println
;              "Dat's goot:"
;              (quote ~good))))



