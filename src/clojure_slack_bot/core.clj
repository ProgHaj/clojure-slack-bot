(ns clojure-slack-bot.core
  (:require [clj-http.client :as client]
            [clojure.data.json :as json]
            [clj-slack-client
             [core :as slack]
             [team-state :as state]
             [web :as web]]))


(def api :xoxb-13491383985-dyqhP898bcZLvTgrAbnEQdFa)
(def https "https://hooks.slack.com/services/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")



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
  (recur [coll coll]
         (if (empty? coll)
           true
           (do (send-slack-niklas988
                https (first coll))
               ( [](rest coll))))))
