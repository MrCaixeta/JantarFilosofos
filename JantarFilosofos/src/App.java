public class App {
    public static void main(String[] args) {
        Garfo[] garfos = new Garfo[5];
        Filosofo[] filosofos = new Filosofo[5];

        // Inicializa os garfos
        for (int i = 0; i < 5; i++) {
            garfos[i] = new Garfo();
        }

        // Inicializa os filósofos
        for (int i = 0; i < 5; i++) {
            filosofos[i] = new Filosofo(i, garfos[i], garfos[(i + 1) % 5]);
            filosofos[i].start();
        }
    }
}
