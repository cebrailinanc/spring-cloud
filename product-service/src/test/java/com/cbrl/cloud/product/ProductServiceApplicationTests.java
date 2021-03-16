package com.cbrl.cloud.product;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest  //This annotation helps in writing integration tests.
class ProductServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void JSONAssert() throws JSONException {

        String actual = "{id:123,name:\"John\",zip:\"33025\"}";
        JSONAssert.assertEquals("{id:123,name:\"John\"}", actual, JSONCompareMode.LENIENT);
        JSONAssert.assertEquals("{id:123,name:\"John\"}", actual, false);
        JSONAssert.assertNotEquals("{id:123,name:\"John\"}", actual, true);


        actual = "{name:\"John\", id:123}";
        JSONAssert.assertEquals("{id:123,name:\"John\"}", actual, JSONCompareMode.STRICT);
        JSONAssert.assertEquals("{name:\"John\"}", actual, JSONCompareMode.LENIENT);
        JSONAssert.assertEquals("{id:123, name:\"John\"}", actual, JSONCompareMode.NON_EXTENSIBLE);
        JSONAssert.assertEquals("{id:123, name:\"John\"}", actual, JSONCompareMode.STRICT_ORDER);


    }

}
