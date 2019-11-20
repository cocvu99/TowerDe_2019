package TowerDefense.GameEnitty.Map;

import TowerDefense.GamePlay.GameFrame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapManager {

    public static spawner spawner;
    public static Target target;
    public static String[] mapper =new String[12];
    public static String MonsterSpan;

    private static void read(int Nlines, String file) throws IOException, InterruptedException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new FileReader(file));

        } catch (Exception e) {
            Thread.sleep(1000);
            GameFrame.gameState = GameFrame.GameState.WINNING;
        }

        for (int i=0; i<Nlines; i++) {
            mapper[i] = reader.readLine();
        }

        MonsterSpan = reader.readLine();
        reader.close();
    }

    public static List<MapObject> updatePlayMapper() throws IOException, InterruptedException {
        List<MapObject> MapObject = new ArrayList<>();

        MapManager.read(12, "res/Map/level/level"
                + GameFrame.GAME_LEVEL
                +".txt");

        for(int i=0; i<11; i++) {
            for (int j=0; j<16; j++) {
                if (mapper[i].charAt(j) == '0') {
                    MapObject.add(new Mountain(new Point(j*64, i*64)));
                }
                else if (mapper[i].charAt(j) == '1') {
                    MapObject.add(new Road(new Point(j*64, i*64)));
                }
                else if (mapper[i].charAt(j) == '8') {
                    spawner =new spawner(new Point(j*64, i*64));
                    MapObject.add(spawner);
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
