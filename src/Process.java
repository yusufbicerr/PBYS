public class Process {
    public int VarisZamani;
    public int Oncelik;
    public int ProcessZamani;
    public int id;

    public int ProcessIsWorking;
    public int timeout;

    public Process(int id,int VarisZamani, int Oncelik, int ProcessZamani, int timeout) {
        this.VarisZamani = VarisZamani;
        this.Oncelik = Oncelik;
        this.ProcessZamani = ProcessZamani;
        this.id=id;
        this.timeout = timeout;
        this.ProcessIsWorking = 0;

    }
    public int getProcessIsWorking(){return ProcessIsWorking;}
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

    public int getTimeout(){return timeout;}

    public void setTimeout(int timeout){this.timeout = timeout;}
    public void setId(){this.id=id;}

    public void setProcessIsWorking(int processIsWorking){this.ProcessIsWorking = processIsWorking;}
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
