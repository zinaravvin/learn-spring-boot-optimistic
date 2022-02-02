# HdStopApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getAristoStopsTransactions**](HdStopApi.md#getAristoStopsTransactions) | **POST** /aristo/stops/{accountId} | Get all stop transactions per account


<a name="getAristoStopsTransactions"></a>
# **getAristoStopsTransactions**
> SelectHDStopTransResponse getAristoStopsTransactions(accountId)

Get all stop transactions per account

### Example
```java
// Import classes:
import org.openapi.invoker.ApiClient;
import org.openapi.invoker.ApiException;
import org.openapi.invoker.Configuration;
import org.openapi.invoker.models.*;
import org.openapi.api.HdStopApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost");

    HdStopApi apiInstance = new HdStopApi(defaultClient);
    BigDecimal accountId = new BigDecimal(78); // BigDecimal | HD account number
    try {
      SelectHDStopTransResponse result = apiInstance.getAristoStopsTransactions(accountId);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling HdStopApi#getAristoStopsTransactions");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **accountId** | **BigDecimal**| HD account number |

### Return type

[**SelectHDStopTransResponse**](SelectHDStopTransResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** |  |  -  |
**405** | Invalid input |  -  |

