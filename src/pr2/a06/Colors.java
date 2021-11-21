package pr2.a06;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public final class Colors {
	// QUELLE : https://www.mediaevent.de/tutorial/farbcodes.html

	final static Map<String, Color> farbmap = new HashMap<String, Color>(); // Creating HashMap
	static {
		farbmap.put("Grasgrün", new Color(124, 252, 0)); // Put elements in Map
		farbmap.put("Siennabraun", new Color(160, 82, 45));
		farbmap.put("Blasses Lila", new Color(219, 112, 147));
		farbmap.put("Helles Lachsrosa", new Color(255, 160, 122));
		farbmap.put("Graugrün", new Color(107, 142, 35));
		farbmap.put("Aquamarin", new Color(127, 255, 212));
		farbmap.put("Blasses Türkis", new Color(175, 238, 238));
		farbmap.put("Stahlblau", new Color(70, 130, 180));
		farbmap.put("Mitternachtsblau", new Color(25, 25, 112));
		farbmap.put("Dunkles Schieferblau", new Color(72, 61, 139));
		farbmap.put("Indigoblau", new Color(75, 0, 130));
		farbmap.put("Dunkelgrau", new Color(105, 105, 105));
		farbmap.put("Dunkles Rosa", new Color(188, 143, 143));
		farbmap.put("Chartreuse", new Color(127, 255, 0));
		farbmap.put("Umbra", new Color(139, 69, 19));
		farbmap.put("Dunkler Erdton", new Color(189, 183, 107));
		farbmap.put("Gold", new Color(255, 215, 0));
		farbmap.put("Blaugrün", new Color(0, 128, 128));
		farbmap.put("Dunkles Orange", new Color(255, 140, 0));
		farbmap.put("Schokoladenbraun", new Color(210, 105, 30));
	}

	public static Color createByName(String cssColorName) {
		if (farbmap.containsKey(cssColorName)) {
			return farbmap.get(cssColorName);
		} else {
			return Color.MAGENTA;
		}
	}

	public static Color[] createColorsByName(String[] cssColorNames) {
		Color[] colors = new Color[cssColorNames.length];
		for (int i = 0; i < cssColorNames.length; i++) {
			colors[i] = farbmap.get(cssColorNames[i]);
		}
		return colors;
	}

	public static Map<String, Color> createMapByName(String[] cssColorNames) {
		Map<String, Color> map = new HashMap<String, Color>();
		for (int i = 0; i < cssColorNames.length; i++) {
			map.put(cssColorNames[i], map.get(cssColorNames[i]));
		}
		return map;
	}
}