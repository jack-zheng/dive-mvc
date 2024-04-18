package org.dive;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

class MainTest {
    String str = """
                {
                    "records": [
                        {
                            "id": 73,
                            "status": "COMPLETED",
                            "createdAt": "2024-04-10T08:17:16Z"
                        }
                    ],
                    "inlineCount": 1,
                    "skipToken": ""
                }
                """;
    @Test
    public void test() throws Exception {

        JSONAssert.assertEquals(
                "{inlineCount:1}", str, JSONCompareMode.LENIENT);
    }

    @Test
    public void test2() throws Exception {
        String expStr = """
                {
                    "records": [
                        {
                            "status": "COMPLETED"
                        }
                    ],
                    "inlineCount": 1,
                    "skipToken": ""
                }
                """;
        JSONAssert.assertEquals(expStr, str, JSONCompareMode.STRICT);

    }
}