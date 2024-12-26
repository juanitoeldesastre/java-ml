
public class Sistema {

    public static Nodo crearArbol() {
        Nodo raiz = new Nodo("Películas");

        // Categorías principales
        Nodo accion = new Nodo("Acción");
        Nodo comedia = new Nodo("Comedia");
        Nodo drama = new Nodo("Drama");
        Nodo cienciaFiccion = new Nodo("Ciencia Ficción");
        Nodo terror = new Nodo("Terror");

        // Subcategorías de Acción
        Nodo superHeroes = new Nodo("Superhéroes");
        Nodo persecuciones = new Nodo("Persecuciones");
        Nodo espias = new Nodo("Espías");

        Nodo avengers = new Nodo("Avengers: Endgame");
        Nodo batman = new Nodo("El Caballero de la Noche");
        Nodo rapidosFuriosos = new Nodo("Rápidos y Furiosos");
        Nodo missionImpossible = new Nodo("Misión Imposible");

        superHeroes.agregarHijo(avengers);
        superHeroes.agregarHijo(batman);
        persecuciones.agregarHijo(rapidosFuriosos);
        espias.agregarHijo(missionImpossible);

        accion.agregarHijo(superHeroes);
        accion.agregarHijo(persecuciones);
        accion.agregarHijo(espias);

        // Subcategorías de Comedia
        Nodo familiar = new Nodo("Familiar");
        Nodo negra = new Nodo("Comedia Negra");

        Nodo shrek = new Nodo("Shrek");
        Nodo madagascar = new Nodo("Madagascar");
        Nodo deadpool = new Nodo("Deadpool");
        Nodo superbad = new Nodo("Superbad");

        familiar.agregarHijo(shrek);
        familiar.agregarHijo(madagascar);
        negra.agregarHijo(deadpool);
        negra.agregarHijo(superbad);

        comedia.agregarHijo(familiar);
        comedia.agregarHijo(negra);

        // Subcategorías de Drama
        Nodo biografico = new Nodo("Biográfico");
        Nodo romantico = new Nodo("Romántico");

        Nodo elPianista = new Nodo("El Pianista");
        Nodo enBuscaFelicidad = new Nodo("En Busca de la Felicidad");
        Nodo titanic = new Nodo("Titanic");
        Nodo diarioDeUnaPasion = new Nodo("Diario de una Pasión");

        biografico.agregarHijo(elPianista);
        biografico.agregarHijo(enBuscaFelicidad);
        romantico.agregarHijo(titanic);
        romantico.agregarHijo(diarioDeUnaPasion);

        drama.agregarHijo(biografico);
        drama.agregarHijo(romantico);

        // Subcategorías de Ciencia Ficción
        Nodo espacio = new Nodo("Espacio");
        Nodo distopia = new Nodo("Distopía");

        Nodo interestelar = new Nodo("Interestelar");
        Nodo starWars = new Nodo("Star Wars: Una Nueva Esperanza");
        Nodo matrix = new Nodo("The Matrix");
        Nodo bladeRunner = new Nodo("Blade Runner 2049");

        espacio.agregarHijo(interestelar);
        espacio.agregarHijo(starWars);
        distopia.agregarHijo(matrix);
        distopia.agregarHijo(bladeRunner);

        cienciaFiccion.agregarHijo(espacio);
        cienciaFiccion.agregarHijo(distopia);

        // Subcategorías de Terror
        Nodo clasico = new Nodo("Clásico");
        Nodo sobrenatural = new Nodo("Sobrenatural");

        Nodo elExorcista = new Nodo("El Exorcista");
        Nodo psicosis = new Nodo("Psicosis");
        Nodo conjuro = new Nodo("El Conjuro");
        Nodo annabelle = new Nodo("Annabelle");

        clasico.agregarHijo(elExorcista);
        clasico.agregarHijo(psicosis);
        sobrenatural.agregarHijo(conjuro);
        sobrenatural.agregarHijo(annabelle);

        terror.agregarHijo(clasico);
        terror.agregarHijo(sobrenatural);

        // Agregar categorías principales a la raíz
        raiz.agregarHijo(accion);
        raiz.agregarHijo(comedia);
        raiz.agregarHijo(drama);
        raiz.agregarHijo(cienciaFiccion);
        raiz.agregarHijo(terror);

        return raiz;
    }

    public static void preOrder(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        System.out.println(nodo.valor); // Procesar nodo actual
        for (Nodo hijo : nodo.hijos) {
            preOrder(hijo);
        }
    }

    public static void postOrder(Nodo nodo) {
        if (nodo == null) {
            return;
        }

        for (Nodo hijo : nodo.hijos) {
            postOrder(hijo);
        }
        System.out.println(nodo.valor); // Procesar nodo actual
    }
}
