public class Coche {
    private static int cuentaCoche = 1;
    private int id;
    private String marca;
    private String modelo;
    private String cilindrada;

    public Coche(String nombre, String creador, String ciudad) {
        id = cuentaCoche;
        this.marca = nombre;
        this.modelo = creador;
        this.cilindrada = ciudad;
        cuentaCoche++;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(String cilindrada) {
        this.cilindrada = cilindrada;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cilindrada='" + cilindrada + '\'' +
                '}';
    }
}
