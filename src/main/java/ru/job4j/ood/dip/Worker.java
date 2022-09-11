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
    public void makingJob(Worker worker) {
        worker.doJob();
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        Job job = new Job();
        job.makingJob(worker);
    }
}
