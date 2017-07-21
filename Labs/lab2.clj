(defn getdivisors [a b res]
  (cond (<= a 0) res
        :else (if
                (= (mod b a) 0)
                  (getdivisors (dec a) b (conj res a))
                  (getdivisors (dec a) b res)

              )
  )
)

(defn prime? [a]
	(= (count (getdivisors a a [])) 2)
)

(defn createlist [a b res]
	(cond (= a (inc b)) res
		:else (createlist (inc a) b (conj res a))
		)
)


(defn sum-primes [a b]
	(reduce + (filter prime? (range a b )))
)

(defn sum-evens [a b]
	(reduce + (filter even? (range a (inc b))))
)

(defn sum [func a b]
        (reduce + (filter func (createlist a b [])))
)

(defn 





