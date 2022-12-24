public class Process {
    public int VarisZamani;
    public int Oncelik;
    public int ProcessZamani;
    public int id;
    public Process(int id,int VarisZamani, int Oncelik, int ProcessZamani) {
        this.VarisZamani = VarisZamani;
        this.Oncelik = Oncelik;
        this.ProcessZamani = ProcessZamani;
        this.id=id;
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
    public int getid(){return id;}

    public void setId(){this.id=id;}
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
