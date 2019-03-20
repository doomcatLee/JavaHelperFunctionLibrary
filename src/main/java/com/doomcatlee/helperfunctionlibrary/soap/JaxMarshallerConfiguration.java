//package com.doomcatlee.helperfunctionlibrary.soap;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//
//@Configuration
//public class JaxMarshallerConfiguration {
//    @Bean
//    public Jaxb2Marshaller marshaller() {
//        String wsdlString = "test.wsdl";
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setContextPath(wsdlString);
//        return marshaller;
//    }
//
//    @Bean
//    public SoapClient soapClient(Jaxb2Marshaller marshaller) {
//        SoapClient soapClient = new SoapClient();
//        String soapUri = "";
//        soapClient.setDefaultUri(soapUri);
//        soapClient.setMarshaller(marshaller);
//        soapClient.setUnmarshaller(marshaller);
//        return soapClient;
//    }
//}