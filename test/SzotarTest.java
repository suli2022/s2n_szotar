import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.FileHandler;

public class SzotarTest {
    ArrayList<String> methodNameList;
    FileHandler fileHandler;



    @BeforeEach
    void setMethodList() {
        this.methodNameList = new ArrayList<>();
        Method[] methods = FileHandler.class.getDeclaredMethods();
        for(Method method : methods) {
            this.methodNameList.add(method.getName());
        }
    }
    @Test
    void checkReadFileMethod() {
        boolean hasReadFileMethod = this.methodNameList.contains("readFile");
        assertTrue(hasReadFileMethod, "Hiba! Nem létezik a readFile metódus");
    }
    ArrayList<String> fieldNameList;
    @BeforeEach
    void setFieldList() {
        this.fieldNameList = new ArrayList<>();
        Field[] fields = FileHandler.class.getDeclaredFields();
        for(Field field : fields) {
            this.fieldNameList.add(field.getName());
        }
    }    
    @Test
    void checkFileName() {
        boolean hasFileName = this.fieldNameList.contains("fileName");
        assertTrue(hasFileName, "Hiba! A fileName mező nem létezik!");
    }
    @Test
    void checkWordPairList() {
        boolean hasWordPairList = this.fieldNameList.contains("wordPairList");
        assertTrue(hasWordPairList, "Hiba! A wordPairList mező nem létezik!");
    }

    @BeforeEach
    void initTest() {
        fileHandler = new FileHandler();
    }
    @Test
    void checkFileNameContent() {
        boolean isGoodName = fileHandler.fileName.equals("szotar.txt");
        assertTrue(isGoodName, "Hiba! A fájlnév nem szotar.txt!");
    }



    @Test
    void checkWordListContent() {
        fileHandler.fileName = "szotarTest.txt";
        fileHandler.readFile();
        int listSize = fileHandler.wordPairList.size();
        
        //TODO: a tesztnek 3-ra kell illeszkednie
        assertEquals(0, listSize, "Hiba! A listában nincs 3 szópár");
    }
}
