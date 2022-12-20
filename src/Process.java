public class Process {
    public int VarisZamani;
    public int Oncelik;
    public int ProcessZamani;

    public Process(int VarisZamani, int Oncelik, int ProcessZamani) {
        this.VarisZamani = VarisZamani;
        this.Oncelik = Oncelik;
        this.ProcessZamani = ProcessZamani;
    }
    public int getVarisZamani() {
        return VarisZamani;
    }
    public int getOncelik() {
        return Oncelik;
    }
    public int getProcessZamani() {
        return ProcessZamani;
    }
    public void setVarisZamani(int VarisZamani){
        this.VarisZamani = VarisZamani;

    }
    public void setOncelik(int Oncelik){
        this.Oncelik = Oncelik;
    }
    public void setProcessZamani(int ProcessZamani){
        this.ProcessZamani = ProcessZamani;
    }
}
