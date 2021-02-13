package eu.europa.ec.digit.search.improveperformance;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class NumberService {

    public Integer findSmallestDuplicate(List<Integer> data) {

        for (int i = 0; i < data.size(); i++) {

            for (int j = i + 1; j < data.size(); j++) {

                if (data.get(i).equals(data.get(j))) {

                    log.info("found number {}", data.get(j));
                    return data.get(j);
                }
            }
        }

        return 0;

    }


    /**
     * The method is the improved version of the {@link #findSmallestDuplicate(List)}.
     * The name may suggest that it returns the smallest duplicated value, but it doesn't,
     * it just returns the first duplicated value from the list of Integers or 0 if not founded.
     */
    public Integer findSmallestDuplicateImproved(List<Integer> data) {

        Set<Integer> uniqueV = new HashSet<>();

        return data.stream()
                .filter(v -> !uniqueV.add(v))
                .findFirst()
                .orElse(0);
    }

    public List<Integer> generateData() {

        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {

            data.add(i);
        }

        Random r = new Random();
        data.add(data.get(r.nextInt(data.size())));
        log.info("number is: {}", data.get(data.size() - 1));
        Collections.shuffle(data);

        return data;
    }
}
