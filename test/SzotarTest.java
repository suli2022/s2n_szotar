import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import models.FileHandler;

public class SzotarTest {
    ArrayList<String> methodNameList;
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
        assertTrue(hasReadFileMethod);
    }

}
