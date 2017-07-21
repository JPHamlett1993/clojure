lojure 1.4.0
user=> (def mytext (slurp "test.txt"))
#'user/mytext
user=> (clojure.string/upper-case mytext)
"\"THE STRUCTURE AND INTERPRETATION OF COMPUTER PROGRAMS\"\n(SICP) IS A LITERARY MASTERPIECE.  IT'S NOT OFTEN THAT YOU CAN SAY THAT A TECHNICAL BOOK IS A PAGE-TURNER, \nBUT THAT'S JUST WHAT I FOUND SICP TO BE.  THE BOOK MOVES FROM TOPIC TO TOPIC WITH RARE EASE AND CLARITY, BUT\nMORE IMPORTANTLY IT MOVES WITH PURPOSE AND MISSION.  AS YOU READ IT, YOU CAN FEEL THE AUTHORS SLOWLY\nBUILDING A TENSION TOWARDS A CLIMAX.  THE CHAPTERS FLY BY AS YOU READ ABOUT DATA STRUCTURES, ALGORITHMS,\nMESSAGE PASSING, FIRST-CLASS PROCEDURES, AND SO MUCH ELSE.  EACH CONCEPT LEADS INEVITABLY TO THE NEXT.\nEACH CHAPTER ADDS TO THE EVER BUILDING TENSION.  BY TIME YOU ARE HALF-WAY THROUGH THE BOOK, THE SENSE THAT\nSOMETHING IMPORTANT IS ABOUT TO CHANGE BECOMES PALPABLE. \n\nAND THEN SOMETHING IMPORTANT CHANGES!  SOMETHING YOU HAD NOT ANTICIPATED.  SOMETHING YOU SHOULD HAVE\nGUESSED, BUT DID NOT.  ON PAGE 216 THEY INTRODUCE A CONCEPT SO FAMILIAR THAT MOST PROGRAMMING BOOKS START\nWITH IT.  ON PAGE 216 THEY PROVE TO YOU THAT YOU'VE HAD SOME WRONG IDEAS ABOUT PROGRAMMING ALL ALONG.  ON\nPAGE TWO HUNDRED AND SIXTEEN, AFTER TALKING ABOUT ALGORITHMS, DATA STRUCTURES, RECURSION, ITERATION, TREES,\nHIGH-ORDER PROCEDURES, SCOPING, LOCAL VARIABLES, DATA ABSTRACTION, CLOSURES, MESSAGE-PASSING, AND A\nPLETHORA OF OTHER TOPICS -- AFTER ALL THAT, THEY INTRODUCE ASSIGNMENT!\n\nAND WITH THAT ELEGANT COUP-DE-GRACE (WHICH IS NOT THE LAST IN THIS BOOK!), THEY VANQUISH THE CONCEPT THAT\nPROGRAMMING IS ABOUT MANIPULATING STATE.  WITH THAT ONE STROKE, THEY FORCE YOU TO LOOK BACK ON ALL YOU HAD\nDONE IN THE PREVIOUS PAGES IN A NEW AND ENLIGHTENED WAY -- A FUNCTIONAL WAY.\n\nTEXT FROM HTTP://THECLEANCODER.BLOGSPOT.COM/2010/08/WHY-CLOJURE.HTML\n"
user=> (spit "copy-text.txt" mytext)
nil
user=> (spit "copy-text.txt" (clojure.string/upper-case mytext))
nil
user=> (spit "copy-text.txt" "to be continued" :append true)
nil
user=> (use 'clojure.java.io)
nil
(with-open [rdr (reader "test.txt")]
  (doseq [line (line-seq rdr)]
         (println line)))
"The Structure and Interpretation of Computer Programs"
(SICP) is a literary masterpiece.  It's not often that you can say that a technical book is a page-turner, 
but that's just what I found SICP to be.  The book moves from topic to topic with rare ease and clarity, but
more importantly it moves with purpose and mission.  As you read it, you can feel the authors slowly
building a tension towards a climax.  The chapters fly by as you read about data structures, algorithms,
message passing, first-class procedures, and so much else.  Each concept leads inevitably to the next.
Each chapter adds to the ever building tension.  By time you are half-way through the book, the sense that
something important is about to change becomes palpable. 

And then something important changes!  Something you had not anticipated.  Something you should have
guessed, but did not.  On page 216 they introduce a concept so familiar that most programming books start
with it.  On page 216 they prove to you that you've had some wrong ideas about programming all along.  On
page two hundred and sixteen, after talking about algorithms, data structures, recursion, iteration, trees,
high-order procedures, scoping, local variables, data abstraction, closures, message-passing, and a
plethora of other topics -- after all that, they introduce assignment!

And with that elegant coup-de-grace (which is not the last in this book!), they vanquish the concept that
programming is about manipulating state.  With that one stroke, they force you to look back on all you had
done in the previous pages in a new and enlightened way -- a functional way.

text from http://thecleancoder.blogspot.com/2010/08/why-clojure.html
nil
user=> (with-open [wrtr (writer "newtest.txt")]
(.write wrtr "SOME LINE OF TEXT")
)
nil
