#CODE
(defn num-digits [n]
	(count (str n))
)

(defn power [n p]
	(if (= p 0) 1 (* n (power n (dec p))))
)

(defn lst [n res]
	(if (= (count res) n) res
		(lst n (conj res n))
	)
)

(defn to-dec [n base]
	(reduce + (map * (map power (lst base []) (reverse (range 0 base))) n))	
)

(defn get-digit [n s c]
	(if (< n s) c (get-digit (- n s) s (inc c)))
)

(defn trim [n]
	(if (not= (first n) 0) n (trim (rest n)))
)

(defn from-dec 
	([n base] (from-dec [] n base (map power (lst base []) (reverse (range 0 base)))))
	([res n base factors] 
		(if (= n 0) (trim res)	
		(from-dec (conj res (get-digit n (first factors) 0)) (- n (* (first factors) (get-digit n (first factors) 0))) base (rest factors)))
))

(defn gcd [a b]
	(if (= b 0) a (gcd b (mod a b)))
)

