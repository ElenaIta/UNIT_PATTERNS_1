public class Main {
    public static void main(String[] args) {
        CreditPaymentService service = new CreditPaymentService();
        int longTime = 12; // срок кредита, месяцев

        int payment = service.calculate(9.9, 1_000_000);

        System.out.println("Ежемесячный платеж составит" + payment + "рублей");
    }


}
