#!/bin/bash

PROBLEMS_DIR="problems"
RUNNER="./runner/run.sh"
LAST_FILE=".last_problem"

# Ensure whiptail exists
command -v whiptail >/dev/null 2>&1 || {
  echo "❌ whiptail not found. Install with: sudo apt install whiptail"
  exit 1
}

while true; do
  CHOICE=$(whiptail \
    --title "Java Practice CLI Runner" \
    --menu "Choose an option" \
    15 60 5 \
    "1" "Open Question" \
    "2" "Resume Last Question" \
    "3" "Exit" \
    3>&1 1>&2 2>&3)

  exit_status=$?

  # User pressed ESC
  [ $exit_status -ne 0 ] && exit 0

  case "$CHOICE" in
    1)
      # Build dynamic question list
      MENU_ITEMS=()
      for d in "$PROBLEMS_DIR"/*/; do
        name=$(basename "$d")
        MENU_ITEMS+=("$name" "")
      done

      PROBLEM=$(whiptail \
        --title "Select Question" \
        --menu "Available problems" \
        20 70 10 \
        "${MENU_ITEMS[@]}" \
        3>&1 1>&2 2>&3)

      [ $? -ne 0 ] && continue

      echo "$PROBLEM" > "$LAST_FILE"
      clear
      $RUNNER "$PROBLEM"
      ;;

    2)
      if [ ! -f "$LAST_FILE" ]; then
        whiptail --msgbox "No previous question found." 8 40
        continue
      fi

      PROBLEM=$(cat "$LAST_FILE")

      if [ ! -d "$PROBLEMS_DIR/$PROBLEM" ]; then
        whiptail --msgbox "Last problem no longer exists." 8 45
        continue
      fi

      clear
      $RUNNER "$PROBLEM"
      ;;

    3)
      exit 0
      ;;
  esac
done
