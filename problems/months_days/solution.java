public class DateCounter {
    int day, month;
    int[] daysInMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};

    public DateCounter(int day, int month) {
        this.day = day;
        this.month = month;
    }

    public void increment() {
        day++;
        if (day > daysInMonth[month]) {
            day = 1;
            month++;
            if (month > 12) month = 1;
        }
    }

    public void print() {
        System.out.print(day + "/" + month);
    }
}
