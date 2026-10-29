public class PokemonFactory {
    

    public static final Map<Integer, Pokemon> getDemoData(){
        Map<Integer, Pokemon> datos = new LinkedHashMap<>();

        datos.put(0, new Pokemon(0, "Pokemon1","tipo1","1", 1, LocalDateTime.now()));
        datos.put(1, new Pokemon(1, "Pokemon2","tipo2","2", 2, LocalDateTime.now()));
        datos.put(2, new Pokemon(2, "Pokemon3","tipo3","3", 3, LocalDateTime.now()));


        return datos;
    }
}