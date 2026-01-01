import subprocess
import time
import json
import sys
from utils import parse_tests

# ---------------------------------------------
# Args:
# judge.py <problem_name> <coding_time> <sample|hidden>
# ---------------------------------------------
if len(sys.argv) < 4:
    print("❌ Usage: judge.py <problem_name> <coding_time> <sample|hidden>")
    sys.exit(1)

problem = sys.argv[1]
coding_time = int(sys.argv[2])
mode = sys.argv[3]   # "sample" or "hidden"

# ---------------------------------------------
# Paths
# ---------------------------------------------
prob_dir = f"problems/{problem}"
sub_dir = f"submissions/{problem}"

# ---------------------------------------------
# Load limits
# ---------------------------------------------
try:
    with open(f"{prob_dir}/limits.json") as f:
        limits = json.load(f)
except FileNotFoundError:
    print("❌ limits.json not found")
    sys.exit(1)

TLE = limits["time_limit_ms"] / 1000.0
MLE_MB = limits["memory_limit_mb"]

# ---------------------------------------------
# Select test file
# ---------------------------------------------
test_file = (
    f"{prob_dir}/sample_tests.txt"
    if mode == "sample"
    else f"{prob_dir}/hidden_tests.txt"
)

# ---------------------------------------------
# Compile
# ---------------------------------------------
compile_proc = subprocess.run(
    ["javac", "Solution.java"],
    cwd=sub_dir,
    capture_output=True,
    text=True
)

if compile_proc.returncode != 0:
    print("❌ Compilation Error:\n")
    print(compile_proc.stderr)
    sys.exit(1)

# ---------------------------------------------
# Load tests
# ---------------------------------------------
tests = parse_tests(test_file)

passed = 0
total = len(tests)
total_exec_time = 0.0
failures = []

# ---------------------------------------------
# Run tests
# ---------------------------------------------
for i, (inp, expected) in enumerate(tests, start=1):
    try:
        start = time.time()

        proc = subprocess.run(
            ["java", f"-Xmx{MLE_MB}m", "Solution"],
            cwd=sub_dir,
            input=inp,
            text=True,
            capture_output=True,
            timeout=TLE
        )

        elapsed = time.time() - start
        total_exec_time += elapsed

        out = proc.stdout.strip()
        exp = expected.strip()

        if out == exp:
            passed += 1
        else:
            failures.append((i, exp, out))

    except subprocess.TimeoutExpired:
        failures.append((i, "TLE", "TLE"))

# ---------------------------------------------
# Report
# ---------------------------------------------
print("\n===== RESULT =====")
print(f"Mode             : {mode.upper()}")
print(f"✔ Passed          : {passed}/{total}")
print(f"⏱️ Execution Time : {round(total_exec_time * 1000, 2)} ms")

if mode == "hidden":
    print(f"🧠 Coding Time    : {coding_time} seconds")

# ---------------------------------------------
# Show failures ONLY for sample mode
# ---------------------------------------------
if failures and mode == "sample":
    print("\n❌ Sample Test Failures:")
    for i, exp, out in failures:
        print(f"\nTestcase {i}:")
        if exp == "TLE":
            print("⏰ Time Limit Exceeded")
        else:
            print("Expected:", exp)
            print("Got     :", out)

# ---------------------------------------------
# Exit code
# ---------------------------------------------
if passed == total:
    print("\n🎉 ALL TESTS PASSED")
    sys.exit(0)
else:
    sys.exit(1)
