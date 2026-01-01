def parse_tests(file):
    tests = []
    with open(file) as f:
        content = f.read().split('---')
        for block in content:
            if not block.strip():
                continue
            parts = block.split('OUTPUT')
            inp = parts[0].replace('INPUT', '').strip()
            out = parts[1].strip()
            tests.append((inp, out))
    return tests
