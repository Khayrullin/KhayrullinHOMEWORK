package ru.kpfu.itis.group11506.set;
/*
*Задание № 13.1 "SortedSet".
*Creators : Хайруллин Булат 11-506 и Филиппенко Тарас 11-506.
* В основном Хайруллин Булат реализовывал HashMap.
* Филиппенко Тарас в основном реализовывал SortedSet.
*/
public class Main {
    public static void main(String[] args) {
        LinkedSortedSet<Client> clients = new LinkedSortedSet<>(new ClientRatingComparator());
        clients.add(new Client(87, "Beriya"));
        clients.add(new Client(55, "Gitler"));
        clients.add(new Client(86, "Nikolai2"));
        clients.add(new Client(86, "Pinachet"));
        clients.add(new Client(33, "Chegevara"));
        clients.add(new Client(54, "Molotov"));

        LinkedSortedSet<Client> clients2 = new LinkedSortedSet<>(new ClientRatingComparator());
        clients2.add(new Client(73, "Stalin"));
        clients2.add(new Client(45, "Lenin"));

        clients.union(clients2);

        for (Client client : clients) {
            System.out.println(client);
        }
    }
}