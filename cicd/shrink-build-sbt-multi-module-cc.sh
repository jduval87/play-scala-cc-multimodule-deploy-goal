#!/usr/bin/env bash

grep -oP '(?<=//#CC-)([a-zA-Z0-9\-]+)' "$APP_HOME"/build.sbt | while read -r m; do
  if [ "$m" != "$MODULE" ]; then
    sed -i -r ":a;\$!{N;ba};s|lazy val $m.*//#$m||" "$APP_HOME"/build.sbt
    sed -i "s| *$m,||g" "$APP_HOME"/build.sbt
  fi
done