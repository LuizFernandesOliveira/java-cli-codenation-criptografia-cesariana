public class CriptografiaCesariana implements Criptografia {

    StringBuilder messageProcessing = new StringBuilder("");
    String messageProcessed = "";
    int KEY_ENCRYPTION = 3;
    int KEY_DECRYPTION = -3;

    public void processing(String message, int key) {

        for (int index = 0; index < message.length(); index += 1) {
            char letter = message.toLowerCase().charAt(index);

            if (letter != ' ' && !Character.isDigit(letter)) {
                messageProcessing.append((char) (letter + key));
            } else {
                messageProcessing.append(letter);
            }
        }

        this.messageProcessed = this.messageProcessing.toString();

    }

    public void verifyExistExceptions(String text) {
        if (text.isEmpty()) throw new IllegalArgumentException("O texto está vazio, impossível criptografar");
        if (text == null) throw new NullPointerException("não é um texto!");
    }

    public String criptografar(String texto) {
        this.verifyExistExceptions(texto);
        processing(texto, KEY_ENCRYPTION);
        return this.messageProcessed;
    }

    public String descriptografar(String texto) {
        this.verifyExistExceptions(texto);
        processing(texto, KEY_DECRYPTION);
        return this.messageProcessed;
    }
}
