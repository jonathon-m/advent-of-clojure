(ns advent-of-clojure.day1.solution)

(require '[clojure.string :as str])

;;   
;;     

(re-seq #"[0-9]" "treb7uchet")
(defn extract-numbers-list [line]
  (re-seq #"[0-9]" line))


(defn get-input [file-name]
  (str/split
   (slurp file-name) #"\n"))


(defn solve1 [file-name]
  (reduce +
          (map #(read-string (str/join "" %))
               (map
                (fn [n] [(first n) (last n)])
                (map
                 #(re-seq #"[0-9]" %)
                 (get-input file-name))))))

(def to-number {:one "1" :two "2" :three "3" :four "4" :five "5" :six "6" :seven "7" :eight "8" :nine "9"})

(defn solve2 [file-name]
  (reduce +
          (map #(read-string (str/join "" (if (contains? to-number %) (to-number %) %)))
               (map
                (fn [n] [(first n) (last n)])
                (map
                 #(re-seq #"[0-9,one,two,three,four,five,six,seven,eight,nine]" %)
                 (get-input file-name))))))





(solve1 "src/advent_of_clojure/day1/test.txt")

(solve1 "src/advent_of_clojure/day1/input.txt")

(solve2 "src/advent_of_clojure/day1/test.txt")




