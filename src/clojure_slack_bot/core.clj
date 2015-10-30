(ns clojure-slack-bot.core
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]
            [clj-slack-client
             [core :as slack]
             [team-state :as state]
             [web :as web]]))
(use 'clojure.string)




(defn send-slack
  [url text]
  (client/post url {:form-params
                    {:payload
                     (json/write-str
                      {
                       :id 1
                       :type "message"
                       :username "maakepgaming"
                       :text text
                       :icon_url "http://hydra-media.cursecdn.com/dota2.gamepedia.com/f/fb/Axe.png"
                       })}}))

(defn maakep-gaming []
  (send-slack https "<https://twitter.com/maakepGaming|This > is #maakepGaming!"))

(defn not-maakep-gaming []
  (send-slack https "That was not #maakepGaming"))


(defn send-slack-niklas988
  [url text]
  (client/post url {:form-params
                    {:payload
                     (json/write-str
                      {
                       :id 1
                       :type "message"
                       :username "niklas988-singalong-bot"
                       :text text
                       :icon_emoji ":kappa:"
                       })}}))

(defn niklas988-sing [coll]
  (loop [coll coll]
         (if (empty? coll)
           true
           (do (do  (send-slack-niklas988
                       https (first coll))
                    (Thread/sleep 2000))
               (recur (rest coll))))))

(def song (remove empty? (split-lines (slurp "resources/niklas.txt"))))
