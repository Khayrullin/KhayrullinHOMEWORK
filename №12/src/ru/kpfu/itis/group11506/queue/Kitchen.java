package ru.kpfu.itis.group11506.queue;



class Kitchen {

    public void doJob(MyPriorityQueue myPriorityQueue){

        while (myPriorityQueue.size() > 0){
            System.out.println(myPriorityQueue.poll());

        }
    }


}
