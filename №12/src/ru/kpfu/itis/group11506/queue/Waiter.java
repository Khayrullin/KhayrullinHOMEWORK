package ru.kpfu.itis.group11506.queue;


class Waiter {

    private Cashier[] cashiers = new Cashier[3];

    private MyPriorityQueue<Client> clients = new MyPriorityQueue<>(100);
    private MyQueue<Client> queue;


    private Kitchen kitchen = new Kitchen();


    Waiter() {
        for (int i = 0; i < cashiers.length; i++) {
            cashiers[i] = new Cashier();
        }
    }

    void handleOrder(Client client) {
        int index = (int) (Math.random() * 3);
        cashiers[index].order(client);
        if (cashiers[index].getSize() == Cashier.getMaxClientsInOneCashier()) {
            queue = cashiers[index].getClients();
            while (queue.size() > 0){
                try {
                    clients.push(queue.poll());
                } catch (QueuOutOfBoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void giveToKithcen(){
        kitchen.doJob(clients);
    }


}
