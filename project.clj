(defproject test-api "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/data.json "2.4.0"]
                 [ring/ring-defaults "0.3.4"]
                 [ring/ring-devel "1.9.6"]
                 [ring/ring-json "0.5.1"]
                 [compojure "1.6.3"]
                 [http-kit "2.3.0"]
                 [lynxeyes/dotenv "1.1.0"]
                 [com.novemberain/monger "3.6.0"]
                 [io.forward/yaml "1.0.11"]
                 [cheshire "5.11.0"]]
  :main ^:skip-aot testapi.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all} :dev {:main testapi.core/-dev-main}})
