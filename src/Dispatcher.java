import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Dispatcher {
    Clock clock = new Clock();

    Queue<Process> priority0 = new LinkedList<>();
    Queue<Process> priority1 = new LinkedList<>();
    Queue<Process> priority2 = new LinkedList<>();
    Queue<Process> priority3 = new LinkedList<>();
    Queue<Process> priority4 = new LinkedList<>();

    int sayac=0;
    int patlamaZamani = 0;
    public void basla(Queue<Process> processQueue)
    {
        ArrayList<String> renkler = new ArrayList();
        renkler.add("\u001B[35m");
        renkler.add("\u001B[30m");
        renkler.add("\u001B[31m");
        renkler.add("\u001B[32m");
        renkler.add("\u001B[33m");
        renkler.add("\u001B[34m");
        renkler.add("\u001B[35m");
        renkler.add("\u001B[36m");
        renkler.add("\u001B[37m");
        Random rnd = new Random();
           if(sayac==0)
           {

               System.out.println(renkler.get(rnd.nextInt(renkler.size()-1))+"Saniye: " + clock.getTime() + " PROSES BASLADI"+" ID:"+processQueue.peek().getid()+" ONCELİK:"+processQueue.peek().getOncelik()+" KALAN SURE:"+processQueue.peek().getProcessZamani());
               processQueue.peek().setProcessZamani(processQueue.peek().getProcessZamani()-1);
               processQueue.peek().setProcessIsWorking(1);
                sayac=1;
           }
           else if (processQueue.peek() != null){
            if(processQueue.peek().getProcessZamani() != 0){
                TimeoutKontrol(processQueue);

                if (processQueue.peek().getProcessZamani() != 0){
                    System.out.println("Saniye: " + clock.getTime() + " PROSES CALISIYOR"+" ID:"+processQueue.peek().getid()+" ONCELİK:"+processQueue.peek().getOncelik()+" KALAN SURE:"+processQueue.peek().getProcessZamani());
                    processQueue.peek().setProcessZamani(processQueue.peek().getProcessZamani()-1);
                }
            }
            else if(processQueue.peek().getProcessZamani() == 0)
            {
                TimeoutKontrol(processQueue);
                System.out.println("Saniye: " + clock.getTime() + " PROSES BITTI"+" ID:"+processQueue.peek().getid()+" ONCELİK:"+processQueue.peek().getOncelik()+" KALAN SURE:"+processQueue.peek().getProcessZamani());
                processQueue.remove();
                sayac=0;
                if(priority0.peek()==null)
                {
                    if(priority1.peek()==null)
                    {
                        if(priority2.peek()==null)
                        {
                            if(priority3.peek()==null)
                            {
                                System.out.println("TAMAMLANDI");
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

            }
        }
    }

    private void TimeoutKontrol(Queue<Process> processQueue) {
        if (processQueue.peek().getOncelik() == 0){
            if (priority1.peek() != null){
                if(priority1.peek().getProcessIsWorking() == 1){
                    if(priority1.peek().getTimeout() == 0){
                        System.out.println("Saniye: " + clock.getTime() + " PROSES ASKIDA"+" ID:"+priority1.peek().getid()+" ONCELİK:"+priority1.peek().getOncelik()+" KALAN SURE:"+priority1.peek().getProcessZamani());
                        System.out.println("Saniye: " + clock.getTime() + " PROSES BAŞLADI"+" ID:"+processQueue.peek().getid()+" ONCELİK:"+processQueue.peek().getOncelik()+" KALAN SURE:"+processQueue.peek().getProcessZamani());
                        processQueue.peek().setProcessZamani(processQueue.peek().getProcessZamani()-1);
                    }
                    priority1.peek().setTimeout(priority1.peek().getTimeout() + 1);
                    if (priority1.peek().getTimeout() == 21){
                        System.out.println("Saniye: " + clock.getTime() + " PROCESES ZAMAN ASIMI "+" ID:"+priority1.peek().getid()+" ONCELİK:" +
                                priority1.peek().getOncelik() + " KALAN SURE:" + priority1.peek().getProcessZamani());
                        priority1.remove();
                    }
                }
                else if (priority2.peek().getProcessIsWorking() == 1){
                    priority2.peek().setTimeout(priority2.peek().getTimeout() + 1);
                    if (priority2.peek().getTimeout() == 21){
                        System.out.println("Saniye: " + clock.getTime() + " PROCESES ZAMAN ASIMI "+" ID:"+priority2.peek().getid()+" ONCELİK:" +
                                priority2.peek().getOncelik() + " KALAN SURE:" + priority2.peek().getProcessZamani());
                        priority2.remove();
                    }
                }
                else if (priority3.peek().getProcessIsWorking() == 1){
                    priority3.peek().setTimeout(priority3.peek().getTimeout() + 1);
                    if (priority3.peek().getTimeout() == 21){
                        System.out.println("Saniye: " + clock.getTime() + " PROCESES ZAMAN ASIMI "+" ID:"+priority3.peek().getid()+" ONCELİK:" +
                                priority3.peek().getOncelik() + " KALAN SURE:" + priority3.peek().getProcessZamani());
                        priority3.remove();
                    }
                }
            }
        }

        else if (processQueue.peek().getOncelik() == 1){
            if (priority2.peek() != null){
                if(priority2.peek().getProcessIsWorking() == 1){
                    priority2.peek().setTimeout(priority2.peek().getTimeout() + 1);
                    if (priority2.peek().getTimeout() == 21){
                        System.out.println("Saniye: " + clock.getTime() + " PROCESES ZAMAN ASIMI "+" ID:"+priority2.peek().getid()+" ONCELİK:" +
                                priority2.peek().getOncelik() + " KALAN SURE:" + priority2.peek().getProcessZamani());
                        priority2.remove();
                    }
                }
                else if (priority3.peek().getProcessIsWorking() == 1){
                    priority3.peek().setTimeout(priority3.peek().getTimeout() + 1);
                    if (priority3.peek().getTimeout() == 21){
                        System.out.println("Saniye: " + clock.getTime() + " PROCESES ZAMAN ASIMI "+" ID:"+priority3.peek().getid()+" ONCELİK:" +
                                priority3.peek().getOncelik() + " KALAN SURE:" + priority3.peek().getProcessZamani());
                        priority3.remove();
                    }
                }
            }
        }
        else if (processQueue.peek().getOncelik() == 2) {
            if (priority3.peek() != null) {
                if (priority3.peek().getProcessIsWorking() == 1) {
                    priority3.peek().setTimeout(priority3.peek().getTimeout() + 1);
                    if (priority3.peek().getTimeout() == 21) {
                        System.out.println("Saniye: " + clock.getTime() + " PROCESES ZAMAN ASIMI " + " ID:" + priority3.peek().getid() + " ONCELİK:" +
                                priority3.peek().getOncelik() + " KALAN SURE:" + priority3.peek().getProcessZamani());
                        priority3.remove();
                    }
                }

            }
        }
    }

    public void OncelikliKuyrugaTasi(Queue<Process> queue,int sure) throws InterruptedException {

        while (sure!=-1) {

            if(queue.size()!=0)
            {
                if (clock.getTime() != queue.peek().getVarisZamani()) {

                    if(priority0.peek()==null)
                    {
                        if(priority1.peek()==null)
                        {
                            if(priority2.peek()==null)
                            {
                                if(priority3.peek()==null)
                                {
                                    System.out.println("Tamamlandı");
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
                    sure--;



                }

                else if(clock.getTime() == queue.peek().getVarisZamani()){


                    if (queue.peek().getOncelik() == 0)
                    {

                        priority0.add(new Process(queue.peek().getid(),queue.peek().getVarisZamani(),queue.peek().getOncelik(),queue.peek().getProcessZamani(),0));
                        queue.remove();
                    }
                    else if (queue.peek().getOncelik() == 1)
                    {

                        priority1.add(new Process(queue.peek().getid(),queue.peek().getVarisZamani(),queue.peek().getOncelik(),queue.peek().getProcessZamani(),0));

                        queue.remove();
                    }
                    else if (queue.peek().getOncelik() == 2)
                    {
                        priority2.add(new Process(queue.peek().getid(),queue.peek().getVarisZamani(),queue.peek().getOncelik(),queue.peek().getProcessZamani(),0));
                        queue.remove();

                    }
                    else if (queue.peek().getOncelik() == 3)
                    {
                        priority3.add(new Process(queue.peek().getid(),queue.peek().getVarisZamani(),queue.peek().getOncelik(),queue.peek().getProcessZamani(),0));
                        queue.remove();

                    }
                    else if (queue.peek().getOncelik() == 4)
                    {
                        priority4.add(new Process(queue.peek().getid(),queue.peek().getVarisZamani(),queue.peek().getOncelik(),queue.peek().getProcessZamani(),0));
                        queue.remove();

                    }

                }
            }
            else if(queue.size()==0)
            {
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
                sure--;
            }

        }


    }

}
