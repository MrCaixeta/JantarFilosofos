public class Filosofo extends Thread {
    private int id;
    private Garfo garfoEsquerda;
    private Garfo garfoDireita;

    public Filosofo(int id, Garfo garfoEsquerda, Garfo garfoDireita) {
        this.id = id;
        this.garfoEsquerda = garfoEsquerda;
        this.garfoDireita = garfoDireita;
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando");
        Thread.sleep(1000);
    }

    private void comer() throws InterruptedException {
        System.out.println("Filósofo " + id + " está comendo");
        Thread.sleep(1000);
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();

                // Tenta pegar os garfos
                if (garfoEsquerda.pegar() && garfoDireita.pegar()) {
                    comer();

                    // Libera os garfos após comer
                    garfoEsquerda.liberar();
                    garfoDireita.liberar();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
