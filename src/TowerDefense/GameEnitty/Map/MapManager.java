package TowerDefense.GameEnitty.Map;

import TowerDefense.GameFrame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapManager {

    public static Spaner spaner;
    public static Target target;
    public static String[] mapper =new String[12];
    public static String MonsterSpan;

    private static void read() throws IOException {

        BufferedReader reader = new BufferedReader(
                new FileReader(
                        "res/Map/level/level"
                                + GameFrame.GAME_LEVEL
                                +".txt"
                )
        );

        for (int i=0; i<12; i++) {
            mapper[i] = reader.readLine();
        }

        MonsterSpan = reader.readLine();
        System.out.println(MonsterSpan);
        reader.close();
    }

    public static List<MapObject> updateMapper() throws IOException {
        List<MapObject> MapObject = new ArrayList<>();

        MapManager.read();

        for(int i=0; i<11; i++) {
            for (int j=0; j<16; j++) {
                if (mapper[i].charAt(j) == '0') {
                    MapObject.add(new Mountain(new Point(j*64, i*64)));
                }
                else if (mapper[i].charAt(j) == '1') {
                    MapObject.add(new Road(new Point(j*64, i*64)));
                }
                else if (mapper[i].charAt(j) == '8') {
                    spaner =new Spaner(new Point(j*64, i*64));
                    MapObject.add(spaner);
                }
                else if(mapper[i].charAt(j) == '9') {
                    target = new Target(new Point(j*64, i*64));
                    MapObject.add(target);
                }

            }
        }

        return MapObject;
    }

}
