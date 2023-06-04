(ns testapi.core
  (:gen-class)
  (:require
    [dotenv :refer [env app-env]]
    [compojure.core :as com]
    [compojure.route :as route]
    [org.httpkit.server :as server]
    [ring.middleware.json :as js]
    [ring.middleware.defaults :as wrap]
    [ring.middleware.reload :refer [wrap-reload]]
    [clojure.pprint :as pp]
    [clojure.string :as str]
    [clojure.data.json :as json]
    [testapi.routes :as routes]
    [yaml.core :as yaml])
  (:gen-class))

(def PORT (-> "resources/config.yml"
                  yaml/from-file
                  :server
                  :port))

(defn -main
  "Production"
  [& args]
  (let [port PORT]
    (server/run-server (js/wrap-json-params (js/wrap-json-response (wrap/wrap-defaults #'routes/app-routes wrap/api-defaults))) {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))))

(defn -dev-main
  "Dev/Test (auto reload watch enabled)"
  [& args]
  (let [port PORT]
    (server/run-server (wrap-reload (js/wrap-json-params (js/wrap-json-response (wrap/wrap-defaults #'routes/app-routes wrap/api-defaults)))) {:port port})
    (println (str "Running webserver at http:/127.0.0.1:" port "/"))))