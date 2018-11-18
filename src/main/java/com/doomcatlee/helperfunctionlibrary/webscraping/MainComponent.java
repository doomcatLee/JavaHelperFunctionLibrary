//package com.doomcatlee.helperfunctionlibrary.webscraping;
//
//import org.springframework.stereotype.Component;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import java.io.File;
//import java.io.IOException;
//import java.net.URLEncoder;
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class MainComponent {
//
//    public JSONObject run(String searchUrl) {
//        HtmlPage html = grabRawHtml(searchUrl);
//        return parseHtml(html);
//    }
//
//    public HtmlPage grabRawHtml(String searchUrl) {
//        WebClient client = new WebClient();
//        client.getOptions().setCssEnabled(false);
//        client.getOptions().setJavaScriptEnabled(false);
//
//        try {
//            return client.getPage(searchUrl);
//        } catch (NullPointerException | IOException ex) {
//            ex.printStackTrace();
//            return null;
//        }
//    }
//
//    public JSONObject parseHtml(HtmlPage page) {
//        JSONObject jsonObject = new JSONObject();
//        JSONArray compatibleVehicleList = new JSONArray();
//
//        // Get Make
//        HtmlSpan partSpan = (HtmlSpan) page.getByXPath("//span[@class='list_value']").get(0);
//        String make = partSpan.getChildNodes().get(0).getNodeValue();
//
//        // Get Part Number
//        HtmlSpan partNumberSpan = (HtmlSpan) page.getByXPath("//span[@class='list_value']").get(1);
//        String partNumber = partNumberSpan.getChildNodes().get(0).getNodeValue();
//
//        // Get Part Title
//        HtmlSpan partTitleSpan = (HtmlSpan) page.getByXPath("//span[@class='list_value']").get(2);
//        String partTitle = partTitleSpan.getChildNodes().get(0).getNodeValue();
//
//        // Get Part Description
//        HtmlSpan partDescriptionSpan = (HtmlSpan) page.getByXPath("//span[@class='list_value description_body']").get(0);
//        String partDescription = partDescriptionSpan.getChildNodes().get(0).getFirstChild().getNodeValue();
//
//        // Get Image Url
//        String imageUrl = "https:" + ((HtmlImage) page.getByXPath("//img[@class='product-main-image centered']").get(0)).getSrcAttribute();
//
//        int rowCount = ((HtmlTable) page.getByXPath("//table[@class='fitment-table']").get(0)).getRowCount();
//
//        for (int i=0; i < rowCount; i++) {
//            JSONObject compatibleVehicles = new JSONObject();
//            HtmlTableRow row = ((HtmlTable) page.getByXPath("//table[@class='fitment-table']").get(0)).getRow(i);
//
//            String tempMake = (((HtmlTable) page.getByXPath("//table[@class='fitment-table']").get(0)).getRow(4))
//                    .getFirstChild().getNextSibling().getFirstChild().getNodeValue().toString();
//            String tempModel = (((HtmlTable) page.getByXPath("//table[@class='fitment-table']").get(0)).getRow(4))
//                    .getFirstChild().getNextSibling().getNextSibling().getFirstChild().getNodeValue().toString();
//
//            String tempYear = (((HtmlTable) page.getByXPath("//table[@class='fitment-table']").get(0)).getRow(4))
//                    .getFirstChild().getNextSibling().getNextSibling().getNextSibling().getFirstChild().getNodeValue().toString();
//
//            String tempTrims = (((HtmlTable) page.getByXPath("//table[@class='fitment-table']").get(0)).getRow(4))
//                    .getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getFirstChild().getNodeValue().toString();
//
//            String tempEngineTransmission = (((HtmlTable) page.getByXPath("//table[@class='fitment-table']").get(0)).getRow(4))
//                    .getFirstChild().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getNextSibling().getFirstChild().getNodeValue().toString();
//
//            compatibleVehicles.put("make", tempMake);
//            compatibleVehicles.put("model", tempModel);
//            compatibleVehicles.put("year", tempYear);
//            compatibleVehicles.put("trims", tempTrims);
//            compatibleVehicles.put("engineAndTransmission", tempEngineTransmission);
//
//            compatibleVehicleList.put(compatibleVehicles);
//
//        }
//
//        jsonObject.put("make", make);
//        jsonObject.put("partTitle", partTitle);
//        jsonObject.put("partNumber", partNumber);
//        jsonObject.put("partDescription", partDescription);
//        jsonObject.put("imageUrl", imageUrl);
//        jsonObject.put("compatibleVehicles", compatibleVehicleList);
//
//        return jsonObject;
//    }
//
//}
