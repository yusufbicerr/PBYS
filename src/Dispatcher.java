import java.util.LinkedList;
import java.util.Queue;

public class Dispatcher {
    Clock clock = new Clock();

    Queue<Process> priority0 = new LinkedList<>();
    Queue<Process> priority1 = new LinkedList<>();
    Queue<Process> priority2 = new LinkedList<>();
    Queue<Process> priority3 = new LinkedList<>();
    Queue<Process> priority4 = new LinkedList<>();
    int sayac=0;
    public void OncelikliKuyrugaTasi(Queue<Process> queue) throws InterruptedException {
        while (queue.peek() != null) {

            if (clock.getTime() != queue.peek().getVarisZamani()) {
                clock.TimeArtsin();
               // OncelikliKuyruklardanTasi();
                //karsilastir();



            }

            else {
                if (queue.peek().getOncelik() == 0)
                {
                    //priority0.add(queue.peek());



                    priority0.add(new Process(queue.peek().getVarisZamani(),queue.peek().getOncelik(),queue.peek().getProcessZamani()));
                    queue.remove();
                }
                if (queue.peek().getOncelik() == 1)
                {

                    priority1.add(new Process(queue.peek().getVarisZamani(),queue.peek().getOncelik(),queue.peek().getProcessZamani()));

                    queue.remove();
                }
                if (queue.peek().getOncelik() == 2)
                {
                    priority2.add(new Process(queue.peek().getVarisZamani(),queue.peek().getOncelik(),queue.peek().getProcessZamani()));
                    queue.remove();

                }
                if (queue.peek().getOncelik() == 3)
                {
                    priority3.add(new Process(queue.peek().getVarisZamani(),queue.peek().getOncelik(),queue.peek().getProcessZamani()));
                    queue.remove();

                }
                if (queue.peek().getOncelik() == 4)
                {
                    priority4.add(new Process(queue.peek().getVarisZamani(),queue.peek().getOncelik(),queue.peek().getProcessZamani()));
                    queue.remove();

                }


            }
            if (priority0.peek() != null){
                System.out.println("içindeyim");
                if(priority0.peek().getProcessZamani() != 0){
                    System.out.print("Saniye: " + clock.getTime() + "   ");
                    //System.out.print(priority0.peek().getVarisZamani() + " ");
                    System.out.println("Proses çalışıyor" + priority0.peek().getProcessZamani());
                    priority0.peek().setProcessZamani(priority0.peek().getProcessZamani()-1);

                }
                else if(priority0.peek().getProcessZamani() == 0)
                {
                    priority0.remove();
                }
                //System.out.print(priority0.peek().getOncelik() + " ");
                //System.out.println(priority0.peek().getProcessZamani());
                //priority0.remove();,
            }
        }


    }

}
