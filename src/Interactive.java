import location.Building;
import location.Location;
import java.util.*;
import java.io.*;


public class Interactive {
    String str;
    String arg;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void start() {
        try {
            while (true) {
                str = br.readLine();
                if (str.isEmpty()) {
                    Thread.sleep(100);
                } else {

                    arg = str.substring(str.indexOf("{") == -1 ? 0 : str.indexOf("{"));

                    if (str.contains("remove_lower")) {

                        removestate(arg, false);
                    } else if (str.contains("remove_greater")) {

                        removestate(arg, true);
                    } else if (str.contains("remove")) {

                        remove(arg);

                    } else if (str.equals("load")) {
                        load(Test.file);
                    }
                }
            }
        } catch (IOException ехс) {
            System.out.println("Omибкa " + ехс);
        } catch (InterruptedException in) {
            System.out.println("Omибкa " + in);
        }

    }

    /**
     * Команда removestate удаляет элементы, меньшие заданного(state=false) или
     * элементы больше заданного из коллеции(state=true)
     *
     * @param string
     * @param state
     */
    private void removestate(String string, boolean state) {

        Parser<Building> p = new Parser<>();
        Building h = p.fromJson(string, Building.class);
        Iterator<Building> iter = Test.location.get(0).getLocationObjects().iterator();

        List<Building> toRemove = new ArrayList<>(16);
        while (iter.hasNext()) {

            Building building = iter.next();
            if (state) {
                if (h.compareTo(building) < 0) {
                    toRemove.add(building);
//                    Test.location.get(0).getLocationObjects().remove(building);
//                    System.out.println("объект " + building.getName() + " удален");
                }
            } else {
                if (h.compareTo(building) > 0) {
                    toRemove.add(building);
//                    Test.location.get(0).getLocationObjects().remove(building);
//                    System.out.println("объект " + building.getName() + " удален");

                }
            }
        }

        for(Building building : toRemove) {
            Test.location.get(0).getLocationObjects().remove(building);
            System.out.println("объект " + building.getName() + " удален");
        }

    }

    /**
     * команда load перечитывает коллекцию из файла
     *
     * @param file
     */
    private void load(String file) {
        Test.location.get(0).getLocationObjects().clear();
        FileKrugets refill = new FileKrugets(file);
        refill.fileread();
        System.out.println("коллекция пересчитана");
    }

    /**
     * команда remove удаляет объект из коллекции
     *
     * @param string
     */
    private void remove(String string) {
        Parser<Building> p = new Parser<>();
        Building h = p.fromJson(string, Building.class);
        Test.location.get(0).getLocationObjects().remove(h);
        System.out.println("объект " + h.getName()+ " удален" );

    }
    public void save(String file) {
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(file))) {

            Iterator<Building> iter = Test.location.get(0).getLocationObjects().iterator();
            while (iter.hasNext()) {
                Building building = iter.next();
                str = building.getName() + "," + building.getState() + "," + building.getAddres() + "," + building.getOwnername() + "\n";
                writer.write(str);
            }
        } catch (Exception e) {

            System.out.println("ошибка");

        }
    }
}







