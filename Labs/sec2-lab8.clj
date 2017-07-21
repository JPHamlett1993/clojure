(defmacro avg [& args] `(float(/ (apply + '~args)(count '~args))))

(defmacro avg-vect [v] `(float (/ (apply + ~v) (count ~v))))

(defmacro numif [e p z n] `(if (zero? ~e) ~z (if (pos? ~e) ~p ~n)))

(defmacro (ntimes [n & body] (ntimes n '() body) ([n res body] (println n) (println res) (println body)))
 


