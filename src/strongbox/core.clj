(ns strongbox.core
  (:gen-class)
  (:use seesaw.core
        seesaw.chooser
        clojure.java.shell
        clojure.pprint
        clojure.java.shell))


(def target-file (atom nil))
(defn set-target-file [arg]
  (swap! target-file (constantly arg)))

(defn run-gpg [filename]
  (sh "gpg" "-c" (str filename)))

(defn bind-listener [frame]
  (listen (select frame [:#chooser])
          :mouse-clicked (fn [e]
                           (choose-file
                            :type "Select"
                            :multi? nil
                            :success-fn (fn [fc file]
                                          (let  [filename (.getAbsolutePath file)]
                                            (set-target-file filename)
                                            (text! (select frame [:#selected-file])
                                                   (cl-format nil "Selected file: ~a" filename)))))))
  (listen (select frame [:#crypt])
          :mouse-clicked (fn [e]
                           (run-gpg @target-file)))
  frame)
(defn make-main-frame []
  (let [main-frame (frame :title "Strongbox 1.0",
                          :id :main-frame
                          :minimum-size [640 :by 200]
                          :content (border-panel
                                    :vgap 5
                                    :border 10
                                    :north (button :id :chooser
                                                   :text "Choose your file")
                                    :center (label :id :selected-file
                                                   :text "Selected file: ")
                                    :south (button :id :crypt
                                                   :text "Encrypt/decrypt"))
                          :on-close :exit)]
    (bind-listener main-frame)))




(defn -main [& args]
  (invoke-later
    (-> (make-main-frame)
     pack!
     show!)))
