(ns chu.reframe.calculation.db)

;; This is the key under whick calculations will be held in app-db
;; Change it at will if it may clash with your app-db schema
(def path ::calculation)
(def status [::failed ::started ::succeeded])
