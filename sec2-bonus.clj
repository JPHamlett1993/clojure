(defn interl+ ([a b]
  (let [Ca (count a) Cb (count b)]
    (if (> Ca Cb)
      (interl+ (reverse a) b 0 0 '() false)
      (interl+ (reverse b) a 0 0 '() true)
    )
  ))

  ([a b aIndex bIndex res swap?]
    (let [cnta (count a) cntb (count b)]
      (if (= aIndex cnta)
        res
        (if (= cntb (inc bIndex))
          (if swap? (interl+ a b (inc aIndex) 0 (conj (conj res (nth a aIndex)) (nth b bIndex)) swap?) (interl+ a b (inc aIndex) 0 (conj (conj res (nth b bIndex)) (nth a aIndex)) swap?))
          (if swap? (interl+ a b (inc aIndex) (inc bIndex) (conj (conj res (nth a aIndex)) (nth b bIndex)) swap?) (interl+ a b (inc aIndex) (inc bIndex) (conj (conj res (nth b bIndex)) (nth a aIndex)) swap?))
        )
      )
    )
  )
)

(defn incircle [point] (let [x (first point) y (last point)] (<= (+ (* x x) (* y y)) 1)))

(defn calculate-pi [nthreads ntests] (let [run  (take ntests (repeatedly #(list (rand) (rand))))]
            (double (* 4.0 (/ (count (filter true? (flatten (pmap (fn [x] (map incircle x))
            (partition-all (Math/ceil (/ ntests nthreads)) run))))) ntests)))))
                                        
                                        
;;If I run calculate-pi multiple times, I get  a slightly different result, this is due to the nature of ;;(rand). It is close to Math/Pi. user=> (calculate-pi 4 100000)
;;3.13776
;;user=> (calculate-pi 4 1000000)
;;3.140872
;;user=> (calculate-pi 4 1000000)
;;3.140216
;;user=> (calculate-pi 4 1000000)
;;3.141668
;;user=> (calculate-pi 4 1000000)
;;3.14290”
