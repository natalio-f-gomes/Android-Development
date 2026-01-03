#!/usr/bin/env bash
set -euo pipefail



if [[ -f "gradlew" ]]; then
  git update-index --chmod=+x gradlew || true
fi

# Stage & commit any changes (message from args or timestamp)
msg="${1:-"sync: $(date -u +'%Y-%m-%d %H:%M:%S UTC')"}"
if [[ -n "$(git status --porcelain)" ]]; then
  git add -A
  git commit -m "$msg"
else
  echo "No local changes to commit."
fi

# Rebase on latest and push
git fetch origin main || true
git pull --rebase origin main || true
git push origin main

echo "Pushed to GitHub main"
