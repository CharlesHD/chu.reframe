(ns chu.reframe.calculation.subs
  (:require [re-frame.core :refer [reg-sub]]
            [chu.reframe.calculation.db :as db]))


;; This is the main way to track a calculation status
;; (rf/subscribe [::status :my-calculation])
;; other kind of subscriptions are available for avoiding boilerplate
(reg-sub
 ::status
 (fn [db [_ type]]
   (get-in db [db/path type :status])))
