package model;
//shamelessly quoting from: JsonParserExample

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadWebPage {
    private DateManager dm = new DateManager();

    public boolean parse() {
        try {
            InputStream is = new FileInputStream("./calendardates.json");
            String jsonData = readSource(is);
            return parseHolidays(jsonData);
        } catch (IOException e) {
            System.out.println("Error reading file...");
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("Error parsing JSON data");
            e.printStackTrace();
        }

        return false;

    }

    private String readSource(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }

        br.close();

        return sb.toString();
    }

    public boolean parseHolidays(String jsonData) throws JSONException {
        JSONArray holidays = new JSONArray(jsonData);
        boolean h = false;

        for (int index = 0; index < holidays.length(); index++) {
            JSONObject holiday = holidays.getJSONObject(index);
            h = findHoliday(holiday);
        }

        return h;
    }

    private boolean findHoliday(JSONObject holiday) throws JSONException {
        String date = holiday.getString("date");
        String name = holiday.getString("name");

        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            Date date2 = new Date();
            if (dm.sameDate(date1, date2)) {
                System.out.println("Today is " +name+ "!");
                return true;
            }
        }catch (ParseException e) {
            System.out.println("Not working :(");
        }

        return false;

    }

}
