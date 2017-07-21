(defn combine [a b] (distinct (concat a b)))

(defn same-elements? [a b] (let [c (count (combine (set a) (set b)))] (and (= (count (set a)) c) (= (count (set b)) c))))

(defn sum-harmonic [n] (if (zero? n) 0 (+ (/ n) (sum-harmonic (dec n)))))

(defn collect ([lst n] (collect lst n '())) ([lst n res] (if (empty? lst) (reverse res) (collect (drop n lst) n (conj res (take n lst))))))

(defn interleave ([a b] (interleave a b '())) ([a b res] (if (and (empty? a) (empty? b)) (reverse (filter (fn [x] (and (not (nil? x)))) res)) (interleave (rest a) (rest b) (conj res (first a) (first b))))))

(let [secret (atom "mistery")] (defn read-secret [] secret) (defn multiply-secret [n] (swap! secret (fn [x] (repeat n x)))))
