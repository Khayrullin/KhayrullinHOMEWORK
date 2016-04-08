package ru.kpfu.itis.group11506.exceptions;


public class Mrx {

    public static void main(String[] args) {
        try {
            FoodDelivery foodDelivery = new FoodDelivery();
            Menu[] order = foodDelivery.doDeal();

            UserFactory userFactory = new UserFactory();
            User user = userFactory.createUser();
            System.out.println("||||||||||||||||||||");
            System.out.println("ЧЕК: ");


            for (int i = 0; i < order.length && order[i] != null; i++) {
                System.out.println("Продукт " + order[i].name() + "; цена: " + order[i].getPrice());
            }
            System.out.println(user.toString());
            System.out.println("||||||||||||||||||||");
        } catch (UserInputException e) {
            System.err.println("Ошибка пользовательского ввода: "
                    + e.getMessage());
        }



    }
}
