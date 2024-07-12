package org.dive;

import org.json.JSONObject;

public class JsonTest {
    public static void main(String[] args) throws Exception {
        String str = """
                {"readFromPool":"dbPool1","PTEMGolden":{"companyId":"PTEMGolden","oraclePoolId":"dbPool1","immutableCompanyId":"01ea318e_23ec_46b8_bde3_57e27304f294","companySchema":"ENGCAND_PTEMGolden.","companyName":"PTEMGolden","companyStatus":6151,"creationDate":1715334356788,"provisionerId":"ProvAutoTestSuperUser","totalSeats":0,"tenantMetadata":{"tenantUrl":"https://engcand.kube-eng.c.eu-de-2.cloud.sap"}}}""";

        JSONObject obj = new JSONObject(str);
        System.out.println(obj);

        System.out.println("-----------------");
        System.out.println(obj.get("PTEMGolden"));
        System.out.println("-----------------");
        System.out.println(obj.getJSONObject("PTEMGolden").get("immutableCompanyId"));
    }
}
