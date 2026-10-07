public class Subscriber {
    String name, plan;
    long id, phone;
    int freeCalls, extraMinutes;
    double packageCost, extraCost, tax = 10;

    void getSubscriberDetails() {
        System.out.println(name + " " + id + " " + phone);
        System.out.println(plan + " " + packageCost);
    }

    public static void main(String[] args) {
        MobileSubscriber m = new MobileSubscriber();

        m.name = "Gagan";
        m.id = 101;
        m.phone = 9876543210L;
        m.plan = "Postpaid";
        m.packageCost = 499;
        m.extraMinutes = 20;
        m.extraCost = 2;
        m.roamingMinutes = 10;
        m.roamingCost = 3;

        m.getSubscriberDetails();
        m.calculateBill();

        LandLineSubscriber l = new LandLineSubscriber();

        l.name = "Rahul";
        l.id = 102;
        l.phone = 9876543211L;
        l.plan = "Landline";
        l.packageCost = 399;
        l.extraMinutes = 20;
        l.extraCost = 1;
        l.stdMinutes = 30;
        l.stdCost = 2;

        l.getSubscriberDetails();
        l.calculateBill();
    }
}

class MobileSubscriber extends Subscriber {
    int roamingMinutes;
    double roamingCost;

    @Override
    void getSubscriberDetails() {
        super.getSubscriberDetails();
        System.out.println("Roaming Minutes: " + roamingMinutes);
    }

    void calculateBill() {
        double bill = packageCost +
                      (extraMinutes * extraCost) +
                      (roamingMinutes * roamingCost);

        bill = bill + (bill * tax / 100);

        System.out.println("Mobile Bill = " + bill);
    }
}

class LandLineSubscriber extends Subscriber {
    int stdMinutes;
    double stdCost;

    @Override
    void getSubscriberDetails() {
        super.getSubscriberDetails();
        System.out.println("STD Minutes: " + stdMinutes);
    }

    void calculateBill() {
        double bill = packageCost +
                      (extraMinutes * extraCost) +
                      (stdMinutes * stdCost);

        bill = bill + (bill * tax / 100);

        System.out.println("Landline Bill = " + bill);
    }
}
