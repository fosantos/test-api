(ns testapi.api
  (:gen-class)
  (:require
    [testapi.db :as db]))

(defn get-friends
  "Retrieve a list of records from friends"
  []
  (db/get-friends))

(defn add-friend
  "Add a record to friends"
  [req]
  (db/add-friend req))
