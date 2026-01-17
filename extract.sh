#!/usr/bin/env bash

INPUT_FILE="$1"
BASE_DIR="problems"

if [ -z "$INPUT_FILE" ]; then
  echo "Usage: ./extract.sh bundle.txt"
  exit 1
fi

current_file=""

while IFS= read -r line || [ -n "$line" ]; do
  # Match: ===== FILE: reverse_words/stub.java =====
  if [[ "$line" =~ ^=====\ FILE:\ (.+)\ =====$ ]]; then
    rel_path="${BASH_REMATCH[1]}"

    # Extract problem name (first directory)
    problem_name="${rel_path%%/*}"

    # Remove problem name from file path
    inner_path="${rel_path#*/}"

    # Final output path
    output_path="$BASE_DIR/$problem_name/$inner_path"

    mkdir -p "$(dirname "$output_path")"
    : > "$output_path"

    current_file="$output_path"

  elif [[ "$line" == "===== END FILE =====" ]]; then
    current_file=""
  else
    if [ -n "$current_file" ]; then
      echo "$line" >> "$current_file"
    fi
  fi
done < "$INPUT_FILE"
