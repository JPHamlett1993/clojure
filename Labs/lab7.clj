(defn lazy-rand [n] (lazy-seq (cons (rand-int n) (lazy-rand n))))

(defn lazy-scale [n s] (lazy-seq (cons (* (first n) s) (lazy-scale (rest n) s))))

(defn integers [start] (cons start (lazy-seq (integers (inc start)))))

(defn lazy-running-sum ([v] (lazy-running-sum v ()))
([v sofar] (lazy-seq (cons (+ (reduce + sofar) (first v)) (lazy-running-sum (rest v) (conj sofar (first v)))))))

(defn lazy-interleave ([a b] (lazy-interleave a b true))
([a b a?] (if a? (lazy-seq (cons (first a) (lazy-interleave (rest a) b false))) (lazy-seq (cons (first b) (lazy-interleave a (rest b) true))))))

(defn in? [coll elm] (some #(= elm %) coll))

(defn lazy-remove-dup ([lst] (lazy-remove-dup lst ()))
([lst sofar] (if (empty? lst) () (if (in? sofar (first lst)) (lazy-seq (lazy-remove-dup (rest lst) sofar)) (lazy-seq (cons (first lst) (lazy-remove-dup (rest lst) (conj sofar (first lst)))))))))

"Output

user=> (take 10 (lazy-rand 5))
(4 3 0 2 2 2 4 3 0 1)
user=> (take 10 (lazy-scale (lazy-rand 5) 2))
(8 8 8 2 0 4 2 4 2 8)
user=> (take 2 (lazy-running-sum (lazy-seq (integers 5))))
(5 11)
user=> (take 3 (lazy-running-sum [2 2 2 2 2 2]))
(2 4 6)
user=> (take 4 (lazy-interleave (integers 1) (lazy-rand 100)))
(1 27 2 39)
user=> (take 6 (lazy-interleave (integers 1) (lazy-rand 100)))
(1 64 2 57 3 68)
user=>  (take 3 (lazy-remove-dup '(a b a a c d)))
(a b c)
user=> (take 1 (lazy-remove-dup '(a b a a c d)))
(a)
user=> (take 6 (lazy-remove-dup '(a b a a c d)))
(a b c d)
user=> "

