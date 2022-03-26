sync:
	rsync -a deduped/solutions ark2:/srv/ox/4clojure/api/

dedupe:
	bb dedupe.clj solutions/*.json
