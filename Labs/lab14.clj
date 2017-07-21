(defn factorial-using-pmap [n sze] (let [lst (partition-all sze (range 1 (inc n)))] (reduce *' (pmap (fn [x] (apply *' x)) lst))))

(defn parse-text [file]
(pmap (fn [x] (apply str x)) (partition-by #(= \newline %) (slurp file)))
)

(defn find-dates [file] (filter (fn [x] (not (nil? x)))(pmap (fn [x]  (re-find #"[0-31]{2}\/[A-Z][a-z][a-z]\/[0-9]{4}" x)) (parse-text file)))
)

(defn test-dates [] "There are none" (find-dates "test.txt"))
(defn NASA-dates []  (count (find-dates "NASA_access_log_Jul95_short")))

;;Question 2 made no sense and the T.A couldn't get a hold of Gini in time
