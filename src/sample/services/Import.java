package sample.services;

import org.apache.commons.io.FilenameUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import sample.models.AramexFile;
import sample.models.Item;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Import {

    public static ArrayList<Item> exportFile() throws Exception {
        File dir = new File("C:\\Aramex\\input");
        File[] directoryListing = dir.listFiles();
        ArrayList<Item> toExport = new ArrayList<>();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                // Do something with child
                toExport.add(getItem(child));
            }
            Export.export(toExport);
        }
        return toExport;
    }

    public static List<AramexFile> getFiles() {
        File dir = new File("C:\\Aramex\\input");
        File[] directoryListing = dir.listFiles();
        ArrayList<AramexFile> toExport = new ArrayList<>();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                // Do something with child
                String ext2 = FilenameUtils.getExtension(child.getName());
                String name = FilenameUtils.getBaseName(child.getName());
                toExport.add(new AramexFile(name, ext2));
            }
        }
        return toExport;
    }


    public static Item getItem(File file) throws IOException {
        PDDocument document = PDDocument.load(file);
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);
        //parser(text);
        return new Item(file.getName(), file.getName() + "@gmail.com");
    }


}