public static String alternateMerge(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int i = 0;

    while (i < a.length() || i < b.length()) {
        if (i < a.length()) sb.append(a.charAt(i));
        if (i < b.length()) sb.append(b.charAt(i));
        i++;
    }
    return sb.toString();
}
