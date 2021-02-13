package eu.europa.ec.digit.search.improveperformance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class NumberServiceTest {
    
    @Autowired
    NumberService numberService;

    @Test
    void test() {
        
        List<Integer> data = numberService.generateData();
        
        long start  = System.currentTimeMillis();
        Integer number1 = numberService.findSmallestDuplicate(data);
        long took1 = System.currentTimeMillis() - start;
        log.info("The first method took {} ms", took1);

        start = System.currentTimeMillis();
        Integer number2 = numberService.findSmallestDuplicateImproved(data);
        long took2 = System.currentTimeMillis() - start;
        log.info("The second method took {} ms", took2);

        assertEquals(number1, number2);
        assertTrue(took1 > took2*10);
        
        
    }

}
