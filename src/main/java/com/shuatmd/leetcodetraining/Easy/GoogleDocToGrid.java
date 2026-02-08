package com.shuatmd.leetcodetraining.Easy;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.Map;

public class GoogleDocToGrid {
    public static void main(String[] args) throws Exception {
        GoogleDocToGrid googleDocToGrid = new GoogleDocToGrid();
        String url = "https://docs.google.com/document/d/e/2PACX-1vRPzbNQcx5UriHSbZ-9vmsTow_R6RRe7eyAU60xIF9Dlz-vaHiHNO2TKgDi7jy4ZpTpNqM7EvEcfr_p/pub";
        googleDocToGrid.printGridFromGoogleDoc(url);
    }

    // 主函数：输入 Google Doc URL，解析并打印图案
    public static void printGridFromGoogleDoc(String url) throws Exception {
        Document doc = Jsoup.connect(url).get();
        Element table = doc.select("table").first();
        Elements rows = table.select("tr");
        Map<String, String> grid = new HashMap<>();

        int maxX = 0, maxY = 0;
        for (int i = 1; i < rows.size(); i++) {
            Elements cols = rows.get(i).select("td");
            if (cols.size() < 3) continue;

            int x = Integer.parseInt(cols.get(0).text().trim());
            String curChar = cols.get(1).text().trim();
            int y = Integer.parseInt(cols.get(2).text().trim());

            grid.put(x + "," + y, curChar);

            maxX = Math.max(maxX, x);
            maxY = Math.max(maxY, y);
        }

        for (int y = maxY; y >= 0; y--) {
            StringBuilder curLine = new StringBuilder();
            for (int x = 0; x <= maxX; x++) {
                curLine.append(grid.getOrDefault(x + "," + y, " "));
            }
            System.out.println(curLine);
        }
    }


}
