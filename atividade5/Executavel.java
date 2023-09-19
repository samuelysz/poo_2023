class Veiculo {
    private String marca;
    private String modelo;
    private int anoFabricacao;
    private int velocidade;

    public Veiculo(String marca, String modelo, int anoFabricacao) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacao = anoFabricacao;
        this.velocidade = 0;
    }

    public void acelerar(int incremento) {
        this.velocidade += incremento;
    }

    public void frear(int decremento) {
        if (this.velocidade - decremento >= 0) {
            this.velocidade -= decremento;
        } else {
            this.velocidade = 0;
        }
    }

    public void info() {
        System.out.println("Marca: " + marca + ", Modelo: " + modelo + ", Ano de Fabricação: " + anoFabricacao + ", Velocidade: " + velocidade + " km/h");
    }
}

class Carro extends Veiculo {
    private int numPortas;

    public Carro(String marca, String modelo, int anoFabricacao, int numPortas) {
        super(marca, modelo, anoFabricacao);
        this.numPortas = numPortas;
    }

    @Override
    public void info() {
        System.out.println("Carro - " + super.toString() + ", Número de Portas: " + numPortas);
    }
}

class Moto extends Veiculo {
    private int cilindrada;

    public Moto(String marca, String modelo, int anoFabricacao, int cilindrada) {
        super(marca, modelo, anoFabricacao);
        this.cilindrada = cilindrada;
    }

    @Override
    public void info() {
        System.out.println("Moto - " + super.toString() + ", Cilindrada: " + cilindrada + " cc");
    }
}

class Bicicleta extends Veiculo {
    private String tipo;

    public Bicicleta(String marca, String modelo, int anoFabricacao, String tipo) {
        super(marca, modelo, anoFabricacao);
        this.tipo = tipo;
    }

    @Override
    public void info() {
        System.out.println("Bicicleta - " + super.toString() + ", Tipo: " + tipo);
    }
}

public class Executavel {
    public static void main(String[] args) {
        Carro carro = new Carro("Toyota", "Corolla", 2022, 4);
        Moto moto = new Moto("Honda", "CBR 1000RR", 2023, 1000);
        Bicicleta bicicleta = new Bicicleta("Trek", "X-Caliber", 2021, "Mountain Bike");

        carro.info();
        moto.info();
        bicicleta.info();

        carro.acelerar(50);
        moto.acelerar(30);
        bicicleta.acelerar(10);

        System.out.println("\nAcelerando...");
        carro.info();
        moto.info();
        bicicleta.info();

        carro.frear(20);
        moto.frear(10);
        bicicleta.frear(5);

        System.out.println("\nFreando...");
        carro.info();
        moto.info();
        bicicleta.info();
    }
}
