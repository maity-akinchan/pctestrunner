public static int invertBinary(int n) {
    int mask = 0;
    int temp = n;

    while (temp > 0) {
        mask = (mask << 1) | 1;
        temp >>= 1;
    }
    return (~n) & mask;
}
