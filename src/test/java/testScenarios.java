import PojoPackage.Player;
import PojoPackage.RCBteam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class testScenarios {

    String data;
    RCBteam rcBteam;
    List<Player> list;

    @BeforeClass
    public void convertjsonIntoJavaObject(){

        ObjectMapper obmap = new ObjectMapper();
        try {
            rcBteam = obmap.readerFor(RCBteam.class).readValue(data);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        list = new ArrayList<>();
        list.addAll(rcBteam.getPlayer());
    }


    @BeforeTest
    public void readJson(){
        data="";
        try {
            data = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/src/main/resources/responseJson.txt")));
        System.out.print(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void verifyForiegnPlayer(){
            int count =0;
        for(Player p: list){
            if(!(p.getCountry().equals("India")))
            {
                count++;
            }
        }
        Assert.assertEquals(count,4);



    }


    @Test
    public void verifyWicketKeeper(){
        int count =0;
        for(Player p: list){
            if((p.getRole().equals("Wicket-keeper")))
            {
                count++;
            }
        }
        Assert.assertTrue(count>=1);



    }

}
