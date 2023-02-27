package vesseltracker.Utils;

import vesseltracker.model.Vessel;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public long getNumbersFromTimestamp(String timestamp) {
        char[] chars = timestamp.toCharArray();
        StringBuilder stringNumbers = new StringBuilder();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                stringNumbers.append(c);
            }
        }
        return Long.parseLong(String.valueOf(stringNumbers));
    }

    public int findingTensOfNumber(long number) {
        return Integer.parseInt(String.valueOf(number % 100));
    }

    public int findingHundredsOfNumberFinding(long number) {
        long second = number % 100;
        return Integer.parseInt(String.valueOf((number % 10000 - second) / 100));
    }

    public int calculateDistance(List<Integer> XDev, List<Integer> YDev) {
        int XSum = XDev.get(XDev.size() - 1) - XDev.get(0);
        int YSum = XDev.get(YDev.size() - 1) - YDev.get(0);
        int distance = (int) (Math.pow(XSum, 2) + Math.pow(YSum, 2));
        int distancePerKm = (int) Math.sqrt(distance);
        return distancePerKm;
    }

    public int getVesselDistance(Vessel vessel) {

        List<Integer> XDev = new ArrayList<>();
        List<Integer> YDev = new ArrayList<>();
        List<String> timestamp = new ArrayList<>();

        vessel.getPosition().stream().forEach(temp -> {
            XDev.add(temp.getX());
            YDev.add(temp.getY());
            timestamp.add(temp.getTimestamp());
        });

        return this.calculateDistance(XDev, YDev);
    }

    public double getVesselSpeed(Vessel vessel) {
        List<String> timeStamps = new ArrayList<>();
        vessel.getPosition().stream().forEach(temp -> {
            timeStamps.add(temp.getTimestamp());
        });
        long timeStartNumber = this.getNumbersFromTimestamp(timeStamps.get(0));
        long timeEndNumber = this.getNumbersFromTimestamp(timeStamps.get(timeStamps.size() - 1));
        int minStart = this.findingTensOfNumber(timeStartNumber);
        int hourStart = this.findingHundredsOfNumberFinding(timeStartNumber);
        int hourEnd = this.findingHundredsOfNumberFinding(timeEndNumber);
        int minEnd = this.findingTensOfNumber(timeEndNumber);
        double finalHour = hourEnd - hourStart;
        int finalMin = 0;
        if (minEnd < minStart) {
            finalMin = (minEnd + 60) - minStart;
            if (finalHour > 0) {
                finalHour = finalHour - 1;
            }
        } else if (minEnd >= minStart) {
            finalMin = minEnd - minStart;
        }

        if (finalMin > 0) {
            double finalMinDecimal = finalMin / 60;
            finalHour = finalHour + finalMinDecimal;
        }

        return this.getVesselDistance(vessel) / finalHour;
    }
}
