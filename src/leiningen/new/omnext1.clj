(ns leiningen.new.omnext1
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "omnext1"))

(defn omnext1
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' omnext1 project.")
    (->files data
      ["project.clj" (render "project.clj" data)]
      [".gitignore" (render "gitignore" data)]
      [".bowerrc" (render "bowerrc" data)]
      ["resources/data/schema.edn" (render "schema.edn" data)]
      ["resources/data/initial.edn" (render "initial.edn" data)]
      ["resources/public/html/index.html" (render "index.html" data)]
      ["resources/public/js/.gitkeep" (render "gitkeep" data)]
      ["src/clj/{{sanitized}}/core.clj" (render "server.clj" data)]
      ["src/clj/{{sanitized}}/util.clj" (render "server_util.clj" data)]
      ["src/cljs/{{sanitized}}/core.cljs" (render "client.cljs" data)])))
