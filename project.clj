(defproject mvfpkey "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [
  	[org.clojure/clojure "1.6.0"] 
    [org.clojure/tools.cli "0.3.1"]
  	[org.craigandera/dynne "0.4.1"]
  	[gloss "0.2.2"]]
  :main ^:skip-aot mvfpkey.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
