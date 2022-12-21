import java.util.concurrent.TimeUnit;
public class Clock {
    private int timer;

    Clock() {
        timer = 0;
    }

    public void TimeArtsin() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        timer++;
    }


    public int getTime(){
        return timer;
    }

    public void setTime(int timer){
        this.timer = timer;
    }
}
