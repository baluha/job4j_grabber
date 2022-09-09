package ru.job4j.ood.dip;
/*Класс Job напрямую зависит от класса Worker.
Снова нет зависимоти от абстракции
*/
public class Worker {
    public void doJob() {
        System.out.println("Im working");
    }
}

class Job {
    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.doJob();
    }
}
