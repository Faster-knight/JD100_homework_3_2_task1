import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Address, Integer> costPerAddress = new HashMap<Address, Integer>();
        Address address1 = new Address("Россия", "Москва");
        Address address2 = new Address("Россия", "Пенза");
        Address address3 = new Address("Германия", "Берлин");

        costPerAddress.put(address1, 200);
        costPerAddress.put(address2, 200);
        costPerAddress.put(address3, 500);

        Scanner scanner = new Scanner(System.in);
        int totalCost = 0;

        while (true) {
            // ---- Создание нового заказа
            System.out.println("\nЗаполнение нового заказа.");
            System.out.print("Введите страну: ");
            String country = scanner.next();
            if (country.equalsIgnoreCase("end")) {
                break;
            }
            System.out.print("Введите город: ");
            String city = scanner.next();
            System.out.print("Введите вес (кг): ");
            int weight = scanner.nextInt();
            Address currentAddress = new Address(country, city);
            // Проверка наличия адреса в активных
            boolean in_active_address = costPerAddress.containsKey(currentAddress);
            // Решение об отказе обслуживания
            if (!in_active_address) {
                System.out.println("Доставки по этому адресу нет");
                continue;
            }
            // Расчет стоимости
            Integer costPerKg = costPerAddress.get(currentAddress);
            int deliveryCost = costPerKg * weight;
            totalCost += deliveryCost;
            System.out.println("Стоимость доставки составит: " + deliveryCost + " руб.");
            System.out.println("Общая стоимость всех доставок: " + totalCost + " руб.");
        }
        scanner.close();
    }
}
