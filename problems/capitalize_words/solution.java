public static String capitalizeWords(String s) {
    String[] parts = s.trim().split("\\s+");
    StringBuilder sb = new StringBuilder();

    for (String w : parts) {
        sb.append(Character.toUpperCase(w.charAt(0)))
          .append(w.substring(1).toLowerCase())
          .append(" ");
    }
    return sb.toString().trim();
}
