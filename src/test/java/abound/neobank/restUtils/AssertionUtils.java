package abound.neobank.restUtils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.response.Response;

import java.util.*;

public class AssertionUtils
{
    public static void getExpectedValuesAssertion(Response response, ExtentTest t, HashMap<String,String> expectedValues) {
        List<AssertionKeys> actualValuesMap = new ArrayList<>();
        actualValuesMap.add(new AssertionKeys("jsonPath","expectedValue","actualValue","result"));

        Set<String> expectedValue = expectedValues.keySet();

        boolean allMatched = true;

        for(String values : expectedValue )
        {
            Optional<Object> expected = Optional.ofNullable(response.jsonPath().get(values));

            if(expected.isPresent())
            {
                Object value = expected.get();

                if(value.equals(expectedValues.get(values))) {
                    // if value is matched then add details
                    actualValuesMap.add(new AssertionKeys(values, expectedValues.get(values), value, "MATCHED ✅"));
                }
                    else {
                    // if single assertion is failed then to update final result as failure
                    allMatched = false;
                    actualValuesMap.add(new AssertionKeys(values, expectedValues.get(values), value, "NOT_MATCHED ❌"));
                }
            }
            // if jsonpath does not exist in the response
            else {
                allMatched = false;
                actualValuesMap.add(new AssertionKeys(values, expectedValues.get(values), "VALUE_NOT_FOUND", "NOT_MATCHED ❌"));
            }
        }
        // To decide final result
        if(allMatched)
            t.info("All assertions are passed. 😊😊😊😊😊");
        else
            t.fail("All assertions are not passed. 😒😒😒😒😒");

        // To log the details in a tabular format in extent report
        String[][] finalAssertionsMap = actualValuesMap.stream().map(assertions -> new String[] {assertions.getJsonPath(),
                        String.valueOf(assertions.getExpectedValue()), String.valueOf(assertions.getActualValue()), assertions.getResult()})
                .toArray(String[][] :: new);
        t.info(MarkupHelper.createTable(finalAssertionsMap));











    }
}
