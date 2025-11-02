package mainFolder.T2_AccesoABBDDRelacionales.A2InUpTrans;

public class mainAppA2 {

    public static void main(String[] args) {

        Comment[] temp = {
                new Comment("Hola, esto es una pregunta", 1),
                new Comment("Esta es una respuesta", 2),
                new Comment("Comentario neutro sin puntos", 0)
        };

        A2.processNewCommentsByAuthor(temp,2);

    }

}
