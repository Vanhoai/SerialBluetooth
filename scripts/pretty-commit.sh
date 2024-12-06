#!/bin/sh

# Function to get emoji based on commit type
get_emoji() {
    local commit_type=$1
    case "$commit_type" in
        "feat")
            echo "✨" # Sparkles for new features
            ;;
        "fix")
            echo "🐛" # Bug for fixes
            ;;
        "docs")
            echo "📚" # Books for documentation
            ;;
        "style")
            echo "🎨" # Palette for style changes
            ;;
        "refactor")
            echo "🔧" # Wrench for refactoring
            ;;
        "test")
            echo "🧪" # Test tube for tests
            ;;
        "chore")
            echo "🤖" # Robot for chores
            ;;
        "perf")
            echo "🚀" # Rocket for performance improvements
            ;;
        *)
            echo "📝" # Memo for default
            ;;
    esac
}

# Check if commit message is provided
if [ $# -eq 0 ]; then
    echo "Usage: make commit -m 'type: message'"
    exit 1
fi

# Extract commit type and message
commit_type=$(echo "$1" | cut -d':' -f1)
commit_message=$(echo "$1" | cut -d':' -f2- | xargs)

# Get appropriate emoji
emoji=$(get_emoji "$commit_type")

# Construct full commit message with emoji
full_commit_message="$emoji $1"

# Perform git add and commit
git commit -m "$full_commit_message"

echo "Committed with pretty format: $full_commit_message"