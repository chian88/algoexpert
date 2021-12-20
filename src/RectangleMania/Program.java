package RectangleMania;

import java.util.*;

class Program {
    public static int rectangleMania(List<Integer[]> coords) {
        // Write your code here.
        int result = 0;
        Map<Integer[], Map<String, List<Integer[]>>> rectMap = generateRectMap(coords);
        for (int i = 0 ; i < coords.size(); i++) {
            Integer[] coord = coords.get(i);
            result += DFSRect(rectMap, coord, 0, "Up", coord);
        }

        return result;
    }

    public static int DFSRect(Map<Integer[], Map<String, List<Integer[]>>> rectMap ,
                              Integer[] coord, int count, String direction, Integer[] originalCoord) {

        if (direction.equals("End") && coord.equals(originalCoord)) {
            return count + 1;
        } else if (direction.equals("End")) {
            return count;
        }

        Map<String, List<Integer[]>> subRectMap = rectMap.get(coord);
        String newDirection = "";
        List<Integer[]> rectCollection = null;



        if (direction.equals("Up")) {
            rectCollection = subRectMap.get("Up");
            newDirection = "Right";
        } else if (direction.equals("Right")) {
            rectCollection = subRectMap.get("Right");
            newDirection = "Down";
        } else if (direction.equals("Down")) {
            rectCollection = subRectMap.get("Down");
            newDirection = "Left";
        } else if (direction.equals("Left")) {
            rectCollection = subRectMap.get("Left");
            newDirection = "End";
        }

        if (rectCollection == null) return count;

        for (int i = 0 ; i < rectCollection.size(); i++) {
            Integer[] newCoord = rectCollection.get(i);
            count = DFSRect(rectMap, newCoord, count, newDirection, originalCoord);
        }
        return count;
    }





    public static Map<Integer[], Map<String, List<Integer[]>>> generateRectMap(List<Integer[]> coords) {
        Map<Integer[], Map<String, List<Integer[]>>> rectMap = new HashMap<>();
        for (int i = 0; i < coords.size(); i++) {
            Integer[] coord = coords.get(i);
            for (int j = 0; j < coords.size(); j++) {
                Integer[] otherCoord = coords.get(j);
                String direction = "";

                if(checkDirectDown(coord, otherCoord)) {
                    direction = "Down";
                } else if (checkDirectLeft(coord, otherCoord)) {
                    direction = "Left";
                } else if (checkDirectUp(coord, otherCoord)) {
                    direction = "Up";
                } else if (checkDirectRight(coord, otherCoord)) {
                    direction = "Right";
                }

                if (!direction.isEmpty()) {
                    if (rectMap.containsKey(coord)) {
                        HashMap<String, List<Integer[]>> subRectMap = (HashMap<String, List<Integer[]>>) rectMap.get(coord);
                        if (subRectMap.containsKey(direction)) {
                            List<Integer[]> rectCollection = subRectMap.get(direction);
                            rectCollection.add(otherCoord);
                            subRectMap.put(direction, rectCollection);

                        } else {
                            List<Integer[]> rectCollection = new ArrayList<>();
                            rectCollection.add(otherCoord);
                            subRectMap.put(direction, rectCollection);
                        }
                        rectMap.put(coord, subRectMap);
                    } else {
                        List<Integer[]> rectCollection = new ArrayList<>();
                        rectCollection.add(otherCoord);
                        HashMap<String, List<Integer[]>> subRectMap = new HashMap<>();
                        subRectMap.put(direction, rectCollection);
                        rectMap.put(coord, subRectMap);
                    }
                }
            }
        }
        return rectMap;
    }


    public static boolean checkDirectLeft(Integer[] coord, Integer[] otherCoord) {
        return otherCoord[0] < coord[0] && otherCoord[1] == coord[1];
    }

    public static boolean checkDirectRight(Integer[] coord, Integer[] otherCoord) {
        return otherCoord[0] > coord[0] && otherCoord[1] == coord[1];
    }

    public static boolean checkDirectUp(Integer[] coord, Integer[] otherCoord) {
        return otherCoord[0] == coord[0] && otherCoord[1] > coord[1];
    }

    public static boolean checkDirectDown(Integer[] coord, Integer[] otherCoord) {
        return otherCoord[0] == coord[0] && otherCoord[1] < coord[1];
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

        Integer[][] coord = new Integer[][]{{0,0}, {0,1}, {1,1}, {1,0}, {2,1}, {2,0}, {3,1}, {3,0}};
        List<Integer[]> coords = new ArrayList<>(Arrays.asList(coord));

        System.out.println(rectangleMania(coords));
    }
}
