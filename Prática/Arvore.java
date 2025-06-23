import java.util.Scanner;

class No{
	public Carro elemento;
	public No dir;
	public No esq;

	public No(Carro elemento){
		this.elemento = elemento;
		this.dir = this.esq = null;
	}
}

class ArvoreBinaria{
	public No raiz;

	public ArvoreBinaria(){
		this.raiz = null;
	}

	private No inserir(Carro x, No i){
		if(i == null){
			i = new No(x);
		}else if(x.placa.compareTo(i.elemento.placa) < 0){
			i.esq = inserir(x,i.esq);
		}else{
			i.dir = inserir(x,i.dir);
		}

		return i;
	}

	public void inserir(Carro x){
		raiz = inserir(x,raiz);
	}

	private void caminharCentral(No i){
		if(i != null){
			caminharCentral(i.esq);
			i.elemento.imprimir();
			caminharCentral(i.dir);
		}
	}

	public void caminharCentral(){
		caminharCentral(raiz);
	}
}

class Carro { 
	String placa, modelo, tipo, chassi;

	void ler(String linha) {
		String[] partes = linha.split(",");
		placa = partes[0]; 
		modelo = partes[1]; 
		tipo = partes[2]; 
		chassi = partes[3];
	}

	void imprimir() {
		System.out.println(placa + " " + modelo + " " + tipo + " " + chassi);
	}
}

public class Arvore { 
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		ArvoreBinaria ab = new ArvoreBinaria();
		String line = sc.nextLine();

		while(!line.equals("FIM")){
			Carro carro = new Carro();
			carro.ler(line);
			ab.inserir(carro);
			line = sc.nextLine();
		}

		ab.caminharCentral();
	}	 
}