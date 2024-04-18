package org.dive;

import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

public class Main {
    public static void main(String[] args) throws Exception {
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

        JSONAssert.assertEquals(
                "{id:123,name:\"John\"}", str, JSONCompareMode.LENIENT);
    }


}