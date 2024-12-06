#!/bin/sh

get_icon() {
  case $1 in
    "feat") echo "✨";;   # New feature
    "fix") echo "🐛";;    # Bug fix
    "refactor") echo "♻️";;  # Code refactor
    "style") echo "🎨";;  # Code styling
    "docs") echo "📝";;   # Documentation
    "test") echo "✅";;   # Adding tests
    "chore") echo "🔧";;  # Chores
    *) echo "🌀";;        # Default icon
  esac
}

COMMIT_MESSAGE="$*"

if [[ "$COMMIT_MESSAGE" != *"-m "* ]]; then
  echo "Error: Missing commit message. Use -m to specify the message."
  exit 1
fi

TYPE=$(echo "$COMMIT_MESSAGE" | grep -oE "(-m\s+\"[a-zA-Z]+):" | cut -d'"' -f2 | cut -d':' -f1)

if [[ -z "$TYPE" ]]; then
  echo "Error: Could not extract a valid type from the commit message."
  exit 1
fi

ICON=$(get_icon "$TYPE")

NEW_MESSAGE=$(echo "$COMMIT_MESSAGE" | sed -E "s/(-m\s+\"$TYPE:)/\1 $ICON/")

echo "Running: git commit ${NEW_MESSAGE}"
eval "git commit ${NEW_MESSAGE}"

