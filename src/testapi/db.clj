(ns testapi.db
  (:gen-class)
  (:require [monger.core :as mg]
            [monger.collection :as mc]
            [cheshire.core :as json]
            [yaml.core :as yaml]))

(def url (-> "resources/config.yml"
             yaml/from-file
             :mongo
             :url))

(def database (-> "resources/config.yml"
                  yaml/from-file
                  :mongo
                  :database))

(def conn (mg/connect (str url database)))
(def db (mg/get-db conn database))

(defn id-to-str
  "Convert mongo ObjectId to string."
  [data]
  (if-let [id (:_id data)]
    (assoc data :_id (str id))))

(defn get-friends
  []
  (map id-to-str (mc/find-maps db "friends")))

(defn add-friend
  [req]
  (mc/insert db "friends" req)
  (mg/disconnect conn))