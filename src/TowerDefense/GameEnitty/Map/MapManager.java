package TowerDefense.GameEnitty.Map;

import TowerDefense.GameFrame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapManager {

    private static String[] mapper =new String[12];

    static void read() throws IOException {

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
    }

    public static List<MapObject> updateMapper() throws IOException {
        List<MapObject> MapObject = new ArrayList<MapObject>();

        MapManager.read();

        for(int i=0; i<12; i++) {
            for (int j=0; j<16; j++) {
                if (mapper[i].charAt(j) == '0') {
                    MapObject.add(new Mountain(new Point(i*64, j*64)));
                }
                else if (mapper[i].charAt(j) != '0') {
                    MapObject.add(new Road(new Point(i*64, j*64)));
                }

            }
        }

        return MapObject;
    }

}
