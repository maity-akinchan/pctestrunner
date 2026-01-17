public static int binaryToDecimal(String bin) {
    int result = 0;
    for (char c : bin.toCharArray()) {
        result = result * 2 + (c - '0');
    }
    return result;
}
