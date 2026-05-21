
    import java.io.*;

    public class Persistencia {

        public static void salvar(Object obj, String ficheiro) {

            try (ObjectOutputStream out =
                         new ObjectOutputStream(
                                 new FileOutputStream(ficheiro))) {

                out.writeObject(obj);

                System.out.println("Dados salvos!");

            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        public static Object carregar(String ficheiro) {

            try (ObjectInputStream in =
                         new ObjectInputStream(
                                 new FileInputStream(ficheiro))) {

                return in.readObject();

            } catch (FileNotFoundException e) {
                System.out.println("Nenhum ficheiro encontrado. Criar nova biblioteca...");

            }
            catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }

            return null;
        }
    }



