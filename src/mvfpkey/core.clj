(ns mvfpkey.core
	(:require 
		[clojure.tools.cli :refer [parse-opts]] 
		[clojure.string :as string])
  	(:gen-class))

(def cli-options
  ;; An option with a required argument
  [
  ;["-p" "--port PORT" "Port number"
  ;  :default 80
  ;  :parse-fn #(Integer/parseInt %)
  ;  :validate [#(< 0 % 0x10000) "Must be a number between 0 and 65536"]]
   ;; A non-idempotent option
  ; ["-v" nil "Verbosity level"
  ;  :id :verbosity
  ;  :default 0
  ;  :assoc-fn (fn [m k _] (update-in m [k] inc))]
   ;; A boolean option defaulting to nil
   ["-h" "--help"]])

(defn usage [options-summary]
  (->> ["mvfpkey - generate fpkey file for provided wav."
        ""
        "Usage: mvfpkey [options] wav files"
        ""
        "Options:"
        options-summary]
       (string/join \newline)))

(defn error-msg [errors]
  (str "The following errors occurred while parsing your command:\n\n"
       (string/join \newline errors)))

(defn exit [status msg]
  (println msg)
  (System/exit status))

(defn -main
  "main function"
  [& args]
  (let [{:keys [options arguments errors summary]} (parse-opts args cli-options)]
    ;; Handle help and error conditions
    (cond
      (:help options) (exit 0 (usage summary))
      ;(not= (count arguments) 1) (exit 1 (usage summary))
      errors (exit 1 (error-msg errors)))
    ;; Execute program with options
    (println "fpkeys: arguments: " arguments)
    (exit 0 "")))
