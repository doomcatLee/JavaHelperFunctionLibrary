package com.doomcatlee.helperfunctionlibrary.webscraping;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WebscrapeComponent {

    private final String baseUrl = "https://www.toyotapartsdeal.com";

    public HtmlPage grabPartsHtml(String partNumber) {
        WebClient client = new WebClient();
        client.getOptions().setCssEnabled(false);
        client.getOptions().setJavaScriptEnabled(false);

        String searchUrl = baseUrl + "/oem/" + partNumber + ".html";

        try {
            return client.getPage(searchUrl);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void parseHtmlPage(HtmlPage page) {
        String partNumber = "";
        String partDescription = "";
        String imgUrl = "";

        try {
            partNumber = ((HtmlDivision) page.getByXPath("//div[@class='summary p_clear']").get(0))
                    .getFirstChild().getFirstChild().getNextSibling().getFirstChild().getNodeValue().toString();
        } catch (Exception ex) {
            partNumber = "";
        }

        try {
            partDescription = ((HtmlTableDataCell) page.getByXPath("//td[@class='e desc']").get(0))
                    .getFirstChild().getNodeValue().toString();
        } catch (Exception ex) {
            partDescription = "";
        }

        try {
            imgUrl = baseUrl + ((HtmlImage) page.getByXPath("//img[@class='e draw']").get(0)).getSrcAttribute();
        } catch (Exception ex) {
            imgUrl = "";
        }

        try {
            DomNodeList tableList = (((HtmlTable) (page.getByXPath("//table[@class='tpd']")).get(0))
                    .getFirstChild()).getChildNodes();

            int rowCount = tableList.size() + 1;

            for (int i=1; i < rowCount; i++) {
                CompatibleVehicles compatibleVehicles = new CompatibleVehicles();

                compatibleVehicles.make = ((HtmlTableDataCell)((HtmlTableRow) tableList.get(1)).getByXPath("//td[@class='make']")
                        .get(i)).getFirstChild().getFirstChild().getChildNodes().get(0).toString();

                compatibleVehicles.model = ((HtmlTableDataCell)((HtmlTableRow) tableList.get(1)).getByXPath("//td[@class='model']")
                        .get(i)).getFirstChild().getFirstChild().getChildNodes().get(0).toString();

                compatibleVehicles.year = ((HtmlTableDataCell)((HtmlTableRow) tableList.get(1)).getByXPath("//td[@class='year']")
                        .get(i)).getFirstChild().getFirstChild().getChildNodes().get(0).toString();

                compatibleVehicles.trim = ((HtmlTableDataCell)((HtmlTableRow) tableList.get(1)).getByXPath("//td[@class='optional']")
                        .get(i)).getFirstChild().getFirstChild().getFirstChild().getFirstChild().asText();

                compatibleVehicles.engine = ((HtmlTableDataCell)((HtmlTableRow) tableList.get(1)).getByXPath("//td[@class='optional']")
                        .get(i)).getFirstChild().getLastChild().getChildNodes().get(0).asText();

                compatibleVehicles.otherDetails = ((HtmlTableDataCell)((HtmlTableRow) tableList.get(1)).getByXPath("//td[@class='other']")
                        .get(i)).getFirstChild().asText();

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
