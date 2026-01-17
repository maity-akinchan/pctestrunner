# PCRunner - Java Practice Problem Runner

A command-line practice platform for managing and executing Java programming problems with automated testing, designed for coding labs, online judges, and practice platforms.

## 🎯 Features

- **Bundle-based Problem Management**: Store multiple problems in a single bundle file with complete metadata
- **Automatic Extraction**: Scripts to extract problems into organized directory structures
- **Interactive CLI**: Menu-driven interface to browse and practice problems
- **Automated Testing**: Execute problems against sample and hidden test cases
- **Execution Limits**: Define time and memory constraints for each problem
- **Problem Tracking**: Resume from where you left off

## 📋 Project Structure

```
pcrunner/
├── main.sh              # Main interactive CLI runner
├── extract.sh           # Bundle extraction script
├── runner/
│   ├── run.sh           # Problem execution script
│   ├── judge.py         # Test judgment logic
│   └── utils.py         # Utility functions
├── bundles/             # Bundle files (can contain multiple problems)
│   ├── bundle.txt
│   ├── bundle2.txt
│   └── ...
├── problems/            # Extracted problems directory
│   ├── problem_name/
│   │   ├── problem.txt
│   │   ├── stub.java
│   │   ├── solution.java
│   │   ├── sample_tests.txt
│   │   ├── hidden_tests.txt
│   │   └── limits.json
│   └── ...
└── editor/              # Editor configurations
    └── vimrc
```

## 🚀 Quick Start

### Prerequisites

- **Bash** shell
- **Java** 8 or higher (for running solutions)
- **Python 3** (for the judge system)
- **whiptail** (for the interactive menu)

Install whiptail on Ubuntu/Debian:
```bash
sudo apt install whiptail
```

### Setup

1. **Make scripts executable**:
   ```bash
   chmod +x main.sh extract.sh runner/run.sh
   ```

2. **Extract problems from a bundle**:
   ```bash
   ./extract.sh bundles/bundle.txt
   ```

3. **Run the interactive CLI**:
   ```bash
   ./main.sh
   ```

## 📖 Usage

### Interactive Runner (main.sh)

```bash
./main.sh
```

The menu provides:
- **Open Question**: Browse and select a problem to practice
- **Resume Last Question**: Continue where you left off
- **Exit**: Quit the program

### Manual Problem Execution

Run a specific problem directly:
```bash
./runner/run.sh problem_name
```

## 📦 Bundle Format

The bundle system allows you to store multiple problems in a single file with complete metadata. This is ideal for distributing problem sets, updating problems, or generating bulk content.

### Bundle File Structure

Each file inside a bundle is wrapped with delimiters:

```
===== FILE: <relative/path/to/file> =====
<file contents>
===== END FILE =====
```

### Complete Example

Create `bundles/bundle.txt`:

```
===== FILE: reverse_words/problem.txt =====
Reverse Words Problem

Given a string, reverse the order of words (spaces remain in original positions).

Input: "Hello World Java"
Output: "Java World Hello"
===== END FILE =====

===== FILE: reverse_words/stub.java =====
import java.util.*;

public class Solution {
    // === BEGIN USER CODE ===
    public static String reverseWords(String s) {
        return "";
    }
    // === END USER CODE ===
}
===== END FILE =====

===== FILE: reverse_words/solution.java =====
import java.util.*;

public class Solution {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) result.append(" ");
        }
        return result.toString();
    }
}
===== END FILE =====

===== FILE: reverse_words/sample_tests.txt =====
Input: "Hello World Java"
Expected Output: "Java World Hello"

Input: "a b c"
Expected Output: "c b a"

Input: "single"
Expected Output: "single"
===== END FILE =====

===== FILE: reverse_words/hidden_tests.txt =====
Input: "The Quick Brown Fox"
Expected Output: "Fox Brown Quick The"

Input: "1 2 3 4 5"
Expected Output: "5 4 3 2 1"
===== END FILE =====

===== FILE: reverse_words/limits.json =====
{
  "time_limit_ms": 1000,
  "memory_limit_mb": 128
}
===== END FILE =====
```

### Bundle File Components

Each problem folder in the bundle should contain:

| File | Purpose |
|------|---------|
| `problem.txt` | Problem statement and description |
| `stub.java` | Starting code with editable region marked by `// === BEGIN/END USER CODE ===` |
| `solution.java` | Reference solution |
| `sample_tests.txt` | Public test cases (visible to students) |
| `hidden_tests.txt` | Private test cases (for evaluation) |
| `limits.json` | Execution constraints (time and memory) |

### Test File Format

Both `sample_tests.txt` and `hidden_tests.txt` use this format:

```
Input: <input_value>
Expected Output: <expected_output>

Input: <input_value>
Expected Output: <expected_output>
```

### Execution Limits

Define constraints in `limits.json`:

```json
{
  "time_limit_ms": 1000,
  "memory_limit_mb": 128
}
```

- `time_limit_ms`: Maximum execution time in milliseconds (default: 1000)
- `memory_limit_mb`: Maximum memory usage in MB (default: 128)

## 🤖 Generate Problems with GPT

Use this prompt with ChatGPT or Claude to generate bulk problems in the bundle format. Simply specify the topics, difficulty level, and count.

### GPT Prompt Template

```
You are an expert Java problem generator for a coding practice platform. 
Generate programming problems in the following EXACT bundle format:

===== FILE: problem_name/problem.txt =====
[Problem statement]
===== END FILE =====

===== FILE: problem_name/stub.java =====
import java.util.*;

public class Solution {
    // === BEGIN USER CODE ===
    public static <return_type> <method_name>(<parameters>) {
        return <default_value>;
    }
    // === END USER CODE ===
}
===== END FILE =====

===== FILE: problem_name/solution.java =====
[Complete working solution]
===== END FILE =====

===== FILE: problem_name/sample_tests.txt =====
Input: <input>
Expected Output: <output>

Input: <input>
Expected Output: <output>

Input: <input>
Expected Output: <output>
===== END FILE =====

===== FILE: problem_name/hidden_tests.txt =====
Input: <input>
Expected Output: <output>

Input: <input>
Expected Output: <output>

Input: <input>
Expected Output: <output>
===== END FILE =====

===== FILE: problem_name/limits.json =====
{
  "time_limit_ms": 1000,
  "memory_limit_mb": 128
}
===== END FILE =====

REQUIREMENTS:
- Use snake_case for problem folder names (e.g., palindrome_checker, merge_sorted_arrays)
- Always include the exact BEGIN/END USER CODE markers
- Provide 3 sample tests and 3 hidden tests
- Ensure solutions are correct and efficient
- Set appropriate time/memory limits based on problem complexity

Generate 5 Java programming problems on the following topics:
1. String manipulation
2. Array operations
3. Basic data structures
4. Recursion
5. Basic algorithms

Difficulty: Beginner to Intermediate
Format: Bundle format (exactly as shown above)
```

### Usage Example

1. Copy the prompt above into ChatGPT or Claude
2. Replace the "Generate 5..." part with your requirements:
   ```
   Generate 3 problems on:
   - Binary search
   - Dynamic programming
   - Graph traversal
   
   Difficulty: Advanced
   ```
3. Copy the generated output into `bundles/my_problems.txt`
4. Extract: `./extract.sh bundles/my_problems.txt`
5. Run: `./main.sh`

## 🔧 Customization

### Adding Custom Editor Config

Edit `editor/vimrc` to customize the Vim editor experience for problems.

### Modifying Execution Limits

Update `limits.json` in any problem directory to change time/memory constraints:

```json
{
  "time_limit_ms": 2000,
  "memory_limit_mb": 256
}
```

## 📝 Problem Development Workflow

1. **Create bundle file** with problems in the specified format
2. **Extract problems**: `./extract.sh bundles/your_bundle.txt`
3. **Test manually**: `./runner/run.sh problem_name`
4. **Review results**: Check test outputs in the runner
5. **Refine**: Update bundle and re-extract as needed

## 🐛 Troubleshooting

| Issue | Solution |
|-------|----------|
| `whiptail not found` | Install with `sudo apt install whiptail` |
| `Permission denied` | Run `chmod +x main.sh extract.sh runner/run.sh` |
| `Java not found` | Install Java 8+: `sudo apt install default-jdk` |
| `Problem not extracting` | Check bundle format matches specification exactly |

## 📚 Additional Resources

- **Bundle Format Spec**: See [info.txt](info.txt) for detailed format documentation
- **Judge Implementation**: See [runner/judge.py](runner/judge.py) for test evaluation logic

## 📄 License

This project is open source and available for educational use.

## 🤝 Contributing

To contribute:
1. Create well-formatted problems in bundle format
2. Test extraction and execution
3. Submit bundles with documentation

---

**Happy Coding!** 🚀

For questions or issues, check the bundle format documentation and ensure all files follow the specification exactly.
