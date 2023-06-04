(ns testapi.routes
  (:require
    [compojure.core :as com]
    [testapi.handlers :as handlers])
  (:gen-class))

(com/defroutes app-routes
               (com/GET "/" [] handlers/echo-route)
               (com/GET "/friends" [] handlers/get-friends-route)
               (com/POST "/friends" [] handlers/add-friend-route))
