import java.util.ArrayList;

public class Motoca {
    private int potencia;
    private int tempo = 0;
    private int tempoComprado = 0;
    private String buzina = "";
    ArrayList <Pessoa> pessoaNaMoto = new ArrayList<>();
    
            
    public Motoca(int potencia){
        this.potencia = potencia;
        System.out.println("Criou motoca!!");
        
    }

    public Pessoa getPessoa() {
        if(pessoaNaMoto.isEmpty()){
            return null;
        }else{
            return pessoaNaMoto.get(0);
        }
    }

    public int getTempo() {
        return tempo;
    }

    public int getPotencia() {
        return potencia;
    }

    public boolean subir(Pessoa pessoa){
        if(!pessoaNaMoto.isEmpty()){
            System.out.println("Moto está lotada com " + pessoaNaMoto.get(0) + "!");
            return false;
        }else{
            pessoaNaMoto.add(pessoa);
            System.out.println(pessoa + "subiu na moto!");
            return true;
        }
    }

    public boolean descer(){
        if(pessoaNaMoto.isEmpty()){
            System.out.println("Não há pessoas na moto!!");
            return false;
        }else{
            System.out.println(pessoaNaMoto.get(0) + "deceu da moto!!");
            pessoaNaMoto.clear();
            return true;
        }
        
    }

    public void colocarTempo(int tempo){
        tempoComprado += tempo;
        System.out.println("Você comprou "+ tempo +" min. " 
                            +"Agora pode andar "
                            + tempoComprado + " min!");
    }

    public boolean dirigir(int tempo){
        if(getPessoa() == null){
            System.out.println("Um fantasma não dirige! Alguém precisa estar na moto!");
            return false;
        }
        
        if(pessoaNaMoto.get(0).getIdade() > 10){
            System.out.println("Você tem mais de 10 anos, não pode dirigir!");
            return false;
        }
        if(tempoComprado < tempo){
            System.out.println("Não pode andar "
                                + tempo + " min. "
                                + "Você comprou apenas "
                                + tempoComprado +" min!");
            return false;
        }else{
            tempoComprado -= tempo;
            this.tempo += tempo;
            System.out.println("Voce andou "
                                + this.tempo +" min! Restam "
                                + tempoComprado +" min!");
            return true;
        }
            
    }

    public String buzinar(){
        int x = getPotencia();
        if(pessoaNaMoto.isEmpty()){
            System.out.println("Fantasma não buzina! " 
                                + "Alguém tem que estar " 
                                + "na moto para buzinar!");
            return buzina;
        }else{
            buzina = "P";
            for (int i = 0; i < x; i++) {
                buzina += "e";
            }
            buzina += "m";
            System.out.println("Você buzinou " + buzina +"!");
            return buzina;
        }
        
    }
}
