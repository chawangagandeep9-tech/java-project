class DaysAlive {
    public static void main(String[] args) {

        int days[] = {31,28,31,30,31,30,31,31,30,31,30,31};

        int birthDay = 01;
        int birthMonth = 8;
        int birthYear = 2005;

        int currentDay = 06;
        int currentMonth = 10;
        int currentYear = 2026;

        int total = 0;

        // Calculate days for complete years
        for (int y = birthYear; y < currentYear; y++) {
            total = total + 365;

            if (y % 4 == 0)
                total++;
        }

        // Add days of current year
        for (int m = 0; m < currentMonth - 1; m++)
            total = total + days[m];

        // Subtract days before birth month
        for (int m = 0; m < birthMonth - 1; m++)
            total = total - days[m];

        total = total + currentDay - birthDay;

        System.out.println("Days alive = " + total);
    }
}