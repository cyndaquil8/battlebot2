package despacito7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.stream.Collectors;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import despacito7.detail.Item;
import despacito7.util.Loader;

public class FeatureLoader implements Loader {
    private static java.util.Map<String, despacito7.map.Map> maps;
    private static java.util.Map<String, Item> items;
    private static boolean loaded = false;

    public static despacito7.map.Map getMap(String id) {return maps.get(id);}
    public static Item getItem(String id) {return items.get(id);}
    public static Player player;

    public boolean isLoaded() {
        return FeatureLoader.loaded;
    }

    public void load() {
        JsonObject itemdata = loadJson("items.json");
        FeatureLoader.items = new HashMap<>(itemdata.size(), 0.99f);
        for (java.util.Map.Entry<String, JsonElement> entry : itemdata.entrySet()) {
            FeatureLoader.items.put(entry.getKey(), new Item(entry.getKey(), entry.getValue().getAsJsonObject()));
        }

        JsonObject mapdata = loadJson("maps.json");
        FeatureLoader.maps = new HashMap<>(mapdata.size(), 0.99f);
        for (java.util.Map.Entry<String, JsonElement> entry : mapdata.entrySet()) {
            FeatureLoader.maps.put(entry.getKey(), new despacito7.map.Map(entry.getValue().getAsJsonObject()));
        }

        player = new Player();
        

        FeatureLoader.loaded = true;

    }

    private JsonObject loadJson(String filename) {
        try (Reader reader = new InputStreamReader(getClass().getClassLoader().getResourceAsStream("data/"+filename))) {
            String text = new BufferedReader(reader).lines().collect(Collectors.joining("\n"));
            return App.gson.fromJson(text, JsonObject.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
