#!/bin/bash

PROBLEM="$1"

if [ -z "$PROBLEM" ]; then
  echo "Usage: ./runner/run.sh <problem_name>"
  exit 1
fi

# Ensure whiptail exists
command -v whiptail >/dev/null 2>&1 || {
  echo "❌ whiptail not found. Install with: sudo apt install whiptail"
  exit 1
}

PROB_DIR="problems/$PROBLEM"
SUB_DIR="submissions/$PROBLEM"
EDITOR=vim

if [ ! -d "$PROB_DIR" ]; then
  whiptail --msgbox "Problem '$PROBLEM' not found." 8 45
  exit 1
fi

mkdir -p "$SUB_DIR"

# Copy stub only once
if [ ! -f "$SUB_DIR/Solution.java" ]; then
  cp "$PROB_DIR/stub.java" "$SUB_DIR/Solution.java"
fi

TOTAL_START=$(date +%s)

# Temp file for function-only editing
TMP_FUNC="/tmp/pcrunner_${PROBLEM}_func.java"

extract_user_code() {
  awk '
  /BEGIN USER CODE/ {flag=1; next}
  /END USER CODE/ {flag=0}
  flag {print}
  ' "$SUB_DIR/Solution.java" > "$TMP_FUNC"
}

inject_user_code() {
  # Remove old user code
  sed -i '/BEGIN USER CODE/,/END USER CODE/{
    /BEGIN USER CODE/!{
      /END USER CODE/!d
    }
  }' "$SUB_DIR/Solution.java"

  # Inject new user code
  sed -i "/BEGIN USER CODE/r $TMP_FUNC" "$SUB_DIR/Solution.java"
}

while true; do
  CHOICE=$(whiptail \
    --title "Problem: $PROBLEM" \
    --menu "Choose an action" \
    18 65 6 \
    "e" "Edit code (function only)" \
    "s" "Run SAMPLE tests" \
    "h" "Run HIDDEN tests" \
    "v" "View problem statement" \
    "q" "Back to main menu" \
    3>&1 1>&2 2>&3)

  # ESC pressed
  [ $? -ne 0 ] && break

  case "$CHOICE" in

    e)
      clear
      echo "✍️ Editing USER CODE only"
      echo "------------------------------------"

      extract_user_code

      # Open scratch buffer
      vim -u editor/vimrc "$TMP_FUNC"

      inject_user_code
      echo "✔ Code updated safely"
      sleep 0.5
      ;;

    s)
      clear
      echo "🧪 Running SAMPLE tests..."
      python3 runner/judge.py "$PROBLEM" 0 sample || true
      echo
      read -p "➡ Press ENTER to continue"
      ;;

    h)
      clear
      echo "🔒 Running HIDDEN tests..."
      python3 runner/judge.py "$PROBLEM" 0 hidden || true
      echo
      read -p "➡ Press ENTER to continue"
      ;;

    v)
      clear
      echo "📘 Problem Statement"
      echo "------------------------------------"
      cat "$PROB_DIR/problem.txt"
      echo "------------------------------------"
      echo
      read -p "➡ Press ENTER to continue"
      ;;

    q)
      break
      ;;
  esac
done

TOTAL_END=$(date +%s)

rm -f "$TMP_FUNC"

clear
echo "⬅ Returning to main menu"
echo "⏱️ Time spent on '$PROBLEM': $((TOTAL_END - TOTAL_START)) seconds"
sleep 1
