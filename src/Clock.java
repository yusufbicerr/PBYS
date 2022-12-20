public class Clock {
    private int timer;

    Clock() {
        timer = 0;
    }

    public void TimeArtsin(){
        timer++;
    }

    public int getTime(){
        return timer;
    }

    public void setTime(int timer){
        this.timer = timer;
    }
}
