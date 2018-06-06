(ns chu.reframe.calculation.events
  "This is a calculation status tracker.
   You can ::start, ::fail or ::success any kind of calculation."
  (:require [re-frame.core :refer [reg-event-db]]
            [chu.reframe.calculation.db :as db]))

(reg-event-db
 ::start
 (fn [db [_ type]]
   (assoc-in db [db/path type]
             {:status ::db/started
              :start (.getTime (js/Date.))})))

(reg-event-db
 ::fail
 (fn [db [_ type reason]]
   (-> db
       (assoc-in [db/path type :status] ::db/failed)
       (assoc-in [db/path type :fail-reason] reason)
       (assoc-in [db/path type :end] (.getTime (js/Date.))))))

(reg-event-db
 ::success
 (fn [db [_ type]]
   (-> db
       (assoc-in [db/path type :status] ::db/succeeded)
       (assoc-in [db/path type :end] (.getTime (js/Date.))))))
