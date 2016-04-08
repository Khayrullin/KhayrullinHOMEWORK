package ru.kpfu.itis.group11506.queue;

public class Main {
    public static void main(String[] args) {
        try {


            Waiter waiter = new Waiter();
            Client[] clients = new Client[25];
            for (int i = 0; i < clients.length; i++) {
                clients[i] = new Client((int) (Math.random() * 100));
            }
            for (Client client : clients) {
                System.out.println(client.toString());
            }
            System.out.println();

            for (Client client : clients) {
                waiter.handleOrder(client);
            }

            waiter.giveToKithcen();


        } catch (Exception e) {
            e.getMessage();
            e.printStackTrace();
        }


    }
}
