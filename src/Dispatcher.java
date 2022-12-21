import java.util.Queue;

public class Dispatcher {
    Clock clock = new Clock();
    public void OncelikliKuyrugaTasi(Queue<Process> queue) throws InterruptedException {
        while (queue.peek() != null) {
            if (clock.getTime() != queue.peek().getVarisZamani()) {
                clock.TimeArtsin();
            }
            else {
                System.out.print("Saniye: " + clock.getTime() + "   ");
                System.out.print(queue.peek().getVarisZamani() + " ");
                System.out.print(queue.peek().getOncelik() + " ");
                System.out.println(queue.peek().getProcessZamani());
                queue.remove();
            }
        }
    }
}
