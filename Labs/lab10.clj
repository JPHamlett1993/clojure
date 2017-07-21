(defmacro car [x] `(first ~x))

(defmacro ([c then tdo else edo] (if (and (= then 'then) (= else 'else)) (if c tdo edo) (println "error")))
([c then tdo] (if (= then 'then) (if c tdo))))

(defn lazy-interleave ([a b] (lazy-interleave a b true))
([a b a?] (if a? (lazy-seq (cons (first a) (lazy-interleave (rest a) b false))) (lazy-seq (cons (first b) (lazy-interleave a (rest b) true))))))


(defn lazy-random [x] (lazy-seq (cons (rand-int x) (lazy-random x))))

(defn atomTest [] (let [num (atom 1) val @num] (swap! num inc) (println "previous " val @num)))

(defn agentTest [] (def ag (agent {})) (defn action [m key] (assoc m key 10)) 
(send ag action :b))

(defn bindingTest [] (def ^:dynamic x 1) (def ^:dynamic y 1) (binding [x 2 y 3] (set! x (+ x y))))


