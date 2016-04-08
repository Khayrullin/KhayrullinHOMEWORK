package ru.kpfu.itis.group11506.exceptions;


import java.util.Scanner;

 class FoodDelivery {
    private int[] inputOrder = new int[5];
    private boolean finishOrder = true;
    private Menu[] order = new Menu[inputOrder.length];


     Menu[] doDeal()
            throws UserInputException {
        Menu[] menus = Menu.values();
        System.out.println("Меню: ");
        for (Menu menu : menus) {
            System.out.println(menu + ", ЦЕНА: " + menu.getPrice() + " рублей.");
        }
        System.out.println("Какой продукт вы желаете заказать? ");
        System.out.println("Ограничение на заказ - 5 продуктов в одни руки. ");
        boolean hasOrder = false;
        for (int tryIndex = 0; tryIndex < 10 && !hasOrder; tryIndex++) {
            try {
                getOrder();
                hasOrder = true;
            } catch (UserInputException e) {
                System.err.println("Неправильный ввод данных: "
                        + e.getMessage());
            } catch (Exception e) {
                inputOrder[0] = 0;
                if (tryIndex < 9) {
                    System.err.println("Неправильный ввод данных, Введите заказ еще раз:");
                } else System.err.println("Неправильный ввод данных");
            }
        }
        if (inputOrder[0] == 0) {
            throw new UserInputException("Превышено количество неправильного ввода заказа");
        }
        for (int i = 0; i < inputOrder.length && inputOrder[i] != 0; i++) {
            if (inputOrder[i] == 1) {
                order[i] = Menu.valueOf("Doshirak");
            } else if (inputOrder[i] == 2) {
                order[i] = Menu.valueOf("Burger");
            } else order[i] = Menu.valueOf("Pizza");
        }
        return order;
    }

    private void getOrder()
            throws UserInputException {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < inputOrder.length; i++) {
            if (finishOrder) {
                System.out.println("Для заказа Введите число от 1 до 3: ");
                int orderedItem = scanner.nextInt();
                if (orderedItem < 1 || orderedItem > 3) {
                    throw new UserInputException("Неправильный заказ. Введите заказ заново");
                } else {
                    inputOrder[i] = orderedItem;
                    if (i != inputOrder.length - 1) {
                        System.out.println("Хотите что то еще? Ответьте true или false:");
                        finishOrder = scanner.nextBoolean();
                    }
                }
            }
        }
        System.out.println("Заказ получен!");
    }
}
