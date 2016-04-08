package ru.kpfu.itis.group11506.shop;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Shop {

    public void createSomeShop() {

        Product[] product = new Product[]{
                new Bicycle(), new Bicycle(), new Bicycle(),
                new RunRoad(), new RunRoad(), new RunRoad(),
                new Shirt(), new Shirt(), new Shirt(),
                new Sneakers(), new Sneakers(), new Sneakers(),
                new XBox(), new XBox(), new XBox(),
                new PlayStation(), new PlayStation(), new PlayStation(),
                new Laptop(), new Laptop(), new Laptop(),
                new PC(), new PC(), new PC(),
        };
        for (int i = 0; i < product.length; i++) {
            if (i > -1 && i < 3) {
                product[i].setName("BICYCLE");
                product[i].setPrice((int) (Math.random() * 10000 + 5000));
            } else if (i > 2 && i < 6) {
                product[i].setName("RUNROAD");
                product[i].setPrice((int) (Math.random() * 10000 + 5000));
            } else if (i > 5 && i < 9) {
                product[i].setName("SHIRT");
                product[i].setPrice((int) (Math.random() * 800 + 1000));
            } else if (i > 8 && i < 12) {
                product[i].setName("SNEAKERS");
                product[i].setPrice((int) (Math.random() * 1000 + 1000));
            } else if (i > 11 && i < 15) {
                product[i].setName("XBOX");
                product[i].setPrice((int) (Math.random() * 20000 + 5000));
            } else if (i > 14 && i < 18) {
                product[i].setName("PLAYSTATION");
                product[i].setPrice((int) (Math.random() * 20000 + 5000));
            } else if (i > 17 && i < 21) {
                product[i].setName("LAPTOP");
                product[i].setPrice((int) (Math.random() * 40000 + 20000));
            } else {
                product[i].setName("PC");
                product[i].setPrice((int) (Math.random() * 40000 + 10000));
            }
            product[i].setRating((int) (Math.random() * 3000));
        }


        Simulator[] simulator = new Simulator[]{
                (Simulator) product[0], (Simulator) product[1], (Simulator) product[2],
                (Simulator) product[3], (Simulator) product[4], (Simulator) product[5],
        };
        for (Simulator anASimulator : simulator) {
            anASimulator.setModes((int) (Math.random() * 18 + 5));
        }


        SportWear[] sportWears = new SportWear[]{
                (SportWear) product[6], (SportWear) product[7], (SportWear) product[8],
                (SportWear) product[9], (SportWear) product[10], (SportWear) product[11],
        };
        for (SportWear aSportWear : sportWears) {
            aSportWear.setBreathabilityPercent((int) (Math.random() * 101 + 1));

        }


        Consoles[] consoles = new Consoles[]{
                (Consoles) product[12], (Consoles) product[13], (Consoles) product[14],
                (Consoles) product[15], (Consoles) product[16], (Consoles) product[17],
        };
        for (Consoles aConsole : consoles) {
            aConsole.setMemory((int) (Math.random() * 1000 + 128));
        }


        Computer[] computers = new Computer[]{
                (Computer) product[18], (Computer) product[19], (Computer) product[20],
                (Computer) product[21], (Computer) product[22], (Computer) product[23],
        };
        for (Computer aComputer : computers) {
            aComputer.setVideoCardPower((int) (Math.random() * 1000 + 128));
        }


        Bicycle[] bicycles = new Bicycle[]{
                (Bicycle) simulator[0],
                (Bicycle) simulator[1],
                (Bicycle) simulator[2],
        };
        for (Bicycle aBicycle : bicycles) {
            aBicycle.setConvenienceDegree((int) (Math.random() * 100));
        }
        RunRoad[] runRoads = new RunRoad[]{
                (RunRoad) simulator[3],
                (RunRoad) simulator[4],
                (RunRoad) simulator[5],
        };
        for (RunRoad aRunRoad : runRoads) {
            aRunRoad.setCompactnessDegree((int) (Math.random() * 100));
        }
        Shirt[] shirts = new Shirt[]{
                (Shirt) sportWears[0],
                (Shirt) sportWears[1],
                (Shirt) sportWears[2],
        };
        for (Shirt aShirt : shirts) {
            aShirt.setCottonPercent((int) (Math.random() * 100));
        }
        Sneakers[] sneakerses = new Sneakers[]{
                (Sneakers) sportWears[3],
                (Sneakers) sportWears[4],
                (Sneakers) sportWears[5],
        };
        for (Sneakers aSneakers : sneakerses) {
            aSneakers.setWeight((int) (Math.random() * 200 + 300));
        }
        XBox[] xBoxes = new XBox[]{
                (XBox) consoles[0],
                (XBox) consoles[1],
                (XBox) consoles[2],
        };
        for (XBox aXBox : xBoxes) {
            aXBox.setGameNumber((int) (Math.random() * 200 + 100));
        }


        PlayStation[] playStations = new PlayStation[]{
                (PlayStation) consoles[3],
                (PlayStation) consoles[4],
                (PlayStation) consoles[5],
        };
        for (PlayStation aPlayStation : playStations) {
            aPlayStation.setProcessorPower((int) (Math.random() * 15 + 1));
        }


        Laptop[] laptops = new Laptop[]{
                (Laptop) computers[0],
                (Laptop) computers[1],
                (Laptop) computers[2],
        };
        for (Laptop alaptop : laptops) {
            alaptop.setWorkingTime((int) (Math.random() * 7 + 3));
        }

        PC[] pcs = new PC[]{
                (PC) computers[3],
                (PC) computers[4],
                (PC) computers[5],
        };
        for (PC aPC : pcs) {
            aPC.setEnergyConsumption((int) (Math.random() * 300 + 350));
        }
        Scanner sc = new Scanner(System.in);

        System.out.println("LIST OF GOODS");
        for (Product aProduct : product) {
            System.out.println(aProduct.toString());
        }


        System.out.println("Which category you want to sort?");
        String i;

        do {
            System.out.println("Write  down 'L' if Laptops,'B' if Bicycles, 'R' if RunRoads, 'S' if Shirts, " +
                    "'P' if PCs, 'X' if Xboxes, 'Ps' if PlayStations, 'Sn' if Sneakers:    ");
            i = sc.nextLine();
        }
        while (!(Objects.equals(i, "L") || Objects.equals(i, "l") || Objects.equals(i, "B") ||
                Objects.equals(i, "b") || Objects.equals(i, "R") || Objects.equals(i, "r") ||
                Objects.equals(i, "S") || Objects.equals(i, "s") || Objects.equals(i, "P") ||
                Objects.equals(i, "p") || Objects.equals(i, "x") || Objects.equals(i, "X") ||
                Objects.equals(i, "Ps") || Objects.equals(i, "ps") || Objects.equals(i, "Sn") ||
                Objects.equals(i, "sn")));

        if (Objects.equals(i, "L") || Objects.equals(i, "l")) {
            Arrays.sort(laptops);
            for (Laptop aLaptop : laptops) {
                System.out.println("Max Working time: " + aLaptop.getWorkingTime() + "; "
                        + "Video Card Power: "
                        + aLaptop.getVideoCardPower() + "; " + aLaptop.toString());
            }
        } else if (Objects.equals(i, "B") || Objects.equals(i, "b")) {
            Arrays.sort(bicycles);
            for (Bicycle aBicycle : bicycles) {
                System.out.println("Max convenienceDegree: " + aBicycle.getConvenienceDegree() +
                        "; " + "Max Modes: " + aBicycle.getModes() + "; " + aBicycle.toString());
            }
        } else if (Objects.equals(i, "R") || Objects.equals(i, "r")) {
            Arrays.sort(runRoads);
            for (RunRoad aRunroad : runRoads) {
                System.out.println("Max compactnessDegree: " + aRunroad.getCompactnessDegree() +
                        "; " + "Max Modes: " + aRunroad.getModes() + "; " + aRunroad.toString());
            }
        } else if (Objects.equals(i, "P") || Objects.equals(i, "p")) {
            Arrays.sort(pcs);
            for (PC aPC : pcs) {
                System.out.println("Max Working time: " + aPC.getEnergyConsumption() + "; "
                        + "Video Card Power: "
                        + aPC.getVideoCardPower() + "; " + aPC.toString());
            }
        } else if (Objects.equals(i, "S") || Objects.equals(i, "s")) {
            Arrays.sort(shirts);
            for (Shirt aShirt : shirts) {
                System.out.println("CottonPercents: " + aShirt.getCottonPercent() + "; "
                        + "Breath AbilityPercent: "
                        + aShirt.getBreathabilityPercent() + "; " + aShirt.toString());
            }
        } else if (Objects.equals(i, "Sn") || Objects.equals(i, "sn")) {
            Arrays.sort(sneakerses);
            for (Sneakers aSneakers : sneakerses) {
                System.out.println("CottonPercents: " + aSneakers.getWeight() + "; "
                        + "Breath ability Percent: "
                        + aSneakers.getBreathabilityPercent() + "; " + aSneakers.toString());
            }
        } else if (Objects.equals(i, "X") || Objects.equals(i, "x")) {
            Arrays.sort(xBoxes);
            for (XBox aXbox : xBoxes) {
                System.out.println("Max Number of Available Games: " + aXbox.getGameNumber() + "; "
                        + "Video Card Power: "
                        + aXbox.getMemory() + "; " + aXbox.toString());
            }
        } else {
            Arrays.sort(playStations);
            for (PlayStation aPlaystation : playStations) {
                System.out.println("Max Processor Power: " + aPlaystation.getProcessorPower() + "; "
                        + "Video Card Power: "
                        + aPlaystation.getMemory() + "; " + aPlaystation.toString());
            }
        }
    }
}
