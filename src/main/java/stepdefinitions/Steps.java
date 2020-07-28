package stepdefinitions;

import commonutilities.CommonUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import requests.AddItemsRequest;
import requests.Items;
import requests.ListRequest;
import responses.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Steps {
    ListResponse listResponse;
    ValidatableResponse validatableResponse;
    List<Items> itemsList;
    @Given("User has set the Request Base URI")
    public void setBaseURI() throws Throwable{
        RestAssured.baseURI= CommonUtils.getCentralData("BaseUri");
    }

    @And("User makes a request for creating a list")
    public void createList(DataTable table) throws Throwable{
        // Set the create list request data like list name,iso_639_1,description,public and iso_3166_1
        ListRequest listRequest = setListRequest(table);
        //Making post request for creating list
        validatableResponse=given()
                .queryParam("api_key",CommonUtils.getCentralData("api_key"))
                .header("Authorization", CommonUtils.getCentralData("authorization"))
                .header("Content-Type", "application/json;charset=utf-8")
                .pathParam("version",CommonUtils.getCentralData("version"))
                .body(listRequest)
                .when()
                .post("/{version}/list")
                .then();
    }

    private ListRequest setListRequest(DataTable table){
        List<Map<String, String>> requestHashMap=table.asMaps(String.class,String.class);
        ListRequest listRequest = new ListRequest();
        listRequest.setName(requestHashMap.get(0).get("name"));
        listRequest.setIso_639_1(requestHashMap.get(0).get("iso_639_1"));
        listRequest.setDescription(requestHashMap.get(0).get("description"));
        listRequest.setPublic(requestHashMap.get(0).get("public") == null || Boolean.parseBoolean(requestHashMap.get(0).get("public")));
        listRequest.setIso_3166_1(requestHashMap.get(0).get("iso_3166_1"));
        return listRequest;
    }

    @Given("^Verify list creation request was successful and verify the response body$")
    public void verifyCreateRequestResponse() throws Throwable{
        //Verifying the status code is 201 and deserialize the responses in a pojo class.
        int responseCode=validatableResponse.extract().statusCode();
        Assert.assertEquals("Expected response Code:"+201+"Actual response code:"+responseCode,201,responseCode);
        listResponse = validatableResponse
                .extract()
                .response()
                .as(ListResponse.class);
        Assert.assertTrue(listResponse.getSuccess());
    }


    @Given("^Verify invalid create request response status code is (\\d+) and response contains \"(.*)\" error message$")
    public void verifyInvalidCreateRequestResponse(int expectedResponseCode, String expectedSuccessMessage) throws Throwable{
        int actualResponseCode=validatableResponse.extract().statusCode();
        Assert.assertEquals("Expected response Code:"+expectedResponseCode+"Actual response code:"+actualResponseCode,expectedResponseCode,actualResponseCode);
        ErrorResponse errorResponse = validatableResponse
                .extract()
                .response()
                .as(ErrorResponse.class);
        String actualSuccessMessage=errorResponse.getErrors().get(0);
        Assert.assertEquals("Expected Success Message:" + expectedSuccessMessage+ "Actual Success Message:"+ actualSuccessMessage,expectedSuccessMessage,actualSuccessMessage);
    }

    @When("User updates the list")
    public void updateList(DataTable table) throws Throwable{
        ListRequest listRequest = setListRequest(table);
        validatableResponse=given()
                .queryParam("api_key",CommonUtils.getCentralData("api_key"))
                .header("Authorization", CommonUtils.getCentralData("authorization"))
                .header("Content-Type", "application/json")
                .pathParam("version",CommonUtils.getCentralData("version"))
                .pathParam("list_id", this.listResponse.getId())
                .body(listRequest)
                .when()
                .put("/{version}/list/{list_id}")
                .then();
    }

    @Given("^Verify response status code is (\\d+) and response contains \"(.*)\" success message$")
    public void verifyResponse(int expectedResponseCode, String expectedSuccessMessage) throws Throwable{
        int actualResponseCode=validatableResponse.extract().statusCode();
        Assert.assertEquals("Expected response Code:"+expectedResponseCode+"Actual response code:"+actualResponseCode,expectedResponseCode,actualResponseCode);
        UpdatedListResponse updatedListResponse = validatableResponse
                .extract()
                .response()
                .as(UpdatedListResponse.class);
        Assert.assertTrue(updatedListResponse.getSuccess());
        String actualSuccessMessage=updatedListResponse.getStatus_message();
        Assert.assertEquals("Expected Success Message:" + expectedSuccessMessage+ "Actual Success Message:"+ actualSuccessMessage,expectedSuccessMessage,actualSuccessMessage);
    }

    @Given("^Verify get list request response$")
    public void verifyGetListRequest(DataTable table) throws Throwable{
        ListRequest listRequest = setListRequest(table);
        GetList getList=
                given()
                        .queryParam("api_key",CommonUtils.getCentralData("api_key"))
                        .pathParam("version",CommonUtils.getCentralData("version"))
                        .pathParam("list_id", this.listResponse.getId())
                        .when()
                        .get("/{version}/list/{list_id}")
                        .then()
                        .statusCode(200)
                        .extract()
                        .response()
                        .as(GetList.class);
        Assert.assertEquals(listRequest.getName(),getList.getName());
        Assert.assertEquals(listRequest.getDescription(),getList.getDescription());
        Assert.assertEquals(listRequest.getIso_639_1(),getList.getIso_639_1());
        Assert.assertEquals(listRequest.getPublic(),getList.getPublic());
        Assert.assertEquals(listRequest.getIso_3166_1(),getList.getIso_3166_1());
    }


    @When("^User add items to the list$")
    public void addItemsToList(DataTable table){
        List<Map<String, String>> requestHashMap=table.asMaps(String.class,String.class);
        itemsList= new ArrayList<Items>();
        for(Map<String, String> item:requestHashMap){
            Items items=new Items();
            items.setMedia_type(item.get("media_type"));
            items.setMedia_id(Integer.parseInt(item.get("media_id")));
            itemsList.add(items);
        }
        AddItemsRequest addItemsRequest=new AddItemsRequest();
        addItemsRequest.setItems(itemsList);
        validatableResponse= given()
                .queryParam("api_key",CommonUtils.getCentralData("api_key"))
                .header("Authorization", CommonUtils.getCentralData("authorization"))
                .header("Content-Type", "application/json")
                .pathParam("version",CommonUtils.getCentralData("version"))
                .pathParam("list_id", this.listResponse.getId())
                .body(addItemsRequest)
                .when()
                .post("/{version}/list/{list_id}/items")
                .then();
    }

    @When("^Verify response status code is (\\d+) and verify the response body$")
    public void verifyItemsAddedToList(int expectedResponseCode){
        int actualResponseCode=validatableResponse.extract().statusCode();
        Assert.assertEquals("Expected response Code:"+expectedResponseCode+"Actual response code:"+actualResponseCode,expectedResponseCode,actualResponseCode);
        AddItemResponse addItemResponse= validatableResponse
                .extract()
                .response()
                .as(AddItemResponse.class);
        Assert.assertTrue(addItemResponse.getSuccess());
        int i=0;
        for(Results result:addItemResponse.getResults()){
            Assert.assertEquals(itemsList.get(i).getMedia_type(),result.getMedia_type());
            Assert.assertEquals(itemsList.get(i).getMedia_id(),result.getMedia_id());
            Assert.assertTrue(result.getSuccess());
            i++;
        }
    }

    @When("^User update list items$")
    public void updateItemsToList(DataTable table){
        List<Map<String, String>> requestHashMap=table.asMaps(String.class,String.class);
        itemsList= new ArrayList<Items>();
        for(Map<String, String> item:requestHashMap){
            Items items=new Items();
            items.setMedia_type(item.get("media_type"));
            items.setMedia_id(Integer.parseInt(item.get("media_id")));
            items.setComment(item.get("comment"));
            itemsList.add(items);
        }
        AddItemsRequest addItemsRequest=new AddItemsRequest();
        addItemsRequest.setItems(itemsList);
        validatableResponse= given()
                .queryParam("api_key",CommonUtils.getCentralData("api_key"))
                .header("Authorization", CommonUtils.getCentralData("authorization"))
                .header("Content-Type", "application/json")
                .pathParam("version",CommonUtils.getCentralData("version"))
                .pathParam("list_id", this.listResponse.getId())
                .body(addItemsRequest)
                .when()
                .put("/{version}/list/{list_id}/items")
                .then();
    }

    @When("^User remove list items$")
    public void removeItemsFromList(DataTable table){
        List<Map<String, String>> requestHashMap=table.asMaps(String.class,String.class);
        itemsList= new ArrayList<Items>();
        for(Map<String, String> item:requestHashMap){
            Items items=new Items();
            items.setMedia_type(item.get("media_type"));
            items.setMedia_id(Integer.parseInt(item.get("media_id")));
            itemsList.add(items);
        }
        AddItemsRequest addItemsRequest=new AddItemsRequest();
        addItemsRequest.setItems(itemsList);
        validatableResponse= given()
                .queryParam("api_key",CommonUtils.getCentralData("api_key"))
                .header("Authorization", CommonUtils.getCentralData("authorization"))
                .header("Content-Type", "application/json")
                .pathParam("version",CommonUtils.getCentralData("version"))
                .pathParam("list_id", this.listResponse.getId())
                .body(addItemsRequest)
                .when()
                .delete("/{version}/list/{list_id}/items")
                .then();
    }

    @When("^User makes a request for clearing all of the items from the list$")
    public void clearList(){
        validatableResponse= given()
                .queryParam("api_key",CommonUtils.getCentralData("api_key"))
                .header("Authorization", CommonUtils.getCentralData("authorization"))
                .pathParam("version",CommonUtils.getCentralData("version"))
                .pathParam("list_id", this.listResponse.getId())
                .when()
                .get("/{version}/list/{list_id}/clear")
                .then();
    }


    @When("^Verify the clear list request response code is (\\d+) and then verify the response body$")
    public void verifyClearListResponse(int expectedResponseCode ){
        int actualResponseCode=validatableResponse.extract().statusCode();
        Assert.assertEquals("Expected response Code:"+expectedResponseCode+"Actual response code:"+actualResponseCode,expectedResponseCode,actualResponseCode);
        ClearListResponse clearListResponse= validatableResponse
                .extract()
                .response()
                .as(ClearListResponse.class);
        Assert.assertTrue(clearListResponse.getSuccess());
        Assert.assertEquals("Success.",clearListResponse.getStatus_message());
    }

    @And("User makes unauthorized list request")
    public void unauthorizedCreateList(DataTable table) throws Throwable{
        // Set the create list request data like list name,iso_639_1,description,public and iso_3166_1
        ListRequest listRequest = setListRequest(table);
        //Making post request for creating list without authorization token
        validatableResponse=given()
                .queryParam("api_key",CommonUtils.getCentralData("api_key"))
                .header("Content-Type", "application/json;charset=utf-8")
                .pathParam("version",CommonUtils.getCentralData("version"))
                .body(listRequest)
                .when()
                .post("/{version}/list")
                .then();
    }

    @Given("^Verify unauthorized create request response status code is (\\d+) and response contains \"(.*)\" error message$")
    public void verifyUnauthorizedCreateRequestResponse(int expectedResponseCode, String expectedSuccessMessage) throws Throwable{
        int actualResponseCode=validatableResponse.extract().statusCode();
        Assert.assertEquals("Expected response Code:"+expectedResponseCode+"Actual response code:"+actualResponseCode,expectedResponseCode,actualResponseCode);
        CreateListErrorResponse errorResponse = validatableResponse
                .extract()
                .response()
                .as(CreateListErrorResponse.class);
        String actualSuccessMessage=errorResponse.getError_message();
        Assert.assertEquals("Expected Success Message:" + expectedSuccessMessage+ "Actual Success Message:"+ actualSuccessMessage,expectedSuccessMessage,actualSuccessMessage);
    }

    @After
    public void afterScenario(){
        System.out.println("Deleting the  list after each test scenario");
        given()
                .queryParam("api_key",CommonUtils.getCentralData("api_key"))
                .header("Authorization", CommonUtils.getCentralData("authorization"))
                .pathParam("version",CommonUtils.getCentralData("version"))
                .pathParam("list_id", this.listResponse.getId())
                .when()
                .delete("/{version}/list/{list_id}")
                .then()
                .statusCode(200);
    }

}

