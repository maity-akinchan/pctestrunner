public static String countCharacters(String s) {
    int v = 0, c = 0, d = 0, sp = 0;
    s = s.toLowerCase();

    for (char ch : s.toCharArray()) {
        if (ch >= 'a' && ch <= 'z') {
            if ("aeiou".indexOf(ch) != -1) v++;
            else c++;
        } else if (ch >= '0' && ch <= '9') {
            d++;
        } else if (ch != ' ') {
            sp++;
        }
    }
    return v + " " + c + " " + d + " " + sp;
}
