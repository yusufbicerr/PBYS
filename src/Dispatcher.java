import java.util.LinkedList;
import java.util.Queue;

public class Dispatcher {
    Clock clock = new Clock();

    Queue<Process> priority0 = new LinkedList<>();
    Queue<Process> priority1 = new LinkedList<>();
    Queue<Process> priority2 = new LinkedList<>();
    Queue<Process> priority3 = new LinkedList<>();
    Queue<Process> priority4 = new LinkedList<>();
    Queue<Process> anasi = new LinkedList<>();
    int sayac=0;
    public void basla(Queue<Process> processQueue)
    {

        if (processQueue.peek() != null){

            //System.out.println("Saniye: " + clock.getTime() + "BASLADI"+processQueue.peek().getProcessZamani());
            if(processQueue.peek().getProcessZamani() != 0){
                System.out.println("Saniye: " + clock.getTime() + "calisiyor"+processQueue.peek().getProcessZamani());
                processQueue.peek().setProcessZamani(processQueue.peek().getProcessZamani()-1);

                //System.out.print(priority0.peek().getVarisZamani() + " ");
            }
            else if(processQueue.peek().getProcessZamani() == 0)
            {
                System.out.println("Saniye: " + clock.getTime() + "bitti"+processQueue.peek().getProcessZamani());

                processQueue.remove();

                //System.out.println("Saniye: " + clock.getTime() + "BASLADI"+processQueue.peek().getProcessZamani());
                basla(processQueue);

            }
            //System.out.print(priority0.peek().getOncelik() + " ");
            //System.out.println(priority0.peek().getProcessZamani());
            //priority0.remove();,
        }
    }

    public void OncelikliKuyrugaTasi(Queue<Process> queue) throws InterruptedException {

        while (priority3.peek()!=null||queue.peek() != null || priority2.peek()!=null) {

            //System.out.println(priority0.size());
            if (clock.getTime() != queue.peek().getVarisZamani()) {

                if(priority0.peek()==null)
                {
                    if(priority1.peek()==null)
                    {
                        if(priority2.peek()==null)
                        {
                            if(priority3.peek()==null)
                            {
                                if(priority4.peek()==null)
                                {

                                }
                                else if(priority4.peek()!=null){
                                    basla(priority4);
                                }
                            }
                            else if(priority3.peek()!=null){
                                basla(priority3);
                            }
                        }
                        else if(priority2.peek()!=null){
                            basla(priority2);
                        }
                    }
                    else if(priority1.peek()!=null)
                    {
                        basla(priority1);
                    }

                }
                else if((priority0.peek()!=null))
                {
                    basla(priority0);
                }
                clock.TimeArtsin();




            }

            else if(clock.getTime() == queue.peek().getVarisZamani()){


                if (queue.peek().getOncelik() == 0)
                {
                    //priority0.add(queue.peek());



                    priority0.add(new Process(queue.peek().getVarisZamani(),queue.peek().getOncelik(),queue.peek().getProcessZamani()));
                    queue.remove();
                }
                else if (queue.peek().getOncelik() == 1)
                {

                    priority1.add(new Process(queue.peek().getVarisZamani(),queue.peek().getOncelik(),queue.peek().getProcessZamani()));

                    queue.remove();
                }
                else if (queue.peek().getOncelik() == 2)
                {
                    priority2.add(new Process(queue.peek().getVarisZamani(),queue.peek().getOncelik(),queue.peek().getProcessZamani()));
                    queue.remove();

                }
                else if (queue.peek().getOncelik() == 3)
                {
                    priority3.add(new Process(queue.peek().getVarisZamani(),queue.peek().getOncelik(),queue.peek().getProcessZamani()));
                    queue.remove();

                }
                else if (queue.peek().getOncelik() == 4)
                {
                    priority4.add(new Process(queue.peek().getVarisZamani(),queue.peek().getOncelik(),queue.peek().getProcessZamani()));
                    queue.remove();

                }

            }


        }


    }

}
