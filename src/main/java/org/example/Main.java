package org.example;

import com.pdftron.pdf.Convert;
import com.pdftron.pdf.OfficeToPDFOptions;
import com.pdftron.pdf.PDFDoc;
import com.pdftron.pdf.PDFNet;
import com.pdftron.sdf.SDFDoc;

public class Main {
    public static void main(String[] args) throws Exception {
        PDFNet.initialize("demo:1665475100050:7acb71a103000000000089808414109689a52333f51e900efd3a9b54b6");
        String input_path = "src/main/resources/";
        String output_path = "target/";
        String inputFilename = "template.docx";
        String outputFilename = "result.pdf";
        PDFDoc pdfdoc = new PDFDoc();
        OfficeToPDFOptions officeToPDFOptions = new OfficeToPDFOptions();
        officeToPDFOptions.setTemplateParamsJson(
                "{\n" +
                        "  \"foo\": \"Bar\",\n" +
                        "  \"rows\": [\n" +
                        "    {\n" +
                        "      \"one\": \"foo\",\n" +
                        "      \"two\": \"bar\",\n" +
                        "      \"three\": \"baz\"\n" +
                        "    },\n" +
                        "    {\n" +
                        "      \"one\": \"foo2\",\n" +
                        "      \"two\": \"bar1\",\n" +
                        "      \"three\": \"baz3\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}"
        );
        Convert.officeToPdf(pdfdoc, input_path + inputFilename, officeToPDFOptions);

        // save the result
        pdfdoc.save(output_path + outputFilename, SDFDoc.SaveMode.INCREMENTAL, null);
        // output PDF pdfdoc

        // And we're done!
        System.out.println("Done conversion " + output_path + outputFilename);
    }
}