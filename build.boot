(def +version+ "0.0.1")

(set-env!
 :source-paths #{"src"}
 :target-path "tmp"
 :dependencies '[[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.9.946"]
                 [org.clojure/tools.reader "1.2.1"]
                 [re-frame "0.10.5"]
                 [adzerk/bootlaces "0.1.13" :scope "test"]
                 [adzerk/boot-test "1.2.0" :scope "test"]
                 [adzerk/boot-cljs "2.1.4" :scope "test"]])


(require '[adzerk.bootlaces :refer :all])
(require '[adzerk.boot-test :refer :all])
(require '[adzerk.boot-cljs :refer [cljs]])

(task-options!
 pom {:project 'chu.trajectory
      :version +version+
      :description "re-frame general utilities I often use"}
 jar {:manifest {"Foo" "bar"}})

(bootlaces! +version+)

(deftask testing
  "Profile setup for running tests."
  []
  (set-env! :source-paths #(conj % "test"))
  identity)
